<template>
    <a-button type="primary" @click="visible = true">添加类型</a-button>
    <a-table :columns="columns" :data-source="dataSource" :pagination="{ pageSize: 8}" style="height: 70vh">
        <template #bodyCell="{column, record}">
            <template v-if="column.dataIndex === 'operation'">
                <a-button type="link" style="margin-right: .5em;" @click="onUpdate(record)">修改</a-button>
                <a-popconfirm
                    v-if="dataSource.length"
                    title="确认要删除吗？"
                    ok-text="确认"
                    cancel-text="取消"
                    @confirm="onDelete(record.bty_id)"
                >
                    <a-button type="link" danger>删除</a-button>
                </a-popconfirm>
            </template>
        </template>
    </a-table>
    <a-modal
        v-model:visible="visible"
        title="桥梁类型"
        ok-text="确认"
        cancel-text="取消"
        @ok="handleOk"
        @cancel="cleanInput"
    >
        <a-input
            class="input-cpn"
            v-model:value="modalValue.bty_id"
            placeholder="桥梁类型编号"
        />
        <a-input
            class="input-cpn"
            v-model:value="modalValue.bty_name"
            placeholder="桥梁类型名称"
        />
    </a-modal>
</template>
<script lang="ts">
import axios from 'axios';
import { Ref, defineComponent, reactive, ref } from 'vue';

const columns = [
    {
        title: "类型编号",
        dataIndex: 'bty_id',
    },
    {
        title: '类型名称',
        dataIndex: 'bty_name',
        ellipsis: true,
    },
    {
        title: '操作',
        dataIndex: 'operation',
    },

];

interface BridgeType {
    bty_id:string
    bty_name: string
}

export default defineComponent({
    components: {

    },

    setup() {
        let visible = ref(false)
        let isUpdate = ref(false)
        let old_bty_id = ref("")
        const dataSource: Ref<BridgeType []> = ref([])

        let units = ref([])
        
        const cleanInput = () => {
            visible.value = false
            isUpdate.value = false

            modalValue.bty_id = ""
            modalValue.bty_name =""
            old_bty_id.value=""

            getTypes()
        }

        const modalValue = reactive({
            bty_id:'',
            bty_name:'',
        })

        const getTypes = () => {
            axios({
                url: 'http://localhost:3000/api/bty/getall',
                method:'GET',
            }).then((resp) => {
                dataSource.value = resp.data
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
                url:'http://localhost:3000/api/bty/insertone',
                method:"POST",
                params:{
                    bty_id:modalValue.bty_id,
                    bty_name:modalValue.bty_name,
                }
            }).then(() => {
                ElMessage.success('添加成功');
                cleanInput()
                
            })
        }

        const onUpdate = (record:any) => {
            modalValue.bty_id = record.bty_id
            modalValue.bty_name = record.bty_name
            old_bty_id.value = record.bty_id
            visible.value = true
            isUpdate.value = true
            console.log(record)
        }

        const handleUpdate = () => {
            axios({
                url:'http://localhost:3000/api/bty/update',
                method:"POST",
                params:{
                    old_bty_id:old_bty_id.value,
                    new_bty_id:modalValue.bty_id,
                    bty_name:modalValue.bty_name,
                }
            }).then(() => {
                ElMessage.success('更新成功');
                cleanInput()
            })
        }

        const onDelete = (bty_id : any) => {

            axios({
                url:'http://localhost:3000/api/bty/delete',
                method:"POST",
                params: {
                    bty_id: bty_id,
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