<script setup lang="ts">
import { ref } from 'vue'
import { useRouter } from 'vue-router'
const router=useRouter()

const name=ref('昵称')
const follow=ref(1)
const fans=ref(2)


const current=ref(0)
</script>

<template>
    <div>
        <div class="left">
            <span style="font-size:35px;font-weight:400;">个人中心</span>
            <div style="margin-top:40px;">
                <img src="@/assets/Avatar.png" style="width:150px;height:140px;">
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

            <div class="lfoot" style="margin-top:250px;" @click="router.push({path:'/changeself'})">
                <img src="@/assets/edit.png" style="width:40px;height:35px;float:left;">
                <span style="font-size:20px;font-weight:200;margin-left:5px;float:left;padding-top:5px;">编辑资料</span>
            </div>
            <div class="lfoot" @click="router.push({path:'/'})">
                <img src="@/assets/back.png" style="width:40px;height:35px;float:left;">
                <span style="font-size:20px;font-weight:200;margin-left:5px;float:left;padding-top:7px;">返回首页</span>
            </div>
            <div class="lfoot" @click="router.replace({path:'/login'})">
                <img src="@/assets/logout.png" style="width:40px;height:35px;float:left;">
                <span style="font-size:20px;font-weight:200;margin-left:5px;float:left;padding-top:5px;">注销登录</span>
            </div>
        </div>

        <div class="right">
            <div class="header">
                <div class="title">
                    在线学习平台
                </div>
                <div>
                    <div class="rbox" :class="{'active':current===0}" @click="current=0">
                        <img src="@/assets/passage.png" style="">
                        <span style="">文章</span>
                    </div>
                    <div class="rbox" :class="{'active':current===1}" @click="current=1">
                        <img src="@/assets/repository.png" style="">
                        <span style="">代码库</span>
                    </div>
                    <div class="rbox" :class="{'active':current===2}" @click="current=2">
                        <img src="@/assets/question.png" style="">
                        <span style="">问答</span>
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
    height:768px;
    text-align: center;
    padding-top:30px;
}

.lbox{
    width:140px;
    height:50px;
    line-height: 50px;
    float:left;
    font-size:20px;
    font-weight:300;
    margin-right: 70px;
    background-color: #cccccc;
}

.lfoot{
    padding-top:7px;
    margin-top:5px;
    margin-left:170px;
    width:140px;
    height:50px;
    padding-top:10px;
    font-size:20px;
    font-weight:300;
    cursor:pointer;
}

.lfoot:hover{
    color:blue;
    transform:scale(1.03);
}

.right{
    width:1200px;
    height:798px;
    position:absolute;
    right:0px;
    top:0px;
    border-left:2px solid gray;
    background-image: url('@/assets/selfbg.png');
}

.header{
    left:0px;
    top:0px;
    position: absolute;
    width:1200px;
    height:170px;
    text-align: center;
    border-bottom:1px solid black;
}

.title{
    height:70px;
    text-align: right;
    padding-top: 35px;
    padding-right:30px;
    font-size:40px;
    font-weight:600;
}

.rbox{
    float:left;
    width:270px;
    height:35px;
    margin-top:10px;
    margin-left:0px;
    padding-top:20px;
    font-size:20px;
    font-weight:300;
    cursor:pointer;
}


.active,
.rbox:hover{
    background-color: rgba(255, 255, 255, 0.628);
}

.rbox img{
    width:40px;
    height:35px;
    float:left;
    margin-top:0px;
    margin-left:90px;
}

.rbox span{
    font-size:20px;
    font-weight:200;
    margin-left:5px;
    padding-top:2px;
    float:left;
}
</style>
