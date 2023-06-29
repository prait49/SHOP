<template>
  <div>
    <h1 class = "text-center"> Таблица  деталей заказов</h1>
    <table>
      <thead>
      <tr>
        <th>Номер товара</th>
        <th>Серийный номер новара</th>
        <th>Название товара</th>
        <th>Количество</th>
        <th>Ссылка на заказ</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="(ordDet, index) in ordersDetail" v-bind:key="ordersDetail.id">
        <td> {{ordDet.id}}</td>
        <td> {{ordDet.product_serial_number}}</td>
        <td> {{ordDet.product_name}}</td>
        <td> {{ordDet.quantity}}</td>
        <td><a :href="'#object'+(ordDet.order.id)" onclick="highlightObject(this)" > Заказ№ {{ordDet.order.id}}</a></td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: "OrderDetail",
  data() {
    return {
      ordersDetail: [],
    };
  },
  mounted() {
    this.fetchOrder();
  },
  methods: {
    fetchOrder() {
      axios.get('http://localhost:8081/api/orders/detail')
          .then(response => {
            this.ordersDetail = response.data;
          }).catch(error => {
        console.error('Ошибка получения данных заказов:', error);
      });
    },
  },
};
</script>

<style scoped>

</style>