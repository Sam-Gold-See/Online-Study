<script setup lang="ts">
import { reactive, ref } from 'vue'
import type { FormInstance, FormRules } from 'element-plus'
import { registerApi } from '@/apis/user.js' 

interface Form {
  name: string
  email: string
  gender: string
}

const ruleFormRef = ref<FormInstance>()
const ruleForm = reactive<Form>({
    name: '123456',
    email: '45456456',
    gender: '',
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
  
  gender: [
    {required: true, message: '请选择性别'},
  ]
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
    <div class="box">
        <el-form
            ref="ruleFormRef"
            class="elform"
            :model="ruleForm"
            :rules="rules"
            label-width="auto"
            label-position="top"
            size="large"
            status-icon
            
        >
            <el-form-item label="昵称" prop="name">
                <el-input v-model="ruleForm.name" :validate-event='false'/>
            </el-form-item>

            <el-form-item label="邮箱" prop="email">
                <el-input v-model="ruleForm.email" :validate-event='false'/>
            </el-form-item>
   
            <el-form-item label="性别" prop="gender">
                <el-radio-group v-model="ruleForm.gender">
                    <el-radio value="M">男</el-radio>
                    <el-radio value="F">女</el-radio>
                </el-radio-group>
            </el-form-item>

            <el-form-item>
                <el-button style='margin-left:105px;margin-top:20px' type="primary" @click.prevent="register(ruleFormRef)">
                    确认修改
                </el-button>
            </el-form-item>
        </el-form>
    </div>
</div>

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
  height:400px;
  margin-left:260px;
  margin-top:90px;
  border-radius:15px;
  background-color: white;
  padding-top:30px;
}

.elform{
    max-width: 300px;
    margin-left:200px;
}
</style>