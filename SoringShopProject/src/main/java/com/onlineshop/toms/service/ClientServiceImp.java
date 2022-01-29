package com.onlineshop.toms.service;

import com.onlineshop.toms.entity.Client;
import com.onlineshop.toms.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImp implements ClientService {


    ClientRepository clientRepository;

    public ClientServiceImp(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> getListOfClients() {
        return clientRepository.findAll();
    }

    @Override
    public void save(Client client) {

        clientRepository.save(client);

    }

    @Override
    public Client getClientByiD(int clientId) {
        return clientRepository.getOne(clientId);
    }

    @Override
    public void delete(int clientId) {
        clientRepository.deleteById(clientId);
    }
}
