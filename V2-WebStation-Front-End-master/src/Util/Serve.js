import axios from "axios";
import jsCookie from "js-cookie";
import Vue from 'vue';
import Vuex from 'vuex';
import qs from "qs"
// 引入 store 实例
import store from '@/VueX/Store';

// 安装 Vuex
Vue.use(Vuex);

// 获取 store 实例
const vuexStore = new Vuex.Store(store);

let token = vuexStore.state.token


axios.interceptors.request.use(
    config => {
        // 在发送请求之前做些什么
        if (token == 0) {
            token = jsCookie.get("Token")
            store.commit("changeToken", token)
        }
        return config;
    },
    error => {
        // 对请求错误做些什么
        console.error('请求错误', error);
        return Promise.reject(error);
    }
);


// 获取天气信息
function getWeather(citycode, callback) {
    return axios.get("https://restapi.amap.com/v3/weather/weatherInfo", {
        params: {
            key: "9b98ca8900785d9c0170014d298f8a7d",
            city: citycode
        }
    }).then(function (res) {
        callback && callback(res)
    })
}
//获取IP地址
function getIp(callback) {
    return axios({
        method: "post",
        url: "path/api/getip",
    }).then(function (res) {
        callback && callback(res)
    }).catch(function (e) {
        console.log(e);
    })
}

//根据IP获取城市
function getCity(ip, callback) {
    return axios({
        method: "post",
        url: "https://restapi.amap.com/v3/ip",
        params: {
            key: "9b98ca8900785d9c0170014d298f8a7d",
            ip: ip
        }
    }).then(function (res) {
        callback && callback(res)
    }).catch(function (e) {
        console.log(e);
    })
}

//验证Token
function veriftyToken(token, callback) {
    return axios({
        method: "post",
        url: "path/api/veriftytoken",
        params: {
            token: token
        },
        headers: {
            'token': vuexStore.state.token,
        },
    }).then(function (res) {
        callback && callback(res)
    }).catch(function (err) {
        console.log(err);
    })
}

//登录验证
function loginVerifty(username, password, callback) {
    return axios({
        method: "post",
        url: "path/api/loginctrl",
        data: {
            username: username,
            password: password
        }
    }).then(function (res) {
        callback && callback(res)
    }).catch(function (err) {
        console.log(err);
    })
}

//获取所有文章

function selectAllArtical(callback) {
    return axios({
        url: "path/api/admin/getallartical",
        method: "post",
        headers: {
            'token': vuexStore.state.token,
        },
    }).then(function (res) {
        callback && callback(res)
    })
}


//根据ID请求文章内容
function getArticalById(id, callback) {
    return axios({
        method: "post",
        url: "path/api/admin/getarticalbyid",
        params: {
            id: id
        },
        headers: {
            'token': vuexStore.state.token,
        }
    }).then(function (res) {
        callback && callback(res)
    })
}


//根据分类获取文章
function getArticalByKindOf(str, callback) {
    return axios({
        method: "post",
        url: "path/api/admin/getarticalbykindof",
        params: {
            str: str
        }
    }).then(function (res) {
        callback && callback(res)
    })
}


//上传文章
function uploadArtical(html, text, title, valueKindOf, valueTag, callback) {
    return axios({
        method: "post",
        url: "path/api/admin/articalupload",
        data: {
            body: html,
            title: title,
            kindOf: valueKindOf,
            kindoftag: valueTag,
            text: text
        },
        headers: {
            'token': vuexStore.state.token,
        }
    }).then(function (res) {
        callback && callback(res)
    })
}


//根据ID删除文章
function delateArticalByID(id, callback) {
    return axios({
        method: "post",
        url: "path/api/admin/deletearticalbyid",
        params: {
            id: id,
        },
        headers: {
            'token': vuexStore.state.token,
        }
    }).then(function (res) {
        callback && callback(res)
    })
}

//编辑文章信息
function changeArtical(bean, callback) {
    return axios({
        method: "post",
        url: "path/api/admin/changeartical",
        data: JSON.stringify(bean),
        headers: {
            'Content-Type': 'application/json;charset=UTF-8',
            'token': vuexStore.state.token,

        }
    }).then(function (res) {
        callback && callback(res)
    })
}

//上传更新日志
function uploadUpdate(bean, callback) {
    return axios({
        method: "post",
        url: "path/api/admin/updatego",
        data: JSON.stringify(bean),
        headers: {
            'Content-Type': 'application/json;charset=UTF-8',
            'token': vuexStore.state.token,
        }
    }).then(function (res) {
        callback && callback(res)
    })
}

//查询所有更新日志
function selectAllUpdate(callback) {
    return axios({
        method: "post",
        url: "path/api/admin/selectallupdate",
        headers: {
            'token': vuexStore.state.token,
        }
    }).then(function (res) {
        callback && callback(res)
    })
}

//通过ID删除更新日志
function delateUpdateByID(id, callback) {
    return axios({
        params: {
            id: id
        },
        method: "post",
        url: "path/api/admin/delateupdatebyid",
        headers: {
            'token': vuexStore.state.token,
        }
    }).then(function (res) {
        callback && callback(res)
    })
}


//根据ID查询更新日志
function queryUpdateByID(id, callback) {
    return axios({
        params: {
            id: id
        },
        method: "post",
        url: "path/api/admin/queryupdatebyid",
        headers: {
            'token': vuexStore.state.token,
        }
    }).then(function (res) {
        callback && callback(res)
    })
}


