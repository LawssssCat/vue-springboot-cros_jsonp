<template>
  <div>
    <dashboard title="jsonp" >
      <template v-slot:show>
        <p>
          点击 show 展示数据<font color='#f10111'>（在控制台中）</font>
        </p>
      </template>
    </dashboard>
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
    getItems (url) {
      return new Promise((resolve) => {
        if (!url) url = this.$store.state.url
        if (url.indexOf('?') === -1) url += '?'
        else url += '&'
        url += 'callback=document.callback'

        let script = document.createElement('script')
        script.src = url

        document.body.appendChild(script)
        document.callback = function (result) {
          console.log(result)
          document.body.removeChild(script)
        }
        resolve()
      })
    }

  }
}
</script>

<style>
</style>
