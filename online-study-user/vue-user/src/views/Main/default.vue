<scrip setup lang="ts"> 

</scrip>


<template>
    <div class="container">
        <div class="imgcontainer">
            <img src="@/assets/logo.svg"/>
            <img src="@/assets/logo.svg"/>
            <img src="@/assets/logo.svg"/>
            <img src="@/assets/logo.svg"/>
            </br>
            <span style="margin-left: 60px;">学习计划</span>
            <span style="margin-left: 170px;">学习笔记</span>
            <span style="margin-left: 170px;">发布动态</span>
            <span style="margin-left: 180px;">GitHub</span>
        </div>

        <el-scrollbar class="academic">
            学术动态
        </el-scrollbar>
            
    </div>

</template>

<style scoped>
.container{
    left:0px;
    top:90px;
    position: absolute;
    width:1010px;
    height:680px;
    border: 1px solid black;
}

.imgcontainer{
    margin-top:30px;
    height:160px;
    border: 1px solid black;
}

.academic{
    margin-top:20px;
    margin-left:40px;
    width:910px;
    height:470px;
    background-color: rgba(0, 0, 0, 0.288);
}

img{
    width:120px;
    height:120px;
    margin-left:40px;
    margin-right:90px;
}

span{
    font-size:20px;
    font-weight:400;
}
</style>