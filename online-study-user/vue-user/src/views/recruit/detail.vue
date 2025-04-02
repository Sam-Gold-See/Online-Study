<script setup lang="ts">
import { ref } from 'vue'
const introduce=ref(true)
defineEmits(['confirm'])
</script>


<template>
    <!--第一个div的样式不起作用-->     
    <div>       
        <div class="header">
            <span @click="introduce=true">队伍介绍</span>
            <span style="margin-left:50px;" @click="introduce=false">队友期望</span>
        </div>

        <div v-if="introduce" class="content">
            队伍介绍
        </div>

        <div v-else class="content">
            队友期望
        </div>

        <el-button style="margin-top:20px;margin-left:220px;width:70px;height:40px;" @click="$emit('confirm')">确定</el-button>
    </div>
    

</template>

<style scoped>
.header{
    height:90px;
    font-size:20px;
    padding-left:10px;
    border-bottom: 1px solid black;
}

.content{
    height:430px;
    line-height:430px;
    text-align:center;
}

.header span{
    margin-top:50px;    
    float:left;
    cursor:pointer;
}

</style>