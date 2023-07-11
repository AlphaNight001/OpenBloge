import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'
import routers from "@/Router/Router"
import 'element-ui/lib/theme-chalk/index.css';
import Cookies from 'js-cookie';
import "@/assets/CSS/prism.css"
import "@/assets/Javascript/prism"
import store from "@/VueX/Store.js"
import ElementUI from "@/assets/Javascript/element-ui"


Vue.config.productionTip = false
Vue.use(ElementUI);
Vue.use(VueRouter)

new Vue({
  router:routers,
  store,
  render: h => h(App),
}).$mount('#app')
