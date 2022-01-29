package com.onlineshop.toms.service;

import com.onlineshop.toms.entity.Client;
import com.onlineshop.toms.entity.Item;
import com.onlineshop.toms.entity.OrderStatus;
import com.onlineshop.toms.repository.ClientRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClientServiceImpTest {

    @Test
    void getListOfClients() {
        //givving
        ClientRepository clientRepository = mock(ClientRepository.class);
        ClientService clientService = new ClientServiceImp(clientRepository);
        when(clientService.getListOfClients()).thenReturn(createListofClients());
        //then


       assertThat(clientService.getListOfClients(),hasSize(2));


    }



    @Test
    void save() {
    }

    @Test
    void getClientByiD() {
    }

    @Test
    void delete() {
    }

    List<Client> createListofClients(){
        Item item = new Item();
        Item item2 = new Item();
        List<Item> items= Arrays.asList(item,item2);


        Client client = new Client(1,"Kopernika",92283884, OrderStatus.COMPLETE,items);
        Client client2 = new Client(2,"Anowcaja",243455, OrderStatus.NEW,items);

        List<Client> clients = Arrays.asList(client,client2);

        return clients;
    }

}