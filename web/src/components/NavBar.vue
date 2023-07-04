<template>
  <div class="header-box">
    <!-- <icon :style="{ fontSize: '50px' }">
        <template #component="svgProps">
          <svg viewBox="0 0 1024 1024" width="1em" height="1em" fill="currentColor" v-bind="svgProps">
            <path
              d="M99.096 315.634s-82.58-64.032-82.58-132.13c0-66.064 33.032-165.162 148.646-148.646 83.37 11.91 99.096 165.162 99.096 165.162l-165.162 115.614zM924.906 315.634s82.58-64.032 82.58-132.13c0-66.064-33.032-165.162-148.646-148.646-83.37 11.91-99.096 165.162-99.096 165.162l165.162 115.614z"
              fill="#6B676E"
              p-id="1143"
            />
            <path
              d="M1024 561.548c0 264.526-229.23 429.42-512.002 429.42S0 826.076 0 561.548 283.96 66.064 512.002 66.064 1024 297.022 1024 561.548z"
              fill="#FFEBD2"
              p-id="1144"
            />
            <path
              d="M330.324 842.126c0 82.096 81.34 148.646 181.678 148.646s181.678-66.55 181.678-148.646H330.324z"
              fill="#E9D7C3"
              p-id="1145"
            />
            <path
              d="M644.13 611.098C594.582 528.516 561.55 512 512.002 512c-49.548 0-82.58 16.516-132.13 99.096-42.488 70.814-78.73 211.264-49.548 247.742 66.064 82.58 165.162 33.032 181.678 33.032 16.516 0 115.614 49.548 181.678-33.032 29.18-36.476-7.064-176.93-49.55-247.74z"
              fill="#FFFFFF"
              p-id="1146"
            />
            <path
              d="M611.098 495.484c0-45.608 36.974-82.58 82.58-82.58 49.548 0 198.194 99.098 198.194 165.162s-79.934 144.904-148.646 99.096c-49.548-33.032-132.128-148.646-132.128-181.678zM412.904 495.484c0-45.608-36.974-82.58-82.58-82.58-49.548 0-198.194 99.098-198.194 165.162s79.934 144.904 148.646 99.096c49.548-33.032 132.128-148.646 132.128-181.678z"
              fill="#6B676E"
              p-id="1147"
            />
            <path
              d="M512.002 726.622c-30.06 0-115.614 5.668-115.614 33.032 0 49.638 105.484 85.24 115.614 82.58 10.128 2.66 115.614-32.944 115.614-82.58-0.002-27.366-85.556-33.032-115.614-33.032z"
              fill="#464655"
              p-id="1148"
            />
            <path
              d="M330.324 495.484m-33.032 0a33.032 33.032 0 1 0 66.064 0 33.032 33.032 0 1 0-66.064 0Z"
              fill="#464655"
              p-id="1149"
            />
            <path
              d="M693.678 495.484m-33.032 0a33.032 33.032 0 1 0 66.064 0 33.032 33.032 0 1 0-66.064 0Z"
              fill="#464655"
              p-id="1150"
            />
          </svg>
        </template>
      </icon> -->
      <!-- <div class="text"> 桥梁初始信息管理</div> -->
      <body>
      <h1>
        
          <span> 公</span>
          <span> 路</span>
          <span> 桥</span>
          <span> 梁</span>
          <span> 信</span>
          <span> 息</span>
          <span> 管</span>
          <span> 理</span>
      </h1>
  </body>

      <a-menu
       v-model:selectedKeys="current" 
       mode="horizontal"
       style=" width:10%; display:flex; flex-direction:row-reverse; align-items:center; justify-content:center;" 
       @click="handleClick"
       
      >
      <a-sub-menu key="user">
          <template #icon>
              <user-outlined />
          </template>
          <template #title>{{ userStore.username }}</template>
          <a-menu-item-group>
            <a-menu-item key="userLogout">
              <template #icon>
                  <logout-outlined />
              </template>
              退出登录
            </a-menu-item>
          </a-menu-item-group>
        </a-sub-menu>
      </a-menu>
  </div>
  
</template>
<script lang="ts">
import { useUserStore } from '../store/user';
import { defineComponent, ref } from 'vue';
import { UserOutlined, LogoutOutlined} from '@ant-design/icons-vue';
import Icon from '@ant-design/icons-vue';
const userStore = useUserStore()

export default defineComponent({
  components: {
      UserOutlined,
      LogoutOutlined,
      Icon
  },
  setup() {
    
    const current = ref<string[]>(['user']);

    const handleClick = (item:any) => {
      console.log(item)

      if (item.key === 'userLogout') {
          userStore.logout()
      }
    }
    return {
      current,
      handleClick,
      userStore,
    };
  },
});
</script>

<style scoped>
        body {
            height: 50px;
            display: flex;
            justify-content: center;
            align-items: center;
            background-color: rgb(255, 255, 255);
        }
        h1 span {
            top: 0px; /*字符上下浮动*/
            position: relative;
            /* animation: loading 0.5s ease 0s infinite alternate; 引用动画 */
            /* animation: 动画名称 动画时间 动画曲线 何时开始 播放次数 是否反方向; 
            alternate:表示动画先正常运行再反方向运行，并持续交替
            infinite:表示无限循环*/
            font-size: 35px;
            color: rgb(20, 19, 19);
            text-shadow: 0 1px 0  #CCC,
                        0 2px 0 #CCC,
                        0 3px 0 #CCC,
                        0 4px 0 #CCC,
                        0 5px 0 #CCC,
                        0 6px 0 #CCC,
                        0 7px 0 #CCC,
                        0 8px 0 #CCC,
                        0 9px 0 #CCC,
                        0 10px 10px rgba(0, 0, 0, 0.5);
     /*text-shadow: 水平阴影位置(必须) 垂直阴影位置(必须) 模糊距离(可选) 阴影颜色(可选);
       text-shadow: h-shadow v-shadow blur color; */
        }
        h1 span:nth-child(2) { 
            animation-delay: 0.1s; 
        }
        h1 span:nth-child(3) { 
            animation-delay: 0.2s; 
        }
        h1 span:nth-child(4) { 
            animation-delay: 0.3s; 
        }
        h1 span:nth-child(5) { 
            animation-delay: 0.4s; 
        }
        h1 span:nth-child(6) { 
            animation-delay: 0.5s; 
        }
        @keyframes loading {  /* 定义动画*/
            100% {
                top: -20px;  /*字符上下浮动*/
                text-shadow: 0 1px 0 #CCC,
                     0 2px 0 #CCC,
                     0 3px 0 #CCC,
                     0 4px 0 #CCC,
                     0 5px 0 #CCC,
                     0 6px 0 #CCC,
                     0 7px 0 #CCC,
                     0 8px 0 #CCC,
                     0 9px 0 #CCC,
                     0 50px 25px rgba(0, 0, 0, 0.3);     
  /*上升的时候阴影要在文字下面一些，所以垂直阴影的位置坐标和模糊距离要大一些*/
            }
        }
    

  .custom-icons-list :deep(.anticon) {
    margin-right: 6px;
  }
  .header-box {
    display: flex;
    box-shadow: 0 .25em 0.25em #bebdbd;
    margin-bottom: 0.3em;
    width: 100%;
  }


</style>