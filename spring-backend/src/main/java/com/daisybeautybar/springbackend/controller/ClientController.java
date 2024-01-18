package com.daisybeautybar.springbackend.controller;

import com.daisybeautybar.springbackend.dao.ClientDao;
import com.daisybeautybar.springbackend.model.Client;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private ClientDao clientDao;

    public ClientController(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Client> list() {
        List<Client> clientList = new ArrayList<>();
        clientList = clientDao.getClients();
        return clientList;
    }
}
