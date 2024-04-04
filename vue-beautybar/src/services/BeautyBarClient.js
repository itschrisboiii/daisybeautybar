import axios from "axios";

const http = axios.create({
    baseURL: 'http://localhost:8080'
});

export default {
    newClient(client) {
        return http.post(`/clients`, client)
    }
}