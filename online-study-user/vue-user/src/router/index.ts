import { createRouter, createWebHistory } from 'vue-router'
import login from '@/views/Login/index.vue'
import main from '@/views/Main/index.vue'
import register from '@/views/Register/index.vue'
import findpass from '@/views/findPassword/index.vue'
import home from '@/views/Main/home.vue'
import plan from '@/views/Main/plan.vue'
import note from '@/views/Main/note.vue'
import self from '@/views/Self/index.vue'
import changeself from '@/views/ChangeSelf/index.vue'
import edit from '@/views/ChangeSelf/edit.vue'
import cgpass from '@/views/ChangeSelf/password.vue'
import recruit from '@/views/recruit/index.vue'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path:'/',
      component:main,  //主页

      children:[
        {
          path:'',
          component:home,     //主页中的首页

          children:[
            {
              path:'',
              component:plan,
            },

            {
              path:'note',
              component:note,
            }


          ],
        },

        {
          path:'/recruit',
          component: recruit,   //主页中的招募页
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


    },

    


    




  ],
})

export default router
