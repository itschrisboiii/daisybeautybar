<template>
  <main>
    <div v-if="!submitted">
    <div class="wrapper">
        <form @submit.prevent="submitForm">
            <h1>Appointment</h1>
            <div class="input-box">
                <input type="date" placeholder="Select Date" required>
            </div>
            <div class="input-box">
                <input type="time" placeholder="Select Time" required>
            </div>
            <div class="input-box">
                <label for="Services">Select a service:</label>
                <select name="Services" id="Services" required>
                    <option value="Hybrid">Hybrid</option>
                    <option value="Cateye">Cateye</option>
                    <option value="Mega-Volume">Mega-Volume</option>
            </select>
            </div>
            <button type="submit" class="btn">Submit</button>
        </form>
    </div>
    </div>
    <div v-else>
        <div class="submit">
            <h1>Thanks for booking with me!</h1>
            <h2>Check your email for your appointment details</h2>
        </div>
    </div>
    </main>
</template>

<script>
export default {
    data() {
        return {
            submitted: false
        };
    },
    methods: {
        submitForm() {
            this.submitted = true;
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

.input-box select {
    color: white;
    border: 2px solid white;
    border-radius: 30px;
    padding: 5px;
    margin-top: 5px;
}

.input-box label {
    color: white;
}
.submit {
    color: white;
    text-align: center;
    font-size: 30px;
}
</style>