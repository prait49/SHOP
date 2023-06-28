<template>
  <div style=" background: #00bd7e;" >
    <p>{{ currentTime }}</p>
  </div>
</template>
<script>


import axios from 'axios';
export default {
  data() {
    return {
      currentTime: '',
    };
  },
  mounted() {
    this.callController();
    setInterval(this.callController, 1000); // 1 раз в секунду
  },
  methods: {
    callController() {
    axios.get('http://localhost:8080')
        .then(response => {
          this.currentTime = response.data;
        }).catch(error => {
          console.error('Ошибка получения времени:', error);
        });
  },},
};
</script>

<style scoped>

</style>



