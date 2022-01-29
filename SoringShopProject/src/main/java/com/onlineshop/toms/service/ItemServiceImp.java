package com.onlineshop.toms.service;

import com.onlineshop.toms.entity.Item;
import com.onlineshop.toms.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImp implements ItemService {

    ItemRepository itemRepository;

    public ItemServiceImp(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getListOfClients() {
        return itemRepository.findAll();
    }

    @Override
    public Optional<Item> getItembyId(int pizzaId) {
        return  itemRepository.findById(pizzaId);
    }
}
