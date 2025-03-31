<script setup lang="ts">
import { ref } from 'vue'
import emailbox from '@/views/ChangeSelf/changeemail.vue'
import passwordbox from '@/views/ChangeSelf/changepass.vue'
import { useRouter } from 'vue-router'
const changeemail=ref(false)
const changepass=ref(false)


</script>


<template>

    <div class="container">
        <div class="box">
          <div class="function">
              <img src="@/assets/email.png">
              <div @click="changeemail=true">修改邮箱</div>
          </div>
          <div class="function">
              <img src="@/assets/editpass.png">
              <div @click="changepass=true">修改密码</div>
          </div>
        </div>
    </div>

    <emailbox v-if="changeemail" @close="changeemail=false"/>
    <passwordbox v-if="changepass" @close="changepass=false"/>



</template>

<style scoped>
.container{
    position: absolute;
    left:0px;
    top:170px;
    width:1195px;
    height:628px;
    font-size:25px;
    font-weight:300;

}

.box{
    width:700px;
    height:300px;
    margin-left:260px;
    margin-top:120px;
    padding-top:0px;
    background-color: white;
}

.function{
    width:350px;
    height:200px;
    margin-top:50px;
    float:left;
}

img{
  width:100px;
  height:100px;
  margin-top:50px;
  margin-left:50px;
  float:left;
}

.function div{
  width:100px;
  height:40px;
  margin-top:80px;
  margin-left:15px;
  float:left;
  cursor:pointer;
}

.function div:hover{
  color:deepskyblue;
}


</style>