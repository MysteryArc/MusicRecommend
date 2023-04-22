<script setup lang="ts">
import Menu from "./components/Menu/MenuList.vue"
</script>

<template>
  <el-container>
    <el-aside width="200px" >
      <Menu></Menu>
    </el-aside>
    <el-container>
      <el-header style="background-color: brown;">
        Header
      </el-header>
      <el-main>
        <RouterView></RouterView>
      </el-main>
      <el-footer style="background-color: blue;">
        Footer
      </el-footer>
    </el-container>
  </el-container>
</template>

<style scoped>
</style>
