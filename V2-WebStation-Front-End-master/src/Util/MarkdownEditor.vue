<template>
  <div class="markdown-editor">
    <v-md-editor
      @change="getText"
      v-model="text"
      height="600px"
      :disabled-menus="[]"
      @upload-image="handleUploadImage"
    ></v-md-editor>
  </div>
</template>
  
  <script>
import axios from "axios";

import "./MarkdownEditor";
import { delateImg } from "@/Util/Serve";
let imgArr1 = new Array();
export default {
  data() {
    return {
      text: "",
    };
  },
  props: {
    changeText: "",
  },
  watch: {
    changeText(n, o) {
      this.text = n;
    },
  },
  methods: {
    getText(text, html) {
      this.$emit("gettext", text, html);
    },
    delateNoImg() {
      let that = this;
      let imageLinks = new Array();
      


      // 获取当前markdown的所有图片
      const regex = /!\[.*?\]\((.*?)\)/g;
      let match;
      while ((match = regex.exec(that.text))) {
        imageLinks.push(match[1]);
      }
      const diff = imgArr1
        .filter((x) => !imageLinks.some((y) => y === x))
        .concat(imageLinks.filter((x) => !imgArr1.some((y) => y === x)));
      // 比较当前上传图片的差异删除服务器多余文件
      let imgarr = new Array();
      for (let i = 0; i < diff.length; i++) {
        imgarr.push(diff[i]);
      }
      delateImg(imgarr, function (res) {
        console.log(res);
      });
    },

    // 上传图片的函数
    handleUploadImage(event, insertImage, files) {
      var formdata = new FormData();
      console.log(files);
      formdata.append("file", files[0]);
      let that = this;
      let token = that.$store.state.token;
      axios({
        url: "path/api/admin/uploadimg",
        method: "post",
        data: formdata,
        headers: {
          "Content-Type": "multipart/form-data",
          token: token,
        },
      }).then(function (res) {
        insertImage({
          url: res.data.data.url,
        });
        imgArr1.push(res.data.data.url);
      });
    },
  },
};
</script>
  
  <style scopen>
.markdown-editor {
  width: 100%;
}
</style>