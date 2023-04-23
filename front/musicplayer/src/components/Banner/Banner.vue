<script setup lang="ts">
import { onMounted, ref } from 'vue';
import axios from 'axios';

const banners = ref([])

async function getBanner() {
    const resp = await axios.get('https://netease-cloud-music-api-pi-coral-30.vercel.app/banner')
    banners.value = resp.data.banners
}

onMounted(() => {
    getBanner()
})
</script>

<template>
    <div class="banner">
        <el-carousel :interval="4000" type="card" height="300px" trigger="click">
            <el-carousel-item v-for="(item,i) in banners" :key="i">
                <el-image :src="item.imageUrl"/>
            </el-carousel-item>
        </el-carousel>
    </div>
</template>

<style scoped>
.el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
    background-color: #d3dce6;
}
</style>