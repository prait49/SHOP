<template>

    <p >{{ currentTime }}</p>

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
      </tr>
      </thead>
      <tbody>
      <tr v-for="order in orders" v-bind:key="order.id">
        <td> {{order.id}}</td>
        <td> {{order.name}}</td>
        <td> {{order.address}}</td>
        <td> {{order.order_price}}</td>
        <td> {{order.create_date}}</td>
      </tr>
      </tbody>
    </table>
  </div>

</template>

<script>
import axios from 'axios';
export default {
  name: "Order",
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

},};
</script>
<style>
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  text-align: left;
  padding: 8px;
}

th {
  background-color: #f2f2f2;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
body {
  display: flex;
  place-items: center;
  flex-direction: column;
}
p, h1{
  text-align: center;
}

</style>