<template>
  <!-- <el-button @click="jjj">jjjjjjj</el-button> -->
  <div class="basic-card-container">
    <a-form layout="horizontal" class="basic-card-form">
      <h3>行政识别数据</h3>
      <hr>
      <a-form-item>
        <table class="basic-card-table">
          <tr>
            <td class="table-item-name">路线编号</td>
            <td class="table-item-content">
              <a-input placeholder="路线编号" disabled v-model:value="Bridge.data.route_id" />
            </td>
            <td class="table-item-name">路线名称</td>
            <td class="table-item-content">
              <a-input placeholder="路线编号" disabled v-model:value="Routes.data.route_name" />
            </td>
            <td class="table-item-name">路线等级</td>
            <td class="table-item-content">
              <a-input placeholder="路线编号" disabled v-model:value="Routes.data.route_grade" />
            </td>
          </tr>
          <tr>
            <td class="table-item-name">桥梁编号</td>
            <td class="table-item-content">
              <a-input placeholder="桥梁编号" disabled v-model:value="Bridge.data.bri_id" />
            </td>
            <td class="table-item-name">桥梁名称</td>
            <td class="table-item-content">
              <a-input placeholder="桥梁名称" disabled v-model:value="Bridge.data.bri_name" />
            </td>
          </tr>
          <tr>
            <td class="table-item-name">功能类型</td>
            <td class="table-item-content">
              <a-input placeholder="功能类型" disabled v-model:value="AiData.data.AIdata_funtype"  />
            </td>
          </tr>
          <tr>
            <td class="table-item-name">设计载荷</td>
            <td class="table-item-content">
              <a-input 
                placeholder="设计载荷" 
                disabled 
                v-model:value="AiData.data.AIdata_load" 
                suffix="T"
              />
            </td>
            <td class="table-item-name">桥梁坡度</td>
            <td class="table-item-content">
              <a-input  
                class="input-item-default"  
                disabled 
                pattern="[0-9]*" 
                placeholder="桥梁坡度" 
                v-model:value="AiData.data.AIdata_radius" 
                suffix="°"
              />
            </td>
            <td class="table-item-name">桥梁平曲线半径</td>
            <td class="table-item-content">
              <a-input 
                class="input-item-default"  
                disabled 
                pattern="[0-9]*" 
                placeholder="桥梁平曲线半径" 
                v-model:value="AiData.data.AIdata_radius" suffix="m"
              />
            </td>
          </tr>
          <tr>
            <td class="table-item-name">建成时间</td>
            <td class="table-item-content">
              <a-input
                placeholder="建成时间"
                disabled 
                v-model:value="AiData.data.AIdata_fintime"
              />
            </td>
            <td class="table-item-name">设计单位</td>
            <td class="table-item-content">
              <a-input
                placeholder="设计单位"
                disabled
                v-model:value="Unit.data.unit_design"
              />
            </td>
            <td class="table-item-name">施工单位</td>
            <td class="table-item-content">
              <a-input
                placeholder="施工单位"
                disabled
                v-model:value="Unit.data.unit_build"
              />
            </td>
          </tr>
          <tr>
            <td class="table-item-name">监理单位</td>
            <td class="table-item-content">
              <a-input
                placeholder="监理单位"
                disabled 
                v-model:value="Unit.data.unit_superv"
              ></a-input>
            </td>
            <td class="table-item-name">业主单位</td>
            <td class="table-item-content">
              <a-input
                placeholder="业主单位"
                disabled 
                v-model:value="Unit.data.unit_owner"
              ></a-input>
            </td>
            <td class="table-item-name">管养单位</td>
            <td class="table-item-content">
              <a-input 
                placeholder="管养单位" 
                disabled 
                v-model:value="Unit.data.unit_care" 
              />
            </td>
          </tr>
        </table>
      </a-form-item>
      <h3>桥梁技术指标</h3>
      <hr>
      <a-form-item>
        <table class="basic-card-table">
          <tr>
            <td class="table-item-name">桥梁全长</td>
            <td class="table-item-content">
              <a-input
                  class="input-item-default"
                  placeholder="桥梁全长"
                  disabled
                  v-model:value="TechIndex.data.tech_length"
                  suffix="M"
              />
            </td>
            <td class="table-item-name">桥面总宽</td>
            <td class="table-item-content">
              <a-input 
                class="input-item-default" 
                disabled 
                placeholder="桥面总宽" 
                v-model:value="TechIndex.data.tech_width" 
                suffix="M"
              />
            </td>
            <td class="table-item-name">车道宽度</td>
            <td class="table-item-content">
              <a-input 
                class="input-item-default" 
                disabled placeholder="车道宽度" 
                v-model:value="TechIndex.data.tech_carwidth" 
                suffix="M"
              />
            </td>
          </tr>
          <tr>
            <td class="table-item-name">人行道宽度</td>
            <td class="table-item-content">
              <a-input 
                class="input-item-default" 
                disabled 
                placeholder="人行道宽度" 
                v-model:value="TechIndex.data.tech_peowidth" 
                suffix="M"
              />
            </td>
            <td class="table-item-name">护栏或防撞墙高度</td>
            <td class="table-item-content">
              <a-input
                class="input-item-default"  
                disabled 
                placeholder="护栏或防撞墙高度" 
                v-model:value="TechIndex.data.tech_barheight" 
                suffix="M"
              />
            </td>
            <td class="table-item-name">中央分隔带高度</td>
            <td class="table-item-content">
              <a-input 
                class="input-item-default" 
                disabled 
                placeholder="中央分隔带高度" 
                v-model:value="TechIndex.data.tech_divwidth" 
                suffix="M"
              />
            </td>
          </tr>
          <tr>
            <td class="table-item-name">桥面标准净空</td>
            <td class="table-item-content">
              <a-input 
                class="input-item-default" 
                disabled 
                placeholder="桥面标准净空" 
                v-model:value="TechIndex.data.tech_staclear" 
                suffix="M"
              />
            </td>
            <td class="table-item-name">桥面实际净空</td>
            <td class="table-item-content">
              <a-input  
                class="input-item-default" 
                disabled 
                placeholder="桥面实际净空" 
                v-model:value="TechIndex.data.tech_reaclear" 
                suffix="M"
              />
            </td>
            <td class="table-item-name">桥下通航等级及标准净空</td>
            <td class="table-item-content">
              <a-input
                class="input-item-default" 
                disabled 
                placeholder="桥下通航等级及标准净空" 
                v-model:value="TechIndex.data.tech_scleargrade" 
                suffix="M"
              />
            </td>
          </tr>
          <tr>
            <td class="table-item-name">桥下实际净空</td>
            <td class="table-item-content">
              <a-input
                class="input-item-default" 
                disabled 
                placeholder="桥下实际净空" 
                v-model:value="TechIndex.data.tech_dreaclear" 
                suffix="M"
              />
            </td>
            <td class="table-item-name">引道总宽</td>
            <td class="table-item-content">
              <a-input
                class="input-item-default"  
                disabled 
                placeholder="引道总宽"
                v-model:value="TechIndex.data.tech_apwidth" 
                suffix="M"
              />
            </td>
            <td class="table-item-name">引道线形或曲线半径</td>
            <td class="table-item-content">
              <a-input
                class="input-item-default" 
                disabled  
                placeholder="引道线形或曲线半径" 
                v-model:value="TechIndex.data.tech_curradius" 
                suffix="M"
              />
            </td>
          </tr>
          <tr>
            <td class="table-item-name">设计洪水频率及其水位</td>
            <td class="table-item-content">
              <a-input
                class="input-item-default" 
                disabled  
                placeholder="设计洪水频率及其水位" 
                v-model:value="TechIndex.data.tech_floodfrelev" 
                suffix="M"
              />
            </td>
            <td class="table-item-name">历史洪水位</td>
            <td class="table-item-content">
              <a-input  
                class="input-item-default" 
                disabled 
                placeholder="历史洪水位" 
                v-model:value="TechIndex.data.tech_floodlev" 
                suffix="M"
              />
            </td>
            <td class="table-item-name">设计地震动峰值加速度系数</td>
            <td class="table-item-content">
              <a-input
                class="input-item-default" 
                disabled 
                placeholder="设计地震动峰值加速度系数" 
                v-model:value="TechIndex.data.tech_eaqua"
                suffix="M" 
              />
            </td>
          </tr>
        </table>
      </a-form-item>
      <h3>桥梁结构信息</h3>
      <hr>
      <a-form-item>
        <div class="struct-container" v-for="item in BridgeStruct.arr">
          <a-row>
            <a-col :span="1" class="struct-main"> <h4> {{ item.struct }} </h4></a-col>
            <a-col :span="23">
              <table class="sub-struct-table" >
                <tr v-for="subItem in item.subStruct">
                  <td style="width: 10%;"> {{ subItem.subName }} </td>
                  <td v-for="data in subItem.subArr">{{ data.material }}</td>
                </tr>
              </table>
            </a-col>
          </a-row>
          <hr>
        </div>
      </a-form-item>
      <h3>桥梁档案资料</h3>
      <hr>
      <a-form-item>
        <table class="basic-card-table">
          <tr>
            <td class="table-item-name">设计图纸</td>
            <td class="table-item-content">
              <a-input
                placeholder="设计图纸"
                disabled 
                v-model:value="BridgeRecord.data.brcord_despaper">
              </a-input>
            </td>
            <td class="table-item-name">设计文件</td>
            <td class="table-item-content">
              <a-input
                placeholder="设计文件"
                disabled 
                v-model:value="BridgeRecord.data.brcord_file">
              </a-input>
            </td>
            <td class="table-item-name">竣工图纸</td>
            <td class="table-item-content">
              <a-input
                placeholder="竣工图纸"
                disabled 
                v-model:value="BridgeRecord.data.bricord_finpaper">
              </a-input>
            </td>
          </tr>
          <tr>
            <td class="table-item-name">施工文件</td>
            <td class="table-item-content">
              <a-input
                placeholder="施工文件"
                disabled 
                v-model:value="BridgeRecord.data.bricord_buildfile">
              </a-input>
            </td>
            <td class="table-item-name">验收文件</td>
            <td class="table-item-content">
              <a-input
                placeholder="验收文件"
                disabled 
                v-model:value="BridgeRecord.data.bricord_checkfile">
              </a-input>
            </td>
            <td class="table-item-name">行政审批文件</td>
            <td class="table-item-content">
              <a-input
                placeholder="行政审批文件"
                disabled 
                v-model:value="BridgeRecord.data.bricord_reviewfile">
              </a-input>
            </td>
          </tr>
          <tr>
            <td class="table-item-name">定期检查资料</td>
            <td class="table-item-content">
              <a-input
                placeholder="定期检查资料"
                disabled 
                v-model:value="BridgeRecord.data.bricord_refularfile">
              </a-input>
            </td>
            <td class="table-item-name">特殊检查资料</td>
            <td class="table-item-content">
              <a-input
                placeholder="特殊检查资料"
                disabled 
                v-model:value="BridgeRecord.data.bricord_specialfile">
              </a-input>
            </td>
            <td class="table-item-name">历次维修、加固资料</td>
            <td class="table-item-content">
              <a-input
                placeholder="历次维修、加固资料"
                disabled 
                v-model:value="BridgeRecord.data.bricord_fixfile">
              </a-input>
            </td>
          </tr>
          <tr>
            <td class="table-item-name">其他档案</td>
            <td class="table-item-content">
              <a-input
                placeholder="其他档案"
                disabled 
                v-model:value="BridgeRecord.data.bricord_elsefile">
              </a-input>
            </td>
            <td class="table-item-name">档案形式</td>
            <td class="table-item-content">
              <a-select ref="select" disabled v-model:value="BridgeRecord.data.bricord_fileform">
                <a-select-option value="电子档案">电子档案</a-select-option>
                <a-select-option value="纸质档案">纸质档案</a-select-option>
              </a-select>
            </td>
            <td class="table-item-name">建档时间</td>
            <td class="table-item-content">
              <a-input
                placeholder="建档时间"
                disabled 
                v-model:value="BridgeRecord.data.bricord_filltime"
              />
            </td>
          </tr>
        </table>
      </a-form-item>
      <h3>桥梁检测评定历史</h3>
      <hr>
      <a-form-item>
        <table class="assess-record-table">
          <tr class="assess-record-tr">
            <th>评定时间</th>
            <th>检测类别</th>
            <th>桥梁技术状况评定结果</th>
            <th>处治对策</th>
            <th>下次检测时间</th>
          </tr>
          <tr v-for="item in BridgeCheckRecord.arr" class="assess-record-tr">
            <td> {{item.chrecord_settime}} </td>
            <td> {{item.chrecord_checktype}} </td>
            <td> {{item.chrecord_spchcln}} </td>
            <td> {{item.chrecord_handleway}} </td>
            <td> {{item.chrecord_nechtime}} </td>
          </tr>
        </table>
        <div class="none-data-tips" v-if="BridgeCheckRecord.arr.length === 0">
          暂无数据
        </div>
      </a-form-item>
      <h3>养护处治记录</h3>
      <hr>
      <a-form-item>
        <table class="assess-record-table">
          <tr class="assess-record-tr">
            <th>时间</th>
            <th>处治类别</th>
            <th>处治原因</th>
            <th>处治范围</th>
            <th>工程费用</th>
            <th>经费来源</th>
            <th>处治质量评定</th>
          </tr>
          <tr v-for="item in CsereRecord.arr" class="assess-record-tr">
            <td> {{ item.cse_time }} </td>
            <td> {{ item.cse_type }} </td>
            <td> {{ item.cse_rea }} </td>
            <td> {{ item.cse_range }} </td>
            <td> {{ item.cse_cost }} </td>
            <td> {{ item.cse_mfrom }} </td>
            <td> {{ item.cse_judge }} </td>
          </tr>
        </table>
        <div class="none-data-tips" v-if="CsereRecord.arr.length === 0">
          暂无数据
        </div>
      </a-form-item>
      <h3>说明事项</h3>
      <hr>
      <a-form-item>
        <a-textarea
          disabled 
          v-model:value="Others.data.oth_tips"
          placeholder="输入说明事项"
          show-count
          :maxlength="200"
          allow-clear
          style="margin: 1em auto 1em;"
          :autosize="{minRows : 4}"
        />
      </a-form-item>
      <h3>其他档案</h3>
      <hr>
      <a-form-item>
        <div class="header-img-box">
          <!-- <span>图片链接</span> -->
          <span>桥梁总体图片</span>
          <!-- <span>图片链接</span> -->
          <span>桥梁正面图片</span>
        </div>
        <div class="photo-box">
          <a-row justify="space-around" style="height: 100%; align-items: center">
            <a-col>
              <!-- <a-input
                  placeholder="图片链接"
                  v-model:value="Others.data.oth_totalimg"
              /> -->
            </a-col>
            <a-col :span="12" class="img-input-box">
              <img
                  :src="Others.data.oth_totalimg.length === 0? '' : Others.data.oth_totalimg"
                  alt="图片"
              />
            </a-col>
            <a-col>
              <!-- <a-input
                  placeholder="图片链接"
                  v-model:value="Others.data.oth_faceimg"
              /> -->
            </a-col>
            <a-col :span="12" class="img-input-box">
              <img
                  :src="Others.data.oth_faceimg.length === 0? '' : Others.data.oth_faceimg"
                  alt="图片"
              />
            </a-col>
          </a-row>
        </div>
        <hr style="margin: 1em auto 1em">
        <table class="basic-card-table">
          <tr style="border-bottom: 1px solid #6c6969">
            <td class="table-item-name">桥梁工程师</td>
            <td class="table-item-content">
              <a-input
                placeholder="桥梁工程师"
                disabled
                v-model:value="Others.data.oth_engineer"
              />
            </td>
            <td class="table-item-name">填卡人</td>
            <td class="table-item-content">
              <a-input placeholder="填卡人" disabled v-model:value="Others.data.oth_people" />
            </td>
            <td class="table-item-name">填卡日期</td>
            <td class="table-item-content">
              <a-input
                placeholder="填卡日期"
                disabled 
                v-model:value="Others.data.oth_date"
              />
            </td>
          </tr>
        </table>
      </a-form-item>
    </a-form>
  </div>

