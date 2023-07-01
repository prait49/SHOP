<script setup>
import Order from "@/components/Order.vue";
import OrderDetail from "@/components/OrderDetail.vue";
import Time from "@/components/Time.vue";

</script>

<template>

  <div id="time"><Time /></div>
  <div id="order"> <Order :orders="orders" :fetchOrders="fetchOrders"/></div>
<!--  <div id="OrderDetail"><OrderDetail :orders="orders" /></div>-->

</template>

<script>
import axios from "axios";

export default {

  name: "App",
  data() {
    return {
      orders: [],
    };
  },
  mounted() {
    this.fetchOrder();
  },
  methods: {
    fetchOrder() {
      axios.get('http://localhost:8081/api/orders')
          .then(response => {
            this.orders = response.data;
          }).catch(error => {
        console.error('Ошибка получения данных заказов:', error);
      });
    },
  },
};

</script>

<style scoped>

</style>