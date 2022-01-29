package com.luv2code.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CMRLogginAspect {

    private Logger mylogger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
    private void forControllerPackage(){}

    @Pointcut("execution(* com.luv2code.springdemo.Service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("execution(* com.luv2code.springdemo.deo.*.*(..))")
    private void forDeoPackage(){}

@Pointcut("forControllerPackage() || forServicePackage() || forDeoPackage()")
    private void forAppFlow(){}

    @Before("forAppFlow()")
    private void before(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().toShortString();
        mylogger.info("@Before method calling" + method);

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println(arg);

        }
    }

        @AfterReturning(
                pointcut = "forAppFlow()",
                returning = "return" )
    public void afterReturning(JoinPoint joinpoint, Object return){

            String method = joinpoint.getSignature().toShortString();
            mylogger.info("@After method calling" + method);

            mylogger.info(return);


        }





}
