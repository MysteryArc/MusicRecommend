<script setup lang="ts">
import { reactive } from 'vue';

const loginForm = reactive({
    userId: '',
    password: ''
})

function onSubmit() {
    console.log("submit")
}
</script>

<template>
    <div class="title">
        登录
    </div>
    <div class="form">
        <el-form :model="loginForm" class="demo-form-inline">
            <el-form-item label="账号">
                <el-input v-model="loginForm.userId" placeholder="userID" style="width: 400px;"/>
            </el-form-item>
            <el-form-item label="密码">
                <el-input v-model="loginForm.password" placeholder="Password" show-password style="width: 400px;"/>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit">登录</el-button>
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