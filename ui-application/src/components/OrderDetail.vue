<template>
  <div>
    <h1 class="text-center"> Таблица деталей заказов</h1>
    <table>
      <thead>
      <tr>
        <th>Номер товара</th>
        <th>Серийный номер товара</th>
        <th>Название товара</th>
        <th>Количество</th>
        <th>Ссылка на заказ</th>
        <td>Работа с деталями заказов</td>
      </tr>
      </thead>
      <tbody>
      <tr v-for="(ordDet) in ordersDetail" v-bind:key="ordersDetail.id">
        <td> {{ ordDet.id }}</td>
        <td> {{ ordDet.product_serial_number }}</td>
        <td> {{ ordDet.product_name }}</td>
        <td> {{ ordDet.quantity }}</td>
        <td><a :href="'#object'+(ordDet.order.id)" onclick="highlightObject(this)"> Заказ№ {{ ordDet.order.id }}</a>
        </td>
        <td>
          <button @click="deleteOrderDetail(ordDet.id)">Delete</button>
        </td>
      </tr>
      </tbody>
    </table>
    <fieldset>
      <legend>Добавление новых деталей заказов:</legend>
      <form v-on:submit.prevent="addOrderDetail">
        <label>Серийный номер товара :</label>
        <input type="text" v-model="newOrderDetail.product_serial_number">
        <label>Название товара:</label>
        <input type="text" v-model="newOrderDetail.product_name">
        <label>Количество:</label>
        <input type="text" v-model="newOrderDetail.quantity">
        <label>Сылка на заказ :</label>
        <select v-model="newOrderDetail.order" >
          <option v-for="(order) in orders"
                  v-bind:key="order.id"
                  :value="order"
          >Заказ №{{ order.id }}</option>
        </select>
        <input type="submit" value="Добавить деталь заказа">
      </form>
    </fieldset>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: "OrderDetail",
  props: ['orders'],
  data() {
    return {
      ordersDetail: [],
      newOrderDetail: {},

    };
  },
  mounted() {
    this.fetchOrderDetail();
  },
  methods: {
    addOrderDetail() {
      axios.post('http://localhost:8081/api/orders/detail', this.newOrderDetail)
          .then(response => {
            this.newOrderDetail = {};
            this.fetchOrderDetail();
          })
    },
    fetchOrderDetail() {
      axios.get('http://localhost:8081/api/orders/detail')
          .then(response => {
            this.ordersDetail = response.data;
          }).catch(error => {
        console.error('Ошибка получения данных заказов:', error);
      });
    },
    deleteOrderDetail(id) {
      axios.delete(`http://localhost:8081/api/orders/detail/${id}`)
          .then(response => {
            this.fetchOrderDetail();
          })
          .catch(error => {
            console.error(error+"ТЕСТ ");
          });
    },
  },
};
</script>

<style scoped>

</style>