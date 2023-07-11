<template>
  <nav class="nav-container">
    <span class="left el-icon-arrow-left" @click="noadd"></span>
    <span class="right el-icon-arrow-right" @click="add"></span>
    <!-- 第一页 -->
    <div class="number-nav" v-if="pages == 1">
      <div class="select-icn" @click="pushBli()">
        <span class="iconfont icon-bilibili"></span>
        <p>B站</p>
      </div>
      <div @click="pushArtical" class="select-icn">
        <span class="iconfont icon-wodewenzhang"></span>
        <p>文章</p>
      </div>
      <div @click.stop="CallMe()" class="select-icn">
        <span class="el-icon-discount"></span>
        <p>加入我们</p>
      </div>
      <div class="select-icn" @click="Message()">
        <span class="el-icon-tickets"></span>
        <p>留言板</p>
      </div>
      <div @click="AboutMe()" class="select-icn">
        <span class="iconfont icon-guanyuwo"></span>
        <p>关于我</p>
      </div>
      <div @click="pushCallAdmin()" class="select-icn">
        <span class="iconfont icon-sixin"></span>
        <p>聊天室</p>
      </div>
    </div>

    <!-- 第二页 -->
    <div class="number-nav" v-if="pages == 2">
      <div @click="UpdateLog()" class="select-icn">
        <span class="iconfont icon-gengxin"></span>
        <p>更新日志</p>
      </div>
    </div>
  </nav>
</template>

<script>
export default {
  data() {
    return {
      BoxStatus: "",
      pages: "1",
    };
  },
  methods: {
    pushCallAdmin() {
      let that = this;

      console.log(this);
      if (this.$store.state.token != 0&& this.$store.state.token!=undefined) {
        that.$router.push({
          path: "/calladmin",
        });
      }else{
        that.$message.error('你还没有登录，请先登录');
      }
    },
    Message() {
      this.$router.push({
        path: "/message",
      });
    },
    pushBli() {
      window.location.href =
        "https://space.bilibili.com/491447125?spm_id_from=333.1007.0.0";
    },
    CallMe() {
      let callme = document.querySelector(".call-container");
      callme.style.visibility = "visible";
      callme.style.opacity = "1";
      callme.style.marginTop = "-250px";
      window.onclick = function () {
        callme.style.visibility = "hidden";
        callme.style.opacity = "0";
        callme.style.marginTop = "-300px";
      };
    },
    AboutMe() {
      this.BoxStatus = "AboutMe";
      this.$emit("showBox", this.BoxStatus);
    },
    UpdateLog() {
      this.BoxStatus = "UpdateLog";
      this.$emit("showBox", this.BoxStatus);
    },
    pushArtical() {
      this.$router.push({
        path: "/artical",
      });
    },
    add() {
      if (this.pages != 2) {
        this.pages++;
      }
    },
    noadd() {
      if (this.pages != 1) {
        this.pages--;
      }
    },
  },
  mounted() {},
};
</script>

<style scoped>
/* 导航栏盒子部分 */
.nav-container {
  position: relative;
  display: flex;
  width: 50%;
  height: 300px;
  background-color: rgba(67, 168, 199, 0.8);
  border-radius: 10%;
}

.left {
  position: absolute;
  top: 50%;
  font-size: 32px;
  cursor: pointer;
  z-index: 99;
}

.right {
  position: absolute;
  top: 50%;
  right: 0px;
  font-size: 32px;
  cursor: pointer;
  z-index: 99;
}

.number-nav {
  width: 100%;
  height: 100%;
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  align-items: center;
  position: absolute;
}

.select-icn {
  width: 28%;
  height: 100px;
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
  cursor: pointer;
}
.select-icn > .iconfont,
.el-icon-discount {
  color: rgb(36, 6, 211);
  font-size: 28px;
  font-weight: 800;
}
.el-icon-tickets {
  color: rgb(36, 6, 211);
  font-size: 28px;
  font-weight: 800;
}
.select-icn > p {
  padding: 0;
  margin: 0;
  color: rgb(36, 6, 211);
  font-size: 20px;
  font-weight: 100;
  white-space: nowrap;
}

@media (max-width: 767px) {
  .select-icn > .iconfont {
    font-size: 20px;
  }
  .select-icn > p {
    font-size: 14px;
  }
  .nav-container {
    height: 200px;
  }
}
</style>