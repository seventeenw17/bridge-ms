<template>
    <NavBar></NavBar>  
    <div class="container-fuild">
        <div class="content-box">
            <RouterView v-slot="{ Component }">
                <component :is="Component"></component>
            </RouterView>
        </div>
    </div>
    
</template>
  <script lang="ts">
  import { UserOutlined, LaptopOutlined, NotificationOutlined } from '@ant-design/icons-vue';
  import '../assets/style/style.css'
  import NavBar from '../components/NavBar.vue'
  import { defineComponent, ref } from 'vue';
  export default defineComponent({
    components: {
      UserOutlined,
      NavBar,
      LaptopOutlined,
      NotificationOutlined,
    },
    setup() {
      return {
        selectedKeys1: ref<string[]>(['2']),
        selectedKeys2: ref<string[]>(['1']),
        collapsed: ref<boolean>(false),
        openKeys: ref<string[]>(['sub1']),
      };
    },
  });
  </script>
  <style scoped>
    .container {
        display: flex;
    }
    .sider-box {
        width: 15%;
    }
    .content-box {
        width: 100%;
        height: 90vh;
        padding: 1em;
        overflow: hidden auto;
    }
  </style>
  