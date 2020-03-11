import axios from 'axios'

// 封装 request 模块
export function request (config) {
  // 1. 创建 axios 的实例
  const instance = axios.create({
    baseURL: 'http://localhost:8001',
    timeout: 5000
  })

  // axios 的拦截器
  instance.interceptors.request.use(
    config => { // config 是 请求的配置信息
      console.log('request interceptor success', config)
      return config
    },
    err => {
      console.log('request interceptor err', err)
    }
  )
  instance.interceptors.response.use(response => {
    console.log('response interceptor success', response)
    return response
  }, err => {
    console.log('response interceptor err', err)
  })

  // 发送真正的网络请求
  return instance(config)
}
