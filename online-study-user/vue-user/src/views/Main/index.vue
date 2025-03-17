<script setup lang="ts">
import { useScheduleStore } from '@/stores/schedule' 

const schedulStore=useScheduleStore()

const functionBox=['Blog','社区','招募']
const userBox=['个人中心','消息','历史']


</script>

<template>
    <div>
        <div class="top">
            <div class="title">
                在线学习平台
            </div>
            <div class="function">
                <div v-for="fun in functionBox" class="box">{{ fun }}</div>
            </div>
            <div class="user">
                <div style="float: left;margin-right:5px;"><img src="@/assets/logo.svg" style="width:50px;height:40px;"></div>
                <div v-for="u in userBox" class="box">{{ u }}</div>
            </div>    
        </div>

        <div>
            <RouterView />
        </div>
        <div class="schedule">
            <el-scrollbar class="detailbox">
                <div class="detail">
                    123111111111111111111111111111111111111111111111111111111111111111111111111111111111
                    123111111111111111111111111111111111111111111111111111111111111111111111111111111111
                    123111111111111111111111111111111111111111111111111111111111111111111111111111111111
                    123111111111111111111111111111111111111111111111111111111111111111111111111111111111
                    123111111111111111111111111111111111111111111111111111111111111111111111111111111111
                    123111111111111111111111111111111111111111111111111111111111111111111111111111111111
                    123111111111111111111111111111111111111111111111111111111111111111111111111111111111
                    123111111111111111111111111111111111111111111111111111111111111111111111111111111111
                </div>
                <div class="detail">
                    123
                </div>
                <div class="detail">
                    123
                </div>
                <!--
                <div v-for="d in schedulStore.details" class="detail">
                    {{ d }}
                </div>
                -->
            </el-scrollbar>

            <div style="text-align: center;margin-top:30px;">
                <span style="font-size:25px;font-weight:400" >日程安排</span>
            </div>

        </div>
    </div>
</template>



<style scoped>
.box{
    float:left;
    margin-right: 60px;
}

.top{
    left:0px;
    top:0px;
    position: absolute;
    width:1690px;
    height:80px;
    border: 1px solid black;
    
}

.title{
    width:380px;
    height:80px;
    font-weight:700;
    font-size:50px;
    text-align: right;   
    border: 1px solid black;
    
}

.function{
    left:450px;
    top:30px;
    position: absolute; 
    width:680px;
    height:50px;
    font-weight:200;
    font-size:30px;
    border: 1px solid black;
}

img{
    width:50px;
    height:40px;
}

.user{
    right:0px;
    top:40px;
    position: absolute;
    width:480px;
    height:40px;
    font-weight:200;
    font-size:20px;
    border: 1px solid black;
}

.schedule{
    right:20px;
    top:90px;
    position: absolute;
    width:650px;
    height:680px;
    border: 1px solid black;
}

.detailbox{
    width:500px;
    height:550px;
    margin-top:30px;
    padding-top:1px;
    margin-left:75px;
    background-color: rgba(0, 0, 0, 0.288);
    text-align: center;
}

.detail{
    width:440px;
    line-height:30px;
    margin-top:30px;
    margin-bottom:20px;
    margin-left:30px;
    border: 1px solid white;
    text-align: center;
    font-size:18px;
    color:blue;
    word-wrap: break-word;
}

</style>