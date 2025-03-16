import { defineStore } from 'pinia'
import { ref } from 'vue'
import { loginApi } from '@/apis/user.js' 

export const useUserStore = defineStore('user', () => {
  
    const userInfo=ref({})

    const getUserInfo= async (message: any)=>{
        userInfo.value = await loginApi(message).result
    }

    return{
        userInfo,
        getUserInfo
    }
} ,{
    persist:true
})