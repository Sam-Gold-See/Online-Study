<script setup lang="ts">
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
            <span style="font-size:25px;font-weight:300;">{{ name }}</span>

            <div style="margin-top:20px;padding-left:65px;">
                <div class="lbox">
                    {{ follow }}关注
                </div>
                <div class="lbox">
                    {{ fans }}粉丝
                </div>
            </div>

            <div class="lfoot">
                <img src="@/assets/logo.svg" style="width:40px;height:35px;float:left;margin-left:175px;">
                <span style="font-size:20px;font-weight:200;margin-left:5px;float:left">编辑资料</span>
            </div>
            <div class="lfoot" style="margin-top:5px;">
                <img src="@/assets/logo.svg" style="width:40px;height:35px;float:left;margin-left:175px;">
                <span style="font-size:20px;font-weight:200;margin-left:5px;float:left">注销登录</span>
            </div>
        </div>

        <div class="right">
            <div class="header">
                <div class="title">
                    在线学习平台
                </div>
                <div style="padding-left:60px;">
                    <div class="rbox">
                        <img src="@/assets/logo.svg" style="width:40px;height:35px;float:left;">
                        <span style="font-size:20px;font-weight:200;margin-left:5px;float:left">文章</span>
                    </div>
                    <div class="rbox">
                        <img src="@/assets/logo.svg" style="width:40px;height:35px;float:left;">
                        <span style="font-size:20px;font-weight:200;margin-left:5px;float:left">代码库</span>
                    </div>
                    <div class="rbox">
                        <img src="@/assets/logo.svg" style="width:40px;height:35px;float:left;">
                        <span style="font-size:20px;font-weight:200;margin-left:5px;float:left">问答</span>
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
    width:120px;
    height:70px;
    border: 1px solid black;
    font-size:20px;
    font-weight:300;
    margin-right: 170px;
}
</style>
