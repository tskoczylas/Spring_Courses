package com.luv2code.springdemo.Service;

import com.luv2code.springdemo.deo.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

@Autowired
private CustomerDAO customerDAO;

@Transactional
@Override
    public List<Customer> getCustomer() {
        return customerDAO.getCustomers().stream().sorted(Comparator.comparing(Customer::getLastName).reversed()).collect(Collectors.toList());
    }
@Transactional
    @Override
    public void saveCustomer(Customer customer) {
    if(customer!=null){
        customerDAO.saveCustomer(customer);}
    }

    @Override
    @Transactional
    public Customer getCustomer(int theId) {
        return customerDAO.getCustomers(theId);
    }

    @Override
    @Transactional
    public void deleteCustomer(int id) {
        customerDAO.deleteCustomer(id);
    }

    @Override
    @Transactional
    public List<Customer> searchCustomer(String searchField) {
       List<Customer> customers = customerDAO.searchCustomers(searchField);
       return customers;
    }
}
