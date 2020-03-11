<template>
  <div>
    <!--标题-->
    <slot name="title">
      <h3>------ {{ title }} ---------</h3>
    </slot>
    <!-- 按钮 -->
    <slot name="buttons">
      <button :class="{ active: isShow }" @click="toggle">show</button>
      <button @click="reset">reset</button>
    </slot>
    <!-- 提示 -->
    <slot name="show">
      <ul v-if="isShow">
        <li v-for="item in items" :key="item.id">{{ item }}</li>
      </ul>
      <p v-if="!isShow">点击show展示数据！</p>
    </slot>
  </div>
</template>

<script>
export default {
  name: 'Dashboard',
  data () {
    return {
      isShow: false
    }
  },
  computed: {
    items () {
      return this.$store.state.items
    }
  },
  props: {
    title: String
  },
  methods: {
    reset () {
      if (this.$parent.resetItems) {
        this.$parent.resetItems()
      } else {
        this.$store.commit('resetItems')
      }
      this.isShow = false
    },
    toggle () {
      if (this.isShow) {
        this.isShow = false
        return
      }
      if (!this.items) {
        this.isShow = true
        return
      }
      if (!this.$parent.getItems) {
        console.error("parent hasn't method 'getItems'")
        return
      }
      this.$parent.getItems().then(value => {
        this.isShow = true
      })
    }
  }
}
</script>

<style>
.active {
  color: red;
}
</style>
