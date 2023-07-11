<template>
  <div class="index-container">
    <canvas id="canvas"></canvas>
    <div class="bg-img"></div>
    <CallMe></CallMe>
    <transition name="bounce">
      <LoginBox @changeuserstatus="userStatus" @closeloginbox="showLogin = !showLogin" v-if="showLogin" />
    </transition>
    <el-row class="top-main">
      <el-col :lg="24">
        <div class="login-nav">
          <section class="login-nav-left">
            <span>Alpha</span>
            <span>的个人博客</span>
          </section>
          <section class="login-nav-right">
            <!-- 还没有登录时右侧盒子 -->
            <div v-if="username==null||userpower==null" class="head-bth">
              <el-button type="success" @click="showLogin = !showLogin"
                >登录</el-button
              >
              <el-button type="warning" @click="pushRegister">注册</el-button>
            </div>

            <!-- 登录之后右侧盒子 -->
            <div v-if="username!=null&&userpower!=null" class="head-user">
              <span class="el-icon-s-custom"></span>
              <p class="head-username">用户名 : {{username}}</p>
              <div class="head-center-line"></div>
              <p class="user-power" @click="pushAdmin">类型 : {{userpower}}</p>
              <div class="head-center-line"></div>
              <p class="user-off" @click="userOff">注销账号</p>
            </div>
          </section>
        </div>
      </el-col>
    </el-row>

    <el-row class="main">
      <el-col
        v-bind:class="{
          'left-main-container': true,
          'left-main-container-zidx': zidxTrue,
        }"
        :lg="12"
      >
        <transition name="component-fade" mode="out-in">
          <component
            :is="BoxName"
            v-if="show"
            @closeLeftNav="closeLeft"
          ></component>
        </transition>
      </el-col>
      <el-col class="right-main-container" :lg="12">
        <TimeCom></TimeCom>
        <NavCom @showBox="changeBox"></NavCom>
      </el-col>
      <el-col class="bottom-icp" :lg="24">
        <div class="icp">
          <p class="icp-img"></p>
          <a href="https://www.12377.cn/">新ICP备2021001065号</a>
        </div>
        <a href="https://www.12377.cn/">互联网信息举报中心</a>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import AboutMe from "@/Compoents/UserComponents/Index/IndexCompoents/AboutMe.vue";
import TimeCom from "@/Compoents/UserComponents/Index/IndexCompoents/TimeCompoents.vue";
import NavCom from "@/Compoents/UserComponents/Index/IndexCompoents/NavCompoents.vue";
import CallMe from "@/Compoents/UserComponents/Index/IndexCompoents/CallMe.vue";
import LoginBox from "@/Compoents/UserComponents/Index/IndexCompoents/LoginBox.vue";
import UpdateLog from "@/Compoents/UserComponents/Index/IndexCompoents/UpdateLog.vue";
import { veriftyToken } from "@/Util/Serve";
import jsCookie from "js-cookie";
import { rainFun } from "@/assets/Javascript/rain";
export default {
  components: {
    LoginBox,
    NavCom,
    TimeCom,
    CallMe,
    AboutMe,
    UpdateLog,
  },
  data() {
    return {
      BoxName: "",
      show: "",
      zidxTrue: "",
      showLogin: false,
      userpower: null,
      username: null,
    };
  },

  methods: {
    userOff(){
      jsCookie.remove("Token")
      this.$router.go(0)
    },
    userStatus(){
      this.username=this.$store.state.userName
      if(this.$store.state.userPower==1){
        this.userpower="管理员"
      }else if(this.$store.state.userPower==0){
        this.userpower="用户"
      }
    },
    pushAdmin(){
      if (this.userpower=="管理员") {
        this.$router.push({
          path:"/admincontroller"
        })
      }
    },
    pushRegister() {
      this.$router.push({
        path: "/register",
      });
    },
    closeLeft() {
      this.show = false;
      this.zidxTrue = false;
    },
    changeBox(name) {
      this.BoxName = name;
      this.show = true;
      this.zidxTrue = true;
    },
  },
  mounted() {
    rainFun();
    this.userStatus()
  },
  activated(){
    let that=this
    if (jsCookie.get("Token")) {
      veriftyToken(jsCookie.get("Token"), function (res) {
        if (res.data.status == 1) {
          that.userStatus()
        } else {
          that.$notify.error({
            title: "错误",
            message: "你的登录信息已过期，请重新登录!",
          });
          that.username=null
          that.userpower=null
          jsCookie.remove("Token");
        }
      });
    }

  },
  beforeRouteLeave(to, from, next) {
    let that = this;
    let token = jsCookie.get("Token");
    if (to.fullPath == "/admincontroller") {
      veriftyToken(token, function (res) {
        console.log(res);
        if (res.data.status == 1) {
          next();
        }
        if (res.data.status == 0) {
          that.$notify.error({
            title: "错误",
            message: "你的token令牌无效，请重新登录!",
          });
          jsCookie.remove("Token");
        }
      });
    }

    next();
  },
};
</script>

