package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class LuvAopExpressions {

    @Pointcut("execution(* com.luv2code.aopdemo.deo.*.*(..)) ")
    public void forDaoPackage() {}

    @Pointcut("execution(* com.luv2code.aopdemo.deo.*.get*(..))")
    public void forGetter(){};

    @Pointcut("execution(* com.luv2code.aopdemo.deo.*.set*(..))")
    public void forSetter(){};

    @Pointcut("forDaoPackage() && !(forGetter() || forSetter())")
    public void forDeoPackageNotGetterSetter(){}


}
