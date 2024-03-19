<template>
  <header>
        <router-link v-bind:to="{name: 'home'}"><i class="fa fa-home"></i></router-link>
    </header>
</template>

<script>
export default {

}
</script>

<style scoped>
    header {
    text-align: center;
    font-size: 50px;
    color: white;
}
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    background-color: hotpink;
    color: white;
}
</style>