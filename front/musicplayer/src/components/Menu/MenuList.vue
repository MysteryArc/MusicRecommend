<script setup lang="ts">
import { ref } from 'vue';
import { useMenu } from './useMenu';

const menus = useMenu()
</script>

<template>
    <div class="layout-menulist" v-for="(item, i) in menus" :key="i">
        <div class="title">{{ item.name }}</div>
        <div class="menus" v-for="menu in item.menus" :key="menu.key">
            <router-link :to="{name:menu.key}">{{ menu.name }}</router-link>
        </div>
    </div>
</template>

<style scoped>

</style>