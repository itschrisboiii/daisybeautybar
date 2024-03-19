<template>
  <main>
    <h1>Daisy's Beauty Bar</h1>
      <h2>Stockton, CA | Lash Tech |</h2>
        <div class="button">
          <router-link v-bind:to="{name: 'client'}">Book Now</router-link>
          <router-link v-bind:to="{name: 'services'}">View Services</router-link>
        </div>
  </main>
</template>

<script>
export default {

}
</script>

<style scoped>
  .button a {
    background-color: white;
    color: hotpink;
    text-decoration: none;
    padding: 15px 50px;
    border-radius: 5px;
    font-family: "Roboto Condensed";
    font-weight: bolder;
    font-size: 20px;
    margin: 5px;
}

main { 
    text-align: center;
    font-size: 30px;
    height: 100%;
    width: 100%;
    margin-top: 15%;
    background-size: cover;
    background-color: hotpink;
    color: white;
}

main h2 {
    font-size: 30px;
}

@media only screen and (max-width: 768px) {
  

    main h2 {
        font-size: 25px;
    }

    main {
        margin-top: 40%;
    }

    .button a {
        padding: 10px 20px;
        font-size: 15px;
    }
}
</style>