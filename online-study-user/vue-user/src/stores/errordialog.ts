import { defineStore } from 'pinia'
import { ref } from 'vue'

export const useErrorStore = defineStore('errordialog', () => {
  
    const see=ref(false)
    const msg=ref('')

    return{
        see,
        msg
    }

})