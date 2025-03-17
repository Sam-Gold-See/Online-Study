import { defineStore } from 'pinia'
import { ref } from 'vue'
import { scheduleDetail } from '@/apis/user.js' 

export const useScheduleStore = defineStore('schedule', () => {
  
    const details=ref({})

    const getDetails= async (message: any)=>{
        details.value = await scheduleDetail(message).result
    }

    return{
        details,
        getDetails
    }
} ,{
    persist:true
})