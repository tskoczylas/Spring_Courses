package com.luv2code.springdemo.rest;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class CustomerRestController {


    @Autowired
CustomerService customerService;


    @GetMapping("/customers")
    public List<Customer> getcustomers() {
        return customerService.getCustomers();

    }

    @GetMapping("/customers/{customerID}")
    public Customer getCustomers(@PathVariable int customerID ){
        Customer customer = customerService.getCustomer(customerID);
        if(customer ==null ){
            throw new CustomerNotFoundException("Klinent o numerze" + customerID +" nie został znaleizony");


        }
        return customer;
    }

    @PostMapping("/customers")
    public Customer addCustomers(@RequestBody Customer requestCoustomer)
    {
        requestCoustomer.setId(0);
        customerService.saveCustomer(requestCoustomer);
        return requestCoustomer;

    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer cutomerRequest){
    customerService.saveCustomer(cutomerRequest);
    return cutomerRequest;
    }

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId)
    {
        Customer tempCustomer=customerService.getCustomer(customerId);

        if(tempCustomer==null){
            throw new CustomerNotFoundException();

        }

        customerService.deleteCustomer(customerId);

        return "Deleted customer id - " + customerId;
    }



}
