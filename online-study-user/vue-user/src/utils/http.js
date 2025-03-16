//axios 配置
import axios from "axios";

import { useErrorStore } from '@/stores/errordialog' 


const http=axios.create({
    baseURL: 'https://2852f0b0.r37.cpolar.top',
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
    errorStore.msg=e.response.data.msg
    errorStore.see=true

    return Promise.reject(e)
})

export default http

