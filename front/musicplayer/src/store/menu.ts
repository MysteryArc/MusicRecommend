import { defineStore } from "pinia";
import { useRouter } from "vue-router";

const useMenuStore = defineStore("menu", {
    state: () => ({
        nowActive:""
    }),
    actions: {
        changeActive(now:string) {
            this.nowActive = now
        }
    }
})

export default useMenuStore