</template>

<script lang="ts" setup>
import axios from 'axios';
import { useRoute } from 'vue-router';



const Bridge = reactive({
  data: {
    bri_id: '',
    bty_id: '',
    route_id: '',
    bri_name: '',
  }
}) 

const Routes = reactive({
  data: {
    route_id: '1', //路线编号
    route_name: '江北城大街南路', //路线名称
    route_grade: '2', //路线等级
  }
})

const AiData = reactive({
  data: {
    bri_id: '', // 桥梁编号
    AIdata_id: '', // 行政识别信息编号
    AIdata_funtype: '', // 功能类型
    AIdata_load: '', // 设计载荷
    AIdata_slope: '', // 桥梁坡度
    AIdata_radius: '', // 桥梁曲率半径
    AIdata_fintime: '', // 建成时间
  }
})

const TechIndex = reactive({
  data: {
    bri_id: '', // 桥梁编码
    tech_id: '', // 桥梁技术指标编码
    tech_length: '', // 桥梁全长
    tech_width: '', // 桥梁总宽
    tech_carwidth: '', // 车道宽度
    tech_peowidth: '', // 人行道宽度
    tech_barheight: '', // 护栏或防护墙高度
    tech_divwidth: '', // 中央分割带宽度
    tech_staclear: '', // 桥面标准净空
    tech_reaclear: '', // 桥面实际净空
    tech_scleargrade: '', // 桥下通航等级及标准净空
    tech_dreaclear: '', // 桥下实际净空
    tech_apwidth: '', // 引道总宽
    tech_floodfrelev: '', // 设计洪水频率及其水位
    tech_curradius: '', // 引道线形或曲率半径
    tech_floodlev: '', // 历史洪水位
    tech_eaqua: '', // 地震峰值加速度系数
    tech_elevation: '', // 桥面高程
  }
})

