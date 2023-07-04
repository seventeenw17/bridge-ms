<!-- <template>
    <a-button type="primary" @click="visible = true">添加单位</a-button>
    <a-table :columns="columns" :data-source="dataSource" :pagination="{ pageSize: 8}" style="height: 70vh">
        <template #bodyCell="{column, record}">
            <template v-if="column.dataIndex === 'operation'">
                <a-button type="link" style="margin-right: .5em;" @click="onUpdate(record)">修改</a-button>
                <a-popconfirm
                    v-if="dataSource.length"
                    title="确认要删除吗？"
                    ok-text="确认"
                    cancel-text="取消"
                    @confirm="onDelete(record.user_id)"
                >
                    <a-button type="link" danger>删除</a-button>
                </a-popconfirm>
            </template>
        </template>
    </a-table>
    <a-modal
        v-model:visible="visible"
        title="用户"
        ok-text="确认"
        cancel-text="取消"
        @ok="handleOk"
        @cancel="cleanInput"
    >
        <a-input
            class="input-cpn"
            v-model:value="modalValue.user_id"
            placeholder="用户编号"
        />
        <a-input
            class="input-cpn"
            v-model:value="modalValue.user_name"
            placeholder="用户名"
        />
    </a-modal>
</template>

<script lang="ts">
import axios from 'axios';
import { Ref, defineComponent, reactive, ref } from 'vue';
import { error_message } from '../utils/errorMessage';

const columns = [
    {
        title: "用户编号",
        dataIndex: 'user_id',
    },
    {
        title: '用户名',
        dataIndex: 'user_name',
        ellipsis: true,
    },
    {
        title: '操作',
        dataIndex: 'operation',
    },

];

interface user {
    user_id: string
    user_name: string
}

export default defineComponent({
    components: {

    },

    setup() {
        let visible = ref(false)
        let isUpdate = ref(false)
        let old_users_id = ref("")
        const dataSource: Ref<user []> = ref([])

        let users = ref([])
        
        const cleanInput = () => {
            visible.value = false
            isUpdate.value = false

            modalValue.user_id = ""
            modalValue.user_name =""
            old_user_id.value=""

            getUsers()
        }

        const modalValue = reactive({
            users_id:'',
            users_name:'',
        })

        const getUsers = () => {
            axios({
                url: 'http://localhost:3000/api/bty/getall',
                method:'GET',
            }).then((resp) => {
                dataSource.value = resp.data
            })
        }
        getUsers()

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
                    user_id:modalValue.users_id,
                    user_name:modalValue.users_name,
                }
            }).then(() => {
                error_message("成功", "success")
                cleanInput()
                
            })
        }

        const onUpdate = (record:any) => {
            modalValue.users_id = record.users_id
            modalValue.users_name = record.users_name
            old_users_id.value = record.users_id
            visible.value = true
            isUpdate.value = true
            console.log(record)
        }

        const handleUpdate = () => {
            axios({
                url:'http://localhost:3000/api/bty/update',
                method:"POST",
                params:{
                    old_units_id:old_units_id.value,
                    new_units_id:modalValue.units_id,
                    units_name:modalValue.units_name,
                }
            }).then(() => {
                error_message("成功", "success")
                cleanInput()
            })
        }

        const onDelete = (units_id : any) => {

            axios({
                url:'http://localhost:3000/api/bty/delete',
                method:"POST",
                params: {
                    units_id: units_id,
                }
            }).then(() => {
                getUsers()
            })
        }

        return {
            columns,
            dataSource,
            modalValue,
            handleOk,
            visible,
            onUpdate,
            users,
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
</style> -->