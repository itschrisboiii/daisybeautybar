<template>
  <page-header-vue />
  <appointment-form-vue />
</template>

<script>
import AppointmentFormVue from '@/components/AppointmentForm.vue'
import PageHeaderVue from '@/components/PageHeader.vue'
export default {
    components: {
        AppointmentFormVue,
        PageHeaderVue
    }
}
</script>

<style>

</style>