<style scoped>
@import "element-ui/lib/theme-chalk/display.css";
@import "@/assets/Icon/font_3878331_47fu2rl12es/iconfont.css";
.top-main{
  height: 50px;
}
#canvas {
  position: absolute;
  top: 0;
  left: 0;
  width: 100vw; /* 设置宽度为视口宽度 */
  height: 100vh; /* 设置高度为视口高度 */
  z-index: 1;
}
.index-container {
  width: 100%;
  height: 100vh;
}

.bg-img {
  width: 100%;
  height: 100vh;
  background-image: url(@/assets/IMG/BG-Main.webp);
  background-size: 100% 100%;
  background-repeat: repeat-y;
  background-attachment: fixed;
  position: fixed;
}
.main {
  height: calc(100vh - 50px);
  position: relative;
  z-index: 99;
}

.top-container,
.bottom-container {
  width: 50%;
}

.right-main-container {
  height: 90%;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-around;
}
.left-main-container {
  height: 90%;
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 999;
}
.component-fade-enter-active,
.component-fade-leave-active {
  transition: opacity 0.4s ease;
}
.component-fade-enter, .component-fade-leave-to
/* .component-fade-leave-active for below version 2.1.8 */ {
  opacity: 0;
}

/* 登录盒子的动画 */
.bounce-enter-active {
  animation: bounce-in 0.5s;
}
.bounce-leave-active {
  animation: bounce-in 0.5s reverse;
}
@keyframes bounce-in {
  0% {
    transform: scale(0);
  }
  50% {
    transform: scale(1.5);
  }
  100% {
    transform: scale(1);
  }
}

.bottom-icp {
  width: 100%;
  height: 10%;
  display: flex;
  flex-direction: column;
  color: pink;
  align-items: center;
  justify-content: center;
}
.icp {
  display: flex;
  color: pink;
}
.bottom-icp a {
  color: pink;
}
.icp-img {
  width: 20px;
  height: 20px;
  background-image: url(@/assets/IMG/icp.png);
  background-repeat: no-repeat;
  background-size: 100% 100%;
}
.login-nav {
  width: 100%;
  height: 50px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  font-size: 24px;
  position: relative;
  z-index: 99;
}
.login-nav-left {
  margin-left: 30px;
}
.login-nav-left > span:nth-of-type(1) {
  color: rgb(255, 255, 255);
  font-weight: 600;
}
.login-nav-left > span:nth-of-type(2) {
  color: rgb(226, 216, 31);
  font-weight: 800;
}
.el-icon-s-check {
  color: rgb(38, 177, 246);
}
.login-nav-right {
  display: flex;
  font-size: 36px;
  margin-right: 30px;
}
.head-bth {
  display: flex;
}
.el-icon-s-custom {
  font-size: 24px;
  color: aqua;
}
.head-center-line {
  height: 60%;
  width: 1px;
  background-color: rgb(84, 88, 69);
}
.head-user {
  min-width: 250px;
  align-items: center;
  height: 30px;
  display: flex;
  justify-content: space-around;
}
.head-username {
  font-size: 16px;
  color: rgb(44, 226, 202);
  cursor: pointer;
}
.user-power {
  font-size: 16px;
  color: rgb(84, 205, 245);
  cursor: pointer;
}

.user-off{
   font-size: 16px;
  color: rgb(240, 61, 61);
  cursor: pointer;
}
@media (max-width: 767px) {
  .left-main-container {
    z-index: -1;
    position: absolute;
    top: 20px;
  }
  .left-main-container-zidx {
    z-index: 999;
  }
  .test-idx {
    position: relative;
    z-index: 99;
  }
  .login-nav-left{
    font-size: 16px;
  }
}
</style>