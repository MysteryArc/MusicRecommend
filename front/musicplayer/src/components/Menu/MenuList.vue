<script setup lang="ts">
import { ref } from 'vue';
import { useMenu } from './useMenu';
import { NIcon } from "naive-ui"
import { useRouter } from 'vue-router';

const menus = useMenu()
const router = useRouter()

function routeTo(path:string) {
    router.push(path)
}

</script>

<template>
    <div class="logo">
        <el-image src="src\assets\logo.png"/>
    </div>
    <div class="layout-menulist" v-for="(item, i) in menus" :key="i" tabindex="11">
        <div class="title">{{ item.name }}</div>
        <div class="menus" v-for="menu in item.menus" :key="menu.key" @click="routeTo(menu.path)">
            <n-icon :component=menu.icon size="20" class="menu-icon"/>
            <!-- <router-link :to="{name:menu.key}">{{ menu.name }}</router-link> -->
            <div class="menu-title">{{ menu.name }}</div>
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
    margin-top: 20px;
    margin-bottom: 30px;
}
.title{
    font-size: 13px;
    font-weight: 300;
    margin-left: 30px;
}
.menus{
    height: 30px;
    display: flex;
    align-items: center;
    margin-top: 10px;
    margin-left: 20px;
    margin-right: 20px;
    border-radius: 5px;
    cursor: pointer;
    transition-property: all;
    transition-duration: 100ms;
}
.menus:hover{
    background-color: #D6D6D6FF;
}
.menus:focus{
    background-color: rgb(218, 36, 36);
}
.menu-title{
    margin-left: 8px;
    font-size: 15px;
}
.menu-icon{
    margin-left: 10px;
}
div{
    font-family: 'Microsoft YaHei UI', Arial, sans-serif;
}
</style>