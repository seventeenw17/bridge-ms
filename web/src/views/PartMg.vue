<template>
    <a-button type="primary" @click="visible = true">添加部位</a-button>
    <a-table :columns="columns" :data-source="dataSource" :pagination="{ pageSize: 8}" style="height: 70vh">
        <template #bodyCell="{column, record}">
            <template v-if="column.dataIndex === 'operation'">
                <a-button type="link" style="margin-right: .5em;" @click="onUpdate(record)">修改</a-button>
                <a-popconfirm
                    v-if="dataSource.length"
                    title="确认要删除吗？"
                    ok-text="确认"
                    cancel-text="取消"
                    @confirm="onDelete(record.part_id)"
                >
                    <a-button type="link" danger>删除</a-button>
                </a-popconfirm>
            </template>
        </template>
    </a-table>
    <a-modal
        v-model:visible="visible"
        title="桥梁部位"
        ok-text="确认"
        cancel-text="取消"
        @ok="handleOk"
        @cancel="cleanInput"
    >
        <a-input
            class="input-cpn"
            v-model:value="modalValue.part_id"
            placeholder="桥梁部位编号"
        />
        <a-input
            class="input-cpn"
            v-model:value="modalValue.part_name"
            placeholder="桥梁部位名称"
        />
    </a-modal>
</template>
<script lang="ts">
import axios from 'axios';
import { Ref, defineComponent, reactive, ref } from 'vue';

const columns = [
    {
        title: "部位编号",
        dataIndex: 'part_id',
    },
    {
        title: '部位名称',
        dataIndex: 'part_name',
        ellipsis: true,
    },
    {
        title: '操作',
        dataIndex: 'operation',
    },
];

interface part {
    part_id:string
    part_name: string
}

export default defineComponent({
    components: {

    },

    setup() {
        let visible = ref(false)
        let isUpdate = ref(false)
        let old_part_id = ref("")
        const dataSource: Ref<part []> = ref([])

        let units = ref([])
        
        const cleanInput = () => {
            visible.value = false
            isUpdate.value = false

            modalValue.part_id = ""
            modalValue.part_name =""
            old_part_id.value=""

            getTypes()
        }

        const modalValue = reactive({
            part_id:'',
            part_name:'',
        })

        const getTypes = () => {
            axios({
                url: 'http://localhost:3000/api/part/getall',
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
                url:'http://localhost:3000/api/part/insertone',
                method:"POST",
                params:{
                    part_id:modalValue.part_id,
                    part_name:modalValue.part_name,
                }
            }).then(() => {
                ElMessage.success('添加成功');
                cleanInput()
                
            })
        }

        const onUpdate = (record:any) => {
            modalValue.part_id = record.part_id
            modalValue.part_name = record.part_name
            old_part_id.value = record.part_id
            visible.value = true
            isUpdate.value = true
            console.log(record)
        }

        const handleUpdate = () => {
            axios({
                url:'http://localhost:3000/api/part/update',
                method:"POST",
                params:{
                    old_part_id:old_part_id.value,
                    new_part_id:modalValue.part_id,
                    part_name:modalValue.part_name,
                }
            }).then(() => {
                ElMessage.success('更新成功');
                cleanInput()
            })
        }

        const onDelete = (part_id : any) => {

            axios({
                url:'http://localhost:3000/api/part/delete',
                method:"POST",
                params: {
                    part_id: part_id,
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