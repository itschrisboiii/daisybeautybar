package com.daisybeautybar.springbackend.controller;

import com.daisybeautybar.springbackend.dao.ClientDao;
import com.daisybeautybar.springbackend.model.Client;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/clients")
@PreAuthorize("isAuthenticated()")
public class ClientController {
    private final ClientDao clientDao;

    public ClientController(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Client> list() {
        return clientDao.getClients();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Client getById(@PathVariable int id) {
        Client client = clientDao.getClientById(id);
        if (client == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found");
        } else {
            return client;
        }
    }
    @PreAuthorize("permitAll")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    public Client addClient(@Valid @RequestBody Client client) {
        return clientDao.newClient(client);
    }


}
