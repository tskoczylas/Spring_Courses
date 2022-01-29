package com.luv2code.springdemo.deo;

import com.luv2code.springdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    public List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomers(int theId);

    void deleteCustomer(int id);

    List<Customer> searchCustomers(String searchField);
}
