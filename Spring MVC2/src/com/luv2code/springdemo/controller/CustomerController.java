package com.luv2code.springdemo.controller;

import com.luv2code.springdemo.Service.CustomerService;
import com.luv2code.springdemo.deo.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.rmi.MarshalledObject;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/list")
    public String test(Model model)
    {
        List<Customer> customers = customerService.getCustomer();
        model.addAttribute("customers",customers);
        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model)
    {
        Customer customer = new Customer();
        model.addAttribute("customer",customer);

return "customer-form";
    }
    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer ") Customer customer){
customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }


    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId,Model model)
    {
        Customer customer=customerService.getCustomer(theId);
model.addAttribute("customer", customer);

return "customer-form";
    }

    @GetMapping("/showFormForDelete")
    public String showFormForDelete(@RequestParam("customerId") int id)
    {
       customerService.deleteCustomer(id);

       return "redirect:/customer/list";

    }

    @GetMapping("/searchCoustomer")
    public String searchCustomers(@RequestParam ("theSearchField") String searchField, Model model){
        List<Customer> customers = customerService.searchCustomer(searchField);
        model.addAttribute("customers",customers);

        return "list-customers";
    }

}
