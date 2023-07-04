import { createApp } from 'vue'
import App from './App.vue'
 
 //routes
import router from "./router/index"; 
 
import { createPinia } from 'pinia'
import Antd from 'ant-design-vue';
import 'ant-design-vue/dist/antd.css';
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.min.js'
const pinia = createPinia()
const app= createApp(App)
 
 //routes 
 app.use(router)
 
app.use(pinia)  
app.use(Antd)
app.mount('#app')