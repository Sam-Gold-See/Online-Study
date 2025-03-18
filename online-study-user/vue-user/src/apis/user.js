import http from "../utils/http";

//登录接口
export const loginApi= (message) => {
    const email=message.email
    const password=message.password
    return http({
        url:'client/user/login',
        method:'POST',
        data:{
            email,
            password
        }
    })
}


//注册接口
export const registerApi=(form)=>{
    name=form.name
    email=form.email
    password=form.password
    gender=form.gender
    verificationCode=form.verificationCode
    
    return http({
        url:'client/user/regist',
        method:'POST',
        data:{
            name,
            email,
            password,
            gender,
            verificationCode
        }
    })

}


//注册获取验证码接口
export const askCode=(email)=>{
    return http({
        url:'client/user/sendMsg',
        method:'GET',
        data:{
            email
        }
    })

}


//重置密码接口
export const editCode=(form)=>{
    return http({
        url:'client/user/editPassword',
        method:'POST',
        data:{
            email
        }
    })

}


//获取日程信息接口
export const scheduleDetail=(form)=>{
    return http({
        url:'client/user/editPassword',
        method:'POST',
        data:{
            email
        }
    })

}


