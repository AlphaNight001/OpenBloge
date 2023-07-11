<template>
  <div id="app">
    <!-- <Loding/> -->
    <router-view v-if="!$route.meta.keepAlive" />

    <Loding/>


    <!-- 需要缓存的组件 -->
    <keep-alive>
      <router-view v-if="$route.meta.keepAlive" />
    </keep-alive>
  </div>
</template>

<script>
import Loding from "@/Compoents/UserComponents/Index/IndexCompoents/LodingHtm.vue";
import { veriftyToken } from "@/Util/Serve";
import jsCookie from "js-cookie";
export default {
  name: "App",
  components: {
    Loding,
  },
  mounted() {
    let that = this;
    if (jsCookie.get("Token")) {
      veriftyToken(jsCookie.get("Token"), function (res) {
        if (res.data.status == 1) {
          that.$store.commit("changeToken", jsCookie.get("Token"));
          that.$store.commit("changeUsername", res.data.username);
          that.$store.commit("changePower", res.data.userpower);
        } else {
          that.$notify.error({
            title: "错误",
            message: "你的登录信息已过期，请重新登录!",
          });
          jsCookie.remove("Token");
        }
      });
    }
  },
};
</script>

<style>
* {
  padding: 0;
  margin: 0;
  list-style: none;
  text-decoration: none;
}

.editor-content-view {
  padding: 0 10px;
  margin-top: 20px;
  overflow-x: auto;
}

.editor-content-view p,
.editor-content-view li {
  white-space: pre-wrap; /* 保留空格 */
}

.editor-content-view blockquote {
  border-left: 8px solid #d0e5f2;
  padding: 10px 10px;
  margin: 10px 0;
  background-color: #f1f1f1;
}

.editor-content-view code {
  font-family: monospace;
  background-color: #eee;
  padding: 3px;
  border-radius: 3px;
}
.editor-content-view pre > code {
  display: block;
  padding: 10px;
}

.editor-content-view table {
  border-collapse: collapse;
}
.editor-content-view td,
.editor-content-view th {
  border: 1px solid #ccc;
  min-width: 50px;
  height: 20px;
}
.editor-content-view th {
  background-color: #f1f1f1;
}

.editor-content-view ul,
.editor-content-view ol {
  padding-left: 20px;
}

.editor-content-view input[type="checkbox"] {
  margin-right: 5px;
}
</style>