const BridgeStruct = reactive({
	arr: [
    {
		  struct: "吊索",
		  subStruct: [
        {
			    subName: '北1',
			    subArr: [
            {
				      material: '长: 45m, 角度: 30°',
			      }
          ]
		    },
        {
			    subName: '北2',
			    subArr: [
            {
				      material: '长: 30m, 角度: 45°',
			      }
          ]
		    },
        {
			    subName: '北3',
			    subArr: [
            {
				      material: '长: 15m, 角度: 60°',
			      }
          ]
		    },
        {
			    subName: '南1',
			    subArr: [
            {
				      material: '长: 45m, 角度: 30°',
			      }
          ]
		    },
        {
			    subName: '南2',
			    subArr: [
            {
				      material: '长: 30m, 角度: 45°',
			      }
          ]
		    },
        {
			    subName: '南3',
			    subArr: [
            {
				      material: '长: 15m, 角度: 60°',
			      }
          ]
		    },
      ]
	  },
    {
		  struct: "索塔",
		  subStruct: [
        {
			    subName: '中央索塔',
			    subArr: [
            {
				      material: '高: 44m',
			      }
          ]
		    }
      ]
	  },
  ]
})

const BridgeRecord = reactive({
  data: {
    bri_id: '', // 桥梁编码
    brcord_id: '', // 档案资料编码
    brcord_despaper: '', // 设计图纸
    brcord_file: '', // 设计文件
    bricord_finpaper: '', // 竣工图纸
    bricord_buildfile: '', // 施工文件
    bricord_checkfile: '', // 验收文件
    bricord_reviewfile: '', // 行政审批文件
    bricord_refularfile: '', // 定期检查资料
    bricord_specialfile: '', // 特殊检查资料
    bricord_fixfile: '', // 历次维修加固资料
    bricord_elsefile: '', // 其他档案
    bricord_fileform: '', // 档案形式
    bricord_filltime: '', // 建档时间
  }
})

