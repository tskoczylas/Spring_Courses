package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(4)
@Component
public class MyCloadLogAsyncAspect {
LuvAopExpressions luvAopExpressions;
    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDeoPackageNotGetterSetter()")
    public void putintheCloud(){
        System.out.println("printtheCloud");
    }
}
