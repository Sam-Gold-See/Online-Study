<template>
    <div>
        首页
        <button @click="$router.push('/login')">登录</button>
        <button @click="$router.push('/register')">注册</button>
        <button @click="$router.push('/findpass')">重置密码</button>
    </div>
</template>