<template>
    <router-link v-bind:to="{name: 'client'}" class="button">Book Now</router-link>
  <div class="card-container">
        <div class="card">
            <img src="../assets/hybrid1.jpeg" alt="">
            <div class="container">
                <h4><b>Hybrid</b></h4>
                <p>$60</p>
                <p>Hybrid lashes combine the best of both worlds, blending classic lash extensions with volume lashes for a striking yet natural look. The result is a customized set of lashes that adds both length and fullness, giving your eyes a captivating and glamorous appearance.</p>
            </div>
        </div>
            <div class="card">
            <img src="../assets/classic1.jpeg" alt="">
            <div class="container">
                <h4><b>Classic</b></h4>
                <p>$60</p>
                <p>Classic lashes offer timeless elegance with a natural enhancement. Each individual extension is carefully applied to your natural lashes, creating a subtle yet beautiful look that enhances your eye shape and adds length and definition. Perfect for those seeking a graceful and effortless everyday glam.</p>
            </div>
        </div>
        <div class="card">
            <img src="../assets/volume1.jpeg" alt="">
            <div class="container">
                <h4><b>Volume</b></h4>
                <p>$60</p>
                <p>Volume lashes deliver stunning fullness and drama. Multiple lightweight extensions are expertly crafted into handmade fans and applied to each natural lash, creating a lush, voluminous effect. Ideal for those craving a bold and glamorous look that instantly amplifies the eyes with luxurious depth and dimension.</p>
            </div>
        </div>
    <div class="card">
        <img src="../assets/hybrid2.jpeg" alt="">
        <div class="container">
            <h4><b>Hybrid Fill</b></h4>
            <p>$30</p>
            <p>A hybrid lash fill refreshes your hybrid lash extensions, replenishing any lost lashes and ensuring a seamless blend between classic and volume extensions. This maintenance session enhances the density and longevity of your lashes, preserving their captivating allure with precision and care.</p>
        </div>
    </div>
    <div class="card">
        <img src="../assets/classic1.jpeg" alt="">
        <div class="container">
            <h4><b>Classic Fill</b></h4>
            <p>$30</p>
            <p>A classic lash fill is a meticulous touch-up session designed to maintain the elegance and natural allure of your classic lash extensions. By replenishing any lost lashes, this service ensures a seamless and consistent look, enhancing the length and definition of your lashes for a timeless and effortlessly glamorous appearance.</p>
        </div>
    </div>
    <div class="card">
        <img src="../assets/volume2.jpeg" alt="">
        <div class="container">
            <h4><b>Volume Fill</b></h4>
            <p>$30</p>
            <p>A volume lash fill is an essential maintenance appointment to uphold the fullness and drama of your volume lash extensions. By replacing any fallen extensions with lightweight handmade fans, this session rejuvenates your lashes, ensuring they remain voluminous, bold, and captivating.</p>
        </div>
    </div>
    <div class="card">
        <img src="../assets/classic1.jpeg" alt="">
        <div class="container">
            <h4><b>Removals</b></h4>
            <p>$20</p>
            <p>Lash removal is a gentle and precise procedure to safely dissolve and remove lash extensions, returning your natural lashes to their original state.</p>
        </div>
    </div>
    </div>
</template>

<script>
export default {

}
</script>

<style scoped>
.button {
  background-color: white;
    color: hotpink;
    text-decoration: none;
    padding: 10px 20px;
    border-radius: 30px;
    font-family: "Roboto Condensed";
    font-weight: bolder;
    font-size: 20px;
    margin-left: auto;
    position: absolute;
    top: 10px;
    right: 15px;
}
 * {
    background-color: hotpink;
    font-family: "Barlow Semi Condensed";
    color: white;
    
}

.card img {
    width:300px;
    height: 300px;
    object-fit: cover;
    border-bottom: solid 4px white;
}

.card {
    /* Add shadows to create the "card" effect */
    box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
    transition: 0.3s;
    width: 300px;
    text-align: center;
    border: 5px solid white;
    border-radius: 5px;
    
  }
  
  /* On mouse-over, add a deeper shadow */
  .card:hover {
    box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
  }
  
  /* Add some padding inside the card container */
  .container {
    padding: 2px 16px;
    margin-bottom: 10px;
  }

  .container button {
    margin-bottom: 10px;
    width: 100%;
    height: 100%;
    background: transparent;
    border: none;
    outline: none;
    border: 4px solid white;
    border-radius: 40px;
    padding: 20px 45px 20px 40px;
    color: white;
    font-size: 20px;
    text-transform: uppercase;
    cursor: pointer;
  }

  .card-container{
    display: flex;
    flex-wrap: wrap;
    gap: 30px;
    justify-content: space-evenly;
    margin-top: 30px;
  }
  @media only screen and (max-width: 280px) {
    .button {
        right: 10px;
        top: 20px;
        font-size: 10px;
    }
  }
</style>