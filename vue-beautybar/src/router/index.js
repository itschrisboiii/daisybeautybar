import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import ClientInfoView from '@/views/ClientInfoView.vue'
import ServicesView from '@/views/ServicesView.vue'
import AppointmentView from '@/views/AppointmentView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/client',
      name: 'client',
      component: ClientInfoView
    },
    {
      path:'/services',
      name: 'services',
      component: ServicesView
    },
    {
      path: '/appointments',
      name: 'appointments',
      component: AppointmentView
    }
  ]
})

export default router
