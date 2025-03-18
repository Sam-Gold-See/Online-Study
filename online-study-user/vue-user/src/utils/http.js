//axios 配置
import axios from "axios";

import { useErrorStore } from '@/stores/errordialog' 


const http=axios.create({
    baseURL: 'http://localhost:8080',
    timeout:5000
})


//请求拦截器
http.interceptors.request.use(config => {
    return config
},e => Promise.reject(e))

//响应拦截器
http.interceptors.response.use(res => res.data, e => {

    //返回的错误信息以弹窗形式呈现
    const errorStore=useErrorStore()
    errorStore.msg=e.response
    errorStore.see=true

    return Promise.reject(e)
})

export default http

