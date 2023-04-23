<script setup lang="ts">
import { ref } from 'vue';
import { useMenu } from './useMenu';

const menus = useMenu()
</script>

<template>
    <div class="logo">
        <el-image src="src\assets\logo.png"/>
    </div>
    <div class="layout-menulist" v-for="(item, i) in menus" :key="i">
        <div class="title">{{ item.name }}</div>
        <div class="menus" v-for="menu in item.menus" :key="menu.key">
            <router-link :to="{name:menu.key}">{{ menu.name }}</router-link>
        </div>
    </div>
</template>

<style scoped>
.logo{
    height: 75px;
    margin-left: 10px;
    margin-top: 5px;
}
.layout-menulist{
    margin-top: 10px;
    margin-left: 30px;
}
.title{
    height: 30px;
    font-size: 13px;
    font-weight: 300;
}
.menus{
    height: 30px;
}
div{
    font-family: 'Microsoft YaHei UI', Arial, sans-serif;
}
</style>