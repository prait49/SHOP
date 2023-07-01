<template>
  <div class="container">
    <h1 class="text-center"> Таблица заказов</h1>
    <table>
      <thead style=" border: solid 5px black ">
      <tr style=" border: solid 5px black ">
        <th> ID заказа</th>
        <th> Имя заказчика</th>
        <th> Адрес заказчика</th>
        <th> Общая сумма заказа</th>
        <th> Дата создания заказа</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="(order) in orders" v-bind:key="order.id" :id="'object'+(order.id)">
        <td> {{ order.id }}</td>
        <td> {{ order.name }}</td>
        <td> {{ order.address }}</td>
        <td> {{ order.order_price }}</td>
        <td> {{ order.create_date }}</td>
      </tr>
      </tbody>
    </table>

    <fieldset>
      <legend>Доавление новых заказов:</legend>
      <form v-on:submit.prevent="addOrder">
        <label for="customer-name">Имя заказчика:</label>
        <input type="text" id="customer-name" name="customer-name" v-model="newOrder.name">
        <label for="customer-name">Адрес заказчика:</label>
        <input type="text" id="customer-address" name="customer-address" v-model="newOrder.address">
        <label for="customer-name">Общая сумма заказа:</label>
        <input type="text" id="order-price" name="order-price" v-model="newOrder.order_price">
        <label for="customer-name">Дата создания заказа:</label>
        <input type="date" id="create-date" name="create-date" v-model="newOrder.create_date">
        <input type="submit" value="Добавить заказ">
      </form>
    </fieldset>
  </div>
</template>
<script>
import axios from 'axios';

export default {
  name: "Order",

  props: ['orders'],


  data() {
    return {
      newOrder: {},
    };
  },

  methods: {
    addOrder() {
      axios.post('http://localhost:8081/api/orders', this.newOrder)
          .then(response => {
            this.newOrder = {};
            this.fetchOrder();
          })
    },
  },
};
</script>
<style>


</style>