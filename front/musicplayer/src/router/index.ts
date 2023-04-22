import Show from "../views/Show.vue"
import Login from "../views/Login.vue"
import Recommend from "../views/Recommend.vue"
import Love from "../views/Love.vue"
import Recently from "../views/Recently.vue"
import { createRouter, createWebHashHistory } from "vue-router"


const routes = [
    {
        path: '/show',
        name: "show",
        component: Show
    },
    {
        path: '/login',
        name: "login",
        component: Login
    },
    {
        path: '/recommend',
        name: "recommend",
        component: Recommend
    },
    {
        path: '/love',
        name: "love",
        component: Love
    },
    {
        path: '/recently',
        name: "recently",
        component: Recently
    },
]

const router = createRouter({
    history: createWebHashHistory(),
    linkActiveClass:"active",
    routes: routes
})

export default router