package com.luv2code.aopdemo.deo;


import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    public String getName() {
        System.out.println("inside a getName");
        return name;
    }

    public void setName(String name) {
        System.out.println("Insaide a setName");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println("inside a getServiceCode");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println("inside a setServiceCode");
        this.serviceCode = serviceCode;
    }

    public void addAccount(Account account, boolean vipFlag){

        System.out.println(getClass() + " Adding an Account");


    }

    public void printIt (Account account){
        System.out.println(getClass() + "Drukuj");
    }


     public List<Account> findAccount(boolean tripWire){
        if(tripWire){
            throw new RuntimeException("No soup for you");
        }
        List<Account> accounts = new ArrayList<>();
        Account account = new Account("Jon","Angel");
        Account account1 = new Account("Adam", " War");

        accounts.add(account);
        accounts.add(account1);
        return accounts;
     }
}
