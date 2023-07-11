<template>
  <div class="Util-controller">
    <div style="border: 1px solid #ccc">
      <Toolbar
        style="border-bottom: 1px solid #ccc"
        :editor="editor"
        :defaultConfig="toolbarConfig"
        :mode="mode"
      />
      <Editor
        ref="edit"
        style="height: 500px; overflow-y: hidden"
        v-model="html"
        :defaultConfig="editorConfig"
        :mode="mode"
        @onCreated="onCreated"
      />
    </div>
  </div>
</template>
  
  <script>
import Vue from "vue";
import { Editor, Toolbar } from "@wangeditor/editor-for-vue";
import { delateImg } from "@/Util/Serve";
var editorImgList1 = new Array();
var editorImgList2 = new Array();

export default Vue.extend({
  components: { Editor, Toolbar },
  data() {
    let that = this;
    return {
      editor: null,
      html: "",
      toolbarConfig: {},
      editorConfig: {
        placeholder: "请输入内容...",
        MENU_CONF: {
          insertImage: {
            onInsertedImage: function (node) {
              editorImgList1.push(node);
            },
          },
          uploadImage: {
            server: "path/api/admin/uploadimg",
            headers: {
              token: that.$store.state.token,
            },
          },
        },
      },
      mode: "default", // or 'simple'
    };
  },
  methods: {
    handleBeforeUnload() {
      editorImgList2 = this.editor.getElemsByType("image");
      const diff = editorImgList1
        .filter((x) => !editorImgList2.some((y) => y.src === x.src))
        .concat(
          editorImgList2.filter(
            (x) => !editorImgList1.some((y) => y.src === x.src)
          )
        );
      let imgarr = new Array();
      for (let i = 0; i < diff.length; i++) {
        imgarr.push(diff[i].src);
      }

      delateImg(imgarr, function (res) {
        console.log(res);
      });
    },
    onCreated(editor) {
      this.editor = Object.seal(editor); // 一定要用 Object.seal() ，否则会报错
    },
  },
  watch: {
    html() {
      this.$emit("editorHtml", this.html);
    },
  },
  mounted() {
    window.addEventListener("beforeunload", this.handleBeforeUnload);
  },
  beforeDestroy() {
    window.removeEventListener("beforeunload", this.handleBeforeUnload);
    console.log("摧毁Edit");
    const editor = this.editor;
    if (editor == null) return;
    editor.destroy(); // 组件销毁时，及时销毁编辑器
  },
});
</script>
  
  <style scoped>
@import url(@wangeditor/editor/dist/css/style.css);
.Util-controller {
  width: 100%;
  background-color: rgb(31, 45, 61);
}
</style>