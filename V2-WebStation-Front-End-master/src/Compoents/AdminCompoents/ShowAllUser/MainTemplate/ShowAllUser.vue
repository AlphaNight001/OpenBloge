<template>
  <div class="admin-showalluser-container">
    <el-table
      border
      :data="
        userlist.filter(
          (data) =>
            !search ||
            data.user_email.toLowerCase().includes(search.toLowerCase())
        )
      "
      style="width: 100%"
    >
      <el-table-column label="ID" :width="50">
        <template slot-scope="scope">
          {{ scope.row.id }}
        </template>
      </el-table-column>
      <el-table-column align="center" label="用户名">
        <template slot-scope="scope">
          {{ scope.row.user_username }}
        </template>
      </el-table-column>
      <el-table-column prop="user_email" label="邮箱">
        <template slot-scope="scope">
          {{ scope.row.user_email }}
        </template>
      </el-table-column>
      <el-table-column label="管理员权限">
        <template slot-scope="scope">
          <el-switch
            v-model="scope.row.user_power"
            active-color="#13ce66"
            inactive-color="#ff4949"
            @change="changeUser(scope.row)"
          >
          </el-switch>
          <span>{{ scope.row.user_power == true ? "开启" : "关闭" }}</span>
        </template>
      </el-table-column>
      <el-table-column label="账号状态">
        <template slot-scope="scope">
          <el-select
            @change="changeUser(scope.row)"
            v-model="scope.row.user_isban"
            placeholder="请选择"
          >
            <el-option
              v-for="item in options"
              :key="item.value"
              :value="item.value"
            >
            </el-option>
          </el-select>
        </template>
      </el-table-column>
      <el-table-column align="center">
        <template slot-scope="scope" slot="header">
          <el-input v-model="search" placeholder="搜索邮箱"></el-input>
        </template>
        <template slot-scope="scope">
          <el-button size="mini" type="danger" @click="delateUser(scope.row.id)"
            >删除用户</el-button
          >
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import { getalluser, changeUserStatus, delateUserByID } from "@/Util/Serve";
export default {
  data() {
    return {
      userlist: [],
      search: "",
      options: [{ value: "正常" }, { value: "封禁中" }],
    };
  },
  mounted() {
    this.getAllUser();
  },
  methods: {
    delateUser(id) {
      let that = this;
      delateUserByID(id, function (res) {
        that.getAllUser();

        if (res.data.status == 1) {
          that.$message({
            message: "状态设置成功",
            type: "success",
          });
        } else {
          that.$message.error("出错了，这是一条错误消息");
        }
      });
    },

    getAllUser() {
      let that = this;
      getalluser(function (res) {
        that.userlist = res.data.userlist;
        for (let i = 0; i < that.userlist.length; i++) {
          if (that.userlist[i].user_power == 1) {
            that.$set(that.userlist[i], "user_power", true);
          } else {
            that.$set(that.userlist[i], "user_power", false);
          }

          if (that.userlist[i].user_isban == 0) {
            that.$set(that.userlist[i], "user_isban", "正常");
          } else {
            that.$set(that.userlist[i], "user_isban", "封禁中");
          }
        }
      });
    },
    changeUser(row) {
      let that = this;
      console.log(row);
      let user_power = null;
      if (row.user_power == true) {
        user_power = "1";
      } else {
        user_power = "0";
      }
      let user_isban = null;
      if (row.user_isban == "正常") {
        user_isban = 0;
      } else {
        user_isban = 1;
      }

      let bean = {
        id: row.id,
        user_power: user_power,
        user_isban: user_isban,
      };

      changeUserStatus(bean, function (res) {
        if (res.data.status == 1) {
          that.$message({
            message: "状态设置成功",
            type: "success",
          });
        } else {
          that.$message.error("出错了，这是一条错误消息");
        }
        that.getAllUser();
      });
    },
  },
};
</script>

<style scoped>
</style>