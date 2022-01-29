package com.luv2code.springdemo.Service;

import com.luv2code.springdemo.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomer();

    void saveCustomer(Customer customer);

    Customer getCustomer(int theId);

    void deleteCustomer(int id);

    List<Customer> searchCustomer(String searchField);
}
