<script setup lang="ts">
import { ArrowLeft } from '@element-plus/icons-vue'
import { ArrowRight } from '@element-plus/icons-vue'
import { Search } from '@element-plus/icons-vue'
import { UserFilled } from '@element-plus/icons-vue'
import { useRouter } from 'vue-router'
import useUserStore from '../../store/user'
import { NDropdown, NIcon } from 'naive-ui'
import { ChevronDownSharp } from '@vicons/ionicons5'
import { reactive, ref } from 'vue'

const input = ""
const router = useRouter()
const userStore = useUserStore()

const options = reactive([
    {
        key: "quit",
        label: "切换账号"
    }
])

function gologin() {
    router.push("/login")
}

function golove() {
    router.push("/love")
}

function goprev() {
    router.back()
}

function goforward() {
    router.forward()
}

function handleSelect(key: string | number) {
    if (key == "quit") {
        userStore.logout()
    }
}
</script>

<template>
    <div class="head" style="display: flex; align-items: center;">
        <div class="head-left">
            <div class="arrowButton">
                <el-button :icon="ArrowLeft" size="large" text @click="goprev"/>
                <el-button :icon="ArrowRight" size="large" text @click="goforward"/>
            </div>
            <div class="search">
                <el-input
                v-model="input"
                size="large"
                placeholder="搜索"
                :suffix-icon="Search"
            />
            </div>
        </div>
        <div class="userinfo">
            <el-avatar :icon="UserFilled" />
            <template v-if="userStore.islogin==true">
                <el-button text type="info" @click="golove">{{userStore.userName}}</el-button>
            </template>
            <template v-else>
                <el-button text type="info" @click="gologin">登录</el-button>
            </template>
            <n-dropdown trigger="click" :options="options" @select="handleSelect" >
                <n-icon size="20" class="optionsButton">
                    <ChevronDownSharp/>
                </n-icon>
            </n-dropdown>
        </div>
    </div>
</template>

<style scoped>
.head{
    width: 100%;
    display: flex;
    justify-content: space-between;
}
.arrowButton{
    margin-left: 25px;
}
.head-left{
    display: flex;
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
    display: flex;
    align-items: center;
    margin-right: 5%;
}
.optionsButton:hover{
    cursor: pointer;
    color: #55D9A2FF;
}
</style>