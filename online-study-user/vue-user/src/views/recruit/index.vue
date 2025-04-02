<script setup lang="ts">
import { ref } from 'vue'
import detail from '@/views/recruit/detail.vue'


const pr = ref(false)       //点击搜索框时隐藏搜索两个字、显示发起按钮
const searchclass=ref('default')      //搜索框动态样式
const input=ref('')
const search=()=>{
    pr.value=true;
    searchclass.value='active';
}

const recover=()=>{
    pr.value=false;
    searchclass.value='default';
}


const clickdetail=ref(false)
const closedetail=()=>{
    clickdetail.value=true;
}

</script>

<template>
    <div class="container">
        <div class="header">
            <div class="title">招募</div>
            <div class="search">
                <div v-if="!pr" style="float:left;margin-left:890px;padding-top:20px;">搜索</div>
                <div :class="searchclass">
                    <el-input
                        style="height:40px;"
                        v-model="input"
                        placeholder="请输入比赛名称"
                        @click="search"
                        @blur="recover"
                    />
                </div>

                <div v-if="pr" class="initiate">
                    <el-button style="width:110px;height:50px;background-color: #cccccc;">发起</el-button>
                </div>

            </div>
            
        </div>

        <el-scrollbar class="content">
            <div class="teambox">

                <div class="introduce"> 
                    123
                </div>

                <div class="buttongroup">
                    <el-button @click="clickdetail=true">查看详情</el-button>
                    <el-button>加入</el-button>
                </div>
                
            </div>
            <div class="teambox">

                <div class="introduce"> 
                    123
                </div>

                <div class="buttongroup">
                    <el-button @click="clickdetail=true">查看详情</el-button>
                    <el-button>加入</el-button>
                </div>
                
            </div>
            <div class="teambox">

                <div class="introduce"> 
                    123
                </div>

                <div class="buttongroup">
                    <el-button @click="clickdetail=true">查看详情</el-button>
                    <el-button>加入</el-button>
                </div>
                
            </div>
        </el-scrollbar>
        
    </div>

    <detail v-if="clickdetail" class="detail" @confirm="clickdetail=false"/>
</template>



<style scoped>
.container{
    position:absolute;
    left:90px;
    top:30px;
    width:1500px;
    height:670px;
    background-color: white;
    border-radius: 25px;
}
.header{
    width:1500px;
    height:70px;
    font-size:20px;
    font-weight:300;

}

.title{
    width:150px;
    height:70px;
    padding-top:10px;
    padding-left:50px;
    font-size:30px;
    font-weight:500;
    float:left;
}


.search{
    width:1350px;
    height:70px;
    margin-left:150px;
}


.default{
    float:left;
    width:350px;
    height:70px;
    margin-left:10px;
    padding-top:16px;
}

.active{
    float:left;
    width: 700px;
    height:70px;
    margin-left:250px;
    padding-top:16px;
}

.initiate{
    float:left;
    width:110px;
    height:70px;
    padding-top:15px;
    margin-left:200px;
}

.content{
    height:560px;
    width:1500px;
    margin-top:20px;
    border-top: 1px solid black;
}

.teambox{
    width:1500px;
    height:100px;
    margin-bottom:30px;
    border-top: 1px solid black;
    border-bottom: 1px solid black;
}

.introduce{
    width:1250px;
    height:100px;
    line-height:100px;
    text-align: center;
    font-size:25px;
    float:left;
}

.buttongroup{
    width:180px;
    height:100px;
    float:right;
}

.buttongroup .el-button{
    width:130px;
    height:35px;
    margin-left:25px;
    margin-top:10px;
    background-color: #cccccc;
}

.detail{
    position:absolute;
    width:500px;
    height:600px;
    left:600px;
    top:40px;
    background-color: white;
    border: 1px solid black;
}
</style>