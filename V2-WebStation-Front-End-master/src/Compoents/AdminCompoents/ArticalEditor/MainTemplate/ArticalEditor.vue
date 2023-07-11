<template>
  <div class="admin-articaleditor-container">
    <div class="top">
      <el-form
        :model="ruleForm"
        :rules="rules"
        ref="ruleForm"
        label-width="100px"
        class="demo-ruleForm"
      >
        <el-form-item required label="请输入标题 :" prop="title">
          <el-input v-model="ruleForm.title" class="title-input"></el-input>
        </el-form-item>

        <el-form-item required label="请输入标签 :" prop="typeTag">
          <el-input v-model="ruleForm.typeTag" class="title-input"></el-input>
        </el-form-item>

        <el-form-item required label="请选择分类 :" prop="kindOf">
          <el-select v-model="ruleForm.kindOf" placeholder="请选择">
            <el-option
              v-for="item in options"
              :key="item.value"
              :value="item.value"
            >
            </el-option>
          </el-select>
        </el-form-item>
      </el-form>

      <MarkdownEditor ref="edit" :changeText="changeText" @gettext="gettext" />

      <div class="bottom-bth">
        <el-button
          v-if="bthStatus == 'upload'"
          type="primary"
          round
          @click="pushArtical"
          >上传文章</el-button
        >
        <el-button
          v-if="bthStatus == 'change'"
          type="primary"
          round
          @click="changeArtical"
          >更改文章</el-button
        >
      </div>
    </div>
  </div>
</template>

<script>
import MarkdownEditor from "@/Util/MarkdownEditor.vue";
import { uploadArtical, getArticalById, changeArtical } from "@/Util/Serve";
export default {
  components: { MarkdownEditor },
  data() {
    return {
      options: [
        {
          value: "前端",
        },
        {
          value: "后端",
        },
        {
          value: "移动端应用",
        },
        {
          value: "开发工具",
        },
        {
          value: "操作系统",
        },
        {
          value: "SQL",
        },
      ],
      ruleForm: {
        title: "",
        kindOf: "",
        typeTag: "",
      },
      rules: {},
      text: "",
      html: "",
      bthStatus: "",
      changeText: "",
    };
  },
  mounted() {
    let that = this;
    if (this.$route.params.id) {
      that.$nextTick(function () {
        that.bthStatus = "change";

        getArticalById(that.$route.params.id, function (res) {
          console.log(res.data);
          that.ruleForm.title = res.data.list.artical_title;
          that.ruleForm.kindOf = res.data.list.artical_kindOf;
          that.ruleForm.typeTag = res.data.list.artical_kindOfTag;
          that.changeText = res.data.list.artical_markdownCode;
        });
      });
    } else {
      that.bthStatus = "upload";
    }
  },
  methods: {
    gettext(text, html) {
      this.text = text;
      this.html = html;
    },
    pushArtical() {
      let that = this;
      this.$confirm("即将上传文章, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          // 调用图片删除方法
          that.$refs.edit.delateNoImg();

          uploadArtical(
            that.html,
            that.text,
            that.ruleForm.title,
            that.ruleForm.kindOf,
            that.ruleForm.typeTag,
            function (res) {
              if (res.data.status == 1) {
                that.$message({
                  message: "文章上传成功",
                  type: "success",
                });
                that.$router.go(0);
              } else {
                that.$message.error("文章上传失败");
              }
            }
          );
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除",
          });
        });
    },

    changeArtical() {
      let that = this;
      let bean = {
        id: that.$route.params.id,
        artical_htmlTag: that.html,
        artical_markdownCode: that.text,
        artical_title: that.ruleForm.title,
        artical_kindOf: that.ruleForm.kindOf,
        artical_kindOfTag: that.ruleForm.typeTag,
      };
      this.$confirm("即将更改文章, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          // 调用图片删除方法
          that.$refs.edit.delateNoImg();
          changeArtical(bean, function (res) {
            if (res.data.status == 1) {
              that.$message({
                message: "文章更新成功",
                type: "success",
              });
              that.$router.replace({
                path: "/admincontroller/showallartical",
              });
            } else {
              that.$message.error("文章更新失败");
            }
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除",
          });
        });
    },
  },
};
</script>

<style scoped>
.admin-articaleditor-container {
  width: 100%;
  height: 100%;
}
.top {
  width: 100%;
  background-color: rgb(255, 255, 255);
}
.title-input {
  width: 300px;
}

.bottom-bth {
  margin-top: 20px;
  margin-bottom: 20px;
  width: 100%;
  display: flex;
  justify-content: center;
}
</style>