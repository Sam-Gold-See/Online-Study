<script setup lang='ts'>
import { reactive, ref } from 'vue'
import type { FormInstance, FormRules } from 'element-plus'
import { editCode,askCode } from '@/apis/user.js' 
import { useRouter } from 'vue-router'


const router=useRouter()

interface Form {
  email: string
  verificationCode: string
}

const ruleFormRef = ref<FormInstance>()
const ruleForm = reactive<Form>({
    email: '',
    verificationCode: ''
})

const rules = reactive<FormRules<Form>>({
  email: [
    {required: true,message: '请输入邮箱地址'},
    { type:'email' , message:'请输入正确的邮箱地址',trigger:'blur' }
  ],
  verificationCode: [
    {
      required: true,
      message: 'Please select at least one activity type',
      trigger: 'change',
    },
  ]
})


const submit = async (formEl:any) => {
  await formEl.validate((valid:any, fields:any) => {
    // router.push({path:'findpass/success'})
    if (valid) {
        editCode(ruleForm)
        router.push({path:'findpass/success'})
      
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
        <div class="header">
            提交申请
        </div>
        <div class="form">
            <el-form
            ref="ruleFormRef"
            style="max-width: 400px"
            :model="ruleForm"
            :rules="rules"
            label-width="auto"
            size="large"
            status-icon
            
            >   
                <el-form-item style='margin-bottom:50px;' label="绑定邮箱" prop="email">
                    <el-input v-model="ruleForm.email" placeholder="请输入绑定的电子邮箱" :validate-event='false'/>
                </el-form-item>
                <el-form-item label="验证码" prop="verificationCode">
                    <el-input v-model="ruleForm.verificationCode" style="width:100px" :validate-event='false'/>
                    <!--点击获取验证码之后的计时器组件-->
                    <span v-if="ifget" class="after">{{ count }}秒后重试</span>
                    <!--没有点击获取验证码时的按钮组件-->
                    <button v-else @click.prevent="getCode(ruleFormRef)" class="before">获取验证码</button>
                </el-form-item>
                <el-button  style='margin-left:150px;margin-top:20px;' @click="submit(ruleFormRef)">
                    确认提交
                </el-button>
            </el-form>
        </div>
    </div>


</template>

<style scoped>
.container{
    width: 600px;
    height:400px;
    position: absolute;
    left:560px;
    top:150px;
    background: white;
    border-radius: 20px;
    box-shadow: 0 15px 35px rgba(0, 0, 0, 0.1);
}

.header{
    text-align: center;
    font-size:25px;
    font-weight: bold;
    margin-left:13px;
    margin-top:20px;
    margin-bottom:20px;
}

.form{
    margin-left:100px;
    margin-top:20px;
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