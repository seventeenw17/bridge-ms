<template>
  <div class="init-card">
    <a-button type="primary" @click="addInit">添加</a-button>
    <div class="card-container">
      <a-form layout="horizontal" class="card-form">
        <a-form-item>
           <table class="card-table">
            <tr>
              <td class="table-item-name">路线编号</td>
              <td class="table-item-content">
                <a-input
                  v-model:value="bridgeinfo.data.route_id"
                  placeholder="路线编号"
                  disabled
                />
              </td>
              <td class="table-item-name">路线名称</td>
              <td class="table-item-content">
                <a-input
                  v-model:value="route_name"
                  placeholder="路线名称"
                  disabled
                />
              </td>
            </tr> 
           <tr>
              <td class="table-item-name">桥梁编号</td>
              <td class="table-item-content">
                <a-input
                  v-model:value="bridgeinfo.data.bri_id"
                  placeholder="桥梁编号"
                  disabled
                />
              </td>
              <td class="table-item-name">桥梁名称</td>
              <td class="table-item-content">
                <a-input
                  v-model:value="bridgeinfo.data.bri_name"
                  placeholder="桥梁名称"
                  disabled
                />
              </td>
            </tr>
            <tr>
              <td class="table-item-name">桥梁全长(m)</td>
              <td class="table-item-content">
                <a-input
                  :value="techinfo.data.tech_length"
                  placeholder="桥梁全长(m)"
                />
              </td>
            </tr>
          </table>
        </a-form-item>
       <hr />
        <a-form-item>
          <table class="card-table"></table>
          <td class="table2-item-name">上、下部结构形式</td>
          <td class="table2-item-content">
            <a-textarea
              v-model:value="initinfo.data.record_ulform"
              placeholder="上、下部结构形式"
              
              :maxlength="200"
              style="margin: 1em auto 1em"
              :autosize="{ minRows: 4 }"
            />
          </td>
        </a-form-item>
        <hr />
        <a-form-item>
          <table class="card-table"></table>
          <td class="table2-item-name">桥梁分联及跨径组合</td>
          <td class="table2-item-content">
            <a-textarea
              v-model:value="initinfo.data.record_group"
              placeholder="桥梁分联及跨径组合"
              show-count
              :maxlength="200"
              allow-clear
              style="margin: 1em auto 1em"
              :autosize="{ minRows: 4 }"
            />
          </td>
        </a-form-item>
        <hr />
        <a-form-item>
          <table class="card-table"></table>
          <td class="table2-item-name">桥梁施工方法</td>
          <td class="table2-item-content">
            <a-textarea
              v-model:value="initinfo.data.record_method"
              placeholder="桥梁施工方法"
              :maxlength="200"
              allow-clear
              style="margin: 1em auto 1em"
              :autosize="{ minRows: 4 }"
            />
          </td>
        </a-form-item>
        <hr />
        <a-form-item>
          <table class="card-table"></table>
          <td class="table2-item-name">
            新建桥梁在施工过程中的返工、维修或加固情况
          </td>
          <td class="table2-item-content">
            <a-textarea
              v-model:value="initinfo.data.record_precase"
              placeholder="新建桥梁在施工过程中的返工、维修或加固情况"
              show-count
              :maxlength="200"
              allow-clear
              style="margin: 1em auto 1em"
              :autosize="{ minRows: 4 }"
            />
          </td>
        </a-form-item>
        <hr />
        <a-form-item>
          <table class="card-table"></table>
          <td class="table2-item-name">加固改造后的桥梁，加固改造情况</td>
          <td class="table2-item-content">
            <a-textarea
              v-model:value="initinfo.data.record_aftercase"
              placeholder="加固改造后的桥梁，加固改造情况"
              :maxlength="200"
              style="margin: 1em auto 1em"
              :autosize="{ minRows: 4 }"
            />
          </td>
        </a-form-item>
        <hr />
        <a-form-item>
          <table class="card-table"></table>
          <td class="table2-item-name">档案资料不齐全的桥梁，维修加固情况</td>
          <td class="table2-item-content">
            <a-textarea
              v-model:value="initinfo.data.record_incocase"
              placeholder="档案资料不齐全的桥梁，维修加固情况"
              show-count
              :maxlength="200"
              allow-clear
              style="margin: 1em auto 1em"
              :autosize="{ minRows: 4 }"
            />
          </td>
        </a-form-item>
        <hr />
        <a-form-item>
          <table class="card-table">
            <tr>
              <td class="table3-item-name">设计单位名称</td>
              <td class="table3-item-content">
                <a-input
                placeholder="设计单位"
                
                v-model:value="Unit.data.unit_design"
              />
              </td>
              <td class="table3-item-name">施工单位名称</td>
              <td class="table3-item-content">
                <a-input
                placeholder="施工单位"
                
                v-model:value="Unit.data.unit_build"
              />
              </td>
            </tr>
          </table>
        </a-form-item>
        <hr />
        <a-form-item>
          <table class="card-table">
            <tr>
              <td class="table3-item-name">管养单位名称</td>
              <td class="table3-item-content">
                <a-input
                placeholder="管养单位"
                disabled
                v-model:value="Unit.data.unit_care"
              />
              </td>
              <td class="table3-item-name">交工时间</td>
              <td class="table3-item-content">
                <a-date-picker
                  v-model:value="initinfo.data.record_fintime"
                  style="height: 2em; width: 100%"
                />
              </td>
            </tr>
          </table>
        </a-form-item>
        <hr />
        <a-form-item>
          <table class="card-table">
            <tr>
              <td class="table3-item-name">初始检查</td>
              <td class="table3-item-content">
                <a-date-picker
                  v-model:value="initinfo.data.record_firtime"
                  style="height: 2em; width: 100%"
                />
              </td>
              <td class="table3-item-name">初始检查时的气候及环境温度</td>
              <td class="table3-item-content">
                <a-input
                  v-model:value="initinfo.data.record_tem"
                  placeholder="初始检查时的气候及环境温度"
                />
              </td>
            </tr>
          </table>
        </a-form-item>
        <hr />
        <a-form-item>
          <tr>
            <td class="table2-item-name">桥面高程</td>
            <td class="table2-item-content">
              <a-input
                v-model:value="techinfo.data.tech_elevation"
                placeholder="桥面高程"
                style="height: 3em"
              />
            </td>
          </tr>
        </a-form-item>
        <hr />
        <a-form-item>
          <tr>
            <td class="table2-item-name">拱轴线</td>
            <td class="table2-item-content">
              <a-input
                v-model:value="initinfo.data.record_gzx"
                placeholder="拱轴线"
                style="height: 3em"
              />
            </td>
          </tr>
        </a-form-item>
        <hr />
        <a-form-item>
          <tr>
            <td class="table2-item-name">主缆线形</td>
            <td class="table2-item-content">
              <a-input
                v-model:value="initinfo.data.record_zlxx"
                placeholder="主缆线形"
                style="height: 3em"
              />
            </td>
          </tr>
        </a-form-item>
        <hr />
        <a-form-item>
          <tr>
            <td class="table2-item-name">墩、台身、锚碇的高程</td>
            <td class="table2-item-content">
              <a-input
                v-model:value="initinfo.data.record_dtmheight"
                placeholder="墩、台身、锚碇的高程"
                style="height: 3em"
              />
            </td>
          </tr>
        </a-form-item>
        <hr />
        <a-form-item>
          <tr>
            <td class="table2-item-name">墩、台身、索塔倾斜度</td>
            <td class="table2-item-content">
              <a-input
                v-model:value="initinfo.data.record_dtmlean"
                placeholder="墩、台身、索塔倾斜度"
                style="height: 3em"
              />
            </td>
          </tr>
        </a-form-item>
        <hr />
        <a-form-item>
          <tr>
            <td class="table2-item-name">索塔水平变位、高程</td>
            <td class="table2-item-content">
              <a-input
                v-model:value="initinfo.data.record_levheight"
                placeholder="索塔水平变位、高程"
                style="height: 3em"
              />
            </td>
          </tr>
        </a-form-item>
        <hr />
        <a-form-item>
          <tr>
            <td class="table2-item-name">拱桥桥台、悬索桥锚碇水平位移</td>
            <td class="table2-item-content">
              <a-input
                v-model:value="initinfo.data.record_hordis"
                placeholder="拱桥桥台、悬索桥锚碇水平位移"
                style="height: 3em"
              />
            </td>
          </tr>
        </a-form-item>
        <hr />
        <a-form-item>
          <tr>
            <td class="table2-item-name">悬索桥索夹螺栓紧固力</td>
            <td class="table2-item-content">
              <a-input
                v-model:value="initinfo.data.record_susbri"
                placeholder="悬索桥索夹螺栓紧固力"
                style="height: 3em"
              />
            </td>
          </tr>
        </a-form-item>
        <hr />
        <a-form-item>
          <tr>
            <td class="table2-item-name">水中基础</td>
            <td class="table2-item-content">
              <a-input
                v-model:value="initinfo.data.record_wbas"
                placeholder="水中基础"
                style="height: 3em"
              />
            </td>
          </tr>
        </a-form-item>
        <hr />
        <a-form-item>
          <tr>
            <td class="table2-item-name">斜拉索或吊杆索力</td>
            <td class="table2-item-content">
              <a-input
                v-model:value="initinfo.data.record_dgsl"
                placeholder="斜拉索或吊杆索力"
                style="height: 3em"
              />
            </td>
          </tr>
        </a-form-item>
        <hr />
        <a-form-item>
          <tr>
            <td class="table2-item-name">主要承重构建尺寸</td>
            <td class="table2-item-content">
              <a-input
                v-model:value="initinfo.data.record_gjsize"
                placeholder="主要承重构建尺寸"
                style="height: 3em"
              />
            </td>
          </tr>
        </a-form-item>
        <hr />
        <a-form-item>
          <tr>
            <td class="table2-item-name">材质强度</td>
            <td class="table2-item-content">
              <a-input
                v-model:value="initinfo.data.record_czqd"
                placeholder="材料强度"
                style="height: 3em"
              />
            </td>
          </tr>
        </a-form-item>
        <hr />
        <a-form-item>
          <tr>
            <td class="table2-item-name">保护层厚度</td>
            <td class="table2-item-content">
              <a-input
                v-model:value="initinfo.data.record_bhcgd"
                placeholder="保护层厚度"
                style="height: 3em"
              />
            </td>
          </tr>
        </a-form-item>
        <hr />
        <a-form-item>
          <tr>
            <td class="table2-item-name">钢管混凝土管内混凝土密实度</td>
            <td class="table2-item-content">
              <a-input
                v-model:value="initinfo.data.record_hntmsd"
                placeholder="钢管混凝土管内混凝土密实度"
                style="height: 3em"
              />
            </td>
          </tr>
        </a-form-item>
        <hr />
        <a-form-item>
          <table class="card-table"></table>
          <td class="table2-item-name">静载试验结果</td>
          <td class="table2-item-content">
            <a-textarea
              v-model:value="initinfo.data.record_stares"
              placeholder="静载试验结果"
              show-count
              :maxlength="200"
              allow-clear
              style="margin: 1em auto 1em"
              :autosize="{ minRows: 4 }"
            />
          </td>
        </a-form-item>
        <hr />
        <a-form-item>
          <table class="card-table"></table>
          <td class="table2-item-name">动载试验结果</td>
          <td class="table2-item-content">
            <a-textarea
              v-model:value="initinfo.data.record_dynres"
              placeholder="动载试验结果"
              show-count
              :maxlength="200"
              allow-clear
              style="margin: 1em auto 1em"
              :autosize="{ minRows: 4 }"
            />
          </td>
        </a-form-item>
        <hr />
        <a-form-item>
          <table class="card-table">
            <tr>
              <td class="table3-item-name">记录人</td>
              <td class="table3-item-content">
                <a-input
                  v-model:value="initinfo.data.record_notekeeper"
                  placeholder="记录人"
                  style="height: 3em"
                />
              </td>
            </tr>
          </table>
        </a-form-item>
      </a-form>
    </div>
  </div>
