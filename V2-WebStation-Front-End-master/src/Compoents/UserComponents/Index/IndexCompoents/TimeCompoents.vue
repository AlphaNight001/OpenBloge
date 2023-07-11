<template>
  <nav class="time-container">
    <p class="year-time" onload="timego()"></p>
    <p class="timeback"></p>
    <div class="weather">
      <span>{{ weatherInfo.city }}</span>
      <span>{{ weatherInfo.weather }}</span>
      <span>{{ weatherInfo.temperature }}℃</span>
      <span>{{ weatherInfo.winddirection }}风</span>
      <span>{{ weatherInfo.windpower }}级</span>
    </div>
  </nav>
</template>

<script>
import { getWeather, getIp, getCity } from "@/Util/Serve";
import { time, getDom } from "@/assets/Javascript/TimeBack";

export default {
  data() {
    return {
      IPaddr: "",
      City: "",
      Province: "",
      CityCode: "",
      weatherInfo: "",
      hour: "",
      min: "",
      second: "",
      timep: ":",
    };
  },
  methods: {
    weatherData() {
      let that = this;
      getIp(function (res) {
        that.IPaddr = res.data;
      });
    },
  },
  mounted() {
    this.weatherData();
    getDom();
    setInterval(time, 1000);
  },
  watch: {
    IPaddr: function (newQuestion, oldQuestion) {
      let that = this;
      
      getCity(that.IPaddr, function (res) {
        that.Province = res.data.province;
        that.City = res.data.city;
        that.CityCode = res.data.adcode;

        getWeather(that.CityCode, function (res) {
          that.weatherInfo = res.data.lives[0];
        });
      });
    },
  },
};
</script>

<style scoped>
/* 右侧上部分时间盒子 */
.timeback {
  display: flex;
}
.time-container {
  width: 50%;
  height: 250px;
  font-size: 34px;
  text-align: center;
  font-weight: 600;
  color: rgb(255, 255, 255);
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  justify-content: space-around;
}
.weather {
  display: flex;
  justify-content: center;
  width: 100%;
  white-space: nowrap;
  font-size: 18px;
  box-sizing: border-box;
}
.weather > span {
  margin: 0px 10px;

}

@media (max-width: 767px) {
 
}
</style>