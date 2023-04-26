<script setup lang="ts">
import { DataTableColumns, NButton, NDataTable, NIcon } from 'naive-ui';
import { h, onMounted, reactive } from 'vue';
import getRecently from "../api/getRecently"
import useUserStore from '../store/user';
import useAudioStore from '../store/audio';

const userStore = useUserStore()
const audioStore = useAudioStore()
const recentlyList = reactive<any>([])
const columns: DataTableColumns<IArtists> = [
    {
        title: "歌曲",
        key: "name"
    },
    {
        title: "歌手",
        key: "singer"
    },
    {
        title: "专辑",
        key: "album"
    },
    {
        title:"play",
        key: "play",
        render(row) {
            return h(
                NButton,
                {
                    strong: true,
                    tertiary: true,
                    size: 'small',
                    onClick: () => play(row)
                },
                {
                    default: () => 'Play'
                }
            )
        }
    }
]

function play(music: any) {
    const audioUrl = "http://music.163.com/song/media/outer/url?id=" + music.cloudId + ".mp3"
    audioStore.setAudio(audioUrl, music.id, music.name, music.picUrl)
    audioStore.read(userStore.recommendId, audioStore.audioId)
}

onMounted(() => {
    getRecently(userStore.recommendId).then((res: any) => {
        recentlyList.push(...res)
    })
})
</script>

<template>
    <div class="recently-main">
        <div class="title">最近播放</div>
        <div class="recently-table">
            <n-data-table :columns="columns" :data="recentlyList" single-column :bordered="false" :max-height="650"></n-data-table>
        </div>
    </div>
</template>

<style scoped>
.recently-main{
    height: 100%;
    margin-left: 30px;
    margin-right: 30px;
}
.title{
    font-size: 40px;
    font-weight: 700;
}
</style>