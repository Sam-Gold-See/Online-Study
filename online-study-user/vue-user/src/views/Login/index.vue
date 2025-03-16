<script setup lang="ts">
import { useUserStore } from '@/stores/user' 
import myForm from '@/views/Login/form.vue'
import { reactive, ref } from 'vue'
import type { ComponentSize, FormInstance, FormRules } from 'element-plus'
import { useRouter } from 'vue-router'


const router=useRouter()
const userStore=useUserStore()



//调用登录接口
const postLogin=async (message: any)=>{
    await userStore.getUserInfo(message)
    console.log(userStore.userInfo);


    //登录成功后跳转
    if(true){
        router.replace({path:'/'})
    }
}
</script>


<template>
    <div>
        <div style="position: absolute;left:180px;top:90px">
            <img src="@/assets/logo.svg" class="img">
        </div>
        <div style="position:absolute;left:900px;top:130px;width:550px;height:600px">
            <my-form @Login="postLogin"/>
        </div>
    </div>
</template>


<style>
.img{
    width: 650px;
    height: 650px;
    border:1px solid black;
}
</style>
