<template>
  <div class="user-messageinner-container">
    <el-button class="backBth" @click="backIndex" type="primary" round
      ><span class="el-icon-back"></span>返回</el-button
    >

    <!-- 发言表单 -->
    <div class="message-upload-container" v-if="messageBox">
      <span class="el-icon-close" @click="messageBox = false"></span>
      <el-form :rules="rules" :model="ruleForm" ref="ruleForm">
        <el-form-item prop="textarea" label="发布你想说的：" label-width="auto">
          <el-input
            type="textarea"
            :rows="2"
            placeholder="请输入内容"
            v-model="ruleForm.textarea"
            resize="none"
            maxlength="50"
            show-word-limit
          >
          </el-input>
        </el-form-item>
      </el-form>

      <el-button type="success" @click="pushMsg()" round>确认发布</el-button>
    </div>

    <!-- 页面头部 -->
    <el-row>
      <el-col :lg="24" class="top-container">
        <span class="say-upload" @click="messageBox = true">我也来说一句</span>
      </el-col>
    </el-row>

    <!-- 页面评论显示区域 -->
    <el-row type="flex" justify="center">
      <el-col :lg="17" class="msg-container">
        <div v-for="p in messageResult" :key="p.id" class="user-msg-container">
          <section class="user-touxiang">
            <span class="el-icon-s-custom" :style="p.user_power==0?'':'color:red;'"></span>
          </section>
          <section class="user-msg">
            <div class="user-msg-top">
              <p class="user-name" :style="p.user_power==0?'':'color:red;'">{{p.msg_username}}</p>
              <span>发布于</span>
              <p class="msg-date">{{p.msg_time}}</p>
            </div>
            <el-divider></el-divider>
            <div class="user-msg-bottom">
              <p class="msg-data">{{p.msg_message}}</p>
            </div>
          </section>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import { uploadMessage, getAllMessage } from "@/Util/Serve";
export default {
  data() {
    return {
      messageBox: false,
      rules: {
        textarea: [
          { required: true, message: "请输入活动名称", trigger: "blur" },
          { min: 3, max: 50, message: "长度在 3 到 50个字符", trigger: "blur" },
        ],
      },
      ruleForm: {
        textarea: "",
      },
      messageResult: "",
    };
  },
  mounted() {
    let that = this;
    getAllMessage(function (res) {
      that.messageResult = res.data.result;
      console.log(res.data.result);
    });
  },
  methods: {
    pushMsg() {
      let that = this;
      let bean = {
        msg_message: that.ruleForm.textarea,
      };
      console.log(bean);
      this.$refs["ruleForm"].validate((valid) => {
        if (valid) {
          uploadMessage(bean, function (res) {
            if (res.data.status == 1) {
              that.$message({
                message: "留言发布成功！！",
                type: "success",
              });
              that.messageBox = false;
              that.ruleForm.textarea = "";
              getAllMessage(function (res) {
                that.messageResult = res.data.result;
              });
            } else {
              that.$alert("你的登录状态错误，请先登录", "警告", {
                confirmButtonText: "确定",
                callback: (action) => {
                  that.$message({
                    type: "error",
                    message: `跳转至主页!!`,
                  });

                  that.$router.replace({
                    path: "/",
                  });
                },
              });
            }
          });
        } else {
          return false;
        }
      });
    },
    backIndex() {
      this.$router.push({
        path: "/",
      });
    },
  },
};
</script>

<style scoped>
.top-container {
  background: linear-gradient(
    to right,
    rgb(66, 87, 142),
    rgba(47, 165, 229, 0.401)
  );
  height: 300px;
  display: flex;
  justify-content: center;
  align-items: center;
}
.say-upload {
  cursor: pointer;
  border-radius: 50px;
  background-color: rgba(49, 74, 196, 0.415);
  font-size: 26px;
  color: aliceblue;
  padding: 20px;
}
.backBth {
  position: fixed;
  right: 20px;
  bottom: 40px;
  background-color: #1a1aa344;
  z-index: 99;
}

.message-upload-container {
  width: 500px;
  height: 400px;
  position: absolute;
  left: 50%;
  background-color: rgb(250, 253, 255);
  margin-left: -250px;
  z-index: 99;
  top: 30px;
  border-radius: 50px;
  box-sizing: border-box;
  border: 1px solid #eee;
  padding: 25px;
  font-size: 26px;
  display: flex;
  flex-direction: column;
  justify-content: center;
}
.message-upload-container /deep/ .el-textarea__inner {
  height: 250px;
}
.el-icon-close {
  position: absolute;
  cursor: pointer;
  right: 25px;
  top: 10px;
  font-size: 26px;
  z-index: 99;
}

/* 评论展示区的样式 */

.msg-container {
  display: flex;
  align-items: center;
  flex-direction: column;
}
.user-msg-container {
  margin-top: 25px;
  width: 800px;
  min-height: 100px;
  display: flex;
}
.el-icon-s-custom {
  font-size: 60px;
}
.user-touxiang {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100px;
  height: 100%;
  border-radius: 20px;
  color: #409eff;
}
.user-msg {
  flex: 1;
  border-radius: 30px;
  margin: 5px;
  box-sizing: border-box;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
}
.user-msg-top {
  width: 100%;
  height: 38px;
  display: flex;
  align-items: center;
  padding-left: 15px;
  box-sizing: border-box;
}
.user-msg-top>span{
  margin-left: 15px;
  margin-right: 15px;
  color: #909399;
}
.user-name{
  color: #409eff;
}
.msg-date{
  color: #909399;
}
.user-msg-bottom {
  flex: 1;
  box-sizing: border-box;
  padding: 15px;
}

.user-msg /deep/ .el-divider {
  margin: 0;
}

.msg-data {
  color: #606266;
  font-weight: 100;
}

@media (max-width: 767px) {
  .info {
    max-width: 250px;
  }
  .message-upload-container {
    width: 300px;
    height: 400px;
    margin-left: -150px;
  }
  .user-msg-container{
    width: 100%;
  }
}
</style>