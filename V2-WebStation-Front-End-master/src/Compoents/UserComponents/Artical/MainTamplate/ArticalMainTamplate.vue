<template>
  <div class="ArticalMainTamplate-container">
    <!-- 移动端下的抽屉导航栏 -->
    <el-drawer
      :visible.sync="drawer"
      :direction="direction"
      :modal="true"
      :show-close="false"
      :with-header="false"
      :size="'50%'"
    >
      <div class="litght-container">
        <div class="kindof-container">
          <header class="kindof-header">
            <span class="el-icon-s-flag"></span>
            <p>分类</p>
          </header>
          <ul class="kindof-main">
            <li
              v-for="p in kindOfArr"
              :key="p.artical_kindOf"
              @click="kindOfArtical(p.category_name)"
            >
              <p>{{ p.category_name }}</p>
              <span>{{ p.num_articles }}</span>
            </li>
          </ul>
        </div>

        <div class="label-kindof">
          <header class="lable-top">
            <span class="el-icon-paperclip"></span>
            <p>标签</p>
          </header>
          <div class="lable-all-container">
            <span v-for="p in articalTagArr" :key="p.artical_kindOfTag">{{
              p.artical_kindOfTag
            }}</span>
          </div>
        </div>
      </div>
    </el-drawer>

    <!-- 此处开始为PC端内容 -->

    <div class="bg-img"></div>
    <el-button @click="backIndex" type="primary" round class="backindex-bth"
      ><p class="el-icon-back"></p
    ></el-button>
    <el-row class="main-container">
      <el-col :lg="18">
        <div class="main-container-body">
          <el-row class="drop-down-nav hidden-sm-and-up">
            <el-col class="test">
              <div @click="drawer = true">
                <span class="el-icon-d-arrow-right"></span>
              </div>
            </el-col>
          </el-row>
          <el-row :gutter="30">
            <el-col :lg="16">
              <div class="left-container">
                <div class="head-container">
                  <div>
                    <button class="check-kind" @click="getAllArtical">
                      全部
                    </button>
                  </div>
                </div>
                <div class="artical-arr">
                  <div
                    class="card-box"
                    v-for="p in articalArr"
                    :key="p.id"
                    @click="pushShowArtical(p.id)"
                  >
                    <header class="card-title">
                      <span>{{ p.artical_title }}</span>
                    </header>
                    <div class="card-box-info">
                      <span>时间:&nbsp;{{ p.artical_time }}</span>
                      <span class="card-info-padding">浏览:&nbsp;0</span>
                      <span class="card-info-padding"
                        >分类:&nbsp;{{ p.artical_kindOf }}</span
                      >
                    </div>
                  </div>
                </div>
              </div>
            </el-col>
            <el-col :lg="8" class="hidden-sm-and-down">
              <div class="litght-container">
                <div class="kindof-container">
                  <header class="kindof-header">
                    <span class="el-icon-s-flag"></span>
                    <p>分类</p>
                  </header>
                  <ul class="kindof-main">
                    <li
                      v-for="(p, i) in kindOfArr"
                      :key="i"
                      @click="kindOfArtical(p.category_name)"
                      :style="{
                        backgroundColor: selectedIndex === i ? '#ff7700' : '',
                      }"
                      @mouseover="changeBgc(i)"
                      @mouseout="backBgc"
                    >
                      <p>{{ p.category_name }}</p>
                      <span>{{ p.num_articles }}</span>
                    </li>
                  </ul>
                </div>

                <div class="label-kindof">
                  <header class="lable-top">
                    <span class="el-icon-paperclip"></span>
                    <p>标签</p>
                  </header>
                  <div class="lable-all-container">
                    <!-- 需要配置数据 -->
                    <span
                      v-for="p in articalTagArr"
                      :key="p.artical_kindOfTag"
                      >{{ p.artical_kindOfTag }}</span
                    >
                  </div>
                </div>
              </div>
            </el-col>
          </el-row>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import {
  checkArticalTag,
  checkArticalQuantity,
  selectAllArtical,
  getArticalById,
  getArticalByKindOf,
} from "@/Util/Serve";
import "element-ui/lib/theme-chalk/display.css";
export default {
  data() {
    return {
      kindOfArr: "",
      articalArr: "",
      articalTagArr: "",
      drawer: false,
      direction: "ttb",
      selectedIndex: -1,
    };
  },
  created() {
    let that = this;

    selectAllArtical(function (res) {
      that.articalArr = res.data.dataArtical;
    });
  },

  mounted() {
    let that = this;
    checkArticalQuantity(function (res) {
      that.kindOfArr = res.data.result;
    });

    checkArticalTag(function (res) {
      that.articalTagArr = res.data.result;
    });
  },
  methods: {
    getAllArtical() {
      let that = this;

      selectAllArtical(function (res) {
        that.articalArr = res.data.dataArtical;
      });
    },
    changeBgc(index) {
      this.selectedIndex = index;
    },
    backBgc(event) {
      this.selectedIndex = -1;
    },
    kindOfArtical(str) {
      let that = this;
      getArticalByKindOf(str, function (res) {
        that.articalArr = res.data.list;
      });
    },
    backIndex() {
      this.$router.replace({
        path: "/",
      });
    },
    pushShowArtical(id) {
      this.$router.push({
        path: `/articalinnerhtml/${id}`,
      });
    },
  },
};
</script>

