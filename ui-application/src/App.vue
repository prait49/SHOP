<script setup>
import Order from "@/components/Order.vue";
import OrderDetail from "@/components/OrderDetail.vue";
import Time from "@/components/Time.vue";
</script>

<template>

  <div id="time"><Time /></div>
  <div id="order"> <Order :orders="orders" :fetchOrder="fetchOrder"  :backgroundColor="backgroundColor"/></div>
  <div id="OrderDetail"><OrderDetail :orders="orders"  :backgroundColor="backgroundColor"/></div>
  <div id="background"></div>
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
    backgroundColor() {
      let div = document.getElementById('background');
      if (div.style.display === 'block') {
        div.style.display='none';
      }
      else {
        div.style.display = 'block';
      }
    }
  },
};

</script>

<style scoped>
</style>