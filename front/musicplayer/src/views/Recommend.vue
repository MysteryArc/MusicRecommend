<script setup lang="ts">
import { onMounted, reactive, ref } from 'vue';
import Banner from "../components/Banner/Banner.vue"
import useUserStore from "../store/user";
import getPopular from "../api/getHot";
import Card from "../components/Card.vue";
import getRecommend from '../api/getRecommend';
import getNeighbors from "../api/getNeighbors"
import useAudioStore from '../store/audio';

const userStore = useUserStore()
const audioStore = useAudioStore()

const hotList = reactive<any>([])
const recommendList = reactive<any>([])
const neighborList = reactive<any>([])

onMounted(() => {
    getPopular().then((res: any) => {
        hotList.push(...res)
    })
    getRecommend(userStore.recommendId).then((res: any) => {
        recommendList.push(...res)
    })
    getNeighbors(audioStore.audioId).then((res: any) => {
        neighborList.push(...res)
    })
})

</script>

<template>
    <div class="recommend-main" style="">
        <div class="title">推荐</div>
        <div class="today" style="margin-top: 15px;">
            <div class="series-title">Hi {{userStore.userName}} 今日为你推荐</div>
            <div style="margin-right: 10px;">
                <Banner></Banner>
            </div>
        </div>
        <div class="recommend-series">
            <div class="series-title">大家都在听</div>
            <div class="card-box">
                <div v-for="item in hotList.slice(0,6)" :key="item.id" class="recommend-card">
                    <Card :item="item"/>
                </div>
            </div>
        </div>
        <div class="recommend-series">
            <div class="series-title">红心歌曲预定</div>
            <div class="card-box" v-if="userStore.islogin==true">
                <div v-for="item in recommendList.slice(0, 6)" :key="item.id" class="recommend-card">
                    <Card :item="item"/>
                </div>
            </div>
            <div v-else>
                <h2>请先登录</h2>
            </div>
        </div>
        <div class="recommend-series">
            <div class="series-title">因为你在听{{ audioStore.audioName }}</div>
            <div class="card-box">
                <div v-for="item in neighborList.slice(0, 6)" :key="item.id" class="recommend-card">
                    <Card :item="item"/>
                </div>
            </div>
        </div>
    </div>
</template>

<style scoped>
.recommend-main{
    height: 100%;
    margin-left: 30px;
    margin-right: 30px;
}
.title{
    font-size: 40px;
    font-weight: 700;
}
.recommend-series{
    margin-top: 20px;
}
.card-box{
    display: flex;
    flex-wrap: wrap;
    margin-top: 15px;
}
.recommend-card{
    width: 50%;
}
.series-title{
    font-weight: 500; 
    font-size: 25px;
}
div{
    font-family: 'Microsoft YaHei UI', Arial, sans-serif;
}
</style>
