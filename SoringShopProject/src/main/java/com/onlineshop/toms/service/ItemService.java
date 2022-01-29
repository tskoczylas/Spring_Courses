package com.onlineshop.toms.service;

import com.onlineshop.toms.entity.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    List<Item> getListOfClients();


    Optional<Item> getItembyId(int pizzaId);
}
