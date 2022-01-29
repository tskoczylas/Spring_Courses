package com.onlineshop.toms.controller;

import com.onlineshop.toms.entity.Client;
import com.onlineshop.toms.entity.Item;
import com.onlineshop.toms.entity.OrderStatus;
import com.onlineshop.toms.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/client")
@Controller
public class ClientController {



    @Autowired
    ClientService clientService;

@GetMapping("/show")
public String showAll(@RequestParam(value = "enum",required = false) OrderStatus orderStatus, Model model ){

    List<Client> listOfClients = clientService.getListOfClients();
    List<Client> collect = listOfClients.stream().filter(i -> i.getOrderStatus().equals(orderStatus)).collect(Collectors.toList());

    if(orderStatus==null){    model.addAttribute("clientList",listOfClients); }
else{model.addAttribute("clientList",collect);}


    return "showClient";
    }


@GetMapping("/details")
        public String getDetails(@RequestParam(value = "clientId",required = true)  int clientId, Model model)
{
   Client client =clientService.getClientByiD(clientId);
    int sum = client.getItemList().stream().map(Item::getPrice).mapToInt(i -> i.intValue()).sum();

    model.addAttribute("sumOrderDetails",sum);
    model.addAttribute("clientOrderDetail",client);
    return "showDetails";
}

    @PostMapping("/changestatus")
    public String changeStatus(@RequestParam(value = "clientId",defaultValue = "13")  int clientId, Model model)
    {
        System.out.println(clientId);
        Client client =clientService.getClientByiD(clientId);
        OrderStatus orderStatus = OrderStatus.geNextOrder(client.getOrderStatus());
        client.setOrderStatus(orderStatus);
clientService.save(client);

        return "redirect:/client/details?clientId=" + clientId;
    }

@GetMapping("/delete")
public String deleteOldOrder(@RequestParam(value = "clientId",defaultValue = "13")  int clientId, Model model)
{
    clientService.delete(clientId);

    return "redirect:/client/show";
}




@PostMapping("/save")
    public String saveOrder(@Valid @ModelAttribute("clientForm") Client client, BindingResult bindingResult){


    if(bindingResult.hasErrors()) return "addorder";
else {
        client.setOrderStatus(OrderStatus.NEW);

        clientService.save(client);
        return "orderConformation";
    }


}





}
