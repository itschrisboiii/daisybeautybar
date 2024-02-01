package com.daisybeautybar.springbackend.controller;

import com.daisybeautybar.springbackend.dao.AppointmentDao;
import com.daisybeautybar.springbackend.exception.DaoException;
import com.daisybeautybar.springbackend.model.Appointment;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/appointments")
@PreAuthorize("isAuthenticated()")
public class AppointmentController {
    private final AppointmentDao appointmentDao;

    public AppointmentController(AppointmentDao appointmentDao) {
        this.appointmentDao = appointmentDao;
    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Appointment> list() {return appointmentDao.getAppointments(); }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Appointment getById(@PathVariable int id) {
        Appointment appointment = appointmentDao.getAppointmentById(id);
        if (appointment == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Appointment not found");
        } else {
            return appointment;
        }
    }
    @PreAuthorize("permitAll")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    public Appointment newAppointment(@Valid @RequestBody Appointment appointment) {
        return appointmentDao.createAppointment(appointment);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public Appointment updateAppointment(@Valid @RequestBody Appointment appointment, @PathVariable int id) {
        appointment.setId(id);
        try {
            Appointment updatedAppointment = appointmentDao.updateAppointment(appointment);
            return updatedAppointment;
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Service not found");
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteAppointment(@PathVariable int id) {
        appointmentDao.cancelAppointmentById(id);
    }
}
