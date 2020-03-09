<template>
  <div id="app">
    <h2>url:{{$store.state.url}}</h2>
    <cors></cors>
    <jsonp></jsonp>
  </div>
</template>

<script>
import Dashboard from '@/components/Dashboard'
import Cors from '@/components/Cors'
import Jsonp from '@/components/Jsonp'

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
