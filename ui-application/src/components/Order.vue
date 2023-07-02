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
        <th> Работа с заказами</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="(order) in orders" v-bind:key="order.id" :id="'object'+(order.id)">
        <td> {{ order.id }}</td>
        <td> {{ order.name }}</td>
        <td> {{ order.address }}</td>
        <td> {{ order.order_price }}</td>
        <td> {{ order.create_date }}</td>
        <td>
          <button @click="deleteOrder(order.id)">Удалить</button>
          <button @click="putOrder(order.id)">Редактировать</button>
        </td>
      </tr>
      </tbody>
    </table>

    <fieldset>
      <legend>Доавление новых заказов:</legend>
      <form v-on:submit.prevent="addOrder">
        <label >Имя заказчика:</label>
        <input type="text"  v-model="newOrder.name">
        <label for="customer-name">Адрес заказчика:</label>
        <input type="text"  v-model="newOrder.address">
        <label for="customer-name">Общая сумма заказа:</label>
        <input type="text"  v-model="newOrder.order_price">
        <label for="customer-name">Дата создания заказа:</label>
        <input type="date"  v-model="newOrder.create_date">
        <input type="submit" value="Добавить заказ">
      </form>
    </fieldset>
    <fieldset>
      <legend>Редактирование заказов:</legend>
      <form v-for="(order) in orders" v-bind:key="order.id">
        <label >ID заказа :</label>
        <input type="text"  :value="order.id">
        <label >Имя заказчика:</label>
        <input type="text"  :value="order.name">
        <label for="customer-name">Адрес заказчика:</label>
        <input type="text"  :value="order.address">
        <label for="customer-name">Общая сумма заказа:</label>
        <input type="text"  :value="order.order_price">
        <label for="customer-name">Дата создания заказа:</label>
        <input type="date"  :value="order.create_date">
        <input type="submit" value="Редактировать заказ">
      </form>
    </fieldset>
  </div>
</template>
<script>
import axios from 'axios';
export default {
  name: "Order",
  props: ['orders', 'fetchOrder'],
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
    deleteOrder(id) {
      axios.delete(`http://localhost:8081/api/orders/${id}`)
          .then(response => {
            this.fetchOrder();
          })
          .catch(error => {
            console.error(error+"ТЕСТ ");
          });
    },
  },

};
</script>
<style>


</style>