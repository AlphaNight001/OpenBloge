<template>
  <div class="Loding">
    <div class="container-Loding">
      <div class="point"></div>
      <div class="point"></div>
      <div class="point"></div>
      <div class="point"></div>
      <div class="point"></div>
    </div>
  </div>
</template>

<script>
window.onload = function () {
  var loding = document.querySelector(".Loding");
  setTimeout(() => {
    loding.style.display = "none";
  }, 2000);
};
export default {};
</script>

<style scoped>
/* 动画 */

.Loding {
  position: absolute;
  z-index: 9969;
  width: 100%;
  height: 100vh;
  background: #0949ea;
  /* 实现子元素的垂直水平居中，采用Flex布局 */
  display: flex;
  align-items: center;
  justify-content: center;
}
.container-Loding {
  display: flex;
}
.container-Loding .point {
  width: 2em;
  height: 2em;
  border-radius: 50%; /* 实现圆形 */
  background: #fff;
  margin: 1em;
  user-select: none;
  position: relative;
}
.container-Loding .point::before {
  position: absolute;
  content: "";
  width: 100%;
  height: 100%;
  background: inherit; /* 从父元素继承背景颜色 */
  border-radius: inherit; /* 从父元素继承圆角 */
  animation: wave 2.2s ease-out infinite;
  /* 对before元素定义动画，完成时间2s, 采用ease-out过渡，重复循环 */
}

@keyframes wave {
  50%,
  70% {
    transform: scale(2.5);
  }
  80%,
  100% {
    opacity: 0;
  }
}

/* 设置背景颜色,自行选取五个颜色即可 */
.container-Loding .point:nth-child(1) {
  background: #7ef9ff;
}
.container-Loding .point:nth-child(2) {
  background: #89cff0;
}
.container-Loding .point:nth-child(3) {
  background: #4682b4;
}
.container-Loding .point:nth-child(4) {
  background: #0f52ba;
}
.container-Loding .point:nth-child(5) {
  background: #000080;
}

/*
* 现在动画都是同时出现的，而我们需要的是一种逐渐出现的效果
* 所以需要对每个元素的动画加一个延迟
* 最后一个与第一个之间的间隔太短
* 所以需要把整体的动画时间延长一下
*/
.container-Loding .point:nth-child(1)::before {
  animation-delay: 0s; /* 第一个不需要延迟 */
}
.container-Loding .point:nth-child(2)::before {
  animation-delay: 0.2s; /* 依次延迟0.2s */
}
.container-Loding .point:nth-child(3)::before {
  animation-delay: 0.4s;
}
.container-Loding .point:nth-child(4)::before {
  animation-delay: 0.6s;
}
.container-Loding .point:nth-child(5)::before {
  animation-delay: 0.8s;
}

@media (max-width: 767px) {
}
</style>