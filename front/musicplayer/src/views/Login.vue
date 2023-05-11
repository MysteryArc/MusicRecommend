<script setup lang="ts">
import { reactive } from 'vue';
import useUserStore from '../store/user';
import { useRouter } from 'vue-router';

const loginForm = reactive({
    loginId: '',
    password: ''
})

const router = useRouter()
const userStore = useUserStore()

async function onSubmit() {
    console.log("submit")
    await userStore.login(loginForm)
    if (userStore.islogin == true) {
        router.push("/recommend")
    }
}

function onReset() {
    loginForm.loginId = '',
    loginForm.password = ''
}
</script>

<template>
    <div class="form">
        <div class="title">
            登录
        </div>
        <el-form :model="loginForm" class="demo-form-inline">
            <el-form-item label="账号">
                <el-input v-model="loginForm.loginId" placeholder="loginID" style="width: 300px;"/>
            </el-form-item>
            <el-form-item label="密码">
                <el-input v-model="loginForm.password" placeholder="Password" show-password style="width: 300px;"/>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit">登录</el-button>
                <el-button @click="onReset">重置</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<style scoped>
div{
    font-family: 'Microsoft YaHei UI', Arial, sans-serif;
}
.title{
    font-size: 30px;
    font-weight: 700;
    margin-left: 40px;
    margin-bottom: 10px;
}
.form{
    margin-left: 35%;
    margin-top: 10%;
    width: 400px;
    height: 200px;
    background-color: rgb(240, 240, 240);
}
.demo-form-inline{
    margin-left: 20px;
}
</style>