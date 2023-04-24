import { createApp } from 'vue'
import './style.css'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import router from './router/index'
import AppVue from './App.vue'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
import pinia from './store/index'

const app = createApp(AppVue)
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}
app.use(ElementPlus).use(router).use(pinia).mount('#app')