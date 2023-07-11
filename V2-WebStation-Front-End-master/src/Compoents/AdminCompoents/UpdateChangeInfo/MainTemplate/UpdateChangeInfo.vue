<template>
  <div class="admin-updatechangeinfo-contianer">
    <MarkdownEditor
      ref="edit"
      :changeText="infoTag.markdown_Code"
      @gettext="getText"
    />
    <div class="upload-update">
      <el-button type="danger" round @click="uploadUpdate()"
        >更新日志为当前内容</el-button
      >
    </div>
  </div>
</template>

<script>
import { queryUpdateByID, changeUpdateByID } from "@/Util/Serve";

import MarkdownEditor from "@/Util/MarkdownEditor.vue";
export default {
  components: {
    MarkdownEditor,
  },
  data() {
    return {
      infoTag: "",
      text: "",
      html: "",
    };
  },
  mounted() {
    let id = this.$route.params.id;
    let that = this;

    if (id == null) {
      that.open();
      return;
    }

    queryUpdateByID(id, function (res) {
      if (res.data.status != 1) {
        that.open();
      } else {
        that.infoTag = res.data.info;
      }
    });
  },

  methods: {
    getText(text, html) {
      (this.text = text), (this.html = html);
    },
    open() {
      let that = this;
      this.$alert("出错了，请返回重新选择更改的文章!!", "错误", {
        confirmButtonText: "确定",
        callback: (action) => {
          that.$router.replace({
            path: "admincontroller/showallupdate",
          });
        },
      });
    },
    uploadUpdate() {
      let that = this;
      let id = this.infoTag.id;
      let bean = {
        id: id,
        html_Tag: that.html,
        markdown_Code: that.text,
      };

      // 调用图片删除方法
      this.$refs.edit.delateNoImg();

      changeUpdateByID(bean, function (res) {
        if (res.data.status == 1) {
          that.$alert("日志修改成功", "提示", {
            confirmButtonText: "确定",
            callback: (action) => {
              that.$router.replace({
                path: "admincontroller/showallupdate",
              });
            },
          });
        } else {
          that.$alert("修改日志出错了！！", "提示", {
            confirmButtonText: "确定",
            callback: (action) => {
              that.$router.replace({
                path: "admincontroller/showallupdate",
              });
            },
          });
        }
      });
    },
  },
};
</script>

<style scoped>
.upload-update {
  display: flex;
  justify-content: center;
  margin-top: 20px;
  width: 100%;
}
</style>