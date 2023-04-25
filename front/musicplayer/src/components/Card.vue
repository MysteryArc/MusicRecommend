<template>
    <n-card hoverable :bordered="false" class="ncard" @mouseenter="displayButton" @mouseleave="hiddenButton">
        <div style="display: flex; align-items: center;">
            <el-image :src="props.item.picUrl" style="height: 100px; width: 100px;"></el-image>
            <div class="musicinfo">
                <div class="music-name">{{ props.item.name }}</div>
                <div class="music-singer">{{ props.item.singer }}</div>
            </div>
            <div class="card-buttons" v-show="buttonVisible">
                <n-icon class="pointer" size="25" style="margin-left: 7px;" @click="cardPlay(props.item.cloudId)">
                    <Play />
                </n-icon>
                <n-icon class="pointer" size="25" style="margin-left: 5px;">
                        <Add/>
                </n-icon>
                <n-icon class="pointer" size="20" style="margin-left: 7px;">
                        <Download/>
                </n-icon>
                <n-icon class="pointer" size="25" style="margin-left: 7px;">
                        <List/>
                </n-icon>
            </div>
        </div>
    </n-card>
</template>

<script setup lang="ts">
import { NCard, NIcon } from 'naive-ui'
import { Play, Add, Download, List } from "@vicons/carbon"
import { ref } from 'vue';
import useAudioStore from "../store/audio"


const props = defineProps<{
    item: IArtists
}>()
const audioStore = useAudioStore()

const buttonVisible = ref(false);

function displayButton() {
    buttonVisible.value = true
}

function hiddenButton() {
    buttonVisible.value = false
}
function cardPlay(playid: string | number) {
    audioStore.audioUrl = "http://music.163.com/song/media/outer/url?id=" + playid + ".mp3"
}
</script>



<style scoped>
.musicinfo{
    margin-left: 3%;
    width: 50%;
}
.music-name{
    font-size: 15px;
    font-weight: 500;
}
.music-singer{
    font-weight: 300;
    font-size: 13px;
}

.ncard:hover{
    background-color: #EDEDEDFF;
}
.card-buttons{
    margin-left: 15%;
    display: flex;
    align-items: center;
}
.pointer:hover{
    cursor: pointer;
    color: #55D9A2FF;
}
div{
    font-family: 'Microsoft YaHei UI', Arial, sans-serif;
}
</style>