</template>

<script lang="ts">
import axios from 'axios';
import { useRoute } from 'vue-router';
import {reactive} from "vue";
export default defineComponent({
    setup(){
        const bridgeinfo = reactive({
          data: {
            bri_id: '',
            bri_name: '',
            route_id: '',
            bty_id: ''
          }
        })
        const techinfo = reactive({
          data:{
              bri_id: '',//桥梁编码
              tech_id: '', //桥梁技术指标编码
              tech_length: '', //桥梁全长
              tech_width: '', //桥梁总宽
              tech_carwidth: '', //车道宽度
              tech_peowidth: '', //人行道宽度
              tech_barheight: '', //护栏或防护墙高度
              tech_divwidth: '', //中央分割带宽度
              tech_staclear: '', //桥面标准净空
              tech_reaclear: '', //桥面实际净空
              tech_scleargrade: '', //桥下通航等级及标准净空
              tech_dreaclear: '', //桥下实际净空
              tech_apwidth: '', //引道总宽
              tech_floodfrelev: '', //设计洪水频率及其水位
              tech_curradius: '', //引道线形或曲率半径
              tech_floodlev: '', //历史洪水位
              tech_eaqua: '', //地震峰值加速度系数
              tech_elevation: '' //桥面高程
          }
        })
        const initinfo = reactive({
          data:{
            bri_id: '', //桥梁编码
            record_id: '', //初始卡片编号
            record_ulform: '', //上下部结构形式
            record_group: '', //桥梁分联及跨径组合
            record_method: '', //桥梁施工方法F
            record_precase: '', //新建桥梁在施工过程的返工维修或加固情况
            record_aftercase: '',//加固改造后的桥梁改造加固后的情况
            record_incocase: '', //档案资料不齐全的桥梁维护加固情况
            record_fintime: '', //交工时间
            record_firtime: '', //初始检查时间
            record_tem: '', //初始检查时的气候及环境温度
            record_height: '', //桥面高程
            record_gzx: '', //拱轴线
            record_zlxx: '', //主缆线形
            record_dtmheight: '', //墩台身锚碇高程
            record_dtmlean: '', //墩台身锚碇倾斜度
            record_levheight: '', //索塔水平变位高程
            record_hordis: '', //拱桥桥台悬索桥锚碇水平位移
            record_susbri: '', //悬索桥索夹螺栓紧固力
            record_wbas: '', //水中基础
            record_dgsl: '', //吊杆索力
            record_gjsize: '', //主要承重构件尺寸
            record_czqd: '', //材质强度
            record_bhcgd: '', //保护层高度
            record_hntmsd: '', //钢管混凝土管内混凝土密实度
            record_stares: '', //静载试验结果
            record_dynres: '',//动载试验结果
            record_notekeeper: '' //记录人
          }
          
        })

        const Unit = reactive({
            data: {
              unit_design: '', // 设计单位
              unit_build: '', // 施工单位
              unit_superv: '', // 监理单位
              unit_owner: '', // 业主单位
              unit_care: '', // 管养单位
            }
          })

        const Cop = reactive({
          arr: [{
            units_id: '',
            AIdata_id: '',
            unit_duty: '',
          }]
        })
        const route = useRoute();
        const bridge_id = route.query.bridgeid;
        const route_name = route.query.bridgeid;
        const getInit = () => {
            axios({
                url: 'http://localhost:3000/api/init/get/init',
                method: 'GET',
                params:{
                    bri_id:bridge_id
                }
            }).then((resp) => {
                initinfo.data=resp.data;
            })
        }
        getInit();
        const getTech = () => {
            axios({
                url: 'http://localhost:3000/api/init/get/tech',
                method: 'GET',
                params:{
                    bri_id:bridge_id
                }
            }).then((resp) => {
                techinfo.data=resp.data;
            })
        }
        getTech();
        const getBridge = () => {
            axios({
                url: 'http://localhost:3000/api/init/get/bridge',
                method: 'GET',
                params:{
                    bri_id: bridge_id
                }
            }).then((resp) => {
              bridgeinfo.data=resp.data;
            })
        }
        getBridge()

        const insertInit = () => {

          console.log(initinfo)
            axios({
                url: 'http://localhost:3000/api/init/insert/init',
                method: 'POST',
                params:{
                    bri_id: bridge_id,
                    record_id:bridge_id,
                    record_ulform:initinfo.data.record_ulform,
                    record_group:initinfo.data.record_group,
                    record_method:initinfo.data.record_method,
                    record_precase:initinfo.data.record_precase,
                    record_aftercase:initinfo.data.record_aftercase,
                    record_incocase:initinfo.data.record_incocase,
                    record_fintime:initinfo.data.record_fintime,
                    record_firtime:initinfo.data.record_firtime,
                    record_tem:initinfo.data.record_tem,
                    record_height:initinfo.data.record_height,
                    record_gzx:initinfo.data.record_gzx,
                    record_zlxx:initinfo.data.record_zlxx,
                    record_dtmheight:initinfo.data.record_dtmheight,
                    record_dtmlean:initinfo.data.record_dtmlean,
                    record_levheight:initinfo.data.record_levheight,
                    record_hordis:initinfo.data.record_hordis,
                    record_susbri:initinfo.data.record_susbri,
                    record_wbas:initinfo.data.record_wbas,
                    record_dgsl:initinfo.data.record_dgsl,
                    record_gjsize:initinfo.data.record_gjsize,
                    record_czqd:initinfo.data.record_czqd,
                    record_bhcgd:initinfo.data.record_bhcgd,
                    record_hntmsd:initinfo.data.record_hntmsd,
                    record_stares:initinfo.data.record_stares,
                    record_dynres:initinfo.data.record_dynres,
                    record_notekeeper:initinfo.data.record_notekeeper,
                }
            }).then(() => {
                console.log("init添加完成")
            })
        }
        const insertTech = () => {

            axios({
                url: 'http://localhost:3000/api/init/insert/tech',
                method:'POST',
                params:{
                    bri_id: bridge_id,
                    tech_id: bridge_id,
                    tech_length: techinfo.data.tech_length,
                    tech_width: techinfo.data.tech_width,
                    tech_carwidth: techinfo.data.tech_carwidth,
                    tech_peowidth: techinfo.data.tech_peowidth,
                    tech_barheight: techinfo.data.tech_barheight,
                    tech_divwidth: techinfo.data.tech_divwidth,
                    tech_staclear: techinfo.data.tech_staclear,
                    tech_reaclear: techinfo.data.tech_reaclear,
                    tech_scleargrade:techinfo.data.tech_scleargrade,
                    tech_dreaclear: techinfo.data.tech_dreaclear,
                    tech_apwidth: techinfo.data.tech_apwidth,
                    tech_floodfrelev:techinfo.data.tech_floodfrelev,
                    tech_curradius:techinfo.data.tech_curradius,
                    tech_floodlev:techinfo.data.tech_floodlev,
                    tech_eaqua:techinfo.data.tech_eaqua,
                    tech_elevation:techinfo.data.tech_elevation
                }
            }).then(()=>{
                console.log("Tech添加完成")
            })
        }

        const addInit = () => {
           console.log("asdasd")
           insertInit()
        }

        const getCo = () => {
          axios({
            url: 'http://localhost:3000/api/basic/get/co',
            method: 'GET',
            params: {
              AIdata_id: bridge_id
            }
          }).then((resp) => {
            Cop.arr=resp.data;
            Unit.data.unit_design = Cop.arr[0].units_id;
            Unit.data.unit_build = Cop.arr[1].units_id;
            Unit.data.unit_superv = Cop.arr[2].units_id;
            Unit.data.unit_owner = Cop.arr[3].units_id;
            Unit.data.unit_care = Cop.arr[4].units_id;
          })
        }
        getCo();
        return {
            bridgeinfo,
            techinfo,
            initinfo,
            route_name,
            Unit,
            Cop,
            addInit,
            getBridge,
            getInit,
            getTech
        }
    }
})
</script>

<style scoped>

.card-container {
  overflow: hidden auto;
  width: 65%;
}


.card-form {
  padding: 1em;
  border-radius: 0.3em;
  background-color: #fff;
  box-shadow: none;
}

.ant-form-item {
  margin: 0.7em;
}

.card-table {
  border-collapse: separate;
  border-spacing: 0.5em 0.5em;
  text-align: center;
  width: 100%;
}

.table-item-name {
  width: 10%;
}

.table-item-content {
  width: 20%;
}

.table2-item-name {
  display: table-cell;
  vertical-align: middle;
  width: 10vw;
}

.table2-item-content {
  width: 70vw;
}

.table3-item-name {
  width: 15%;
}

.table3-item-content {
  width: 30%;
}



</style>
