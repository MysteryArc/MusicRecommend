<script setup lang="ts">
import { DataTableColumns, NButton, NDataTable, NIcon } from 'naive-ui';
import { h, onMounted, reactive } from 'vue';
import getLoveList from "../api/getLoveList"
import useUserStore from '../store/user';
import useAudioStore from '../store/audio';

const userStore = useUserStore()
const audioStore = useAudioStore()
const loveList = reactive<any>([])
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
        title: "play",
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

function play(music:any) {
    const audioUrl = "http://music.163.com/song/media/outer/url?id=" + music.cloudId + ".mp3"
    audioStore.setAudio(audioUrl, music.id, music.name, music.picUrl)
    audioStore.read(userStore.recommendId, audioStore.audioId)
}

onMounted(() => {
    getLoveList(userStore.recommendId).then((res: any) => {
        loveList.push(...res)
    })
})
</script>

<template>
    <div class="love-main">
        <div class="title">我喜欢</div>
        <div class="love-table">
            <n-data-table :columns="columns" :data="loveList" single-column :bordered="false" :max-height="650"></n-data-table>
        </div>
    </div>
</template>

<style scoped>
.love-main {
    height: 100%;
    margin-left: 30px;
    margin-right: 30px;
}

.title {
    font-size: 40px;
    font-weight: 700;
}
</style>