import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    token:"0",
    userName: null,
    userPower: null,
  },
  mutations: {
    changeToken(state, newToken) {
      state.token = newToken
    },
    changePower(state,userPower){
      state.userPower=userPower
    },
    changeUsername(state,userName){
      state.userName=userName
    }
  },



});
