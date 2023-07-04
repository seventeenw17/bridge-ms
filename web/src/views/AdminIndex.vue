<template>
	<NavBar></NavBar>
	<div class="container">
		<div class="sider-box">
            <SiDer></SiDer>
		</div>
		<div class="content-box">
			<RouterView v-slot="{ Component }">
				<component :is="Component">
					<img src="../assets/imgs/jm.jpg"/>
				</component>
			</RouterView>
		</div>
	</div>
</template>
<script lang="ts">
import { UserOutlined, LaptopOutlined, NotificationOutlined } from '@ant-design/icons-vue';
import SiDer from '../components/SiDer.vue';
import NavBar from '../components/NavBar.vue';
import { defineComponent, ref } from 'vue';
export default defineComponent({
	components: {
		UserOutlined,
		SiDer,
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
    margin-left: 0%;
}

.sider-box {
	width: 15%;
}

.content-box {
	width: 85%;
	height: 90vh;
	padding: 1em;
	overflow: hidden auto;
	background-color: rgb(239, 238, 238);
    margin-right: 0%;
}
</style>
  