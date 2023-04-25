import { defineStore } from "pinia";

const useAudioStore = defineStore("audio", {
    state: () => ({
        audioUrl: "",
        isPlay: false,
        audioName: "",
        audioId: "",
        audioPic: ""
    }),
    actions: {
        setAudio(audioUrl: any, audioId: any, audioName: any, audioPic: any) {
            this.audioUrl = audioUrl
            this.audioId = audioId
            this.audioName = audioName
            this.audioPic = audioPic
        }
    }

})

export default useAudioStore