<style scoped>
.ArticalMainTamplate-container {
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
.left-container {
  width: 100%;
}
.main-container {
  display: flex;
  align-items: center;
  justify-content: center;
}
.main-container-body {
  box-sizing: border-box;
  width: 100%;
  height: 95vh;
  background-color: rgb(227, 227, 227);
  border-radius: 20px;
  padding: 20px;
  margin-top: 15px;
}
.head-container {
  box-sizing: border-box;
  display: flex;
  justify-content: space-between;
  width: 100%;
  height: 40px;
  border-radius: 10px;
  background-color: rgb(255, 255, 255);
  padding: 0px 10px 0px 10px;
}
.serch-container {
  display: flex;
  margin-left: 15px;
}
.hot-font {
  display: flex;
  align-items: center;
}
.serch-bth {
  background-color: orange;
  height: 25px;
  display: block;
  display: flex;
  justify-content: center;
  align-items: center;
  width: 30px;
}

.serch {
  border: 0px;
  border: 1px solid orange;
  box-sizing: border-box;
  margin: 0;
  padding: 0;
  width: 100px;
  height: 25px;
}
.check-kind {
  height: 100%;
  width: 40px;
  background-color: rgba(250, 235, 215, 0);
  border: 0px;
  cursor: pointer;
}
.artical-arr {
  height: 580px;
  margin-top: 30px;
  overflow-y: scroll;
}
.artical-arr::-webkit-scrollbar {
  width: 5px;
  background-color: #dddada;
  border-radius: 5px;
}
.artical-arr::-webkit-scrollbar-thumb {
  background-color: #999;
  border-radius: 5px;
}
.card-box {
  box-sizing: border-box;
  padding-left: 15px;
  border-radius: 10px;
  width: 100%;
  background-color: rgb(255, 255, 255);
  margin-top: 20px;
  cursor: pointer;
}
.card-title {
  box-sizing: border-box;
  font-size: 24px;
  font-weight: 400;
  margin: 10px 0 15px 0;
}
.card-box-info {
  color: #999;
  font-size: 14px;
  margin-bottom: 15px;
}
.card-info-padding {
  margin-left: 20px;
}
.kindof-container {
  width: 100%;
  background-color: rgb(255, 255, 255);
}
.kindof-header {
  border-bottom: 1px solid rgb(116, 112, 112);
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 10px;
}
.kindof-main > li {
  display: flex;
  justify-content: space-between;
  padding: 10px;
  align-items: center;
  color: rgb(119, 119, 119);
  cursor: pointer;
}
.kindof-main > li > span {
  padding: 3px;
  border-radius: 5px;
  color: rgb(255, 255, 255);
  background-color: rgb(255, 119, 0);
}
.label-kindof {
  margin-top: 20px;
  width: 100%;
  background-color: #ffffff;
}
.lable-top {
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 10px;
  border-bottom: 1px solid #999;
}
.lable-all-container {
  display: flex;
  flex-wrap: wrap;
  width: 100%;
}
.lable-all-container > span {
  font-size: 12px;
  color: #ffffff;
  background-color: rgb(255, 119, 0);
  padding: 5px;
  border-radius: 5px;
  margin: 10px;
}
.backindex-bth {
  z-index: 1;
  position: fixed;
  right: 50px;
  top: 10px;
  width: 60px;
  height: 60px;
  display: flex;
  justify-content: center;
  align-items: center;
}
.el-icon-back {
  font-size: 50px;
}

.drop-down-nav {
  width: 100%;
  height: 30px;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 26px;
  transform: rotate(90deg);
  margin-bottom: 20px;
  color: rgb(8, 174, 245);
}
.test {
  width: 30px;
}

@media (max-width: 767px) {
  .backindex-bth {
    position: fixed;
    top: 80%;
    opacity: 0.7;
  }
  .artical-arr {
    height: 640px;
  }
  .hot-font > p:nth-of-type(1) {
    white-space: nowrap;
    font-size: 10px;
  }
}
</style>