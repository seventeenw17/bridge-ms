<template>
    <a-button type="primary" @click="visible = true">添加部件</a-button>
    <a-table :columns="columns" :data-source="dataSource" :pagination="{ pageSize: 8}" style="height: 70vh">
        <template #bodyCell="{column, record}">
            <template v-if="column.dataIndex === 'operation'">
                <a-button type="link" style="margin-right: .5em;" @click="onUpdate(record)">修改</a-button>
                <a-popconfirm
                    v-if="dataSource.length"
                    title="确认要删除吗？"
                    ok-text="确认"
                    cancel-text="取消"
                    @confirm="onDelete(record.asun_id)"
                >
                    <a-button type="link" danger>删除</a-button>
                </a-popconfirm>
            </template>
        </template>
    </a-table>
    <a-modal
        v-model:visible="visible"
        title="桥梁部件"
        ok-text="确认"
        cancel-text="取消"
        @ok="handleOk"
        @cancel="cleanInput"
    >
        <a-input
            class="input-cpn"
            v-model:value="modalValue.asun_id"
            placeholder="桥梁部件编号"
        />
        <a-input
            class="input-cpn"
            v-model:value="modalValue.part_id"
            placeholder="所在部位编号"
        />
        <a-input
            class="input-cpn"
            v-model:value="modalValue.asun_name"
            placeholder="桥梁部件名称"
        />
    </a-modal>
</template>

<script lang="ts">
import axios from 'axios';
import { Ref, defineComponent, reactive, ref } from 'vue';

const columns = [
    {
        title: "部件编号",
        dataIndex: 'asun_id',
    },
    {
        title: '所在部位编号',
        dataIndex: 'part_id',
        ellipsis: true,
    },
    {
        title: '部件名称',
        dataIndex: 'asun_name',
        ellipsis: true,
    },
    {
        title: '操作',
        dataIndex: 'operation',
    },
];

interface asunit {
    asun_id:string
    part_id:string
    asun_name: string
}

export default defineComponent({
    components: {

    },

    setup() {
        let visible = ref(false)
        let isUpdate = ref(false)
        let old_asun_id = ref("")
        const dataSource: Ref<asunit []> = ref([])

        let units = ref([])
        
        const cleanInput = () => {
            visible.value = false
            isUpdate.value = false

            modalValue.asun_id = ""
            modalValue.asun_name =""
            modalValue.part_id=""
            old_asun_id.value=""

            getTypes()
        }

        const modalValue = reactive({
            asun_id:'',
            part_id :'',
            asun_name:'',
        })

        const getTypes = () => {
            axios({
                url: 'http://localhost:3000/api/assunit/getall',
                method:'GET',
            }).then((resp) => {
                dataSource.value = resp.data
                console.log(resp.data)
            })
        }
        getTypes()

        const handleOk = () => {
            if (isUpdate.value) {
                handleUpdate()
            } else {
                handleAdd()
            }
        }

        const handleAdd = () => {
            axios({
                url:'http://localhost:3000/api/assunit/insertone',
                method:"POST",
                params:{
                    asun_id:modalValue.asun_id,
                    part_id:modalValue.part_id,
                    asun_name:modalValue.asun_name,
                }
            }).then(() => {
                ElMessage.success('添加成功');
                cleanInput()
                
            })
        }

        const onUpdate = (record:any) => {
            modalValue.asun_id = record.asun_id
            modalValue.asun_name = record.asun_name
            modalValue.part_id=record.part_id
            old_asun_id.value = record.asun_id
            visible.value = true
            isUpdate.value = true
            console.log(record)
        }

        const handleUpdate = () => {
            axios({
                url:'http://localhost:3000/api/assunit/update',
                method:"POST",
                params:{
                    old_asun_id:old_asun_id.value,
                    new_asun_id:modalValue.asun_id,
                    asun_name:modalValue.asun_name,
                    part_id:modalValue.part_id
                }
            }).then(() => {
                ElMessage.success('更新成功');
                cleanInput()
            })
        }

        const onDelete = (asun_id : any) => {

            axios({
                url:'http://localhost:3000/api/assunit/delete',
                method:"POST",
                params: {
                    asun_id: asun_id,
                }
            }).then(() => {
                ElMessage.success('删除成功');
                getTypes()
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