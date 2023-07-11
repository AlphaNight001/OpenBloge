<template>
  <div class="admin-main-container">
    <div class="bg-img"></div>

    <!-- 移动端抽屉左往右 -->
    <el-drawer
      title="我是标题"
      :visible.sync="drawer"
      :direction="direction"
      :with-header="false"
      :size="'50%'"
    >
      <LeftNav />
    </el-drawer>


    <!-- PC端 -->
    <div class="admin-container">
      <el-row>
        <el-col :lg="24" class="header-nav hidden-sm-and-up">
          <span @click="drawer = true" class="el-icon-s-unfold"></span>
          <p class="now-typ">后台管理系统</p>
        </el-col>
      </el-row>
      <el-row>
        <el-col :lg="4">
          <div class="left hidden-sm-and-down">
            <LeftNav></LeftNav>
          </div>
        </el-col>
        <el-col :lg="20">
          <div class="right">
            <router-view></router-view>
          </div>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
import "element-ui/lib/theme-chalk/display.css";
import LeftNav from "@/Compoents/AdminCompoents/Controller/ControllerCompoents/AdminLeftNav.vue";
import { veriftyToken } from "@/Util/Serve";
import jsCookie from "js-cookie";
export default {
  data() {
    return {
      drawer: false,
      direction: "ltr",
    };
  },
  components: {
    LeftNav,
  },
};
</script>

<style scoped>
.admin-main-container {
  width: 100%;
}
.bg-img {
  width: 100%;
  height: 100vh;
  background-image: url(@/assets/IMG/BG-Main.webp);
  background-size: 100% 100%;
  background-attachment: fixed;
  position: fixed;
}
.admin-container {
  margin: 0 auto;
  max-width: 1620px;
}

.left {
  height: 100vh;
  background-color: rgb(48, 65, 86);
}

.right {
  height: 100vh;
  background-color: rgb(31, 45, 61);
  overflow: scroll;
  overflow-x: hidden;
}
.header-nav {
  padding: 0px 10px 0px 10px;
  display: flex;
  justify-content: center;
  justify-content: space-between;
  background-color: #304156;
  font-size: 26px;
}
.el-icon-s-unfold{
  color:red;
}
.now-typ {
  color: red;
}
</style>