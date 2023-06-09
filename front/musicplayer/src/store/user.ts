import axios from "../api/request";
import { defineStore } from "pinia";
import { ElMessage } from "element-plus";
import { useRouter } from "vue-router";

const $router = useRouter()

const useUserStore = defineStore("user", {
    state: () => ({
        islogin: false,
        userId: "",
        recommendId: "",
        userName: ""
    }),
    getters: {
        getUserId: state => state.userId
    },
    actions: {
        async login(loginForm: any) {
            const resp = await axios.post("/api/login/user", loginForm)
            if (resp.data.flag == true) {
                this.userId = resp.data.value.userId
                this.recommendId = resp.data.value.id
                this.userName = resp.data.value.name
                this.islogin = true
                ElMessage({
                    message: '登录成功',
                    type: 'success',
                })
            }
            else {
                ElMessage({
                    message: '登录失败，用户名或密码错误',
                    type: 'error',
                })
            }
        },
        logout() {
            this.userId = ""
            this.recommendId = ""
            this.islogin = false
            ElMessage({
                message: '已退出登录',
                type: 'success',
            })
        }
    }
})

export default useUserStore