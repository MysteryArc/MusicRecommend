<script setup lang="ts">
import { onMounted, reactive, ref, h } from 'vue';
import axios from "../api/request"
import { DataTableColumns, NButton, NDataTable, NPagination } from 'naive-ui';
import { ElMessage } from 'element-plus';

const userData = ref([])
const userCount = ref()
const page = ref(1)
const pageSize = ref(12)

async function getUserCount() {
    const resp = await axios.get('/user/count')
    userCount.value = resp.data
}

const userColumns: DataTableColumns<IUser> = [
    {
        title: "账号",
        key: "userId"
    },
    {
        title: "昵称",
        key: "name"
    },
    {
        title: "国籍",
        key: "country"
    },
    {
        title: "性别",
        key: "gender"
    },
    {
        title: "操作",
        key: "delete",
        render(row) {
            return h(
                NButton,
                {
                    strong: true,
                    tertiary: true,
                    size: 'small',
                    onClick: () => deleteUser(row)
                },
                {
                    default: () => '删除'
                }
            )
        }
    }
]

async function deleteUser(user: IUser) {
    await axios.get("/user/delete/" + user.id)
    ElMessage({
        message: '删除成功',
        type: 'success'
    })
    getUserPage(page.value, pageSize.value)
}

async function getUserPage(currentPage:any, pageSize:any) {
    const resp = await axios.get('/user/'+currentPage+'/'+pageSize)
    // console.log(resp.data)
    userData.value = resp.data
}

onMounted(() => {
    getUserPage(page.value, pageSize.value)
    getUserCount()
})

</script>

<template>
    <h3>用户管理</h3>
    <div class="recently-table">
        <n-data-table :columns="userColumns" :data="userData" :max-height="650" ></n-data-table>
        <n-pagination v-model:page="page" v-model:page-size="pageSize" :item-count="userCount" @update:page="getUserPage(page, pageSize)" />
    </div>
</template>

<style scoped>

</style>