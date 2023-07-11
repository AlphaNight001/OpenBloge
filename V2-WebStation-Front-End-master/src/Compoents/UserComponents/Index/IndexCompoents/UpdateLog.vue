<template>
  <div class="IndexCompoents-UpdateLog">
    <i class="close-left-nav el-icon-close" @click="closeBth()">关闭</i>
    <div class="block">
      <el-timeline :reverse="reverse">
        <el-timeline-item
          v-for="(p, index) in updateArr"
          :key="index"
          :timestamp="p.update_Time"
          placement="top"
          type="success"
        >
          <el-card>
            <div v-html="p.html_Tag"></div>
          </el-card>
        </el-timeline-item>
      </el-timeline>
    </div>
  </div>
</template>

<script>
import { selectAllUpdate } from "@/Util/Serve";
export default {
  data() {
    return {
      reverse: true,
      updateArr: [],
      
    };
  },
  mounted() {
    let that = this;
    selectAllUpdate(function (res) {
      that.updateArr = res.data.list;
      console.log(that.updateArr);
    });
  },
  methods: {
    closeBth() {
      this.$emit("closeLeftNav");
    },
  },
};
</script>

<style scoped>
.IndexCompoents-UpdateLog {
  position: relative;
  box-sizing: border-box;
  padding: 20px;
  width: 95%;
  height: 98%;
  border-radius: 20px;
  background-color: rgba(105, 175, 193, 0.459);
  overflow-y: scroll;
  z-index: 999;
}
.IndexCompoents-UpdateLog::-webkit-scrollbar {
  border-radius: 20px;
  width: 5px;
  height: 50px;
}
.IndexCompoents-UpdateLog::-webkit-scrollbar-thumb {
  width: 100%;
  border-radius: 20px;
  background-color: rgb(117, 99, 99);
}

.IndexCompoents-UpdateLog >>> .el-timeline-item__timestamp {
  color: black;
}
.close-left-nav {
  position: absolute;
  width: 60px;
  height: 20px;
  font-size: 20px;
  top: 0px;
  right: 10px;
  display: flex;
  white-space: nowrap;
  cursor: pointer;
  z-index: 99;
}

@media (max-width: 767px) {
  .IndexCompoents-UpdateLog {
    background-color: rgba(105, 175, 193, 1);
  }
}
</style>