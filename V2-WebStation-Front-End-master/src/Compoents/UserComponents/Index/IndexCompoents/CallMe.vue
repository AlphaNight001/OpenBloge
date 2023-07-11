<template>
  <div @click.stop="dithis()" class="call-container">
    <div class="call-container-header">
      <span @click="QQurl()">QQ群</span>
      <span @click="WXurl()">微信私信</span>
    </div>
    <div @click="addQQGroup()" class="call-container-Main">
      <img :src="url" title="点击加入群聊">
    </div>
  </div>
</template>

<script>
import QQurlPath from "@/assets/IMG/QQGrop.webp"
import WeChatPath from "@/assets/IMG/we-chat.webp"

export default {
  data(){
    return{
      url:QQurlPath
    }
  },
  methods:{
    dithis(){},
    addQQGroup(){
      location.href="https://qm.qq.com/cgi-bin/qm/qr?k=dUifXWKjw6o67J0L9EsltlYUxOTOebhz&jump_from=webapi&authKey=34zQrLPV41qYewpXto6xo0XhcMH54eRt6CV6bEw9+RTvjEZzfmnNvul4LVxbjVbt"
    },
    dothis(){},
    
    QQurl(){
      this.url=QQurlPath
    },
    WXurl(){
      this.url=WeChatPath
    },
  },
  mounted(){
  }
};
</script>

<style scoped>
.call-container {
  visibility: hidden;
  opacity: 0;
  position: absolute;
  width: 300px;
  height: 400px;
  background-color: rgba(28, 208, 214, 0.637);
  left: 50%;
  margin-left: -150px;
  top: 50%;
  border-radius: 20px;
  margin-top: -200px;
  z-index: 999;
  transition: all 1s;
}


.call-container-header {
  width: 100%;
  height: 80px;
  border-radius: 20px 20px 0 0;
  display: flex;
  cursor: pointer;
  flex-wrap: wrap;
}
.call-container-header > span {
  box-sizing: border-box;
  display: flex;
  justify-content: center;
  align-items: center;
  width: 50%;
  height: 100%;
  border-bottom: 2px solid rgb(7, 134, 238);
  cursor: pointer;
  font-size: 30px;
  color: rgb(255, 255, 255);
}
.call-container-header > span:nth-of-type(1) {
  border-right: 1px solid rgb(7, 134, 238);
}
.call-container-header > span:nth-of-type(2) {
  border-left: 1px solid rgb(7, 134, 238);
}
.call-container-Main {
  cursor: pointer;
  width: 100%;
  height: 100%;
}
.call-container-Main>img{
  width: 100%;
  height: 100%;
  border-radius: 0 0 20px 20px;

}
</style>