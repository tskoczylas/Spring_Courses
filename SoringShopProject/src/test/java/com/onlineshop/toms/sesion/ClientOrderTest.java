package com.onlineshop.toms.sesion;

import com.onlineshop.toms.entity.Client;
import com.onlineshop.toms.entity.Item;
import com.onlineshop.toms.entity.OrderStatus;
import com.onlineshop.toms.repository.ItemRepository;
import com.onlineshop.toms.service.ItemService;
import com.onlineshop.toms.service.ItemServiceImp;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class ClientOrderTest {

    @BeforeAll()
    static void CreateLitMap(){
       Map<Integer, Item> itemMap = new HashMap<>();
        Item item1 = new Item();
        Item item2 = new Item();
        itemMap.put(1,item1);
        itemMap.put(2,item2);


        ItemRepository itemRepository = mock(ItemRepository.class);
        ItemService itemService = new ItemServiceImp(itemRepository);
    }

    @Test
    void initalizeItemsMap() {
    }

    @Test
    void getOrders() {
    }

    @Test
    void createClient() {
        //giiving
        Item item = new Item();
        Item item1= new Item();
        List<Item> items = new ArrayList<>();
        HashMap<Integer, Item> itemHashMap = new HashMap<>();
        itemHashMap.put(1,item);
        itemHashMap.put(2,item1);

        Client client = new Client();
        ItemRepository itemRepository = mock(ItemRepository.class);
        ItemService itemService = new ItemServiceImp(itemRepository);

        ClientOrder clientOrder = new ClientOrder(itemService);

        //whem
        clientOrder.item = itemHashMap;
        Client client1 = clientOrder.createClient();


        //then
        assertThat(client1.getItemList(),hasSize(2));



    }

    @Test
    void addingOrderToMapShuldGenretingCorrectOrdersOrder() {
        //given
        ItemRepository itemRepository = mock(ItemRepository.class);
        ItemService itemService = new ItemServiceImp(itemRepository);

        ClientOrder clientOrder = new ClientOrder(itemService);

        //when

 
        clientOrder.initalizeItemsMap();
        when(itemService.getItembyId(1)).thenReturn(Optional.of(new Item()));
        when(itemService.getItembyId(7)).thenReturn(Optional.of(new Item()));
        when(itemService.getItembyId(10)).thenReturn(Optional.of(new Item()));
            //then

        clientOrder.addOrdertoMap("1");
        clientOrder.addOrdertoMap("7");
        clientOrder.addOrdertoMap("10");
        clientOrder.addOrdertoMap(null);
        clientOrder.addOrdertoMap("abcd");




        //then
        assertThat(clientOrder.item.values(),hasSize(3));
        assertTrue(clientOrder.item.containsKey(1));
        assertTrue(clientOrder.item.containsKey(2));
        assertTrue(clientOrder.item.containsKey(3));




    }

    @Test
    void getPriceOffOrdersInPricePattern() {
    }

    @Test
    void removeOrderWhenOrderIdDoeasntExist() {
        //given
        ClientOrder clientOrder = mock(ClientOrder.class);

        //when



        //then






    }
}