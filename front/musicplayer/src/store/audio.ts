import { defineStore } from "pinia";

const useAudioStore = defineStore("audio", {
    state: () => ({
        audioUrl: "",
        isPlay: false
    }),
})

export default useAudioStore