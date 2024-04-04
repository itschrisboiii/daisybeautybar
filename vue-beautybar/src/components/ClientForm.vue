<template>
<main>
  <div class="wrapper">
        <form @submit.prevent="submitForm">
            <h1>Personsal Info</h1>
            <div class="input-box">
                <input type="text" placeholder="First Name" v-model="client.firstName" required>
            </div>
            <div class="input-box">
                <input type="text" placeholder="Last Name"  v-model="client.lastName" required>
            </div>
            <div class="input-box">
                <input type="email" placeholder="Email" v-model="client.email" required>
            </div>
            <button type="submit" class="btn" v-on:click="addClient()">Submit</button>
        </form>
    </div>
</main>
</template>

<script>
import BeautyBarClient from '@/services/BeautyBarClient';
export default {
    data() {
        return {
            client: {
                firstName: '',
                lastName: '',
                email: ''
            },
            newClientId: 0
        }
    },
methods: {
    submitForm() {
        this.$router.push('/appointments')
    },
    addClient() {
        BeautyBarClient
        .newClient(this.client)
        .then(response => {
            const newClientId = response.data.id;
            this.$store.commit('setClientId', newClientId);
            this.client = response.data;
            console.log(this.client);
        })
        .catch(error => {
            console.log(error + " probloem with addClient")
        });
    }
}
}
</script>

<style scoped>
    * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: "Barlow Semi Condensed";
    background-color: hotpink;
    color: white;
}
main {
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
    background-color: hotpink;
}

.wrapper {
    width: 420px;
    background: hotpink;
    color: white;
    padding: 30px 40px;
}

.wrapper h1 {
    font-size: 36px;
    text-align: center;
}

.wrapper .input-box {
    width: 100%;
    height: 50px;
    margin: 30px 0;
    color: black;
}

.input-box input {
    width: 100%;
    height: 100%;
    background: transparent;
    border: none;
    outline: none;
    border: 2px solid white;
    border-radius: 40px;
    padding: 20px 45px 20px 20px;
    color: white;
}

.input-box input::placeholder {
    color: white;
}

.input-box i {
    position: absolute;
    right: 20px;
    top: 50%;
    transform: translateY(-50%);
    font-size: 20px;
}


.wrapper .btn {
    width: 100%;
    height: 45px;
    background: white;
    border: none;
    outline: none;
    border-radius: 40px;
    box-shadow: 0 0 10px rgba(0, 0, 0, .1);
    cursor: pointer;
    font-size: 16px;
    color: hotpink;
    font-weight: 600;
}
</style>