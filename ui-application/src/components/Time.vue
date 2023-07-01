<template>
  <h1>Дата: {{currentTime}}</h1>
</template>

<script>
import axios from 'axios';
export default {
  name: "Time",
  data() {
    return {
      currentTime:'',
    };
  },
  mounted() {
    this.callController();
  },
  methods: {
    callController() {
      axios.get('http://localhost:8080')
          .then(response => {
            this.currentTime = response.data;
          }).catch(error => {
        console.error('Ошибка получения времени:', error);
      });},
  },};
</script>

<style scoped>

</style>