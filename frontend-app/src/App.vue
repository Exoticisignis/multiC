<template>
  <div class="container">
    <router-view />
  </div>
</template>

<script>
export default {
  name: "App",
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Rubik:ital,wght@0,400;0,500;1,400&display=swap");

body {
  font-family: "Rubik", sans-serif;

}
.container{

  top: 0;
  left: 0;
  width: 100%;
  height: 100%;

}

</style>