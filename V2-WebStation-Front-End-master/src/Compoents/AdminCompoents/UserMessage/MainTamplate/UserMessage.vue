<template>
  <div class="admin-user-message">
    <el-table
      :data="
        result.filter(
          (data) =>
            !search ||
            data.msg_username.toLowerCase().includes(search.toLowerCase())
        )
      "
      style="width: 100%"
    >
      <el-table-column label="时间" prop="msg_time"> </el-table-column>
      <el-table-column label="用户" prop="msg_username"> </el-table-column>
      <el-table-column label="内容" prop="msg_message"> </el-table-column>
      <el-table-column align="right">
        <template slot="header" slot-scope="scope">
          <el-input v-model="search" size="mini" placeholder="输入关键字搜索" />
        </template>
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="danger"
            @click="handleDelete(scope.$index, scope.row)"
            >Delete</el-button
          >
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import { getAllMessage, delateMsgByID } from "@/Util/Serve";
export default {
  data() {
    return {
      search: "",
      result: [],
    };
  },
  mounted() {
    let that = this;
    getAllMessage(function (res) {
      that.result = res.data.result;
    });
  },
  methods: {
    handleDelete(index, row) {
      let that = this;
      delateMsgByID(row, function (res) {
        if (res.data.status == 1) {
          that.$message({
            message: "删除成功",
            type: "success",
          });

          getAllMessage(function (res) {
            that.result = res.data.result;
          });
        }else{
            that.$message.error('出错了，请检查服务器');
        }
      });
    },
  },
};
</script>

<style scoped>
.admin-user-message {
  width: 100%;
  height: 100%;
  background-color: #ffff;
}
</style>