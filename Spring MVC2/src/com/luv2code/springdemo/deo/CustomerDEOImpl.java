package com.luv2code.springdemo.deo;

import com.luv2code.springdemo.entity.Customer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public class CustomerDEOImpl implements CustomerDAO {

    @Autowired
    SessionFactory sessionFactory;


    @Override
    public List<Customer> getCustomers() {
        List<Customer> resultList = sessionFactory.getCurrentSession()
                .createQuery("from Customer",Customer.class).getResultList();

        return resultList;
    }

    @Override
    public void saveCustomer(Customer customer) {
        sessionFactory.getCurrentSession().saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomers(int theId) {
        Customer customer = sessionFactory.getCurrentSession().get(Customer.class,theId);

        return customer;


    }

    @Override
    public void deleteCustomer(int id) {

        Customer customer = sessionFactory.getCurrentSession().get(Customer.class, id);
        sessionFactory.getCurrentSession().delete(customer);
    }

    @Override
    public List<Customer> searchCustomers(String searchField) {

        List<Customer> customersList = sessionFactory.getCurrentSession().
                createQuery
                        ("from Customer where firstName like lower(:field) or lastName like lower(:field)",Customer.class).
                setParameter("field", "%" + searchField.toLowerCase() + "%").getResultList();
        System.out.println(customersList);

        return customersList;

    }
}
