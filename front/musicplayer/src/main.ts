import { createApp } from 'vue'
import './style.css'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import router from './router/index'
import AppVue from './App.vue'

createApp(AppVue).use(ElementPlus).use(router).mount('#app')