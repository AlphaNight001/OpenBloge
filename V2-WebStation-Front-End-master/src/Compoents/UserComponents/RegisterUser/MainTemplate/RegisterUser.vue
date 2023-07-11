<template>
  <div class="user-register-container">
    <el-row>
      <el-col :lg="24">
        <div class="header">
          <p>Alpha的个人博客</p>
          <p>注册</p>
        </div>
      </el-col>
    </el-row>
    <el-divider><i class="el-icon-mobile-phone"></i></el-divider>
    <el-row>
      <el-col :lg="24" class="register-center-container">
        <div class="register-container">
          <el-form
            ref="ruleForm"
            :label-position="labelPosition"
            :rules="rules"
            :model="ruleForm"
            label-width="100px"
          >
            <el-form-item :error="errorForm.name" prop="name" label="用户昵称">
              <el-input v-model="ruleForm.name"></el-input>
            </el-form-item>

            <el-form-item prop="email" label="邮箱">
              <el-input v-model="ruleForm.email"></el-input>
            </el-form-item>

            <el-form-item label="密码" prop="pass">
              <el-input
                type="password"
                v-model="ruleForm.pass"
                autocomplete="off"
              ></el-input>
            </el-form-item>

            <el-form-item label="确认密码" prop="checkPass">
              <el-input
                type="password"
                v-model="ruleForm.checkPass"
                autocomplete="off"
              ></el-input>
            </el-form-item>
            <!-- 验证码表单 -->
          </el-form>
          <el-form
            ref="codeForm"
            :rules="rules"
            :label-position="labelPosition"
            label-width="100px"
            :inline="true"
            :model="emailCode"
            class="demo-form-inline"
          >
            <el-form-item :error="errorForm.code" prop="code" label="验证码">
              <el-input
                style="width: 100px"
                v-model="emailCode.code"
                placeholder="请输入验证码"
              ></el-input>
            </el-form-item>
            <el-form-item>
              <el-button
                class="code-bth"
                type="primary"
                @click="startCountdown"
                :disabled="isDisabled"
                >{{ buttonText }}</el-button
              >
            </el-form-item>
          </el-form>
          <div class="bth-container">
            <el-button type="primary" @click="submitForm('ruleForm')" round
              >注册</el-button
            >
          </div>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import Validator from "async-validator";
import {
  veriftyEmail,
  veriftyName,
  sendEmailCode,
  registerUser,
} from "@/Util/Serve";
import axios from "axios";
export default {
  data() {
    var validatePass = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入密码"));
      } else {
        if (this.ruleForm.checkPass !== "") {
          this.$refs.ruleForm.validateField("checkPass");
        }
        callback();
      }
    };
    var validatePass2 = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请再次输入密码"));
      } else if (value !== this.ruleForm.pass) {
        callback(new Error("两次输入密码不一致!"));
      } else {
        callback();
      }
    };

    return {
      isDisabled: false,
      countdown: 60,
      buttonText: "获取验证码",
      labelPosition: "left",
      countdownInterval: null,
      timer: null, // 计时器变量
      countdownTime: 60, // 倒计时时间
      emailCode: {
        code: "",
      },
      errorForm: {
        name: "",
        code: "",
      },
      ruleForm: {
        name: "",
        email: "",
        pass: "",
        checkPass: "",
      },
      rules: {
        code: [
          {
            required: true,
            message: "请输入验证码",
            trigger: ["blur", "change"],
          },
        ],
        name: [
          {
            required: true,
            message: "请输入活动名称",
            trigger: ["blur", "change"],
          },
          {
            required: true,
            min: 3,
            max: 5,
            message: "长度在 3 到 5 个字符",
            trigger: ["blur", "change"],
          },
        ],
        email: [
          { required: true, message: "请输入邮箱地址", trigger: "blur" },
          {
            type: "email",
            message: "请输入正确的邮箱地址",
            trigger: ["blur", "change"],
          },
        ],
        pass: [{ required: true, validator: validatePass, trigger: "blur" }],

        checkPass: [
          { required: true, validator: validatePass2, trigger: "blur" },
        ],
      },
    };
  },
  mounted() {},
  methods: {
    //验证码发送之后倒计时
    startCountdown() {
      let that = this;
      sendEmailCode(that.ruleForm.email, function (res) {
        console.log(res);
      });

      // 设置按钮为不可用
      this.isDisabled = true;

      // 设置按钮文本为倒计时剩余时间
      this.buttonText = `${this.countdown} 秒`;

      // 开始定时器
      this.countdownInterval = setInterval(() => {
        if (this.countdown > 1) {
          // 更新倒计时剩余时间和按钮文本
          this.countdown -= 1;
          this.buttonText = `${this.countdown} 秒`;
        } else {
          // 清除定时器和倒计时状态
          clearInterval(this.countdownInterval);
          this.countdownInterval = null;
          this.countdown = 60;
          this.buttonText = "获取验证码";
          this.isDisabled = false;
        }
      }, 1000);
    },

    // 表单的数据提交
    submitForm(formName) {
      let that = this;
      let oneDet = false;
      let bean = {
        user_username: this.ruleForm.name,
        user_password: this.ruleForm.pass,
        user_email: this.ruleForm.email,
      };

      that.$refs["codeForm"].validate((valid) => {
        if (valid) {
          oneDet = true;
        } else {
          return false;
        }
      });

      this.$refs[formName].validate((valid) => {
        if (valid && oneDet) {
          veriftyName(that.ruleForm.name, function (res) {
            if (res.data.status != 0) {
              veriftyEmail(
                that.ruleForm.email,
                that.emailCode.code,
                function (res) {
                  if (res.data.status != 0) {
                    registerUser(bean, function (res) {
                      if (res.data.status == 1) {
                        that.$alert("恭喜你注册成功!!", "提示", {
                          confirmButtonText: "确定",
                          callback: (action) => {
                            that.$message({
                              type: "success",
                              message: `跳转到主页`,
                            });

                            that.$router.replace({
                              path: "/",
                            });
                          },
                        });
                      }
                    });
                  } else {
                    that.errorForm.code = "验证码错误";
                  }
                }
              );
            } else {
              that.errorForm.name = "名称已被使用!";
            }
          });
        } else {
          return false;
        }
      });
    },
  },
};
</script>

<style scoped>
.header {
  display: flex;
  justify-content: space-between;
  font-size: 38px;
  font-weight: 400;
  font-family: "erxian";
  padding: 15px;
}
.register-container {
  padding: 20px;
  width: 400px;
  min-height: 500px;
  border: 1px solid rgba(0, 0, 0, 0.3);
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
}
.register-center-container {
  display: flex;
  justify-content: center;
}
.bth-container {
  width: 100%;
  display: flex;
  justify-content: center;
}
.code-bth {
  font-size: 1px;
  width: 100px;
  display: flex;
  justify-content: center;
}
.demo-form-inline {
  display: flex;
}
.code-input {
  width: 60px;
}
</style>