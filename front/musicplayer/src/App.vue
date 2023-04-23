<script setup lang="ts">
import Menu from "./components/Menu/MenuList.vue"
</script>

<template>
  <!-- <el-container>
    <el-aside width="200px" >
      <div>music</div>
      <hr>
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
  </el-container> -->

  <div class="main-container">
    <div class="menu">
      <Menu/>
    </div>

    <div class="main">
      <div class="header">
        Header
      </div>

      <div class="content">
        <RouterView/>
      </div>

      <div class="footer">
        Footer
      </div>
    </div>
  </div>
</template>

<style scoped>
.main-container{
  height: 100vh;
  display: flex;

}
.menu{
  width: 200px;
  background-color: #EBEEF5;
}
.main{
  flex:1;
  height: 100vh;
  display: flex;
  flex-direction: column;
  overflow: hidden;
}
.header{
  height: 75px;
}
.footer {
  height: 75px;
}
.content {
  flex: 1;
  overflow-y: auto;
}
</style>
