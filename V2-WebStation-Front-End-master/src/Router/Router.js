import VueRouter from 'vue-router'
import adminRouter from "@/Router/AdminRouter"
import { veriftyToken } from "@/Util/Serve"
import jsCookie from "js-cookie";

import Vue from 'vue';
import Vuex from 'vuex';

// 引入 store 实例
import store from '@/VueX/Store';

// 安装 Vuex
Vue.use(Vuex);

// 获取 store 实例
const vuexStore = new Vuex.Store(store);



const router = new VueRouter({

    routes: [
        {
            path: "/",
            component: () => import("@/Compoents/UserComponents/Index/MainTempLate/IndexMainTempLate.vue"),
            meta:{
                keepAlive:true
            }
        },
        {
            path: "/register",
            component: () => import("@/Compoents/UserComponents/RegisterUser/MainTemplate/RegisterUser.vue"),
        },
        {
            path: "/artical",
            component: () => import("@/Compoents/UserComponents/Artical/MainTamplate/ArticalMainTamplate.vue"),
        },
        {
            path: "/articalinnerhtml/:id",
            component: () => import("@/Compoents/UserComponents/ArticalInnerHtml/MainTamplate/ArticalInnerHtml.vue"),
        },
        {
            path: "/message",
            component: () => import("@/Compoents/UserComponents/MessageInner/MainTamplate/MessageInner.vue"),
        },
        {
            path:"/calladmin",
            component: () => import("@/Compoents/UserComponents/CallAdminSocket/MainTamplate/CallAdminIndex.vue"),
        },
        ...adminRouter,

    ]
})


router.beforeEach((to, from, next) => {
    let that = this
    let token = vuexStore.state.token

    if (token == 0) {
        token = jsCookie.get("Token")
    }
    if (to.path.startsWith('/admincontroller')) {
        // 进行拦截处理
        veriftyToken(token, function (res) {
            if (res.data.status == 1 && res.data.userpower == 1) {
                next()
            } else {
                alert("你无权访问此页面,点击确认跳转至首页！！") 
                router.replace({
                    path:"/"
                })
            }
        })
    } else {
        // 不需要拦截，继续进行路由跳转
        next();
    }
});


export default router