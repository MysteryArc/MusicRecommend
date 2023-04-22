<script setup lang="ts">
import axios from '../api/request';
import { onMounted, ref } from 'vue';

const musicdata = ref([]) 
const src = ref("");
const audioee = ref()
const page = ref()
const musictotal = ref(100)
const currentpage = ref(1)

async function getMusic() {
    const resp = await axios.get('/artists')
    // console.log(resp.data)
    musicdata.value = resp.data
}

async function getPage(current:number) {
    const resp = await axios.get('/artists/' + current)
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

function playmusic0(playid: number) {
    audioee.value.src = "http://music.163.com/song/media/outer/url?id=" + playid + ".mp3"
    audioee.value.play()
}

onMounted(() => {
    getMusic()
    getMusicTotal()
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
                <el-table :data="musicdata" stripe height="530" style="width: 100%;">
                    <el-table-column prop="cloudId" label="ID" />
                    <el-table-column prop="name" label="Name" />
                    <el-table-column label="Picture">
                        <template #default="scope">
                            <el-image :src="scope.row.picUrl" style="width: 150px; height: 150px;" lazy/>
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


<style>
.main{
    margin-left: 10px;
    margin-right: 10px;
}

</style>