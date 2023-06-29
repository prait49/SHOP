import './assets/main.css'
import { createApp } from 'vue'
import Order from "@/components/Order.vue";
import OrderDetail from "@/components/OrderDetail.vue";
import Time from "@/components/Time.vue";



createApp(Order).mount('#order');
createApp(OrderDetail).mount('#orderDetail');
createApp(Time).mount('#time');



