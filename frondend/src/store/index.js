import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const store = new Vuex.Store({
  state: {
    url: 'http://localhost:8001/home/multidata',
    items: []
  },
  mutations: {
    updateItems (state, items) {
      state.items = items
    },
    resetItems (state) {
      state.items = []
    }
  }
})

export default store
