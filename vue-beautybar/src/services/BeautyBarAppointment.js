import axios from "axios";

const http = axios.create({
    baseURL: 'http://localhost:8080'
});

export default {
    newAppointment(appointment) {
        return http.post(`/appointments`, appointment)
    }
}