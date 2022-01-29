package com.onlineshop.toms.sesion;

import com.onlineshop.toms.entity.Client;
import com.onlineshop.toms.entity.Item;
import com.onlineshop.toms.service.ItemService;
import com.onlineshop.toms.utils.MainUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import javax.persistence.criteria.CriteriaBuilder;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.transaction.support.TransactionSynchronizationManager.clear;

@Component
@SessionScope
public class ClientOrder {

    protected ItemService itemService;

    public ClientOrder(ItemService itemService) {

        this.itemService = itemService;
    }

    protected Map<Integer, Item> item;

    @PostConstruct
    protected void initalizeItemsMap() {
        item = new HashMap<>();
    }



    public Map<Integer, Item> getOrders() {
        return item;
    }

    public Client createClient() {
        Client client = new Client();
        client.setItemList(new ArrayList<>(item.values()));
        return client;
    }

    public void addOrdertoMap(String pizzaId) {



        if(MainUtils.isIntegerAndNotNull(pizzaId)) {

            Optional<Item> itembyId = itemService.
                    getItembyId(Integer.parseInt(pizzaId));

            if (itembyId.isPresent()) {

                int mapKeyNumber = item.values().size() + 1;
                item.put(mapKeyNumber, itembyId.get());
            }

        }
    }
    public String getPriceOffOrdersInPricePattern() {
        double doubleOrderPrice = item.
                values().
                stream().
                mapToDouble(Item::getPrice).sum();
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return decimalFormat.format(doubleOrderPrice);
    }


    public void removeOrder(int orderId) {
        if (item.containsKey(orderId)) {
            item.remove(orderId);
        } }
}
