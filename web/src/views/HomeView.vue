<template>
  <div class="btn-box">
    <el-button type="primary" @click="addBri">添加桥梁</el-button>
  </div>  
  <el-row :gutter="20">
    <el-col :span="6" v-for="item in briInfo">
      <el-card :body-style="{ padding: '0px' }" >
        <img
          :src="item.url"
          class="image"
        />
        <div style="padding: 14px">
           <span style="font-size: 150%">{{ item.name }}</span>
          <div class="bottom">
            <!-- <time class="time">{{ currentDate }}</time> -->
            <div class="btn-look">
              <el-button type="primary" @click="lookfor1(item.no)">基本信息</el-button>
              <el-button type="primary" @click="lookfor2(item.no)">初始检查</el-button>
              <el-button type="primary" @click="lookfor3(item.no)">检测记录</el-button>
            </div> 
          </div>
        </div>
      </el-card>
    </el-col>
  </el-row>
  <el-dialog title="添加" v-model="editVisible1" width="30%">
    <el-form label-width="70px">
      <el-form-item label="桥梁编号">
        <el-input v-model="form.bri_id"></el-input>
      </el-form-item>
      <el-form-item label="桥梁名称">
        <el-input v-model="form.bri_name"></el-input>
      </el-form-item>
      <el-form-item label="桥梁类型">
        <el-input v-model="form.bty_id"></el-input>
      </el-form-item>
      <el-form-item label="所在路线">
        <el-input v-model="form.route_id"></el-input>
      </el-form-item>
    </el-form>
    <template #footer>
				<span class="dialog-footer">
					<el-button type="primary" @click="addyes">确 定</el-button>
          <el-button @click="editVisible1 = false">取 消</el-button>
				</span>
    </template>
  </el-dialog>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
import axios from 'axios';
import router from '../router';
// const currentDate = ref(new Date())

const editVisible1 = ref(false)

let form = reactive({
  bri_id: '',
  bri_name: '',
  route_id: '',
  bty_id: ''
});

interface Bri {
  no: string
  name: string
  url: string
}

const lookfor1 = (id: string) => {
  router.push({name: 'basicinfo' ,query:{ bridgeid: id}})
}
const lookfor2 = (id: string) => {
  router.push({name: 'initexam' ,query:{ bridgeid: id}})
}
const lookfor3 = (id: string) => {
  router.push({name: 'regularexam' ,query:{ bridgeid: id}})
}

const addBri = () => {
  form.bri_id = '',
  form.bri_name = '',
  form.route_id = '',
  form.bty_id = ''
  editVisible1.value = true;
};

let briInfo = ref<Bri []> ([])

const getBriInfo = () => {
  axios({
    url:"http://127.0.0.1:3000/api/bridge/getBri",
    method:"GET",
  }).then((resp) => {
    briInfo.value = resp.data;
  }).catch((resp) =>{
    console.log(resp);
  })
}
getBriInfo();

const freshPage = () => {
  getBriInfo();
}

interface bType {
  bty_id: string,
  bty_name: string
}

let briTypes = ref<bType []> ([])

const getBriType = () => {
  axios({
    url:"http://127.0.0.1:3000/api/bridge/getbty",
    method:"GET",
  }).then((resp) => {
    briTypes.value = resp.data;
  }).catch((resp) =>{
    console.log(resp);
  })
} 
getBriType();

const addyes = () => {
  editVisible1.value = false;
  axios({
    url:"http://127.0.0.1:3000/api/bridge/insertOne",
    method:"POST",
    params:{
      bri_id: form.bri_id,
      bty_id: form.bty_id,
      route_id: form.route_id,
      bri_name: form.bri_name
    }
  }).then(() => {
      freshPage();
      ElMessage.success('添加成功');
      getBriInfo();
  })
};
</script>

<style scoped>
.image{
  padding: 30px 0;
  text-align: center;
  border-right: solid 1px var(--el-border-color);
  display: inline-block;
  height: 40vh;
  width: 100%;
  box-sizing: border-box;
  vertical-align: top;
}
.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
.btn-box {
  width: 100%;
  display: flex;
  flex-direction: row-reverse;
  margin-bottom: 1EM;
}
.flexbox {
  display: flex;
  align-items: center;
}

.btn-look {
  width: 100%;
  display: flex;
  margin-top: 1EM;
}
</style>
   