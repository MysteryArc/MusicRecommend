<script setup lang="ts">
import { onMounted, reactive, ref } from "vue"
import useAudioStore from "../store/audio"
import useUserStore from "../store/user"
import { PlayCircle, PauseCircle, PlaySkipBackSharp, PlaySkipForwardSharp, HeartOutline, Heart } from "@vicons/ionicons5"
import { NIcon, NImage } from "naive-ui"
import { ElMessage } from "element-plus"
import axios from "../api/request"

const audioStore = useAudioStore()
const userStore = useUserStore()
const audio = ref()
const slidebar = ref()
const wrap = ref()
const circle = ref()
const circleVisible = ref(false)
const nullptr = ""
const islove = ref(false)


const audioData = reactive({
    audiourl: audioStore.audioUrl,
    playing: audioStore.isPlay,
    duration: 0, // 音频总时长
    currentTime: 0, // 当前播放的位置
});

const wrapEle: {
    width: string;
    el: any;
} = {
    width: '0px',
    el: null,
};

const sliderBar: {
    width: string;
    el: any;
} = {
    width: '0%',
    el: null,
};
const circleTarget: {
    circleMouseMouve: boolean;
    pageX: number;
    circleLeft: string;
    el: any;
} = {
    circleMouseMouve: false,
    pageX: 0,
    circleLeft: '0%',
    el: null,
};

let circleDragLeft = '0%'; // 圆圈被鼠标水平拖拽的距离（默认向左）

document.addEventListener('mousemove', (e) => {
    if (circleTarget.circleMouseMouve) {
        const nowLeft =
            parseFloat(circleTarget.circleLeft) +
            getPercentage(e.pageX - circleTarget.pageX, wrapEle.width);
        if (nowLeft >= 100) {
            circleDragLeft = '100%';
        } else if (nowLeft <= 0) {
            circleDragLeft = '0%';
        } else {
            circleDragLeft = `${nowLeft}%`;
        }
        updateProgressBar(circleDragLeft);
        currentTimeByProgressBar(circleDragLeft);
    }
});

document.addEventListener('mouseup', () => {
    circleTarget.circleMouseMouve = false;
});

const circleMousedown = (e:any) => {
    circleTarget.el = e.target; // 圆圈自身
    wrapEle.el = e.target.parentElement; // 圆圈父元素
    sliderBar.el = e.target.nextElementSibling; // 圆圈的兄弟节点

    circleTarget.circleLeft = e.target.style.left;
    circleTarget.pageX = e.pageX;
    circleTarget.circleMouseMouve = true;
    wrapEle.width = window.getComputedStyle(wrapEle.el, null).getPropertyValue('width');
};

// 只处理e.target是slider-wrap 或 slider-bar的情况
const clickSliderWrap = (e:any) => {
    if (e.target.getAttribute('target') === 'wrap') {
        wrapEle.el = e.target;
        circleTarget.el = e.target.firstElementChild;
        sliderBar.el = e.target.lastElementChild;
    } else if (e.target.getAttribute('target') === 'sliderbar') {
        sliderBar.el = e.target;
        circleTarget.el = e.target.previousElementSibling;
        wrapEle.el = e.target.parentElement;
    } else {
        return;
    }
    wrapEle.width = window.getComputedStyle(wrapEle.el, null).getPropertyValue('width');
    const styleLeft = `${getPercentage(e.offsetX, wrapEle.width)}%`;
    updateProgressBar(styleLeft);
    currentTimeByProgressBar(styleLeft);
};

// 播放或暂停音频
function playPauseAudio() {
    if (audioStore.isPlay == false) {
        audio.value.play()
        audioStore.isPlay = true
    }
    else {
        audio.value.pause()
        audioStore.isPlay = false
    }
};

// 计算百分比的分子
function getPercentage(num: number | string, den: number | string): number {
    const numerator = typeof num === 'number' ? num : parseFloat(num);
    const denominator = typeof den === 'number' ? den : parseFloat(den);
    return Math.round((numerator / denominator) * 10000) / 100;
}

// /**
//  * 更新进度条
//  * @param percentage 得到一个百分比的字符串
//  */
function updateProgressBar(percentage: string) {
    circleTarget.el.style.left = percentage;
    sliderBar.el.style.width = percentage;
    // leftPercent.value = percentage
}

/**
 * 以下是对音频的操作
 */

// 音频播放结束
const audioEnded = () => {
    audioData.playing = false;
};
// 播放进度：表示audio正在播放，currentTime在更新
const audioTimeupdate = () => {
    audioData.currentTime = audio.value.currentTime;
    progressBarBycurrentTime();
};
// 当媒体音频第一帧加载完成时
const audioLoadeddata = () => {
    audioData.duration = audio.value.duration;
    audio.value.play()
    audioStore.isPlay = true
    isLove()
};

