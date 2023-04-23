<script setup lang="ts">
import Banner from "../components/Banner/Banner.vue"
</script>

<template>
    <div class="main" style="">
        <div class="title">推荐</div>
        <div class="today" style="margin-top: 10px;">
            <div class="hello">Hi xxx 今日为你推荐</div>
            <div style="margin-right: 10px;">
                <Banner></Banner>
            </div>
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
div{
    font-family: 'Microsoft YaHei UI', Arial, sans-serif;
}

</style>
