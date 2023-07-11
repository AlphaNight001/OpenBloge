<template>
  <div class="AdminLeftNav-container">
    <el-menu
      class="el-menu-vertical-demo"
      text-color="#bfcbd9"
      ref="menu"
      @open="handleOpen"
      @close="handleClose"
      background-color="#304156"
      :unique-opened="state"
    >
      <el-submenu index="1">
        <template slot="title">
          <i class="iconfont icon-wodewenzhang"></i>
          <span>文章管理</span>
        </template>
        <el-menu-item-group>
          <el-menu-item index="1-1" @click="pushUploadArtical()"
            >文章发布</el-menu-item
          >
          <el-menu-item index="1-2" @click="pushArticalShow()"
            >文章查询</el-menu-item
          >
        </el-menu-item-group>
      </el-submenu>
      <el-submenu index="2">
        <template slot="title">
          <i class="iconfont icon-gengxin"></i>
          <span>更新日志</span>
        </template>
        <el-menu-item-group>
          <el-menu-item index="2-1" @click="pushUpdateGo()"
            >发布新的更新</el-menu-item
          >
          <el-menu-item index="2-2" @click="showAllUpdate()"
            >更新日志查询</el-menu-item
          >
        </el-menu-item-group>
      </el-submenu>

      <el-submenu index="3">
        <template slot="title">
          <i class="el-icon-user-solid"></i>
          <span>用户管理</span>
        </template>
        <el-menu-item-group>
          <el-menu-item index="3-1" @click="pushUser()">用户账户管理</el-menu-item>
        </el-menu-item-group>
        <el-menu-item-group>
          <el-menu-item index="3-2" @click="pushUserSay()">用户评论管理</el-menu-item>
        </el-menu-item-group>
      </el-submenu>

       <el-submenu index="4">
        <template slot="title">
          <i class="el-icon-user-solid"></i>
          <span>网站信息</span>
        </template>
        <el-menu-item-group>
          <el-menu-item index="4-1" @click="pushStationInfo()">网站信息</el-menu-item>
        </el-menu-item-group>
      </el-submenu>
    </el-menu>
    <div class="backIndex">
      <el-button @click="pushIndex()" type="danger">返回主页</el-button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      state: true,
    };
  },
  methods: {
    pushStationInfo(){
       if (this.$route.path == "/admincontroller/stationinfo") return;
      this.$router.replace({
        path: "/admincontroller/stationinfo"
      })
    },
    pushUserSay(){
      if (this.$route.path == "/admincontroller/usermessage") return;
      this.$router.replace({
        path: "/admincontroller/usermessage"
      })
    },
    pushUser(){
      if (this.$route.path == "/admincontroller/showalluser") return;

      this.$router.replace({
        path:"/admincontroller/showalluser"
      })
    },
    showAllUpdate() {
      if (this.$route.path == "/admincontroller/showallupdate") return;
      this.$router.replace({
        path: "/admincontroller/showallupdate",
      });
    },
    pushUpdateGo() {
      if (this.$route.path == "/admincontroller/updatego") return;

      this.$router.replace({
        path: "/admincontroller/updatego",
      });
    },
    pushIndex() {
      this.$router.replace({
        path: "/",
      });
    },
    pushUploadArtical() {
      if (this.$route.path == "/admincontroller/articaleditor") {
        this.$router.go(0)
        return
      };

      this.$router.replace({
        path: "/admincontroller/articaleditor",
      });
    },
    pushArticalShow() {
      if (this.$route.path == "/admincontroller/showallartical") return;

      this.$router.replace({
        path: "/admincontroller/showallartical",
      });
    },
    handleOpen(key, keyPath) {},
    handleClose(key, keyPath) {},
  },
};
</script>

<style scoped lang="scss">
@import url(@/assets/Icon/font_3878331_47fu2rl12es/iconfont.css);
.AdminLeftNav-container {
  width: 100%;
  height: 100%;
  background-color: rgb(48, 65, 86);
}
.el-menu-vertical-demo {
  border: 0px;
}

.AdminLeftNav-container /deep/ .el-menu-item,
.AdminLeftNav-container /deep/ .el-menu-item-group__title {
  background-color: #1f2d3d !important;
  text-align: center;
}
.backIndex {
  width: 100%;
  height: 200px;
  display: flex;
  justify-content: center;
  align-items: center;
}
.icon-user-solid{
  font-size: 10px;
}
</style>