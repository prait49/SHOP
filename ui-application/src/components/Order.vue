<template>
  <div class="container">
    <h1 class="text-center"> Таблица заказов</h1>
    <table>
      <thead>
      <tr>
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
        <td> {{ order.orderPrice }}</td>
        <td row-reverse> {{ order.createDate }}</td>
        <td>
          <button @click="deleteOrder(order.id)">Удалить</button>
          <button @click="() => getEditOrder(order)">Редактировать</button>
        </td>
      </tr>
      </tbody>
    </table>
    <div id="editing" v-for="(order) in orders" v-bind:key="order.id">
      <fieldset v-if="editingOrderId === order.id">
        <legend>Редактирование заказов:</legend>
        <form id="editingForm" v-on:submit.prevent="editOrder(putOrder.id)">
          <label>Имя заказчика:</label>
          <input type="text" v-model="putOrder.name">
          <label>Адрес заказчика:</label>
          <input type="text" v-model="putOrder.address">
          <label>Общая сумма заказа:</label>
          <input type="text" v-model="putOrder.orderPrice">
          <label> Дата создания заказа:</label>
          <input type="date" v-model="putOrder.createDate">
          <input type="submit" value="Сохранить изменения">
          <button @click="null">Закрыть</button>
        </form>
      </fieldset>
    </div>
    <fieldset>
      <legend>Добавление новых заказов:</legend>
      <form id="ADD" v-on:submit.prevent="addOrder">
        <label>Имя заказчика:</label>
        <input type="text" v-model="newOrder.name">
        <label for="customer-name">Адрес заказчика:</label>
        <input type="text" v-model="newOrder.address">
        <label for="customer-name">Общая сумма заказа:</label>
        <input type="text" v-model="newOrder.orderPrice">
        <label for="customer-name">Дата создания заказа:</label>
        <input type="date" v-model="newOrder.createDate">
        <input class="box1" type="submit" value="Добавить заказ">
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
      editingOrderId: null,
    };
  },
  methods: {
    addOrder() {
      axios.post('http://localhost:8081/api/orders/save', this.newOrder)
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
            console.error(error);
          });
    },
    editOrder(id) {
      axios.put(`http://localhost:8081/api/orders/edit/${id}`, this.putOrder)
          .then(response => {
            this.fetchOrder();
            this.editingOrderId = null;
          })
          .catch(error => {
            console.error(error);
          });
    },
    getEditOrder(objOrder) {
      if (this.editingOrderId === objOrder.id) {
        this.editingOrderId = null;
      } else {
        this.editingOrderId = objOrder.id;
      }
      this.putOrder = {...objOrder};
    },
    backgroundColor() {

    }
  },


};
</script>
<style>

</style>