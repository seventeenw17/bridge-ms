import { createApp } from 'vue'
import App from './App.vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.min.js'
import Antd from 'ant-design-vue';
import 'ant-design-vue/dist/antd.css';
const app = createApp(App)

app.use(ElementPlus, { size: 'small', zIndex: 3000 })
app.use(Antd)
app.mount('#app')

