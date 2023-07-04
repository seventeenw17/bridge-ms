<template>
    <el-button type="primary" @click="lookfor">查看</el-button>
</template>

<script lang="ts" setup>
import axios from 'axios';
import { ref } from 'vue'
let test = ref('')
const lookfor = () => {
    alert("454444")
    axios({
        url: "http://127.0.0.1:3000/api/bridge/test/",
        method: "GET",
    }).then((resp) => {
        alert(resp)
        test.value = resp.data;
    }).catch((resp) => {
        console.log(resp);
    })
}

</script>

<style scoped>
</style>