<script setup lang="ts">
import { useRouter } from 'vue-router'
import { ref } from 'vue'
const router=useRouter()
const current=ref(0)
const name=ref('昵称')
const follow=ref(1)
const fans=ref(2)

</script>

<template>
    <div>
        <div class="left">
            <span style="font-size:35px;font-weight:400;">个人中心</span>
            <div style="margin-top:40px;">
                <img src="@/assets/Avatar.png" style="width:150px;height:140px;">
            </div>
            
            <div class="lfoot" style="margin-top:30px;margin-left:180px;" @click="router.replace({path:'/changeself'})">
                <img src="@/assets/photo.png" style="width:40px;height:35px;margin-left:10px;;float:left;">
                <span style="font-size:20px;font-weight:200;margin-left:5px;float:left;padding-top:5px;">更换头像</span>
            </div>

            <div class="lfoot" style="width:110px;" @click="router.replace({path:'/self'})">
                <img src="@/assets/back2.png" style="width:40px;height:35px;margin-left:10px;;float:left;">
                <span style="font-size:20px;font-weight:200;margin-left:5px;float:left;padding-top:5px;">返回</span>
            </div>
        </div>

        <div class="right">
            <div class="header">
                <div class="title">
                    在线学习平台
                </div>
                <div>
                    <div class="rbox"  :class="{'active':current===0}"
                        @click="current=0;router.replace({path:'/changeself'})"
                    >
                        <img src="@/assets/user.png" style="width:40px;height:35px;float:left;">
                        <span style="font-size:20px;font-weight:200;margin-left:5px;float:left" >
                            基本信息
                        </span>
                    </div>
                    <div class="rbox" :class="{'active':current===1}"
                        @click="current=1;router.replace({path:'/changeself/password'})"
                    >
                        <img src="@/assets/usersafe.png" style="width:40px;height:35px;float:left;">
                        <span style="font-size:20px;font-weight:200;margin-left:5px;float:left">
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
    height:768px;
    text-align: center;
    padding-top:30px;
}


.lfoot{
    padding-top:7px;
    margin-top:270px;
    width:140px;
    height:50px;
    font-size:20px;
    font-weight:300;
    margin-left: 190px;
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
    background-image: url('@/assets/bk3.png');
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
    margin-left:70px;
}

.rbox span{
    font-size:20px;
    font-weight:200;
    margin-left:5px;
    padding-top:2px;
    float:left;
}
</style>
