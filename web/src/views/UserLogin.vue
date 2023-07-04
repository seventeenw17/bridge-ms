<template>
    <div class="login-box">
      <a-form :model="formState" name="normal_login" class="login-form" @finish="onFinish" @finishFailed="onFinishFailed">
        
        <a-form-item label="用户名称" name="username" class="sign-input"
          :rules="[{ required: true, message: '不能输入空用户账号' }]">
          <a-input size="large"  v-model:value="formState.username">
            <template #prefix>
              <UserOutlined class="site-form-item-icon" />
            </template>
          </a-input>
        </a-form-item>
  
        <a-form-item label="用户密码" name="password" :rules="[{ required: true, message: '不能输入空密码' }]" class="sign-input">
          <a-input-password size="large" v-model:value="formState.password">
            <template #prefix>
              <LockOutlined class="site-form-item-icon" />
            </template>
          </a-input-password>
        </a-form-item>
            <div>
                  <router-link class="nav-link" :to="{ name: 'register' }"
                     role="button">没有账号？立即注册</router-link>
            </div>
        <div class="login-btn-box">

          <a-form-item>
            <a-button type="primary" html-type="submit" class="login-form-button">
              登录
            </a-button>
          </a-form-item>
        </div>
      </a-form>
    </div>
  </template>
  <script lang="ts">
  import { defineComponent, reactive } from 'vue';
  import { UserOutlined, LockOutlined } from '@ant-design/icons-vue';
  import axios from 'axios';
  import { notification } from 'ant-design-vue';
  import { useUserStore } from '../store/user';
  import router from '../router';
  interface FormState {
    username: string;
    password: string;
    remember: boolean;
  }
  export default defineComponent({
    components: {
      UserOutlined,
      LockOutlined,
    },
    setup() {
      const userStore = useUserStore()
      const formState = reactive<FormState>({
        username: '',
        password: '',
        remember: true,
      });
  
      const onFinish = (values: any) => {
        axios({
          url: 'http://localhost:3000/api/user/login',
          method: 'POST',
          params: {
            username: values.username,
            password: values.password,
          }
        })
          .then((resp) => {
            const data = resp.data;
  
            if (data.error_info === 'success') {
              userStore.$patch({
                username:data.username,
                units_id:data.units_id,
                units_name:data.units_name,
                is_login:true,
                account:values.account,
              })
              ElMessage({
                message: h('span', { style: 'color: teal' }, "欢迎使用本桥梁系统！"),
                type: 'success',
              })
              sessionStorage.setItem("is_login", "true");
              if(data.username==='admin')
                router.push('/adminhome')
              else
                router.push('/home')             

            } else {
              notification.error({
                message: '登录出现错误',
                description: "请检查账号或密码",
              })
            }
          })
      };
  
      const onFinishFailed = (errorInfo: any) => {
        notification.error({
          message: "登录出现错误",
          description: errorInfo,
        })
      };
  
      return {
        formState,
        onFinish,
        onFinishFailed,
      };
    },
  });
  </script>
  <style scoped>
  .login-form {
    width: 22rem;
    height: 45vh;
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    /* background-image: linear-gradient(to top, #30cfd0 0%, #330867 100%); */

    background-color: rgba(255, 194, 147, 0.5);
    /* background-image: linear-gradient(to top, #d299c2 0%, #fef9d7 100%); */
    padding: 20px;
    border-radius: 10px;
  }
  .login-box{
    background-color: rgba(228, 13, 106, 0.5);
  }
  .sign-input {
    margin-top: 1rem;
  }
  </style>
    