<template>
  <main>
    <div v-if="!submitted">
    <div class="wrapper">
        <form @submit.prevent="submitForm">
            <h1>Appointment</h1>
            <div class="input-box">
                <input type="date" placeholder="Select Date" :min="minDate" :max="maxDate" v-model="selectedDate"  required>
            </div>
            <div class="input-box">
                <input type="time" placeholder="Select Time" v-model="selectedTime" @input="restrictTime" required>
            </div>
            <div class="input-box">
                <label for="Services">Select a service:</label>
                <select name="Services" id="Services" required v-model="appointment.service_id">
                    <option v-for="service in services" v-bind:key="service.id" :value="service.id">
                    {{ service.serviceName }}
                    </option>
                    
            </select>
            </div>
            <button type="submit" class="btn"  v-on:click="makeAppointment()">Submit</button>
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
import BeautyBarServices from '@/services/BeautyBarServices';
import BeautyBarAppointment from '@/services/BeautyBarAppointment';
export default {
    data() {
        return {
            submitted: false,
            services: [],
            minDate: this.getCurrentDate(),
            maxDate: this.getMaxDate(),
            selectedTime: '12:00',
            selectedDate: '',
            appointment: {
                date: this.selectedDate,
                time: "12:00:00",
                client_id: this.$store.state.clientId,
                service_id: null,
            }
        };
    },
    methods: {
        submitForm() {
            this.submitted = true;
        },
        getServices() {
            BeautyBarServices.getServices()
            .then(response => {
                this.services = response.data;
            })
            .catch(error => {
                console.log(error + " in getServices")
            })
        },
        getCurrentDate(){
            const now = new Date();
            const year = now.getFullYear();
            let month = now.getMonth() + 1;
            let day = now.getDate();

            month = month < 10 ? '0' + month : month;
            day = day < 10 ? '0' + day : day;

            return `${year}-${month}-${day}`;
        },
        getMaxDate() {
            const now = new Date();
            now.setMonth(now.getMonth() + 1);
            const year = now.getFullYear();
            let month = now.getMonth() + 1;
            let day = now.getDate();

            month = month < 10 ? '0' + month : month;
            day = day < 10 ? '0' + day : day;

            return `${year}-${month}-${day}`;
        },
        restrictTime() {
            if (this.selectedTime !== '12:00') {
             this.selectedTime = '12:00';
        }
    },
    makeAppointment() {
        this.appointment.date = this.formatDate(this.selectedDate);
        BeautyBarAppointment.newAppointment(this.appointment)
        .then(response => {
            this.appointment = response.data;
        })
        .catch(error => {
            console.log(error + " problem with makeAppointment")
        });
    },
    formatDate(date) {
      // Convert date string to Date object
      const selectedDate = new Date(date);
      // Get the year, month, and day
      const year = selectedDate.getFullYear();
      const month = ('0' + (selectedDate.getMonth() + 1)).slice(-2);
      const day = ('0' + selectedDate.getDate()).slice(-2);
      // Return formatted date string (YYYY-MM-DD)
      return `${year}-${month}-${day}`;
    }
  },
    created() {
        this.getServices();
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