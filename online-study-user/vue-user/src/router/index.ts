import { createRouter, createWebHistory } from 'vue-router'
import login from '@/views/Login/index.vue'
import main from '@/views/Main/index.vue'
import register from '@/views/Register/index.vue'
import findpass from '@/views/findPassword/index.vue'
import success from '@/views/findPassword/success.vue'
import apply from '@/views/findPassword/apply.vue'
import def from '@/views/Main/default.vue'
import plan from '@/views/Main/plan.vue'
import dynamic from '@/views/Main/dynamic.vue'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path:'/',
      component:main,  //主页
      children:[
        {
          path:'',
          component:def
        },

        {
          path:'plan',
          component:plan
        },

        {
          path:'dynamic',
          component:dynamic
        },
      ]
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
