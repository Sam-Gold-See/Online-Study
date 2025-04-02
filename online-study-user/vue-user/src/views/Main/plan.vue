<script setup lang="ts"> 
import { ref } from 'vue'
const control = ref(1)
</script>


<template>
    <div class="container">
        <div class="title">
            <span style="margin-left: 50px;" @click="control=1" :class="{'active':control===1}">
                学习计划
            </span>
            <span @click="control=2" :class="{'active':control===2}">
                未完成待办
            </span>
            <span @click="control=3" :class="{'active':control===3}">
                已完成待办
            </span>
        </div>
        <div  v-if="control===1" style="width:920px;height:410px;">
            <el-scrollbar class="plan" style="height:360px;">
                <div class="plandetail">
                    123456666666666666666666666666666666666666666666666666666666661234566666666666666666666666666666666666666666666666666666666612345666666666666666666666666666666666666666666666666666666666
                </div>
                <div class="plandetail">123456</div>
                <div class="plandetail">123456</div>
                <div class="plandetail">123456</div>

            </el-scrollbar>
            <div style="margin-left:430px;margin-top:5px;">
                <el-button type='primary' style="height:40px;">添加计划</el-button>
            </div>
        </div>
        
        <div  v-else-if="control===2" style="width:920px;height:410px;">
            <el-scrollbar class="plan">
                <div class="plandetail">6654321</div>
                <div class="plandetail">6654321</div>
                <div class="plandetail">6654321</div>
                <div class="plandetail">6654321</div>

            </el-scrollbar>
        </div>

        <div  v-else style="width:920px;height:410px;">
            <el-scrollbar class="plan">
                <div class="plandetail">qwwqf</div>
                <div class="plandetail">qwwqf</div>
                <div class="plandetail">qwwqf</div>
                <div class="plandetail">qwwqf</div>
            </el-scrollbar>
        </div>

            
    </div>
    

</template>

<style scoped>
.container{
    position: absolute;
    left:70px;
    top:240px;
    width:920px;
    height:460px;
    border-radius: 25px;
    background-color: white;
}

.title{
    width:920px;
    height:40px;
    padding-top:7px;
}

.title span{
    cursor:pointer;
}

.active,
.title span:hover{
    color:rgb(0, 200, 255);
}

span{
    float:left;
    font-size:18px;
    font-weight:250;
    margin-left:120px;
}

.plan{
    width:920px;
    height:410px;
    border-top:1px solid black;
}

.plandetail{
    margin-left:15px;
    width:890px;
    margin-top:10px;
    margin-bottom:20px;
    text-align: center;
    font-size:21px;
    color:black;
    word-wrap: break-word;
}


</style>