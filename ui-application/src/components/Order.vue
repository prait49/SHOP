<template>
  <div class = "container">
    <h1 class = "text-center"> Таблица заказов</h1>
    <table>
      <thead style=" border: solid 5px black ">
      <tr style=" border: solid 5px black ">
        <th >  ID заказа</th>
        <th> Имя заказчика</th>
        <th> Адрес заказчика</th>
        <th> Общая сумма заказа</th>
        <th> Дата создания заказа</th>
        <th> Детали заказа</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="order in orders" v-bind:key="order.id">
        <td> {{order.id}}</td>
        <td> {{order.name}}</td>
        <td> {{order.address}}</td>
        <td> {{order.order_price}}</td>
        <td> {{order.create_date}}</td>
        <td> {{order.orderDetails}}</td>
      </tr>
      </tbody>
    </table>

  </div>
  <div>
    <p >{{ currentTime }}</p>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: "Order",
  data() {
    return {
      orders: [],
      currentTime:'',
    };
  },
  mounted() {
    this.fetchOrder();
    this.callController();
  },
  methods: {
    fetchOrder() {
      axios.get('http://localhost:8081/api/order')
          .then(response => {
            this.orders = response.data;
          }).catch(error => {
        console.error('Ошибка получения данных заказов:', error);
      });
    },
    callController() {
      axios.get('http://localhost:8080')
          .then(response => {
            this.currentTime = response.data;
          }).catch(error => {
        console.error('Ошибка получения времени:', error);
      });},
},};
</script>
<style>
table {
  border-collapse: collapse;
  width: 100%;
}

table, th, td {
  border: 1px solid black;
  padding: 8px;
  text-align: left;
}
</style>