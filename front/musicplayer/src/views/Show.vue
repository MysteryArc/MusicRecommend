<script setup lang="ts">
import axios from '../api/request';
import { onMounted, ref } from 'vue';

const musicdata = ref([]) 
const src = ref("");
const audioee = ref()

async function getMusic() {
    const resp = await axios.get('/discover/song')
    console.log(resp.data)
    musicdata.value = resp.data
}

function playmusic(playid: number) {
    window.open("http://music.163.com/song/media/outer/url?id=" + playid + ".mp3")
}

function playmusic0(playid: number) {
    audioee.value.src = "http://music.163.com/song/media/outer/url?id=" + playid + ".mp3"
    audioee.value.play()
}

onMounted(() => {
    getMusic()
})
</script>

<template>
    <el-container class="main">
        <el-header>
            <h3 style="float: left;">音乐分页</h3>
            <audio controls ref='audioee' style="float: right">
                <source :src="src"/>
            </audio>
        </el-header>
        <el-main>
            <div style="width: 100%;">
                <el-table :data="musicdata" stripe style="width: 100%;">
                    <el-table-column prop="cloudId" label="ID" />
                    <el-table-column prop="name" label="Name" />
                    <el-table-column label="Picture">
                        <template #default="scope">
                            <el-image :src="scope.row.picUrl" style="width: 200px; height: 200px;"/>
                        </template>
                    </el-table-column>
                    <el-table-column prop="singer" label="Singer" />
                    <el-table-column label="Play">
                        <template #default="scope">
                            <el-button type="primary" @click="playmusic(scope.row.cloudId)">播放</el-button>
                            <el-button type="primary" @click="playmusic0(scope.row.cloudId)">此页面</el-button>
                        </template>
                    </el-table-column>
                </el-table>
            </div>
        </el-main>
        <el-footer>
            <div>
                
            </div>
        </el-footer>
    </el-container>
    
</template>


<style>
.main{
    margin-left: 100px;
    margin-right: 100px;
}

</style>