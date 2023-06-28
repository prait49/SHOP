import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'
import Order from "@/components/Order.vue";


createApp(App).mount('#app')
createApp(Order).mount('#order');

