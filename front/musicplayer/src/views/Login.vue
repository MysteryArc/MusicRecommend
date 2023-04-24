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
    <div class="title">
        登录
    </div>
    <div class="form">
        <el-form :model="loginForm" class="demo-form-inline">
            <el-form-item label="账号">
                <el-input v-model="loginForm.loginId" placeholder="loginID" style="width: 400px;"/>
            </el-form-item>
            <el-form-item label="密码">
                <el-input v-model="loginForm.password" placeholder="Password" show-password style="width: 400px;"/>
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
    font-size: 40px;
    font-weight: 700;
}
.form{
    margin-top: 20px;
}
</style>