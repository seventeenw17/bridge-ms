import { createRouter, createWebHistory } from 'vue-router'
import store from '../store/index'
import HomeView from '@/views/HomeView.vue'
import UserLoginView from '@/views/UserLoginView.vue'
const routes = [
  {
    path: "/",
    name: 'home',
    redirect: "/home/",
    meta: {
      requestAuth: true,
    }
  },
  {
    path: '/home/',
    name: 'home',
    component: HomeView,
    meta: {
      requestAuth: true,
    }
  },
  {
    path: "/user/account/login/",
    name: "user_account_login",
    component: UserLoginView,
    meta: {
      requestAuth: false,
    }
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})
router.beforeEach((to, from, next) => {

  const jwt_token = localStorage.getItem('jwt_token');
  if (jwt_token) {
    store.commit('updateToken', jwt_token);
    store.dispatch('getinfo', {
      success() {
        store.dispatch("updatePullingInfo", false);
        next();
      },
      error() {
        store.dispatch('logout');
        store.dispatch("updatePullingInfo", false);
        alert("token无效，请重新登录！");
        next({ name: "user_account_login" });
      }
    })
  } else {
    if (to.meta.requestAuth && !store.state.user.is_login) {
      alert("请先进行登录！");
      next({ name: "user_account_login" });
    } else {
      next();
    }
  }
})
export default router
