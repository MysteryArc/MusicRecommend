<script setup lang="ts">
import { onMounted, reactive } from 'vue';
import Banner from "../components/Banner/Banner.vue"
import useUserStore from "../store/user";
import getPopular from "../api/getHot";

const userStore = useUserStore()

const hotList = reactive<any>([])

onMounted(() => {
    getPopular().then((res: any) => {
        hotList.push(...res)
    })
})

</script>

<template>
    <div class="recommend-main" style="">
        <div class="title">推荐</div>
        <div class="today" style="margin-top: 15px;">
            <div class="series-title">Hi {{userStore.userId}} 今日为你推荐</div>
            <div style="margin-right: 10px;">
                <Banner></Banner>
            </div>
        </div>
        <div class="recommend-series">
            <div class="series-title">大家都在听</div>
            <div class="card-box">
                <div v-for="item in hotList.slice(0,6)" :key="item.id" class="recommend-card">
                    <el-card shadow="hover">
                        <div style="display: flex; align-items: center;">
                            <el-image :src="item.picUrl" style="height: 100px; width: 100px;"></el-image>
                            <div class="musicinfo">
                                <div class="music-name">{{ item.name }}</div>
                                <div class="music-singer">{{ item.singer }}</div>
                            </div>
                        </div>
                    </el-card>
                </div>
            </div>
        </div>
        <div class="recommend-series">
            <div class="series-title">红心歌曲预定</div>
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
.musicinfo{
    margin-left: 3%;
}
.music-name{
    font-size: 15px;
    font-weight: 500;
}
.music-singer{
    font-weight: 300;
    font-size: 13px;
}
.series-title{
    font-weight: 500; 
    font-size: 25px;
}
div{
    font-family: 'Microsoft YaHei UI', Arial, sans-serif;
}

</style>
