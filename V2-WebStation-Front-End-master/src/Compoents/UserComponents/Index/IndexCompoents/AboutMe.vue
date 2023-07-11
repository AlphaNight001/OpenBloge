<template>
  <div class="Indexcompoents-aboutme">
    <i class="close-left-nav el-icon-close" @click="closeBth">关闭</i>
    <header class="main-title">
      <p>关于Alpha</p>
    </header>
    <ul class="skil-info">
      <li class="font">
        <header class="title">
          <p>前端技能:</p>
          <ol class="skil">
            <li>1.前端三件套:H5/CSS3/JavaScript</li>
            <li>2.Vue2:正在学习转Vue3中</li>
            <li>3.ElementUI:前端Vue组件库</li>
            <li>4.BootStrap:Twitter推出的一个用于前端开发的开源工具包</li>
            <li>
              5.Axios:这是一个基于 promise 的网络请求库,可以用于浏览器和
              node.js,比起原生AJAX更加简单方便
            </li>
          </ol>
        </header>
      </li>
      <li class="back">
        <header class="title">
          <p>后端技能:</p>
          <ol class="skil">
            <li>1:Java基础:会使用Java实现常见的各种逻辑</li>
            <li>
              2:SSM框架:框架集由Spring、MyBatis两个开源框架整合而成，常作为数据源较简单的web项目的框架。
            </li>
            <li>3.MyBits:优秀的持久层框架,简化后端操作数据库</li>
            <li>
              4.SpringBoot:能够使用SpringBoot通过MVC三层架构设计并完成接口的开发.
            </li>
            <li>
              5.MySQL:能够使用Mysql实现基本增删改查的功能，以及简单的逻辑查询.
            </li>
          </ol>
        </header>
      </li>
      <li class="server">
        <header class="title">
          <p>服务器端技能:</p>
          <ol class="skil">
            <li>
              Nginx:可以实现网站的部署，请求的反向代理，部署SSL证书等基本操作
            </li>
            <li>Tomcat:可以实现后端代码的基本部署，SSL证书的基本配置等</li>
            <li>CentOS7:能够基本操作系统，熟悉常用的系统指令等</li>
          </ol>
        </header>
      </li>
      <li class="add-info">
        <header>说明</header>
        <p class="last-info">
          目前正在通过不断的尝试自己写各种代码，网站功能等途径积累经验，主攻前端,为即
          将毕业工作做好准备，现在后端仅出于了解以及会使用的状态，准备毕业后从事前端
          方面工作再通过后期继续对后端的学习成为全栈工程师。
        </p>
        <p class="last-info">
          制作网站的初衷是为了通过项目更接近实战，通过实战发现不足，不断补充知识点，
          另一方面想通过完成个人博客来写文章，能够更好的积累经验，更方便的分享他人。
        </p>
        <p class="last-info">
            总之为了爱好，和对未来生活的期待，继续努力吧，努力不一定能成功但一定不会
            一无所获。
        </p>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  methods:{
     closeBth(){
      this.$emit("closeLeftNav")
    }
  }
};
</script>

<style scoped>
.Indexcompoents-aboutme {
  position: relative;
  z-index: 999;
  width: 95%;
  height: 98%;
  border-radius: 20px;
  background-color: rgba(105, 175, 193, 0.459);
  overflow-y: scroll;
}

.Indexcompoents-aboutme::-webkit-scrollbar {
  border-radius: 20px;
  width: 5px;
  height: 50px;
  overflow: hidden;
}
.Indexcompoents-aboutme::-webkit-scrollbar-thumb {
  width: 100%;
  border-radius: 20px;
  background-color: rgb(117, 99, 99);
  overflow: hidden;
}
.main-title {
  width: 100%;
  text-align: center;
  font-size: 36px;
  font-weight: 600;
  font-family: "erxian";
  padding: 20px;
  box-sizing: border-box;
}
.skil-info .title {
  font-size: 32px;
  font-family: "sansu";
  font-weight: 400;
}
.skil-info .skil {
  margin-left: 25px;
  font-size: 20px;
  letter-spacing: 1px;
  font-family: "Gill Sans", "Gill Sans MT", Calibri, "Trebuchet MS", sans-serif;
}
.skil > li {
  margin-top: 20px;
}
.skil-info > li {
  margin-top: 20px;
}
.font {
  color: rgb(155, 17, 182);
}

.back {
  color: rgb(226, 4, 4);
}
.server {
  color: rgb(255, 255, 255);
}
.add-info {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-bottom: 20px;
  font-family: "erxian";
  font-size: 32px;
}
.last-info {
  text-indent: 50px;
}
.close-left-nav{
 position: absolute;
 width: 60px;
 height: 20px;
 font-size: 20px;
 right: 15px;
 display: flex;
 white-space: nowrap;
 cursor: pointer;
 z-index: 99;
}


@media (max-width: 767px) {
  
.Indexcompoents-aboutme {
 
  background-color: rgba(105, 175, 193, 1);
 
}

}
</style>