package com.onlineshop.toms.controller;

import com.onlineshop.toms.entity.Client;
import com.onlineshop.toms.entity.Item;
import com.onlineshop.toms.service.ItemService;
import com.onlineshop.toms.sesion.ClientOrder;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;

import java.text.DecimalFormat;
import java.util.*;

@Controller
@RequestMapping("/")
public class ItemController {

    @Autowired
    ItemService itemService;

    @Autowired
    ClientOrder clientOrder;

    @GetMapping("/")
    public String showAll(Model model){
        List<Item> itemList = itemService.getListOfClients();
        model.addAttribute("itemList",itemList);

        return "mainPage";
    }


    @GetMapping("/desription")
public String showDesription(Model model, @RequestParam("pizzaId") int pizzaId){
        Optional<Item> itembyId = itemService.getItembyId(pizzaId);

        itembyId.ifPresent(item -> model.addAttribute("item", item));
        return "fullDescription";
}

    @GetMapping("/addorder")
    public String addOrder(Model model, @RequestParam(value = "pizzaId",required = false) String pizzaId){

     clientOrder.addOrdertoMap(pizzaId);

        model.addAttribute("clientForm",clientOrder.createClient());
            model.addAttribute("orderList", clientOrder.getOrders());
            model.addAttribute("sumOrder", clientOrder.getPriceOffOrdersInPricePattern());
        return "addOrder";
    }


    @GetMapping("/deleteOrder")
 public String deleteOrder(@RequestParam("orderId") int orderId){

        clientOrder.removeOrder(orderId);
        return "redirect:/addorder";
 }

}
