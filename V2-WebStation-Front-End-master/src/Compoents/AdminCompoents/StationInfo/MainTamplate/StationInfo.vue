<template>
  <div class="station-info-container">
    <v-chart class="chart" :option="option" />
  </div>
</template>

<script>
import { getArticalKindOfInfo } from "@/Util/Serve";
import { use } from "echarts/core";
import { CanvasRenderer } from "echarts/renderers";
import { PieChart } from "echarts/charts";
import {
  TitleComponent,
  TooltipComponent,
  LegendComponent,
} from "echarts/components";
import VChart, { THEME_KEY } from "vue-echarts";

use([
  CanvasRenderer,
  PieChart,
  TitleComponent,
  TooltipComponent,
  LegendComponent,
]);

export default {
  name: "HelloWorld",
  components: {
    VChart,
  },
  provide: {
    [THEME_KEY]: "dark",
  },
  data() {
    return {
      charData: null,
    };
  },
  computed: {
    option() {
      return {
        title: {
          text: "文章种类数据",
          left: "center",
        },
        tooltip: {
          trigger: "item",
        },
        legend: {
          orient: "vertical",
          left: "left",
        },
        series: [
          {
            name: "Traffic Sources",
            type: "pie",
            radius: "55%",
            center: ["50%", "60%"],
            data: this.charData,
            emphasis: {
              itemStyle: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: "rgba(0, 0, 0, 0.5)",
              },
            },
          },
        ],
      };
    },
  },
  created() {
    let that = this;
    getArticalKindOfInfo(function (res) {
      console.log(res);
      var chartData = res.data.result.map(function (item) {
        return {
          value: item.count,
          name: item.artical_kindOf,
        };
      });

      that.charData = chartData;
      console.log(that.charData);
    });
  },
};
</script>

<style scoped>
.station-info-container {
  height: 100vh;
  width: 100%;
}
.chart {
  height: 100%;
}
</style>