<template>
  <div class="AdminUpdateGo-container">
    <MarkDwonEditor ref="edit" @gettext="gettext" />
    <div class="upload-bth" @click="open">
      <el-button type="primary" round>上传更新日志</el-button>
    </div>
  </div>
</template>

<script>
import MarkDwonEditor from "@/Util/MarkdownEditor.vue";
import { uploadUpdate } from "@/Util/Serve";
export default {
  components: {
    MarkDwonEditor,
  },
  data() {
    return {
      markdowdCode: "",
      html: "",
    };
  },
  methods: {
    gettext(text, html) {
      this.markdowdCode = text;
      this.html = html;
    },

    //这一步是将文章上传的前奏以及结果处理部分
    open() {
      let that = this;
      this.$confirm("此操作将上传更新日志, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      }).then(() => {
        let status;
        let bean = {
          markdown_Code: this.markdowdCode,
          html_Tag: this.html,
        };

        // 调用图片删除方法
        this.$refs.edit.delateNoImg();
        uploadUpdate(bean, function (res) {
          status = res.data.status;
          if (status == 1) {
            that.$message({
              type: "success",
              message: "上传成功",
            });

            that.$router.go(0);
          } else {
            that.$message({
              type: "warning",
              message: "上传出错！！",
            });
          }
        }).catch(() => {
          this.$message({
            type: "info",
            message: "已取消",
          });
        });
      });
    },
  },
};
</script>

<style scoped>
.AdminUpdateGo-container {
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
}
.upload-bth {
  margin-top: 20px;
}
</style>>

