<script setup lang="ts">
import axios from '../api/request';
import { onMounted, ref } from 'vue';
import useAudioStore from "../store/audio"
import useUserStore from '../store/user';

const musicdata = ref([]) 
const page = ref()
const musictotal = ref(100)
const currentpage = ref(1)
const audioStore = useAudioStore()
const userStore = useUserStore()

async function getMusic() {
    const resp = await axios.get('/artists/page')
    // console.log(resp.data)
    musicdata.value = resp.data
}

async function getPage(current:number) {
    const resp = await axios.get('/artists/page/' + current)
    console.log(resp.data)
    musicdata.value = resp.data
}

async function getMusicTotal() {
    const resp = await axios.get('/artists/total')
    // console.log(resp.data)
    musictotal.value = resp.data
}

function playmusic(playid: number) {
    window.open("http://music.163.com/song/media/outer/url?id=" + playid + ".mp3")
}

function playmusic0(music: any) {
    const audioUrl = "http://music.163.com/song/media/outer/url?id=" + music.cloudId + ".mp3"
    audioStore.setAudio(audioUrl, music.id, music.name, music.picUrl)
    audioStore.read(userStore.recommendId, audioStore.audioId)
}

onMounted(() => {
    getMusic()
    // getMusicTotal()
})
</script>

<template>
    <el-container class="show-main">
        <el-header>
            <h3 style="float: left;">音乐分页</h3>
        </el-header>
        <el-main>
            <div style="width: 100%;">
                <el-table :data="musicdata" stripe height="580" style="width: 100%;">
                    <el-table-column prop="cloudId" label="ID" />
                    <el-table-column prop="name" label="Name" />
                    <el-table-column label="Picture">
                        <template #default="scope">
                            <el-image :src="scope.row.picUrl" style="width: 100px; height: 100px;" lazy/>
                        </template>
                    </el-table-column>
                    <el-table-column prop="singer" label="Singer" />
                    <el-table-column label="Play">
                        <template #default="scope">
                            <!-- <el-button type="primary" @click="playmusic(scope.row.cloudId)">播放</el-button> -->
                            <el-button type="primary" @click="playmusic0(scope.row)">Play</el-button>
                        </template>
                    </el-table-column>
                </el-table>
                <el-divider />
                <el-pagination background 
                    ref = 'page'
                    layout="prev, pager, next" 
                    :total="musictotal" 
                    :page-size="10" 
                    v-model:current-page="currentpage"
                    @current-change="getPage(currentpage)"/>
            </div>
        </el-main>
    </el-container>
</template>


<style scoped>
.show-main{
    height: 100%;
}
</style>