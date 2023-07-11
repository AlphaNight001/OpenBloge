<template>
  <div class="login-box-container">
    <span class="el-icon-circle-close" @click="closeLoginBox"></span>
    <span class="top-text">登录</span>
    <el-form
      label-position="left"
      ref="ruleForm"
      label-width="80px"
      :model="ruleForm"
      :rules="rules"
      class="form-login"
    >
      <el-form-item label="用户名" prop="username">
        <el-input
          placeholder="请输入用户名"
          v-model="ruleForm.username"
        ></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input
          type="password"
          placeholder="请输入密码"
          v-model="ruleForm.password"
        ></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="success" @click="veriftyLogin">确认</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { loginVerifty } from "@/Util/Serve";
import jsCookie from "js-cookie";
export default {
  data() {
    return {
      ruleForm: {
        username: "",
        password: "",
      },
      rules: {
        username: [{ required: true, message: "请输入用户名" }],
        password: [{ required: true, message: "请输入密码" }],
      },
    };
  },
  methods: {
    closeLoginBox() {
      this.$emit("closeloginbox");
    },
    veriftyLogin() {
      let that = this;
      this.$refs["ruleForm"].validate((valid) => {
        if (valid) {
          loginVerifty(
            that.ruleForm.username,
            that.ruleForm.password,
            function (res) {
              console.log(res);
              if (res.data.status == 1) {
                jsCookie.set("Token", res.data.token);
                that.$store.commit("changeToken", res.data.token);
                that.$store.commit("changeUsername", res.data.username);
                that.$store.commit("changePower", res.data.userpower);
                that.$emit("closeloginbox");
                that.$emit("changeuserstatus");
                that.$notify({
                  type: "success",
                  title: "成功",
                  message: "你已经成功登录",
                });
              } else {
                if (res.data.status == 202) {
                  that.$notify.error({
                    title: "警告",
                    message: "你的账号已经被封锁,请联系管理员!",
                  });
                  return;
                }
                that.$notify.error({
                  title: "警告",
                  message: "账号或密码有误！！",
                });
              }
            }
          );
        } else {
          return false;
        }
      });
    },
  },
};
</script>

<style scoped>
.login-box-container {
  box-sizing: border-box;
  padding: 20px;
  position: absolute;
  left: calc(50% - 200px);
  top: calc(50% - 200px);
  width: 400px;
  height: 400px;
  background-color: rgb(255, 255, 255);
  z-index: 100;
  border-radius: 50px;
  display: flex;
  flex-direction: column;
  align-items: center;
}
.top-text {
  font-size: 36px;
  font-weight: 600;
}
.form-login {
  margin-top: 50px;
}
.el-icon-circle-close {
  position: absolute;
  top: 20px;
  right: 30px;
  font-size: 36px;
  cursor: pointer;
}
</style>