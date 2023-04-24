<script setup lang="ts">
import { ArrowLeft } from '@element-plus/icons-vue'
import { ArrowRight } from '@element-plus/icons-vue'
import { Search } from '@element-plus/icons-vue'
import { UserFilled } from '@element-plus/icons-vue'
import { useRouter } from 'vue-router'
import useUserStore from '../../store/user'

const input = ""
const $router = useRouter()
const userStore = useUserStore()

function gologin() {
    $router.push("/login")
}

function golove() {
    $router.push("/love")
}
</script>

<template>
    <div class="Head" style="display: flex; align-items: center;">
        <div class="arrowButton">
                <el-button :icon="ArrowLeft" size="large" circle />
                <el-button :icon="ArrowRight" size="large" circle />
        </div>
        <div class="search">
            <el-input
            v-model="input"
            size="large"
            placeholder="搜索"
            :suffix-icon="Search"
        />
        </div>
        <div class="userinfo">
            <el-avatar :icon="UserFilled" />
            <template v-if="userStore.islogin==true">
                <el-button text type="info" @click="golove">{{userStore.userId}}</el-button>
            </template>
            <template v-else>
                <el-button text type="info" @click="gologin">登录</el-button>
            </template>
        </div>
    </div>
</template>

<style scoped>
.arrowButton{
    margin-left: 15px;
}

/*搜索组件最外层div */
.search {
    width: 300px;
    height: 40px;
    border-radius: 95px;
    background-color: #E4E7ED;
    margin-left: 15px;
}
/*搜索input框 */
:deep(.el-input__wrapper) {
    background-color: transparent;/*覆盖原背景颜色，设置成透明 */
    border-radius: 95px;
    border: 0;
    box-shadow: 0 0 0 0px;
}
/*搜索button按钮 */
:deep(.el-input-group__append) {
    background-color: #E4E7ED;
    border-radius: 95px;
    border: 0;
    box-shadow: 0 0 0 0px;
}
.userinfo{
    position: fixed;
    right: 5%;
    display: flex;
    align-items: center;
}
</style>