// 进度条和音频播放进度进行关联
function progressBarBycurrentTime() {
    const progress = getPercentage(audioData.currentTime, audioData.duration);
    updateProgressBar(`${progress}%`);
}
// /**
//  * 播放进度与进度条进行关联
//  * @param stylePercentage 圆圈的left值
//  */
function currentTimeByProgressBar(styleLeft: string) {
    if (audio.value) {
        const currentTime = (parseFloat(styleLeft) / 100) * audioData.duration;
        audio.value.currentTime = currentTime;
        audioData.currentTime = currentTime;
    }
}

function displayCircle() {
    circleVisible.value = true
}

function hiddenCircle() {
    circleVisible.value = false
}

//添加到喜欢
async function loveAndRemove() {
    if (islove.value == false) {
        audioStore.love(userStore.recommendId, audioStore.audioId)
        ElMessage({
            message: '已添加到喜欢！',
            type: 'success',
        })
    }
    else {
        audioStore.notlove(userStore.recommendId, audioStore.audioId)
        ElMessage({
            message: '我不喜欢了！',
            type: 'error',
        })
    }
    isLove()
}

//查询是否是喜欢的歌
async function isLove() {
    const resp = await axios.get("/love/" + userStore.recommendId + "/" + audioStore.audioId) 
    islove.value = resp.data.flag
}

onMounted(() => {
    wrapEle.el = wrap.value
    circleTarget.el = circle.value
    sliderBar.el = slidebar.value
})

</script>

<template>
    <div class="slider-box" @mouseenter="displayCircle" @mouseleave="hiddenCircle">
        <div
            class="slider-wrap"
            target="wrap"
            ref="wrap"
            @click="clickSliderWrap"
            >
            <div class="circle" target="circle" @mousedown="circleMousedown" ref="circle" v-show="circleVisible"></div>
            <div class="slider-bar" target="sliderbar" ref="slidebar"></div>
        </div>
    </div>
    <!-- <div class="icon-div" @click="playPauseAudio">
        <video-play class="icon" v-if="!audioData.playing"></video-play>
        <video-pause class="icon" v-else></video-pause>
    </div> -->
    
    <div class="button-box">
        <div class="musicInfo">
            <n-image width="50" :src=audioStore.audioPic />
            <div style="margin-left: 10px;">
                <div class="music-name">{{ audioStore.audioName }}</div>
                <div class="loveButton" v-if="audioStore.audioName!=nullptr" @click="loveAndRemove">
                    <n-icon size="20" class="loving" v-if="islove == true">
                        <Heart/>
                    </n-icon>
                    <n-icon size="20" class="notlove" v-else>
                        <HeartOutline/>
                    </n-icon>
                </div>
            </div>
        </div>
        <div class="controlButtons">
            <n-icon size="25" class="skipctrl">
                <PlaySkipBackSharp/>
            </n-icon>
            <n-icon size="45" class="play-pause" @click="playPauseAudio">
                <PlayCircle v-if="audioStore.isPlay==false"/>
                <PauseCircle v-else/>
            </n-icon>
            <n-icon size="25" class="skipctrl">
                <PlaySkipForwardSharp/>
            </n-icon>
        </div>
    </div>
    <audio
        :src="audioStore.audioUrl"
        ref='audio'
        preload="auto"
        @ended="audioEnded"
        @timeupdate="audioTimeupdate"
        @loadeddata="audioLoadeddata"
        ></audio>
</template>

<style scoped>
.slider-box{
    display: flex;
    align-items: center;
    height: 20px;
}
.slider-wrap{
    position: relative;
    width: 100%;
    display: flex;
    align-items: center;
    background-color: #EFEFEFFF;
    height: 3px;
}
.circle {
        position: absolute;
        width: 12px;
        height: 12px;
        background-color: #1FC175FF;
        border-radius: 100%;
        cursor: pointer;
        user-select: none;
        transform: translate(-50%);
    }
.slider-bar{
    height: 3px;
    background-color: #1FC175FF;
}
.button-box{
    height: 100%;
    display: flex;
    align-items: center;
    /* justify-content: space-around; */
}
.musicInfo{
    display: flex;
    align-items: center;
    margin-left: 40px;
    margin-bottom: 20px;
}
.loveButton:hover{
    cursor: pointer;
}
.loving{
    color: #F24A4AFF;
}
.music-name{
    font-size: 14px;
}
.loveButton{
    margin-top: 3px;
}
.controlButtons{
    display: flex;
    align-items: center;
    margin-bottom: 30px;
    margin-left: 36%;
}
.skipctrl:hover {
    cursor: pointer;
    color: #55D9A2FF;
}
.play-pause{
    margin-left: 15px;
    margin-right: 15px;
    color: #55D9A2FF;
    cursor: pointer;
}

</style>