<template>
   <NavBar />
  <UserLoginView></UserLoginView>
</template>

<script>
import NavBar from '../src/components/NavBar.vue'
import UserLoginView from './views/UserLoginView.vue';
export default {
  name: 'App',
  components: {
    NavBar,
    UserLoginView
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 0px;
}
</style>