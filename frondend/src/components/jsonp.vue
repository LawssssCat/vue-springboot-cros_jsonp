<template>
  <div>
    <dashboard title="jsonp" ></dashboard>
  </div>
</template>

<script>
import Dashboard from '@/components/Dashboard'

export default {
  name: 'Jsonp',
  components: {
    Dashboard
  },
  methods: {
    getItems () {
      return new Promise(() => {
        let url = this.$store.state.url
        if (url.indexOf('?') === -1) url += '?'
        else url += '&'
        url += 'callback=document.callback'

        let script = document.createElement('script')
        script.src = url

        document.body.appendChild(script)
        document.callback = function (result) {
          document.write('看看控制台~')
          console.log(result)
          document.body.removeChild(script)
        }
      })
    }

  }
}
</script>

<style>
</style>
