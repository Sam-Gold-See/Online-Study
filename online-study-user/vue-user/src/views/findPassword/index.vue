<script setup lang="ts">
import { reactive,ref } from 'vue'
import { useRouter } from 'vue-router'
import type { FormInstance, FormRules } from 'element-plus'
import success from '@/views/Register/successdialog.vue'

const router=useRouter()
const pass=ref(false)
const nocode=ref(true)
const count=ref(60)
const successful=ref(false)

const getcode=()=>{
    nocode.value=false;
    const timer=setInterval(()=>{
            if(count.value>0){
                count.value--
            }
            else{
                clearInterval(timer)
                count.value=60
                nocode.value=true
            }
     },1000)
}


interface Form1 {
  verifycode: string
}
const ruleFormRef1 = ref<FormInstance>()
const ruleForm1 = reactive<Form1>({
    verifycode: '' ,
})
const rules1 = reactive<FormRules<Form1>>({
  verifycode: [
    { required: true, message: '请输入验证码',trigger: 'blur'},
    { min: 3, max: 5, message: '用户名长度限制',trigger: 'blur'},
  ],
})


interface Form2 {
  newpassword:string
  confirmpassword:string
}
const ruleFormRef2 = ref<FormInstance>()
const ruleForm2 = reactive<Form2>({
    newpassword: '' ,
    confirmpassword:''
})
const rules2 = reactive<FormRules<Form2>>({
  newpassword: [
    { required: true, message: '请输入邮箱地址',trigger: 'blur'},
    { type:'email' , message:'邮箱地址格式不正确',trigger: 'blur'}
  ],
  confirmpassword: [
    {required: true, message: '请再次输入密码',trigger: 'blur'},

    {validator:(rule,value,callback)=>{
        if(value!=ruleForm2.newpassword)
            callback(new Error('两次密码输入不一致'))
        else
          callback()
    }}
  ],
})

const replace=()=>{
    successful.value=true;
    setTimeout(()=>{
        router.replace({path:'/login'})
    },900)
}
</script>

<template>
    <div class="background">

        <div class="container">
            <div class="title">
                重置密码
            </div>
            <div style="height:100px;margin-top:20px;padding-left:30px;">
                <div style="font-size:22px;margin-bottom:20px;">邮箱验证</div>
                <div style="color:#61666D">为了您的账号安全，需要验证您的邮箱。验证码将发送至：</div>
            </div>
            <div class="verify">
                <el-form
                    ref="ruleFormRef1"
                    style="max-width: 300px;margin-top:80px;"
                    :model="ruleForm1"
                    :rules="rules1"
                    label-width="auto"
                    label-position="top"
                    size="large"
                    status-icon
                    class="elform"
                    v-if="!pass"
                > 
                <el-form-item label="验证码" prop="verifycode">
                    <el-input v-model="ruleForm1.verifycode" :validate-event='false'/>
                </el-form-item>

                <div v-if="nocode" style="font-size:12px;color:#00AEEC;cursor:pointer;"
                    @click="getcode"
                >
                    获取验证码
                </div>
                <div v-else style="font-size:12px;color:lightgray">{{ count }}秒后可重新发送验证码</div>


                <el-button style='margin-left:110px;margin-top:20px;float:left;' type="primary"
                    @click="pass=true"
                >
                    下一步
                </el-button>
            </el-form>

            <el-form
                ref="ruleFormRef2"
                style="max-width: 300px"
                :model="ruleForm2"
                :rules="rules2"
                label-width="auto"
                label-position="top"
                size="large"
                status-icon
                class="elform"
                v-else
            >
                <el-form-item label="请输入新的密码" prop="newpassword">
                    <el-input v-model="ruleForm2.newpassword" :validate-event='false'/>
                </el-form-item>
                <el-form-item label="请再次确认密码" prop="confirmpassword">
                    <el-input v-model="ruleForm2.confirmpassword" :validate-event='false'/>
                </el-form-item>
    
                    
                <el-button style='margin-left:105px;margin-top:20px;float:left;' type="primary"
                    @click="replace"
                >
                    立即修改
                </el-button>
            </el-form>
            </div>
            <div class="footer" @click="router.push({path:'/login'})">
                返回登录
            </div>
        </div>
        
    </div>

    <success v-if="successful" message="修改成功！"/>
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
    width:650px;
    height:630px;
    margin-left:540px;
    margin-top:50px;
    background-color: white;
    border:1px solid white;
    border-radius: 10px;
}

.title{
    height:60px;
    margin-top:20px;
    font-size:30px;
    font-weight: 600;
    border-bottom:2px solid gray;
    padding-left:30px;
}

.verify{
    width:650px;
    height:300px;
    margin-top:10px;
    border:1px solid white;
}

.elform{
    margin-left:180px;
    margin-top:50px;
}

.footer{
    width:70px;
    height:40px;
    margin-top:20px;
    margin-left:300px;
    line-height:40px;
    font-size:16px;
    text-align: center;
    cursor:pointer;
}
.footer:hover{
    color:#61666d98;
}
</style>

