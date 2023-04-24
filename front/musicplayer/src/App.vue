<script setup lang="ts">
import Menu from "./components/Menu/MenuList.vue"
import Header from "./components/Header/Header.vue"
</script>

<template>
  <div class="main-container">
    <div class="menu">
      <Menu/>
    </div>

    <div class="main">
      <div class="header">
        <Header></Header>
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
  background-color: #F2F3F5;
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
  align-items: center;
  display: flex;
}
.footer {
  height: 75px;
}
.content {
  flex: 1;
  overflow-y: scroll;
}
</style>
