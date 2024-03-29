package com.daisybeautybar.springbackend.dao;



import com.daisybeautybar.springbackend.model.Client;

import java.util.List;

public interface ClientDao {
    // gets by their id
    Client getClientById(int clientId);
    // get a list of all clients
    List<Client> getClients();
    // add new client
    Client newClient (Client client);
}
