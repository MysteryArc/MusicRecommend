import Show from "../views/Show.vue"
import Login from "../views/Login.vue"
import { createRouter, createWebHashHistory } from "vue-router"


const routes = [
    {
        path: '/show',
        component: Show
    },
    {
        path: '/login',
        component: Login
    }
]

const router = createRouter({
    history: createWebHashHistory(),
    routes: routes
})

export default router