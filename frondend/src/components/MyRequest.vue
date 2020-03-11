<template>
  <div>
    <dashboard title="封装好的request"> </dashboard>
  </div>
</template>

<script>
// 封装好的 request 模块
import { request } from '@/network/request'
import Dashboard from '@/components/Dashboard'

export default {
  name: 'MyRequest',
  methods: {
    getItems (url) {
      if (!url) url = this.$store.state.url
      return request(url).then(
        value => {
          console.log(value)
        },
        reason => {
          console.log(reason)
        }
      )
    }
  },
  components: {
    Dashboard
  }
}
</script>

<style></style>
