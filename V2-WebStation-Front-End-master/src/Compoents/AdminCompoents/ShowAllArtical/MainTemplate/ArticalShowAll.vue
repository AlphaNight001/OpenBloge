<template>
  <div class="AdminArticalShowAll-container">
    <el-table :data="tableData" style="width: 100%">
      <el-table-column label="上传日期" width="300">
        <template slot-scope="scope">
          <i class="el-icon-time"></i>
          <span style="margin-left: 10px">{{ scope.row.artical_time }}</span>
        </template>
      </el-table-column>
      <el-table-column label="文章标题" width="300">
        <template slot-scope="scope">
          {{ scope.row.artical_title }}
        </template>
      </el-table-column>
      <el-table-column label="最后编辑时间" width="300">
        <template slot-scope="scope">
          {{ scope.row.artical_lastChangeTime }}
        </template>
      </el-table-column>
      <el-table-column label="操作" width="300">
        <template slot-scope="scope">
          <el-button size="mini" @click="handleEdit(scope.row.id)"
            >编辑</el-button
          >
          <el-button
            size="mini"
            type="danger"
            @click="handleDelete(scope.$index, scope.row.id)"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import axios from "axios";
import { delateArticalByID, selectAllArtical } from "@/Util/Serve";
export default {
  data() {
    return {
      tableData: [],
    };
  },
  methods: {
    open(id) {
      let that = this;
      this.$confirm("此操作将永久删除该文件, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          delateArticalByID(id, function (res) {
            console.log(res);
            if (res.data.status == 1) {
              that.$msgbox({
                type: "success",
                message: "删除成功!",
              });

              that.getAllArtical();
            } else {
              that.$msgbox({
                type: "warning",
                message: "删除失败!",
              });
            }
          });
        })
        .catch(() => {
          this.$msgbox({
            type: "info",
            message: "已取消删除",
          });
        });
    },
    handleEdit(id) {
      this.$router.push({
        name: "articaleditor",
        params: {
          id: id,
        },
      });
    },
    handleDelete(index, id) {
      this.open(id);
    },
    getAllArtical() {
      let that = this;
      selectAllArtical(function (res) {
        that.tableData = res.data.dataArtical;
      });
    },
  },

  mounted() {
    this.getAllArtical();
  },
};
</script>

<style scoped>
.AdminArticalShowAll-container {
  width: 100%;
}
</style>