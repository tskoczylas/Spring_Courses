package com.luv2code.aopdemo;

import com.luv2code.aopdemo.deo.AccountDAO;
import com.luv2code.aopdemo.deo.MembershipDEO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningMainDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);


        AccountDAO accountDAO= context.getBean("accountDAO",AccountDAO.class);

        List<Account> accounts = null;

        try {
            boolean tripWire=true;
            accountDAO.findAccount(tripWire);
        }
        catch (Exception exc){
            System.out.println("Main program exceptions " + exc);
        }

        System.out.println("Main program" + accounts);



        context.close();


    }
}
