<script setup lang="ts">
import { reactive, ref } from 'vue'
import type { FormInstance, FormRules } from 'element-plus'
import { registerApi,askCode } from '@/apis/user.js' 

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
    { required: true, message: '请输入用户名'},
    { min: 3, max: 5, message: '用户名长度'},
  ],
  email: [
    {required: true,message: '请输入邮箱地址'},
    { type:'email' , message:'邮箱地址格式不正确'}
  ],
  password: [
    {required: true,message: '请输入密码',trigger: 'blur',},
    {}
  ],
  confirmPassword: [
    {required: true, message: '请再次输入密码'},

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

<div class="container">
    <div class="header"><h2>用户注册</h2></div>
    <div style="margin-left:130px;margin-top:30px;">
        <el-form
            ref="ruleFormRef"
            style="max-width: 400px"
            :model="ruleForm"
            :rules="rules"
            label-width="auto"
            size="large"
            status-icon
            
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
      
            <el-form-item>
                <el-button style='margin-left:215px;margin-top:15px' type="primary" @click.prevent="register(ruleFormRef)">
                    注册
                </el-button>
            </el-form-item>
        </el-form>
    </div>
</div>

</template>

<style scoped>
.container{
    position: absolute;
    left:480px;
    top:130px;
    width:760px;
    height:580px;
    border:1px solid black;
    text-align: center;

}

.header{
    margin-top:10px;
    font-weight: 500;
    font-size: 25px;
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


</style>