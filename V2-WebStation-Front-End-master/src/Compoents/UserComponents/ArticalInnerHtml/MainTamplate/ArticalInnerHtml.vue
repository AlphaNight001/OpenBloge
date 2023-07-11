<template>
  <div class="ArticalInnerHtml-container">
    <el-button class="backBth" @click="backIndex" type="primary" round
      ><span class="el-icon-back"></span>返回</el-button
    >

    <div class="nav-showBth" @click="drawer = !drawer">导航栏</div>

    <el-drawer
      size="300px"
      title="我是标题"
      direction="ltr"
      :visible.sync="drawer"
      :with-header="false"
      class="drawer"
    >
      <div
        v-for="anchor in howerTitles"
        :key="anchor.title"
        :style="{ padding: `10px 0 10px ${anchor.indent * 20}px` }"
        @click="handleAnchorClick(anchor)"
      >
        <a style="cursor: pointer;color:#409EFF;">{{ anchor.title }}</a>
      </div>
    </el-drawer>

    

    <div class="html-container">
      <header>
        <p class="title">{{ title }}</p>
      </header>
      <div class="time">
        <p>编辑时间:{{ time }}</p>
      </div>

    <el-divider><i class="el-icon-document"></i></el-divider>
      
      <v-md-preview class="preview" :text="markdown" ref="preview"></v-md-preview>
    </div>
  </div>
</template>

<script>
import Vue from "vue";
import VMdPreview from "@kangc/v-md-editor/lib/preview";
import "@kangc/v-md-editor/lib/style/preview.css";
// 引入你所使用的主题 此处以 github 主题为例
import githubTheme from "@kangc/v-md-editor/lib/theme/github";
import "@kangc/v-md-editor/lib/theme/style/github.css";

//这是提示插件
import createTipPlugin from '@kangc/v-md-editor/lib/plugins/tip/index';
import '@kangc/v-md-editor/lib/plugins/tip/tip.css';
VMdPreview.use(createTipPlugin())

//这是代码行号显示
import createLineNumbertPlugin from '@kangc/v-md-editor/lib/plugins/line-number/index';

VMdPreview.use(createLineNumbertPlugin());

//这是流程图插件
import createMermaidPlugin from '@kangc/v-md-editor/lib/plugins/mermaid/cdn';
import '@kangc/v-md-editor/lib/plugins/mermaid/mermaid.css';
VMdPreview.use(createMermaidPlugin());
// highlightjs
import hljs from "highlight.js";
import { getArticalById } from "@/Util/Serve";

VMdPreview.use(githubTheme, {
  Hljs: hljs,
});

Vue.use(VMdPreview);

export default {
  data() {
    return {
      html: "",
      title: "",
      time: "",
      markdown: "",
      drawer: false,
      howerTitles: "",
    };
  },
  methods: {
    backIndex() {
      this.$router.replace({
        path: "/artical",
      });
    },
    handleAnchorClick(anchor) {
      const { preview } = this.$refs;
      const { lineIndex } = anchor;
      const box=document.querySelector(".html-container")
      const heading = preview.$el.querySelector(
        `[data-v-md-line="${lineIndex}"]`
      );
      console.log(preview.$el);
      if (heading) {
        preview.scrollToTarget({
          target: heading,
          scrollContainer: box,
          top: 0,
        });
      }
    },
    getAllTitle() {
      let that = this;
      //进行获取所有标题标签操作
      const anchors =
        that.$refs.preview.$el.querySelectorAll("h1,h2,h3,h4,h5,h6");

      const titles = Array.from(anchors).filter(
        (title) => !!title.innerText.trim()
      );

      if (!titles.length) {
        that.titles = [];
        return;
      }

      const hTags = Array.from(
        new Set(titles.map((title) => title.tagName))
      ).sort();

      that.howerTitles = titles.map((el) => ({
        title: el.innerText,
        lineIndex: el.getAttribute("data-v-md-line"),
        indent: hTags.indexOf(el.tagName),
      }));
    },
  },
  mounted() {
    let that = this;
    let id = this.$route.params.id;
    getArticalById(id, function (res) {
      that.html = res.data.list.artical_htmlTag;
      that.title = res.data.list.artical_title;
      that.time = res.data.list.artical_time;
      that.markdown = res.data.list.artical_markdownCode;
      that.$nextTick(function () {
        that.getAllTitle();
      });
    });
  },
};
</script>

<style scoped>
.preview{
  width: 100%;
}
.ArticalInnerHtml-container {
  width: 100%;
  height: 100vh;
  background-color: rgb(227, 227, 227);
  display: flex;
  justify-content: center;
}

.html-container {
  width: 1000px;
  height: 100%;
  background-color: rgb(255, 255, 255);
  display: flex;
  flex-direction: column;
  align-items: center;
  overflow-y: scroll;
  overflow-x: hidden;
}

.html-container::-webkit-scrollbar {
  width: 5px;
  background-color: aliceblue;
}
.html-container::-webkit-scrollbar-thumb {
  border-radius: 5px;
  background-color: rgb(126, 124, 129);
}

.backBth {
  position: fixed;
  right: 20px;
  bottom: 40px;
  background-color: #1a1aa344;
}
.title {
  font-size: 36px;
}
.htmlBody {
  width: 100%;
  box-sizing: border-box;
  padding: 30px;
}
.time {
  color: #999;
  align-self: flex-end;
  margin-right: 20px;
}
.nav-showBth {
  width: 25px;
  height: 100px;
  background-color: #409eff;
  position: absolute;
  left: 0px;
  top: calc(50% - 50px);
  display: flex;
  align-items: center;
  text-align: center;
  cursor: pointer;
  color: aliceblue;
}

.ArticalInnerHtml-container /deep/ .el-drawer__body{
  padding: 20px;
  display: flex;
  flex-direction: column;
  justify-content: center;
}
@media (max-width: 767px) {
  .title {
    font-size: 24px;
  }
}
</style>