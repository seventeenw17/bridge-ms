<template>
    <a-button class="operator-btn" @click="visible = true">添加单位</a-button>

    <a-table :columns="columns" :data-source="dataSource" :pagination="{ pageSize: 8}" style="height: 70vh">
        <template #bodyCell="{column, record}">
            <template v-if="column.dataIndex === 'operation'">
                <a-button type="link" style="margin-right: .5em;" @click="onUpdate(record)">修改</a-button>
                <a-popconfirm
                    v-if="dataSource.length"
                    title="确认要删除吗？"
                    ok-text="确认"
                    cancel-text="取消"
                    @confirm="onDelete(record.units_id)"
                >
                  <a-button type="link" danger>删除</a-button>
                </a-popconfirm>
              </template>
        </template>
    </a-table>

    <a-modal
        v-model:visible="visible"
        title="单位"
        ok-text="确认"
        cancel-text="取消"
        @ok="handleOk"
        @cancel="cleanInput"
    >
        
        <a-input class="input-cpn" pattern="[0-9]*" v-model:value="modalValue.units_id" placeholder="单位编号" />
        <a-input class="input-cpn" v-model:value="modalValue.units_name" placeholder="单位名称" />
    </a-modal>
</template>
<script lang="ts">
import axios from 'axios';
import { Ref, defineComponent, reactive, ref } from 'vue';
const columns = [
    {
        title: '单位编号',
        dataIndex: 'units_id',
    },
    {
        title: '单位名称',
        dataIndex: 'units_name',
        ellipsis: true,
    },
    {
        title: '操作',
        dataIndex: 'operation',
    },
    
];

export interface Unit {
    units_id:string
    units_name: string
}

export default defineComponent({
    components: {

    },

    setup() {
        let visible = ref(false)
        let isUpdate = ref(false)
        let old_units_id = ref("")
        const dataSource: Ref<Unit[]> = ref([])

        let units = ref([])


        const cleanInput = () => {
            visible.value = false
            isUpdate.value = false

            modalValue.units_id = ""
            modalValue.units_name =""
            old_units_id.value=""

            getUnits()
        }

        const modalValue = reactive({
            units_id:'',
            units_name:'',
        })

        const getUnits = () => {
            axios({
                url: 'http://localhost:3000/api/units/getall',
                method:'GET',
            }).then((resp) => {
                dataSource.value = resp.data
            })
        }
        getUnits()

        const handleOk = () => {

            if (isUpdate.value) {
                handleUpdate()
            } else {
                handleAdd()
            }
            
        }

        const handleAdd = () => {
            axios({
                url:'http://localhost:3000/api/units/insertone',
                method:"POST",
                params:{
                    units_id:modalValue.units_id,
                    units_name:modalValue.units_name,
                }
            }).then(() => {
                ElMessage.success('添加成功');
                cleanInput()
                
            })
        }

        const onUpdate = (record:any) => {
            modalValue.units_id = record.units_id
            modalValue.units_name = record.units_name
            old_units_id.value = record.units_id
            visible.value = true
            isUpdate.value = true
            console.log(record)
        }

        const handleUpdate = () => {
            console.log(modalValue.units_id,old_units_id.value,modalValue.units_name)
            axios({
                url:'http://localhost:3000/api/units/update',
                method:"POST",
                params:{
                    old_units_id:old_units_id.value,
                    new_units_id:modalValue.units_id,
                    units_name:modalValue.units_name,
                }
            }).then(() => {
                ElMessage.success('更新成功');
                cleanInput()
            })
        }

        const onDelete = (units_id : any) => {
            axios({
                url:'http://localhost:3000/api/units/delete',
                method:"POST",
                params: {
                    units_id: units_id,
                }
            }).then(() => {
                ElMessage.success('删除成功');
                getUnits()
            })
        }

        return {
            columns,
            dataSource,
            modalValue,
            handleOk,
            visible,
            onUpdate,
            units,
            onDelete,
            cleanInput,
        };
    },
});
</script>

<style>
    .operator-btn {
        margin-bottom: .8em;
        height: 3em;
    }
    .input-cpn {
        margin: .5em;
        height: 2.5em;
    }
</style>