<script setup lang="ts">
import { ref } from 'vue'
import { useRouter } from 'vue-router'
const router=useRouter()


const secondLevel=ref(0)
const routerBox=['/','/plan','/dynamic','/github']
</script>

<template>
    <div class="container">
        <div>
            <div class="imgcontainer">
                <div class="imgbox" :class="{'secondActive': secondLevel===0}"
                    style="border-top-left-radius: 25px;border-bottom-left-radius: 25px;"
                    @click="secondLevel=0,router.push({path:'/'})"
                >
                    <img src="@/assets/plan.png" style="margin-left:40px;"/>
                    <span style="margin-left: 70px;">学习计划</span>
                </div>

                <div class="imgbox" :class="{'secondActive': secondLevel===1}" 
                    @click="secondLevel=1,router.push({path:'/note'})"
                >
                    <img src="@/assets/note.png" style="margin-left:40px;"/>
                    <span style="margin-left: 70px;">学习笔记</span>
                </div>

                <div class="imgbox" :class="{'secondActive': secondLevel===2}" 
                    @click="secondLevel=2,router.push({path:'/'})"
                >
                    <img src="@/assets/dynamic.png" style="margin-left:40px;"/>
                    <span style="margin-left: 70px;">发布动态</span>
                </div>

                <div class="imgbox" :class="{'secondActive': secondLevel===3}"
                    style="border-top-right-radius: 25px;border-bottom-right-radius: 25px;"
                    @click="secondLevel=3,router.push({path:'/'})"
                >
                    <img src="@/assets/github.png" style="margin-left:47px;"/>
                    <span style="margin-left: 85px;">GitHub</span>
                </div>
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

            <div class="btn">
                <span style="font-size:25px;font-weight:400" >日程安排</span>
            </div>

        </div>
    </div>
</template>


<style scoped>

.container{
    width:1697px;
    height:700px;
    position:absolute;
    top:0px;
    left:0px;
}

.imgcontainer{
    background-color: #F6F7F8;
    position: absolute;
    left:70px;
    top:10px;
    width:920px;
    height:160px;
    margin-top:30px;
    border-radius: 25px;
}

.imgbox{
    float:left;
    width:230px;
    height:160px;
    cursor:pointer;
}


.secondActive,
.imgbox:hover{
    background-color: #d8d8d8ab;
}


.imgcontainer img{
    width:150px;
    height:122px;
    margin-right:60px;
}



.schedule{
    right:20px;
    top:0px;
    position: absolute;
    width:600px;
    height:699px;
    border-left: 2px solid black;
}

.detailbox{
    width:460px;
    height:550px;
    margin-top:30px;
    padding-top:1px;
    margin-left:75px;
    background-color: rgba(0, 0, 0, 0.288);
    text-align: center;
}

.detail{
    width:425px;
    line-height:30px;
    margin-top:20px;
    margin-bottom:20px;
    margin-left:18px;
    border: 1px solid white;
    text-align: center;
    font-size:21px;
    color:black;
    word-wrap: break-word;
}

.btn{
    text-align: center;
    margin-top:20px;
    margin-left:240px;
    width:130px;
    height:60px;
    line-height:60px;
    background-color: #FFBCAA;
    cursor:pointer;
    transition:0.3s;
}
.btn:hover{
    transform: scale(1.1);
}

span{
    font-size:20px;
    font-weight:400;
}

</style>