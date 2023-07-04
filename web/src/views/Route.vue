<template>
    <el-button type="primary" @click="visible = true">添加路线</el-button>

    <a-table :columns="columns" :data-source="dataSource" :pagination="{ pageSize: 8}" style="height: 75vh">
        <template #bodyCell="{column, record}">
            <template v-if="column.dataIndex === 'operation'">
                <a-button type="link" style="margin-right: .5em;" @click="onUpdate(record)">修改</a-button>
                <a-popconfirm
                    v-if="dataSource.length"
                    title="确认要删除吗？"
                    ok-text="确认"
                    cancel-text="取消"
                    @confirm="onDelete(record.route_id)"
                >
                  <a-button type="link" danger>删除</a-button>
                </a-popconfirm>
              </template>
        </template>
    </a-table>

    <a-modal
        v-model:visible="visible"
        title="路线"
        ok-text="确认"
        cancel-text="取消"
        @ok="handleOk"
        @cancel="cleanInput"
    >
        <a-input class="input-cpn" v-model:value="modalValue.route_id" placeholder="路线编号" />
        <a-input class="input-cpn" v-model:value="modalValue.route_name" placeholder="路线名称" />
        <a-input class="input-cpn" v-medel:value="modalValue.route_grade" placeholder="路线等级" />
    </a-modal>
</template>
<script lang="ts">
import axios from 'axios';
import { Ref, defineComponent, reactive, ref } from 'vue';

const columns = [
    {
        title: "路线编号",
        dataIndex: 'route_id',
    },
    {
        title: '路线名称',
        dataIndex: 'route_name',
        ellipsis: true,
    },
    {
        title: '路线级别',
        dataIndex: "route_grade",
        ellipsis: true,
    },
    {
        title: '操作',
        dataIndex: 'operation',
    },
    
];

interface Route {
    route_id: string
    route_name: string
    route_grade: string
}

export default defineComponent({
    components: {

    },

    setup() {
        let visible = ref(false)
        let isUpdate = ref(false)
        let old_route_id = ref("")
        const dataSource: Ref<Route[]> = ref([])


        const cleanInput = () => {
            visible.value = false
            isUpdate.value = false

            modalValue.route_id = ""
            modalValue.route_name =""
            modalValue.route_grade =""
            old_route_id.value=""

            getRoutes()
        }

        const modalValue = reactive({
            route_id:'',
            route_name:'',
            route_grade:''
        })

        const getRoutes = () => {
            axios({
                url: 'http://localhost:3000/api/route/getroute',
                method:'GET',
            }).then((resp) => {
                dataSource.value = resp.data
            })
        }
        getRoutes()

        const handleOk = () => {
            if (isUpdate.value) {
                handleUpdate()
            } else {
                handleAdd()
            }
            
        }

        const handleAdd = () => {
            axios({
                url:'http://localhost:3000/api/route/insertone',
                method:"POST",
                params:{
                    route_id:modalValue.route_id,
                    route_name:modalValue.route_name,
                    route_grade:modalValue.route_grade
                }
            }).then(() => {
                ElMessage.success('添加成功');
                cleanInput()
            })
        }

        const onUpdate = (record:any) => {
            modalValue.route_id = record.route_id
            modalValue.route_name = record.route_name
            modalValue.route_grade = record.route_grade
            old_route_id.value = record.route_id
            visible.value = true
            isUpdate.value = true
        }

        const handleUpdate = () => {
            axios({
                url:'http://localhost:3000/api/route/update',
                method:"POST",
                params:{
                    old_route_id:old_route_id.value,
                    new_route_id:modalValue.route_id,
                    route_name:modalValue.route_name,
                    route_grade:modalValue.route_grade,
                }
            }).then(() => {
                ElMessage.success('更新成功');
                cleanInput()
            })
        }

        const onDelete = (route_id : any) => {

            axios({
                url:'http://localhost:3000/api/route/delete',
                method:"POST",
                params: {
                    route_id: route_id,
                }
            }).then(() => {
                ElMessage.success('删除成功');
                getRoutes()
            })
        }

        return {
            columns,
            dataSource,
            modalValue,
            handleOk,
            visible,
            onUpdate,
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