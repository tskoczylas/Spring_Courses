package com.luv2code.aopdemo;

import com.luv2code.aopdemo.deo.AccountDAO;
import com.luv2code.aopdemo.deo.MembershipDEO;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);


        AccountDAO accountDAO= context.getBean("accountDAO",AccountDAO.class);
        Account account=new Account();
        account.setName("Adam");
        account.setLevel("Five");
        accountDAO.printIt(account);
        accountDAO.addAccount(account,true);

        accountDAO.setName("Foobbar");
        accountDAO.setServiceCode("silver");

        String name = accountDAO.getName();
        String code = accountDAO.getServiceCode();

        System.out.println();






        MembershipDEO membershipDEO=context.getBean("membershipDEO",MembershipDEO.class);
        membershipDEO.addSilly();
        membershipDEO.doIt();


        context.close();


    }
}
