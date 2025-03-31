<script setup lang="ts"> 

</script>


<template>
    <div class="container">
        <div class="title">
            <span>学习笔记</span>
        </div>
        <el-scrollbar class="note">
            <div class="box">
                <img src="@/assets/note2.png" />
                </br>
                <span>123</span>
            </div>
            <div class="box">
                <img src="@/assets/note2.png" />
                </br>
                <span>123</span>
            </div>
            <div class="box">
                <img src="@/assets/note2.png" />
                </br>
                <span>123</span>
            </div>
            <div class="box">
                <img src="@/assets/note2.png" />
                </br>
                <span>123</span>
            </div>
            <div class="box">
                <img src="@/assets/note2.png" />
                </br>
                <span>123</span>
            </div>
            <div class="box">
                <img src="@/assets/note2.png" />
                </br>
                <span>123</span>
            </div>
            <div class="box" style="padding-top:5px;">
                <img src="@/assets/add.png" />
            </div>
        </el-scrollbar>
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
    font-size:18px;
    font-weight:250;
    margin-left:50px;
}

.note{
    width:920px;
    height:360px;
    padding-left:50px;
    border-top:1px solid black;
}

.box{
    float:left;
    width:120px;
    height:130px;
    padding-left:14px;
    margin-right:50px;
    margin-top:30px;
    cursor:pointer;
    transition:0.3s;
}

.box:hover{
    transform:scale(1.1);
}

.box span{
    width:120px;
    height:30px;
    font-size:18px;
    font-weight:250;
    margin-top:5px;
    margin-left:32px;
}

img{
    width:90px;
    height:90px;
    margin-right:20px;
}


</style>