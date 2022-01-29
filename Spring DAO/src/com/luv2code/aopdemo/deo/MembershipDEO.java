package com.luv2code.aopdemo.deo;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class MembershipDEO {


    public boolean addSilly(){

        System.out.println(getClass() + " Adding an Account");
    return true;
    }


    public  int doIt (){
        System.out.println("wen");
        return 2;
    }
}
