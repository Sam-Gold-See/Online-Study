<script setup lang="ts">
import { useUserStore } from '@/stores/user' 
import { reactive,ref } from 'vue'
import { useRouter } from 'vue-router'
import type { FormInstance, FormRules } from 'element-plus'


const router=useRouter()
const userStore=useUserStore()


interface Form {
  email: string
  password: string
}

const ruleFormRef = ref<FormInstance>()
const ruleForm = reactive<Form>({
    email: '',
    password: '',
})

const rules = reactive<FormRules<Form>>({
  email: [
    {required: true,message: '请输入邮箱地址',trigger: 'blur'},
    { type:'email' , message:'邮箱地址格式不正确',trigger: 'blur'}
  ],
  password: [
    {required: true,message: '请输入密码',trigger: 'blur'},
    {}
  ]
})

//调用登录接口
const postLogin=async (message: any)=>{
    await userStore.getUserInfo(message)
    console.log(userStore.userInfo);


    //登录成功后跳转
    if(true){
        router.replace({path:'/'})
    }
}
</script>


<template>
    <div class="container">
        <div class="box">
            <div class="left">
                <img src="@/assets/bk4.png">
            </div>
            <div class="right">
                <div style="height:140px;">
                    <div class="title">
                        登录
                    </div>
                    <div style="width:326px;height:80px;margin-left:204px;">
                        <img src="@/assets/title.png">
                    </div>
                    <div class="platform"> 
                        <span>在线学习平台</span>
                    </div>
                </div>

                <div>
                    <el-form
                        ref="ruleFormRef"
                        style="max-width: 350px"
                        :model="ruleForm"
                        :rules="rules"
                        label-width="auto"
                        label-position="top"
                        size="large"
                        status-icon
                        class="form"
                    >
                        <el-form-item label="邮箱" prop="email">
                            <el-input v-model="ruleForm.email" placeholder="请输入电子邮箱" :validate-event='false'/>
                        </el-form-item>

                        <el-form-item label="密码" prop="password">
                            <el-input v-model="ruleForm.password" placeholder="请输入密码" :validate-event='false'/>
                        </el-form-item>
      
                        <el-button @click="router.replace({path:'/'})">登录</el-button>
                        <div class="register" @click="router.push({path:'/register'})">
                            注册
                        </div>
                        <div class="register" style="width:80px;margin-left:215px;" @click="router.push({path:'/findpass'})">
                            忘记密码
                        </div>
                    </el-form>
                </div>

            </div>

        </div>
        
    </div>
</template>


<style scoped>
.container{
    width:1698px;
    height:800px;
    position:absolute;
    left:0px;
    top:0px;
    background-image: url('@/assets/bk3.png');
}

.box{
    width:1150px;
    height:600px;
    margin-left:275px;
    margin-top:100px;
    background-color: white;
    border-radius: 10px;
}

.left{
    width:500px;
    height:450px;
    margin-left:100px;
    margin-top:70px;
    float:left;
}

.right{
    width:528px;
    height:600px;
    margin-left:20px;
    float:left;
}

.title{
    width:70px;
    height:50px;
    margin-top:85px;
    margin-left:60px;
    font-size:30px;
    font-weight:400;
    text-align: center;
    float:left;
}

.platform{
    width:180px;
    height:50px;
    font-size:29px;
    font-weight:500;
    text-align: center;
    position:absolute;
    margin-left:330px;
    top:120px;
}

.left img{
    width: 500px;
    height: 450px;
}
.right img{
    width:326px;
    height:80px;
}

.form{
    margin-left:90px;
    margin-top:30px;
}

.el-button{
    width:350px;
    height:45px;
    margin-top:30px;
    color:black;
    background-color: #91B6DF;
}

.el-button:hover{
    background-color: #91b5dfca;
}

.register{
    float:left;
    width:52px;
    height:24px;
    margin-top:20px;
    font-size:18px;
    text-align: center;
    color:#2A82E4;
    cursor: pointer;
}
.register:hover{
    color:#2a81e4c7
}



</style>
