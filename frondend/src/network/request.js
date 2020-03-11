import axios from 'axios'

// 封装 request 模块
export function request (config) {
  // 1. 创建 axios 的实例
  const instance = axios.create({
    baseURL: 'http://localhost:8001',
    timeout: 5000
  })

  // 发送真正的网络请求
  return instance(config)
}
