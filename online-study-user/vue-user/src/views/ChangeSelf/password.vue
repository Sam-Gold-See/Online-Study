<script setup lang="ts">
import { reactive, ref } from 'vue'
import type { FormInstance, FormRules } from 'element-plus'
import { registerApi } from '@/apis/user.js' 

interface Form {
  newpassword: string
  confirmpassword: string
}

const ruleFormRef = ref<FormInstance>()
const ruleForm = reactive<Form>({
    newpassword: '' ,
    confirmpassword: ''
})

const rules = reactive<FormRules<Form>>({
  newpassword: [
    { required: true, message: '请输入用户名',trigger: 'blur'},
    { min: 3, max: 5, message: '用户名长度限制',trigger: 'blur'},
  ],

  confirmpassword: [
    {required: true, message: '请再次输入密码',trigger: 'blur'},

    {validator:(rule,value,callback)=>{
        if(value!=ruleForm.newpassword)
            callback(new Error('两次密码输入不一致'))
        else
          callback()
    }}
  ],
})


const register = async (formEl:any) => {
  await formEl.validate((valid:any, fields:any) => {
    if (valid) {
      registerApi(ruleForm)
    }
  })
}
</script>


<template>

<div class="container">
    <div style="margin-left:130px;margin-top:60px;">
        <el-form
            ref="ruleFormRef"
            style="max-width: 300px"
            :model="ruleForm"
            :rules="rules"
            label-width="auto"
            label-position="top"
            size="large"
            status-icon
            
        >
            <el-form-item label="新密码" prop="newpassword">
                <el-input v-model="ruleForm.newpassword" :validate-event='false'/>
            </el-form-item>

            <el-form-item label="再次确认密码" prop="confirmpassword">
                <el-input v-model="ruleForm.confirmpassword" :validate-event='false'/>
            </el-form-item>


            <el-form-item>
                <el-button style='margin-left:105px;margin-top:20px' type="primary" @click.prevent="register(ruleFormRef)">
                    立即修改
                </el-button>
            </el-form-item>
        </el-form>
    </div>
</div>

</template>

<style scoped>
.container{
    position: absolute;
    left:500px;
    top:170px;
    width:1195px;
    height:600px;
    border:1px solid black;
    font-size:25px;
    font-weight:300;

}
</style>