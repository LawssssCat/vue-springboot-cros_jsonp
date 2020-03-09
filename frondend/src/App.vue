<template>
  <div id="app">
    <h2>url:{{$store.state.url}}</h2>
    <cors></cors>
    <jsonp></jsonp>
  </div>
</template>

<script>
import Dashboard from '@/components/Dashboard'
// cors 跨域
import Cors from '@/components/Cors'
// jsonp 跨域
import Jsonp from '@/components/Jsonp'

// axios 跨域
import axios from 'axios'

// /home/multidata
// /home/data?type=sell&page=3
axios({
  url: 'http://localhost:8001/home/multidata',
  method: 'get'
}).then(value => {
  console.log('http://localhost:8001/home/multidata', value)
})

// String[] types = { "phone", "book", "computer", "clothing", "daily-supply", "adult", "CD", "virtual" };
axios.get('http://localhost:8001/order/data', {
  // 专门针对get请求的参数拼接
  params: {
    type: 'book',
    page: 400
  }
}).then(value => {
  console.log('http://localhost:8001/order/data', value)
})

export default {
  name: 'App',
  components: {
    Dashboard,
    Jsonp,
    Cors
  }
}
</script>

<style>
</style>
