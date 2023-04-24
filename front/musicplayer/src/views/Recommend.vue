<script setup lang="ts">
import Banner from "../components/Banner/Banner.vue"
import useUserStore from "../store/user";

const userStore = useUserStore()
</script>

<template>
    <div class="main" style="">
        <div class="title">推荐</div>
        <div class="today" style="margin-top: 10px;">
            <div class="hello">Hi {{userStore.userId}} 今日为你推荐</div>
            <div style="margin-right: 10px;">
                <Banner></Banner>
            </div>
        </div>
        <div class="hot">
            <div style="font-weight: 500; font-size: 25px;">大家都在听</div>

        </div>
    </div>
    
</template>

<style scoped>
.title{
    font-size: 40px;
    font-weight: 700;
}
.hello{
    font-weight: 500;
    font-size: 25px;
}
.hot{
    margin-top: 10px;
}
div{
    font-family: 'Microsoft YaHei UI', Arial, sans-serif;
}

</style>