const BridgeCheckRecord = reactive({
  arr: [{
    bri_id: '', // 桥梁编码
    chrecord_settime: '', // 设定时间
    chrecord_checktype: '', // 检测类别
    chrecord_spchcln: '', // 特殊检查结论
    chrecord_handleway: '', // 处置对策
    chrecord_nechtime: '', // 下次检测时间
  }]
})

const CsereRecord = reactive({
  arr: [{
    bri_id: '', // 桥梁编码
    cse_time: '', // 时间段
    cse_type: '', // 处治类别
    cse_rea: '', // 处治原因
    cse_range: '', // 处治范围
    cse_cost: '', // 工程费用
    cse_mfrom: '', // 经济来源
    cse_judge: '', // 处治质量评定
  }]
})

const Others = reactive({
  data: {
    bri_id: '', // 桥梁编码
    oth_id: '', // 其它编码
    oth_totalimg: '', // 桥梁总体照片
    oth_engineer: '', // 桥梁工程师
    oth_faceimg: '', // 桥梁正面照片
    oth_people: '', // 填卡人
    oth_date: '', // 填卡日期
    oth_tips: '', // 说明事项
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

const route = useRoute()
console.log(route.query.bri_id)

const bid = route.query.bridgeid;


const getBridge = () => {
  axios({
    url: 'http://localhost:3000/api/init/get/bridge',
    method: 'GET',
    params: {
      bri_id: bid
    }
  }).then((resp) => {
    // alert("获取桥梁信息")
    Bridge.data=resp.data;
  })
}
getBridge();

const getAiData = () => {
  axios({
    url: 'http://localhost:3000/api/basic/get/aidata',
    method: 'GET',
    params: {
      bri_id: bid
    }
  }).then((resp) => {
    AiData.data=resp.data;
    // alert(AiData.data.AIdata_id)
  })
}
getAiData();

const getTechIndex = () => {
  axios({
    url: 'http://localhost:3000/api/basic/get/tech',
    method: 'GET',
    params: {
      bri_id: bid
    }
  }).then((resp) => {
    TechIndex.data=resp.data;
  })
}
getTechIndex();

const getBridgeStruct = () => {
	axios({
		url: 'http://localhost:3000/api/basic/get/bridgestruct',
		method: 'GET',
		params: {
			bri_id: bid,
		}
	}).then((resp) => {
		BridgeStruct.arr = resp.data
	})
}
getBridgeStruct();

const getBridgeRecord = () => {
  axios({
    url: 'http://localhost:3000/api/basic/get/bridgerecord',
    method: 'GET',
    params: {
      bri_id: bid
    }
  }).then((resp) => {
    // alert("获取BridgeRecord")
    BridgeRecord.data=resp.data;
  })
}
getBridgeRecord();

const getBridgeCheckRecord = () => {
  axios({
    url: 'http://localhost:3000/api/basic/get/check',
    method: 'GET',
    params: {
      bri_id: bid
    }
  }).then((resp) => {
    // alert("获取BridgeRecord")
    BridgeCheckRecord.arr=resp.data;
  })
}
getBridgeCheckRecord();

const getCsereRecord = () => {
  axios({
    url: 'http://localhost:3000/api/basic/get/csere',
    method: 'GET',
    params: {
      bri_id: bid
    }
  }).then((resp) => {
    // alert("获取BridgeRecord")
    CsereRecord.arr=resp.data;
  })
}
getCsereRecord();

const getOthers = () => {
  axios({
    url: 'http://localhost:3000/api/basic/get/others',
    method: 'GET',
    params: {
      bri_id: bid
    }
  }).then((resp) => {
    // alert("获取BridgeRecord")
    Others.data=resp.data;
  })
}
getOthers();
// const jjj = ()=>{
//   getCo();
// }
// const adid = AiData.data.AIdata_id;
 
const getCo = () => {
  // getAiData();
  axios({
    url: 'http://localhost:3000/api/basic/get/co',
    method: 'GET',
    params: {
      AIdata_id: bid
    }
  }).then((resp) => {
    // alert("获取cop")
    Cop.arr=resp.data;
    console.log('123');
    console.log(AiData.data.AIdata_id);
    // console.log(resp);
    console.log(Cop.arr);
    Unit.data.unit_design = Cop.arr[0].units_id;
    Unit.data.unit_build = Cop.arr[1].units_id;
    Unit.data.unit_superv = Cop.arr[2].units_id;
    Unit.data.unit_owner = Cop.arr[3].units_id;
    Unit.data.unit_care = Cop.arr[4].units_id;
  })
}
getCo();
console.log(Cop.arr[0].units_id)
// const jjj = () =>{
//   getCo();
//   alert(Cop.arr[4].units_id)
// }
</script>

<style scoped>
.basic-card-container {
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
	align-items: center;
	top: 100px;
	right: 2%;
}

.none-data-tips {
	width: 100%;
	height: 3em;
	font-size: 2em;
	text-align: center;
	line-height: 3em;
	border-bottom: 1px solid #6c6969;
}

.sub-struct-table {
	width: 100%;
	text-align: center;
	border-collapse: separate;
	border-spacing: .5em .5em;
}

.struct-main {
	writing-mode: vertical-rl;
	text-align: center;
	padding: .5em;
	display: flex;
	justify-content: center;
	border-right: 1px solid #bebdbd;
	align-items: center;
}

.basic-card-form {
	padding: 1em;
	border-radius: .3em;
	background-color: #FFF;
	box-shadow: none;
}

.basic-card-table {
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

.assess-record-table {
	border-collapse: collapse;
	text-align: center;
	width: 100%;
}

.assess-record-tr {
	border-bottom: 1px solid #6c6969;
	height: 3em;
}

hr {
	margin: 0;
}

h3 {
	margin-bottom: .8em;
}

.input-item-default {
	width: 100%;
}

.photo-box {
	height: 15em;
}

.img-input-box {
	width: 150%;
	display: flex;
	justify-content: center;
	height: 14em;
}

.header-img-box {
	display: flex;
	justify-content: space-around;
}

.header-img-box span {
	margin-right: 3%;
}

.img-input-box img {
	margin-top: 1em;
	height: 12em;
	width: 12em;
}
</style>