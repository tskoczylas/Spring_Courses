package com.luv2code.aopdemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(6)
@Component
public class MyAPIAnalitycsAsspect {

    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDeoPackageNotGetterSetter())")
    public void performeAnalitycs(){
        System.out.println("PERFORME ANALITYCS");
    }
}
