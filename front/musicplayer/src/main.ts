import { createApp } from 'vue'
import './style.css'
import ShowVue from './views/Show.vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

const app = createApp(ShowVue)
app.use(ElementPlus)
app.mount('#app')