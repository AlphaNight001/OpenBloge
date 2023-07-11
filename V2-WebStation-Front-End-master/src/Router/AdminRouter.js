import VueRouter from 'vue-router'

const adminRouter = [
    {

        path: "/admincontroller",
        component: () => import("@/Compoents/AdminCompoents/Controller/MainTemplate/AdminController.vue"),
        children: [
            {
                path: "/admincontroller",
                component: () => import("@/Compoents/AdminCompoents/Controller/ControllerCompoents/AdminRightBody.vue"),
            },
            {
                name: "articaleditor",
                path: "/admincontroller/articaleditor",
                component: () => import("@/Compoents/AdminCompoents/ArticalEditor/MainTemplate/ArticalEditor"),
            },
            {
                path: "/admincontroller/showallartical",
                component: () => import("@/Compoents/AdminCompoents/ShowAllArtical/MainTemplate/ArticalShowAll.vue"),
            },
            {
                path: "/admincontroller/updatego",
                component: () => import("@/Compoents/AdminCompoents/UpdateGo/MainTemplate/UpdateGo.vue"),
            },
            {
                path: "/admincontroller/showallupdate",
                component: () => import("@/Compoents/AdminCompoents/ShowAllUpdate/MainTemplate/ShowAllUpdate.vue"),
            },
            {
                path: "/updatechangeinfo",
                name: "UpdateChange",
                component: () => import("@/Compoents/AdminCompoents/UpdateChangeInfo/MainTemplate/UpdateChangeInfo.vue"),
            },
            {
                path: "/admincontroller/showalluser",
                name: "Showalluser",
                component: () => import("@/Compoents/AdminCompoents/ShowAllUser/MainTemplate/ShowAllUser.vue"),
            },
            {
                path: "/admincontroller/usermessage",
                name: "Showallusermessage",
                component: () => import("@/Compoents/AdminCompoents/UserMessage/MainTamplate/UserMessage.vue"),
            },
            {
                path: "/admincontroller/stationinfo",
                name: "stationinfo",
                component: () => import("@/Compoents/AdminCompoents/StationInfo/MainTamplate/StationInfo.vue"),
            }
        ]

    }
]






export default adminRouter