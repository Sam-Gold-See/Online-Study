<script setup>
import { ref, reactive, onMounted, computed } from 'vue'
import { useRouter } from 'vue-router'

const emit=defineEmits(['Login'])

const router = useRouter()
 
const loginForm = reactive({
    email: '',
    password: ''
})

const emailErrorMsg=ref('')
const passwordErrorMsg=ref('')
const rex=/^\w[-\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\.)+[A-Za-z]{2,14}/



const sendMsg=()=>{
    //输入验证
    emailErrorMsg.value=''
    passwordErrorMsg.value=''

    const email=loginForm.email
    const password=loginForm.password
    
    if(email==='')  {emailErrorMsg.value='请输入邮箱地址'; return}
    if(!rex.test(email))  {emailErrorMsg.value='请输入正确的邮箱地址'; return}

    if(password==='') {passwordErrorMsg.value='请输入密码'; return}
    
    //传递给主页进行来调用登录接口
    emit('Login',{email,password})
}
</script>

<template>
    <div>
        <div class="container">
            <div class="header">
                <h2>用户登录</h2>
            </div>
            <form @submit.prevent="sendMsg">
                <div style="font-size:25px;margin-top:20px">Email</div>
                <div>
                    <input id="email" v-model.trim="loginForm.email"/>
                </div>
                <div class="error" v-show="emailErrorMsg">
                    {{ emailErrorMsg }}
                </div>
                <div style="font-size:25px;margin-top:20px">Password</div>
                <div>
                    <input id="password" v-model.trim="loginForm.password"/>
                </div>
                <div>
                    <a href="/find" style="font-size:13px;margin-left: 355px;color:black">忘记密码？</a>
                </div>
                <div class="error" v-show="passwordErrorMsg">
                    {{ passwordErrorMsg }}
                </div>
                <button class="btn">
                    登录
                </button>
                <div class="footer">
                    <span>还没有账号？</span>
                    <a href="/register">立即注册</a>
                </div>
            </form>
        </div> 
    </div>
</template>


<style scoped>
.container {
    width: 100%;
    background: white;
    border-radius: 20px;
    padding: 40px;
    padding-right: 80px;
    box-shadow: 0 15px 35px rgba(0, 0, 0, 0.1);
}
 
.header {
    margin-left:35px;
    margin-bottom: 40px;
    text-align: center;
    color: #2c3e50;
    font-size: 32px;
    margin-bottom: 10px;
    font-weight: 700;
}   

.error{
    padding-left:25px;
    margin-top:0px;
    color:rgba(255, 0, 0, 0.7);
    font-size: 18px;
}

input {
    width: 100%;
    padding: 15px;
    border: 2px solid #e0e0e0;
    border-radius: 12px;
    font-size: 16px;
    transition: all 0.3s ease;
    background: transparent;
    margin-top:8px;
}
input:focus,
input:valid {
    border-color: #e0e0e0;;
}

 
.btn {
    width: 300px;
    padding: 15px;
    margin-left: 85px;
    margin-top:40px;
    background: linear-gradient(to right, #3498db, #2980b9);
    color: white;
    border: none;
    border-radius: 12px;
    font-size: 18px;
    font-weight: 600;
    cursor: pointer;
    transition: all 0.3s ease;
    display: flex;
    align-items: center;
    justify-content: center;
    gap: 10px;
}
.btn:hover {
    transform: translateY(2px);
    box-shadow: 0 5px 15px rgba(52, 152, 219, 0.3);
}
 
.footer {
    text-align: center;
    margin-left:30px;
    margin-top: 20px;
    color: #95a5a6;
}
 
.footer a {
    color: #3498db;
    text-decoration: none;
    margin-left: 5px;
    font-weight: 600;
}
 
.footer a:hover {
    text-decoration: underline;
}
</style>