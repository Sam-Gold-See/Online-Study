import { createRouter, createWebHistory } from 'vue-router'
import login from '@/views/Login/index.vue'
import layout from '@/views/Layout/index.vue'
import register from '@/views/Register/index.vue'
import findpass from '@/views/findPassword/index.vue'
import success from '@/views/findPassword/success.vue'
import apply from '@/views/findPassword/apply.vue'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path:'/',
      component:layout  //主页
    },

    {
      path:'/login',
      component:login  //登录页
    },

    {
      path:'/register',
      component: register   //注册页
    },

    {
      path:'/findpass',
      component: findpass,   //重置密码页
      
      children:[
        {
          path:'',
          component: apply
        },

        {
          path:'success',
          component: success
        }
      ]
    }


    




  ],
})

export default router
