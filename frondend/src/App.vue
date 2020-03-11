<template>
  <div id="app">
    <h2>url:{{ $store.state.url }}</h2>
    <cors></cors>
    <jsonp></jsonp>
    <raw-axios></raw-axios>
    <my-request></my-request>
  </div>
</template>

<script>
import Dashboard from '@/components/Dashboard'
// cors 跨域
import Cors from '@/components/Cors'
// jsonp 跨域
import Jsonp from '@/components/Jsonp'
// 裸用 axios
import RawAxios from '@/components/RawAxios'
// 对 axios 进行封装
import MyRequest from '@/components/MyRequest'

export default {
  name: 'App',
  components: {
    Dashboard,
    Jsonp,
    Cors,
    RawAxios,
    MyRequest
  }
}
</script>

<style></style>
