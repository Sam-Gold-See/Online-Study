<script setup lang="ts">
import { reactive, ref } from 'vue'
import { useRouter } from 'vue-router'
import type { FormInstance, FormRules } from 'element-plus'
import success from '@/views/Register/successdialog.vue'
import { registerApi,askCode } from '@/apis/user.js' 


const router = useRouter()

const successful=ref(false)
const temp=()=>{
    successful.value=true
    setTimeout(()=>{
        router.replace({path:'/login'})
    },900)
}

interface Form {
  name: string
  email: string
  password: string
  confirmPassword:string
  gender: string
  verificationCode: string
}

const ruleFormRef = ref<FormInstance>()
const ruleForm = reactive<Form>({
    name: '',
    email: '',
    password: '',
    confirmPassword: '',
    gender: '',
    verificationCode: ''
})

const rules = reactive<FormRules<Form>>({
  name: [
    { required: true, message: '请输入用户名',trigger: 'blur'},
    { min: 3, max: 5, message: '用户名长度限制',trigger: 'blur'},
  ],
  email: [
    {required: true,message: '请输入邮箱地址',trigger: 'blur'},
    { type:'email' , message:'邮箱地址格式不正确',trigger: 'blur'}
  ],
  password: [
    {required: true,message: '请输入密码',trigger: 'blur'},
    {}
  ],
  confirmPassword: [
    {required: true, message: '请再次输入密码',trigger: 'blur'},

    {validator:(rule,value,callback)=>{
        if(value!=ruleForm.password)
            callback(new Error('两次密码输入不一致'))
        else
          callback()
    }}
  ],
  gender: [
    {required: true, message: '请选择性别'},
  ],
  verificationCode: [
    {required: true, message: '请输入验证码'},
    {}
  ]
})


const register = async (formEl:any) => {
  await formEl.validate((valid:any, fields:any) => {
    if (valid) {
      registerApi(ruleForm)
    }
  })
}

const ifget=ref(false)
const count=ref(60)

function getCode(formEl: any) {
    formEl.validateField(['email'], (valid: any)=>{

        if(valid){
            //60s计时器
            ifget.value=true
            const timer=setInterval(()=>{
                if(count.value>0){
                    count.value--
                }
                else{
                    clearInterval(timer)
                    count.value=60
                    ifget.value=false
                }
            },1000)

            //调用接口
            askCode(ruleForm.email)
        }
        
    })

}

</script>

<template>
<div class="background">
<div class="container">
    <div class="left">
        <img src="@/assets/bk5.png">
    </div>

    <div class="right">
        <div style="height:120px;">
            <div style="width:226px;height:80px;margin-left:334px;">
                <img src="@/assets/title.png" style="width:226px;height:80px;">
            </div>
            <div class="register">
                注册
            </div>
        </div>  
        <el-form
            ref="ruleFormRef"
            style="max-width: 400px"
            :model="ruleForm"
            :rules="rules"
            label-width="auto"
            size="large"
            status-icon
            class="form"
        >
            <el-form-item label="用户名" prop="name">
                <el-input v-model="ruleForm.name" placeholder="请输入用户名" :validate-event='false'/>
            </el-form-item>

            <el-form-item label="邮箱" prop="email">
                <el-input v-model="ruleForm.email" placeholder="请输入电子邮箱" :validate-event='false'/>
            </el-form-item>

            <el-form-item label="密码" prop="password">
                <el-input v-model="ruleForm.password" placeholder="请输入密码" :validate-event='false'/>
            </el-form-item>

            <el-form-item label="确认密码" prop="confirmPassword">
                <el-input v-model="ruleForm.confirmPassword" placeholder="请再次输入密码" :validate-event='false'/>
            </el-form-item>
   
            <el-form-item label="性别" prop="gender">
                <el-radio-group v-model="ruleForm.gender">
                    <el-radio value="M">男</el-radio>
                    <el-radio value="F">女</el-radio>
                </el-radio-group>
            </el-form-item>

            <el-form-item label="验证码" prop="verificationCode">
                <el-input v-model="ruleForm.verificationCode" style="width:100px" :validate-event='false'/>
                <!--点击获取验证码之后的计时器组件-->
                <span v-if="ifget" class="after">{{ count }}秒后重试</span>
                <!--没有点击获取验证码时的按钮组件-->
                <button v-else @click.prevent="getCode(ruleFormRef)" class="before">获取验证码</button>
            </el-form-item>
      
            <el-button @click.prevent="temp">
                立即注册
            </el-button>
        </el-form>
        <div class="footer" @click="router.push({path:'/login'})">
            返回登录
        </div>
    </div>
</div>
</div>

<success v-if="successful" message="注册成功！"/>

</template>

<style scoped>
.background{
    width:1698px;
    height:800px;
    position:absolute;
    left:0px;
    top:0px;
    background-image: url('@/assets/bk3.png');
}

.container{
    width:1150px;
    height:650px;
    margin-left:275px;
    margin-top:100px;
    background-color: white;
    border-radius: 10px;
}

.left{
    width:500px;
    height:500px;
    margin-left:70px;
    margin-top:70px;
    float:left;
}

.left img{
    width:500px;
    height:500px;
}

.right{
    width:557px;
    height:650px;
    margin-left:20px;
    float:left;
}

.register{
    width:80px;
    height:50px;
    font-size:29px;
    font-weight:500;
    text-align: center;
    position:absolute;
    margin-left:440px;
    top:120px;
}

.form{
    margin-top:0px;
    margin-left:40px;
}

.before{
    width:90px;
    height:35px;
    margin-left:20px;
    font-size:13px;
}

.after{
    width:90px;
    height:35px;
    margin-left:20px;
    font-size:13px;
    color:#a1a1a1;
}

.el-button{
    width:350px;
    height:45px;
    margin-top:20px;
    margin-left:50px;
    color:black;
    background-color: #91B6DF;
}
.el-button:hover{
    background-color: #91b5dfca;
}

.footer{
    width:70px;
    height:40px;
    margin-top:10px;
    margin-left:230px;
    line-height:40px;
    font-size:14px;
    text-align: center;
    cursor:pointer;
}
.footer:hover{
    color:#61666d98;
}
</style>