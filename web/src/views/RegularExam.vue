<template>
    <div class="init-card">
        <!-- <div class="header-tips">
            你当前正在编写编号为{{ $route.query.bridge_no }}的桥梁初始检查记录表
        </div> -->
            <div class="card-container">
                <a-form layout="horizontal" class="card-form">
                    <hr>
                    <!-- <a-form-item>
                        <table class="card-table">
                            <tr>
                                <td class="table-item-name" style="width: 15%">公路管理机构名称</td>
                                <td class="table-item-content">
                                    <a-input v-model:value=userStore.unit_name disabled placeholder="公路管理机构名称" />
                                </td>
                            </tr>
                        </table>
                    </a-form-item> -->
                    <hr>
                    <a-form-item>
                        <table class="card-table">
                            <tr>
                                <td class="table-item-name">路线编号</td>
                                <td class="table-item-content">
                                    <a-input v-model:value=routeinfo.data.route_id placeholder="路线编号" disabled />
                                </td>
                                <td class="table-item-name">路线名称</td>
                                <td class="table-item-content">
                                    <a-input v-model:value=routeinfo.data.route_name placeholder="路线名称" disabled />
                                </td>
                            </tr>
                            <tr>
                                <td class="table-item-name">桥梁编号</td>
                                <td class="table-item-content">
                                    <a-input v-model:value=$route.query.bridgeid placeholder="桥梁编号" disabled :maxlength="20"/>
                                </td>
                                <td class="table-item-name">桥梁名称</td>
                                <td class="table-item-content">
                                    <a-input v-model:value=bridgeinfo.data.bri_name placeholder="桥梁名称" disabled />
                                </td>
                            </tr>
                            <tr>
                                <td class="table-item-name">桥梁全长(m)</td>
                                <td class="table-item-content">
                                    <a-input-number 
                                    v-model:value=techindexinfo.data.tech_length
                                    placeholder="桥梁全长(m)" 
                                    :min="0" 
                                    :max="999999.99" 
                                    style="width: 100%;"
                                    />
                                </td>
                            </tr>
                        </table>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <table class="card-table"></table>
                        <td class="table2-item-name">上、下部结构形式</td>
                        <td class="table2-item-content">
                            <a-textarea v-model:value=initinfo.data.record_ulform placeholder="上、下部结构形式" show-count :maxlength="200"
                                allow-clear style="margin: 1em auto 1em;" :autosize="{ minRows: 4 }" />
                        </td>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <table class="card-table"></table>
                        <td class="table2-item-name">桥梁分联及跨径组合</td>
                        <td class="table2-item-content">
                            <a-textarea v-model:value=initinfo.data.record_group placeholder="桥梁分联及跨径组合" show-count
                                :maxlength="200" allow-clear style="margin: 1em auto 1em;" :autosize="{ minRows: 4 }" />
                        </td>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <table class="card-table"></table>
                        <td class="table2-item-name">桥梁施工方法</td>
                        <td class="table2-item-content">
                            <a-textarea v-model:value=initinfo.data.record_method placeholder="桥梁施工方法" show-count :maxlength="200"
                                allow-clear style="margin: 1em auto 1em;" :autosize="{ minRows: 4 }" />
                        </td>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <table class="card-table"></table>
                        <td class="table2-item-name">新建桥梁在施工过程中的返工、维修或加固情况</td>
                        <td class="table2-item-content">
                            <a-textarea v-model:value=initinfo.data.record_precase placeholder="新建桥梁在施工过程中的返工、维修或加固情况" show-count
                                :maxlength="200" allow-clear style="margin: 1em auto 1em;" :autosize="{ minRows: 4 }" />
                        </td>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <table class="card-table"></table>
                        <td class="table2-item-name">加固改造后的桥梁，加固改造情况</td>
                        <td class="table2-item-content">
                            <a-textarea v-model:value=initinfo.data.record_aftercase placeholder="加固改造后的桥梁，加固改造情况" show-count
                                :maxlength="200" allow-clear style="margin: 1em auto 1em;" :autosize="{ minRows: 4 }" />
                        </td>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <table class="card-table"></table>
                        <td class="table2-item-name">档案资料不齐全的桥梁，维修加固情况</td>
                        <td class="table2-item-content">
                            <a-textarea v-model:value=initinfo.data.record_incocase placeholder="档案资料不齐全的桥梁，维修加固情况" show-count
                                :maxlength="200" allow-clear style="margin: 1em auto 1em;" :autosize="{ minRows: 4 }" />
                        </td>
                    </a-form-item>
                    <hr>
                    <!-- <a-form-item>
                        <table class="card-table">
                            <tr>
                                <td class="table3-item-name">设计单位名称</td>
                                <td class="table3-item-content">
                                    <a-select v-model:value=cardInfo.unit.design_unit :options="units" style="height: 2em;"></a-select>
                                </td>
                                <td class="table3-item-name">施工单位名称</td>
                                <td class="table3-item-content">
                                    <a-select v-model:value=cardInfo.unit.construction_unit :options="units"
                                        style="height: 2em;"></a-select>
                                </td>
                            </tr>
                        </table>
                    </a-form-item> -->
                    <hr>
                    <!-- <a-form-item>
                        <table class="card-table">
                            <tr>
                                <td class="table3-item-name">管养单位名称</td>
                                <td class="table3-item-content">
                                    <a-select v-model:value=cardInfo.unit.custody_unit :options="units" disabled style="height: 2em;"></a-select>
                                </td>
                                <td class="table3-item-name">交工时间</td>
                                <td class="table3-item-content">
                                    <a-date-picker 
                                        v-model:value=cardInfo.arr.del_time 
                                        style="height: 2em; width: 100%;" 
                                        value-format="YYYY-MM-DD"
                                        format="YYYY-MM-DD"
                                        :locale="locale"
                                        placeholder="交工时间"
                                    />
                                </td>
                            </tr>
                        </table>
                    </a-form-item> -->
                    <hr>
                    <a-form-item>
                        <table class="card-table">
                            <tr>
                                <td class="table3-item-name">初始检查时间</td>
                                <td class="table3-item-content">
                                    <a-date-picker
                                        v-model:value=initinfo.data.record_firtime
                                        style="height: 2em; width: 100%;"
                                        value-format="YYYY-MM-DD"
                                        format="YYYY-MM-DD"
                                        placeholder="初始检查时间"
                                        />
                                </td>
                                <td class="table3-item-name">初始检查时的气候及环境温度</td>
                                <td class="table3-item-content">
                                    <a-input v-model:value=initinfo.data.record_tem placeholder="初始检查时的气候及环境温度" />
                                </td>
                            </tr>
                        </table>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <tr>
                            <td class="table2-item-name">桥面高程</td>
                            <td class="table2-item-content">
                                <a-input v-model:value=initinfo.data.record_height placeholder="桥面高程" style="height: 3em;" :maxlength="100"/>
                            </td>
                        </tr>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <tr>
                            <td class="table2-item-name">拱轴线</td>
                            <td class="table2-item-content">
                                <a-input v-model:value=initinfo.data.record_gzx placeholder="拱轴线" style="height: 3em;" :maxlength="100"/>
                            </td>
                        </tr>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <tr>
                            <td class="table2-item-name">主缆线形</td>
                            <td class="table2-item-content">
                                <a-input v-model:value=initinfo.data.record_zlxx placeholder="主缆线形" style="height: 3em;" :maxlength="100"/>
                            </td>
                        </tr>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <tr>
                            <td class="table2-item-name">墩、台身、锚碇的高程</td>
                            <td class="table2-item-content">
                                <a-input v-model:value=initinfo.data.record_dtmheight placeholder="墩、台身、锚碇的高程" style="height: 3em;" :maxlength="100"/>
                            </td>
                        </tr>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <tr>
                            <td class="table2-item-name">墩、台身、索塔倾斜度</td>
                            <td class="table2-item-content">
                                <a-input v-model:value=initinfo.data.record_dtmlean placeholder="墩、台身、索塔倾斜度" style="height: 3em;" :maxlength="100"/>
                            </td>
                        </tr>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <tr>
                            <td class="table2-item-name">索塔水平变位、高程</td>
                            <td class="table2-item-content">
                                <a-input v-model:value=initinfo.data.record_levheight placeholder="索塔水平变位、高程" style="height: 3em;" :maxlength="100"/>
                            </td>
                        </tr>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <tr>
                            <td class="table2-item-name">拱桥桥台、悬索桥锚碇水平位移</td>
                            <td class="table2-item-content">
                                <a-input v-model:value=initinfo.data.record_hordis placeholder="拱桥桥台、悬索桥锚碇水平位移"
                                    style="height: 3em;" :maxlength="100"/>
                            </td>
                        </tr>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <tr>
                            <td class="table2-item-name">悬索桥索夹螺栓紧固力</td>
                            <td class="table2-item-content">
                                <a-input v-model:value=initinfo.data.record_susbri placeholder="悬索桥索夹螺栓紧固力" style="height: 3em;" :maxlength="100"/>
                            </td>
                        </tr>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <tr>
                            <td class="table2-item-name">水中基础</td>
                            <td class="table2-item-content">
                                <a-input v-model:value=initinfo.data.record_wbas placeholder="水中基础" style="height: 3em;" :maxlength="100"/>
                            </td>
                        </tr>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <tr>
                            <td class="table2-item-name">斜拉索或吊杆索力</td>
                            <td class="table2-item-content">
                                <a-input v-model:value=initinfo.data.record_dgsl placeholder="斜拉索或吊杆索力" style="height: 3em;" :maxlength="100"/>
                            </td>
                        </tr>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <tr>
                            <td class="table2-item-name">主要承重构建尺寸</td>
                            <td class="table2-item-content">
                                <a-input v-model:value=initinfo.data.record_gjsize placeholder="主要承重构建尺寸" style="height: 3em;" :maxlength="100"/>
                            </td>
                        </tr>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <tr>
                            <td class="table2-item-name">材料强度</td>
                            <td class="table2-item-content">
                                <a-input v-model:value=initinfo.data.record_czqd placeholder="材料强度" style="height: 3em;" :maxlength="100"/>
                            </td>
                        </tr>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <tr>
                            <td class="table2-item-name">保护层厚度</td>
                            <td class="table2-item-content">
                                <a-input v-model:value=initinfo.data.record_bhcgd placeholder="保护层厚度" style="height: 3em;" :maxlength="100"/>
                            </td>
                        </tr>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <tr>
                            <td class="table2-item-name">钢管混凝土管内混凝土密实度</td>
                            <td class="table2-item-content">
                                <a-input v-model:value=initinfo.data.record_hntmsd placeholder="钢管混凝土管内混凝土密实度" style="height: 3em;" :maxlength="100"/>
                            </td>
                        </tr>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <table class="card-table"></table>
                        <td class="table2-item-name">静载试验结果</td>
                        <td class="table2-item-content">
                            <a-textarea v-model:value=initinfo.data.record_stares placeholder="静载试验结果" show-count :maxlength="200"
                                allow-clear style="margin: 1em auto 1em;" :autosize="{ minRows: 4 }" />
                        </td>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <table class="card-table"></table>
                        <td class="table2-item-name">动载试验结果</td>
                        <td class="table2-item-content">
                            <a-textarea v-model:value=initinfo.data.record_dynres placeholder="动载试验结果" show-count :maxlength="200"
                                allow-clear style="margin: 1em auto 1em;" :autosize="{ minRows: 4 }" />
                        </td>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <table class="card-table">
                            <tr>
                                <td class="table3-item-name">记录人</td>
                                <td class="table3-item-content">
                                    <a-input v-model:value=initinfo.data.record_notekeeper placeholder="记录人" style="height: 3em;" :maxlength="100"/>
                                </td>
                            </tr>
                        </table>
                    </a-form-item>
                </a-form>
            </div>
        <!-- <div class="footer-bar" v-if="!loading">
            <a-button type="primary" style="margin-bottom: 1em" @click="submitData" :disabled="$route.query.status === 'finish'">
                <template #icon>
                    <CloudUploadOutlined />
                </template>
            </a-button>
            <a-button type="primary" @click="$router.back()">
                <template #icon>
                    <ArrowLeftOutlined />
                </template>
            </a-button>
        </div> -->
    </div>
