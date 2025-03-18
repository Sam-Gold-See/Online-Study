<script setup lang="ts">
import router from '@/router'
import { ref } from 'vue'
const name=ref('昵称')
const follow=ref(1)
const fans=ref(2)

</script>

<template>
    <div>
        <div class="left">
            <span style="font-size:35px;font-weight:400;">个人中心</span>
            <div style="margin-top:40px;">
                <img src="@/assets/logo.svg" style="width:150px;height:140px;">
            </div>
            <div class="lfoot" style="margin-top:30px;">
                <img src="@/assets/logo.svg" style="width:40px;height:35px;float:left;margin-left:175px;">
                <span style="font-size:20px;font-weight:200;margin-left:5px;float:left">更换头像</span>
            </div>
            <div class="lfoot">
                <img src="@/assets/logo.svg" style="width:40px;height:35px;float:left;margin-left:175px;">
                <span style="font-size:20px;font-weight:200;margin-left:5px;float:left">注销登录</span>
            </div>
        </div>

        <div class="right">
            <div class="header">
                <div class="title">
                    在线学习平台
                </div>
                <div style="padding-left:40px;">
                    <div class="rbox">
                        <img src="@/assets/logo.svg" style="width:40px;height:35px;float:left;">
                        <span style="font-size:20px;font-weight:200;margin-left:5px;float:left" 
                            @click.prevent="router.replace({path:'/changeself'})"
                        >
                            基本信息
                        </span>
                    </div>
                    <div class="rbox">
                        <img src="@/assets/logo.svg" style="width:40px;height:35px;float:left;">
                        <span style="font-size:20px;font-weight:200;margin-left:5px;float:left"
                            @click.prevent="router.replace({path:'/changeself/password'})"
                        >
                            账户安全
                        </span>
                    </div>
                </div>
            </div>

            <RouterView />

        </div>

    </div>
</template>

<style scoped>
.left{
    left:0px;
    top:0px;
    position: absolute;
    width:500px;
    height:800px;
    border: 1px solid black;
    text-align: center;
    padding-top:30px;
}

.lbox{
    width:140px;
    height:50px;
    line-height: 50px;
    border: 1px solid black;
    float:left;
    font-size:20px;
    font-weight:300;
    margin-right: 70px;
    background-color: #cccccc;
}

.lfoot{
    padding-top:7px;
    margin-top:300px;
    text-align: center;
    width:500px;
    height:50px;
    border: 1px solid black;
    font-size:20px;
    font-weight:300;
    margin-right: 70px;
}

.header{
    left:500px;
    top:0px;
    position: absolute;
    width:1195px;
    height:170px;
    border: 1px solid black;
    text-align: center;
}

.title{
    height:100px;
    border: 1px solid black;
    text-align: right;
    padding-top: 35px;
    padding-right:30px;
    font-size:40px;
    font-weight:600;
}

.rbox{
    float:left;
    padding-top:25px;
    text-align: center;
    width:150px;
    height:70px;
    border: 1px solid black;
    font-size:20px;
    font-weight:300;
    margin-right: 170px;
}
</style>
