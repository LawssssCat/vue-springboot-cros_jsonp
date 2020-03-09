<template>
  <div>
    <dashboard title="cors" ></dashboard>
  </div>
</template>

<script>
import Dashboard from '@/components/Dashboard'

export default {
  name: 'Cors',
  components: {
    Dashboard
  },
  methods: {
    getItems () {
      return new Promise((resolve) => {
        let url = this.$store.state.url
        let xhr = new XMLHttpRequest()
        xhr.open('GET', url)
        xhr.send()
        xhr.onload = (e) => {
          resolve(e.target)
        }
      }).then(xhr => {
        let body = JSON.parse(xhr.response)
        if (body.code === 200) {
          this.$store.commit('updateItems', body.data)
        }
      })
    }
  }
}
</script>

<style>
</style>