</template>

<script lang="ts">
import axios from 'axios';
import { defineComponent, reactive} from 'vue';
import { CloudUploadOutlined, ArrowLeftOutlined } from '@ant-design/icons-vue'
import { useRoute } from "vue-router";
// import locale from "ant-design-vue/lib/time-picker/locale/zh_CN";

export default defineComponent({
    components: {
        CloudUploadOutlined,
        ArrowLeftOutlined,
    },
    setup() {
        const route = useRoute();
        const bridge_id = route.query.bridgeid;
        const routeinfo = reactive({
            data:{
                route_id: '',//路线编号
                route_name: '',//路线名称
                route_grade: '' //路线等级
            }
        })
        const bridgeinfo = reactive({
            data: {
                bri_id: '',
                bri_name: '',
                route_id: '',
                bty_id: ''
            }
        })
        const techindexinfo = reactive({
            data:{
                bri_id:'', //桥梁编码
                tech_id:'', //桥梁技术指标编码
                tech_length:'', //桥梁全长
                tech_width:'', //桥梁总宽
                tech_carwidth:'',//车道宽度
                tech_peowidth:'',//人行道宽度
                tech_barheight:'', //护栏或防护墙高度
                tech_divwidth:'',//中央分割带宽度
                tech_staclear:'', //桥面标准净空
                tech_reaclear:'',//桥面实际净空
                tech_scleargrade:'', //桥下通航等级及标准净空
                tech_dreaclear:'',//桥下实际净空
                tech_apwidth:'',//引道总宽
                tech_floodfrelev:'', //设计洪水频率及其水位
                tech_curradius:'', //引道线形或曲率半径
                tech_floodlev:'', //历史洪水位
                tech_eaqua:'', //地震峰值加速度系数
                tech_elevation:'' //桥面高程
            }
        })
        const rechcardinfo = reactive({
            data:{
                bri_id:'', // 桥梁编号
                rech_nowtime:'', //本次检查时间
                rech_latime:'', //上次检查时间
                rech_tem:'',//本次检查气候
                rech_grade:'',//桥梁技术状况评级
                rech_clzk:'', //桥梁清洁状况
                rech_xfyhzk:'',//预防及修复养护状况
                rech_notekeeper:'', //记录人
                rech_prinpeo:'', //负责人
                rech_netime:'' //下次检查时间
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
        const getInit = () => {
            axios({
                url: 'http://localhost:3000/api/rech/get/init',
                method: 'GET',
                params:{
                    bri_id:bridge_id
                }
            }).then((resp) => {
                console.log(resp);
                initinfo.data=resp.data;
            })
        }
        getInit();
        const getRoute = () => {
            axios({
                url: 'http://localhost:3000/api/rech/get/route',
                method: 'GET',
                params:{
                    bri_id:bridge_id
                }
            }).then((resp) => {
                // alert("获取路线")
                routeinfo.data=resp.data;
            })
        }
        getRoute();
        const getBridge = () => {
            axios({
                url: 'http://localhost:3000/api/rech/get/bridge',
                method: 'GET',
                params:{
                    bri_id: bridge_id
                }
            }).then((resp) => {
              // alert("获取桥梁信息")
              bridgeinfo.data=resp.data;
            })
        }
        getBridge()
        const getTechIndex = () => {
            axios({
                url: 'http://localhost:3000/api/rech/get/tech',
                method: 'GET',
                params:{
                    bri_id:bridge_id
                }
            }).then((resp) => {
              // alert("获取tech")
                techindexinfo.data=resp.data;
            })
        }
        const insertInit = () => {
            axios({
                url: 'http://localhost:3000/api/rech/insert/init',
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
        const insertTechIndex = () => {
            axios({
                url: 'http://localhost:3000/api/rech/insert/tech',
                method:'POST',
                params:{
                    bri_id: bridge_id,
                    tech_id: bridge_id,
                    tech_length: techindexinfo.data.tech_length,
                    tech_width: techindexinfo.data.tech_width,
                    tech_carwidth: techindexinfo.data.tech_carwidth,
                    tech_peowidth: techindexinfo.data.tech_peowidth,
                    tech_barheight: techindexinfo.data.tech_barheight,
                    tech_divwidth: techindexinfo.data.tech_divwidth,
                    tech_staclear: techindexinfo.data.tech_staclear,
                    tech_reaclear: techindexinfo.data.tech_reaclear,
                    tech_scleargrade:techindexinfo.data.tech_scleargrade,
                    tech_dreaclear: techindexinfo.data.tech_dreaclear,
                    tech_apwidth: techindexinfo.data.tech_apwidth,
                    tech_floodfrelev:techindexinfo.data.tech_floodfrelev,
                    tech_curradius:techindexinfo.data.tech_curradius,
                    tech_floodlev:techindexinfo.data.tech_floodlev,
                    tech_eaqua:techindexinfo.data.tech_eaqua,
                    tech_elevation:techindexinfo.data.tech_elevation
                }
            }).then(()=>{
                console.log("Techindex添加完成")
            })
        }
        getTechIndex();
        return {
            bridge_id,
            routeinfo,
            bridgeinfo,
            techindexinfo,
            rechcardinfo,
            initinfo,
            getInit,
            getBridge,
            getTechIndex,
            insertInit,
            insertTechIndex,
            getRoute
        }
    }
})

</script>

<style scoped>
.card-container {
    overflow: hidden auto;
    width: 95%;
}

.header-tips {
    position: sticky;
    top: -1em;
    z-index: 2;
    height: 2em;
    margin-bottom: 1em;
    width: 95%;
    background-color: #7ac0fc;
    font-size: 1.2em;
    text-align: center;
    line-height: 2em;
}

.footer-bar {
    position: absolute;
    display: flex;
    flex-direction: column;
    top: 100px;
    right: 2%;
}

.card-form {
    padding: 1em;
    border-radius: .3em;
    background-color: #FFF;
    box-shadow: none;
}

.ant-form-item {
    margin: .7em;
}

.card-table {
    border-collapse: separate;
    border-spacing: .5em .5em;
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

hr {
    margin: 0;
}
</style>