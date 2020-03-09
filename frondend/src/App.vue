<template>
  <div id="app">
    <h2>url:{{$store.state.url}}</h2>
    <cors>
    </cors>
  </div>
</template>

<script>
import Dashboard from '@/components/Dashboard'
import Cors from '@/components/Cors'

export default {
  name: 'App',
  components: {
    Dashboard,
    Cors
  }
}
</script>

<style>
</style>
