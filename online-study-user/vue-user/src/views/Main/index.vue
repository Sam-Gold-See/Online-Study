<script setup lang="ts">
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import { useScheduleStore } from '@/stores/schedule' 

const schedulStore=useScheduleStore()
const router=useRouter()

const functionBox=['首页','Blog','社区','招募']
const routerBox=['/','/','','/recruit']

const userBox=['个人中心','消息','收藏']
const routerBox2=['/self','/','/']
const firstLevel=ref(0)


</script>

<template>
    <div>
        <div class="top">
            <div class="title">
                在线学习平台
            </div>

            <div class="function">
                <div v-for="(fun,index) in functionBox" class="box" :class="{'firstActive':firstLevel===index}"
                    @click="firstLevel=index,router.push({path:routerBox[index]})"
                >
                    {{ fun }}
                </div>
            </div>

            <div class="user">
                <div style="float: left;margin-right:5px;">
                    <img src="@/assets/Avatar.png" style="width:50px;height:50px;margin-top:16px;">
                </div>
                <div v-for="(u,index) in userBox" class="box" style="margin-right:40px;" 
                    @click="router.push({path:routerBox2[index]})"
                >
                    {{ u }}
                </div>
            </div>    
        </div>

        
        <div class="content">       <!--背景图片-->
            <div>
                <RouterView />
            </div>
        </div>
    </div>
</template>



<style scoped>
.box{
    float:left;
    margin-right: 80px;
    cursor: pointer;
    color:#61666D;
    font-weight:300;
}

.firstActive,
.box:hover{
    color:black;
    font-weight:500;
}


.top{
    left:0px;
    top:0px;
    position: absolute;
    width:1690px;
    height:80px;
    
}


.title{
    width:400px;
    height:80px;
    font-weight:700;
    font-size:50px;
    text-align: right;   
    padding-top:5px;
    
}

.function{
    left:480px;
    top:0px;
    position: absolute; 
    width:680px;
    height:80px;
    line-height:80px;
    font-weight:300;
    font-size:30px;
}


.user{
    right:0px;
    top:0px;
    position: absolute;
    width:340px;
    height:80px;
    line-height:80px;
    font-weight:300;
    font-size:20px;
}


.content{
    position: absolute;
    top:100px;
    left:0px;
    width:1697px;
    height:699px;
    background-image: url('@/assets/background1.png');
}


</style>