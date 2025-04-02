<script setup lang="ts">
import { reactive,ref } from 'vue'
import type { FormInstance, FormRules } from 'element-plus'
const emit = defineEmits(['close'])


const pass=ref(false)
const nocode=ref(true)
const count=ref(60)

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


</script>

<template>
    <div>
        <div class="box">
            <div style="height:100px;margin-top:30px;padding-left:10px;">
                <div style="font-size:22px;margin-bottom:20px;">邮箱验证</div>
                <div style="color:#61666D">为了您的账号安全，需要验证您的邮箱。验证码将发送至：</div>
            </div>

            <el-form
                ref="ruleFormRef1"
                style="max-width: 300px"
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
                    @click="pass=false"
                >
                    立即修改
                </el-button>
                <el-form-item>
                    
                </el-form-item>
            </el-form>

            <span class="cancel" @click="emit('close')">
                取消修改
            </span>
        </div>
    </div>
</template>

<style scoped>
.box{
  width:700px;
  height:500px;
  position: absolute;
  left:260px;
  top:240px;
  background-color: white;
}

.elform{
    margin-left:200px;
    margin-top:50px;
}

.cancel{
    position:absolute;
    left:325px;
    top:450px;
    font-size:14px;
    cursor:pointer;
}
.cancel:hover{
    color:#61666d98;
}
</style>