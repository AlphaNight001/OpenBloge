<template>
  <div class="admin-showallupdate">
    <el-table :data="infoList" style="width: 100%">
      <el-table-column type="index" label="序号" align="center">
      </el-table-column>
      <el-table-column label="日志发布时间" align="center">
        <template slot-scope="scope">
          <i class="el-icon-time"></i>
          <span style="margin-left: 10px">{{ scope.row.update_Time }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center">
        <template slot-scope="scope">
          <el-button size="mini" @click="handleEdit(scope.row.id)"
            >编辑</el-button
          >
          <el-button
            size="mini"
            type="danger"
            @click="handleDelete(scope.row.id)"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import { selectAllUpdate, delateUpdateByID } from "@/Util/Serve";
export default {
  data() {
    return {
      infoList: [],
    };
  },
  mounted() {
    let that = this;
    selectAllUpdate(function (res) {
      that.infoList = res.data.list;
    });
  },
  methods: {
    handleDelete(id) {
      let that = this;
      delateUpdateByID(id, function (res) {
        console.log(res);
        if (res.data == 1) {
          that.$message({
            message: "成功删除记录！！",
            type: "success",
          });

          selectAllUpdate(function (res) {
            that.infoList = res.data.list;
          });
        }
      });
    },
    handleEdit(id) {
      this.$router.replace({
        name: "UpdateChange",
        params: {
          id: id,
        },
      });
    },
  },
};
</script>

<style>
</style>