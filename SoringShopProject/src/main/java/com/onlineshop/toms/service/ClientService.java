package com.onlineshop.toms.service;

import com.onlineshop.toms.entity.Client;

import java.util.List;

public interface ClientService {

    List<Client> getListOfClients();

    void save(Client client);

    Client getClientByiD(int clientId);

    void delete(int clientId);
}
