<template>
  <div>
    <dashboard title="裸用 axios">
    </dashboard>
  </div>
</template>

<script>
// axios 跨域
import axios from 'axios'
import Dashboard from '@/components/Dashboard'

function request () {
  return axios
    .all([
      axios({
        url: 'http://localhost:8001/home/multidata',
        method: 'get'
      }),
      axios.get('http://localhost:8001/order/data', {
        // 专门针对get请求的参数拼接
        params: {
          type: 'book',
          page: 3
        }
      })
    ])
    .then(value => {
      console.log('value', value)
      return Promise.resolve(value)
    })
    .then(
      axios.spread((res1, res2) => {
        this.$store.state.items = res1
      })
    )
}
export default {
  name: 'RawAxios',
  methods: {
    getItems: request
  },
  components: {
    Dashboard
  }
}
</script>

<style></style>
