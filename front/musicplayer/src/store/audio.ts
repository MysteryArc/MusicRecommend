import { defineStore } from "pinia";
import axios from "../api/request";
import { reactive } from "vue";

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
        },
        async read(user: string | number, artist: string | number) {
            const readForm = reactive({
                userId: user,
                artistId: artist
            })
            await axios.post("/read", readForm)
        },
        async love(user: string | number, artist: string | number) {
            const readForm = reactive({
                userId: user,
                artistId: artist
            })
            await axios.post("/love", readForm)
        },
        async notlove(user: string | number, artist: string | number) {
            await axios.delete("/love/" + user + "/" + artist)
        },
    }

})

export default useAudioStore