//根据ID更改已经存在的更新数据
function changeUpdateByID(bean, callback) {
    return axios({
        data: bean,
        method: "post",
        url: "path/api/admin/changeupdate",
        headers: {
            'token': vuexStore.state.token,
        }
    }).then(function (res) {
        callback && callback(res)
    })
}


//查询所有的文章类型数量
function checkArticalQuantity(callback) {
    return axios({
        method: "post",
        url: "path/api/checkarticalquantity",
    }).then(function (res) {
        callback && callback(res)
    }).catch(function (e) {
        console.log(e);
    })
}

//查询所有获取文章有多少中标签
function checkArticalTag(callback) {
    return axios({
        method: "post",
        url: "path/api/checkarticaltag",

    }).then(function (res) {
        callback && callback(res)
    }).catch(function (e) {
        console.log(e);
    })
}

//发送验证码
function sendEmailCode(email, callback) {
    return axios({
        method: "post",
        url: "path/api/getemail",
        params: {
            email: email
        }

    }).then(function (res) {
        callback && callback(res)
    }).catch(function (e) {
        console.log(e);
    })
}

//验证用户昵称是否重复
function veriftyName(name, callback) {
    return axios({
        method: "post",
        url: "path/api/veriftyname",
        params: {
            name: name,
        },

    }).then(function (res) {
        callback && callback(res)
    }).catch(function (e) {
        console.log(e);
    })
}

//验证验证码是否通过
function veriftyEmail(email, code, callback) {
    return axios({
        method: "post",
        url: "path/api/veriftyemail",
        params: {
            email: email,
            code: code
        },

    }).then(function (res) {
        callback && callback(res)
    }).catch(function (e) {
        console.log(e);
    })
}
//上传用户注册信息
function registerUser(bean, callback) {
    return axios({
        method: "post",
        url: "path/api/registeruser",
        params: {
            user_username: bean.user_username,
            user_password: bean.user_password,
            user_email: bean.user_email
        }
    }).then(function (res) {
        callback && callback(res)
    }).catch(function (e) {
        console.log(e);
    })
}
//上传留言请求
function uploadMessage(bean, callback) {
    return axios({
        method: "post",
        url: "path/api/user/uploadmessage",
        params: {
            msg_message: bean.msg_message
        },
        headers: {
            'token': vuexStore.state.token,
        }
    }).then(function (res) {
        callback && callback(res)
    }).catch(function (e) {
        console.log(e);
    })
}

//获取所有留言
function getAllMessage(callback) {
    return axios({
        method: "post",
        url: "path/api/user/getallmessage"
    }).then(function (res) {
        callback && callback(res)
    }).catch(function (e) {
        console.log(e);
    })
}

//编辑器Editor删除已被删除的图片
function delateImg(imgarr, callback) {
    return axios({
        method: "post",
        url: "path/api/admin/delateimg",
        data: {
            imgarr: imgarr
        },
        headers: {
            'token': vuexStore.state.token,
        }
    }).then(function (res) {
        callback && callback(res)
    }).catch(function (e) {
        console.log(e);
    })
}
//获取所有用户信息
function getalluser(callback) {
    return axios({
        method: "post",
        url: "path/api/admin/getalluser",
        headers: {
            'token': vuexStore.state.token,
        }
    }).then(function (res) {
        callback && callback(res)
    }).catch(function (e) {
        console.log(e);
    })
}
//设置用户账户状态
function changeUserStatus(bean, callback) {
    return axios({
        method: "post",
        url: "path/api/admin/changeuserstatus",
        data: bean,
        headers: {
            'token': vuexStore.state.token,
        }
    }).then(function (res) {
        callback && callback(res)
    }).catch(function (e) {
        console.log(e);
    })
}


//根据账户ID删除用户

function delateUserByID(id, callback) {
    return axios({
        method: "post",
        url: "path/api/admin/delateuserbyid",
        params: { id: id },
        headers: {
            'token': vuexStore.state.token,
        }
    }).then(function (res) {
        callback && callback(res)
    }).catch(function (e) {
        console.log(e);
    })
}

// 获取管理员当前是否在线
function getAdminStatus(callback) {
    return axios({
        method: "post",
        url: "path/api/getadminstatus",
    }).then(function (res) {
        callback && callback(res)
    }).catch(function (e) {
        console.log(e);
    })
}

// 获取所有文章种类数量信息
function getArticalKindOfInfo(callback) {
    return axios({
        method: "post",
        url: "path/api/admin/getarticalkindofinfo",
        headers: {
            'token': vuexStore.state.token,
        }
    }).then(function (res) {
        callback && callback(res)
    }).catch(function (e) {
        console.log(e);
    })
}



//删除指定id的留言
function delateMsgByID(bean, callback) {
    return axios({
        method: "post",
        url: "path/api/admin/delatemsg",
        data:bean ,
        headers: {
            'token': vuexStore.state.token,
        }
    }).then(function (res) {
        callback && callback(res)
    }).catch(function (e) {
        console.log(e);
    })
}




export {
    getArticalKindOfInfo,
    delateMsgByID,
    getAdminStatus,
    delateUserByID,
    changeUserStatus,
    getalluser,
    delateImg,
    getAllMessage,
    uploadMessage,
    veriftyEmail,
    veriftyName,
    sendEmailCode,
    registerUser,
    uploadArtical,
    delateArticalByID,
    getWeather,
    getIp,
    getCity,
    veriftyToken,
    loginVerifty,
    selectAllArtical,
    getArticalById,
    getArticalByKindOf,
    changeArtical,
    uploadUpdate,
    selectAllUpdate,
    delateUpdateByID,
    queryUpdateByID,
    changeUpdateByID,
    checkArticalQuantity,
    checkArticalTag
}