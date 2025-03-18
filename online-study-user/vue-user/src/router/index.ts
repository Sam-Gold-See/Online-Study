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
import self from '@/views/Self/index.vue'
import changeself from '@/views/ChangeSelf/index.vue'
import edit from '@/views/ChangeSelf/edit.vue'
import cgpass from '@/views/ChangeSelf/password.vue'


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
    },

    {
      path:'/self',
      component: self,   //个人中心页
      

    },

    {
      path:'/changeself',
      component: changeself,   //更改个人信息页
      children:[
        {
          path:'',
          component: edit
        },

        {
          path:'password',
          component: cgpass
        },
      ]


    }


    




  ],
})

export default router
