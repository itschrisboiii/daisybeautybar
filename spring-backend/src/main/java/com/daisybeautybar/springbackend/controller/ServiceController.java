package com.daisybeautybar.springbackend.controller;

import com.daisybeautybar.springbackend.dao.ServicesDao;
import com.daisybeautybar.springbackend.exception.DaoException;
import com.daisybeautybar.springbackend.model.Service;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/services")
@PreAuthorize("isAuthenticated()")
public class ServiceController {

    private final ServicesDao servicesDao;

    public ServiceController(ServicesDao servicesDao) {
        this.servicesDao = servicesDao;
    }
    @PreAuthorize("permitAll")
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Service> list() {return servicesDao.getServices(); }


    @PreAuthorize("permitAll")
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Service getById(@PathVariable int id) {
        Service service = servicesDao.getServiceById(id);
        if (service == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Service not found");
        } else {
            return service;
        }
    }


    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    public Service addService(@Valid @RequestBody Service service) {
        return servicesDao.newService(service);
    }


    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public Service updateService(@Valid @RequestBody Service service, @PathVariable int id) {
        service.setId(id);
        try {
            Service updatedService = servicesDao.updateService(service);
            return updatedService;
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Service not found");
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteService(@PathVariable int id) {
        servicesDao.deleteServiceById(id);
    }
}
