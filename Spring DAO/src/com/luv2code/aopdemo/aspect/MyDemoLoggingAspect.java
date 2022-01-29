package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Order(3)
@Component
public class MyDemoLoggingAspect {


    @AfterReturning(
            pointcut = "execution(* com.luv2code.aopdemo.deo.AccountDAO.findAccount(..))",
            returning = "result")
    public void afterReturningFindAccount(JoinPoint joinPoint, List<Account> result)
    {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("After returing " + method);
        Account account = result.get(0);
        account.setLevel("ZMODIFIKOWNO");
        System.out.println( "After returning resolut"  + result);


    }
    @AfterThrowing(
            pointcut = "execution(* com.luv2code.aopdemo.deo.AccountDAO.findAccount(..))",
            throwing = "argThrow")
            public void afterThrowing(JoinPoint joinPoint,Throwable argThrow)
    {
        MethodSignature methodSignature =(MethodSignature) joinPoint.getSignature();

        System.out.println("after exception " + methodSignature);
        System.out.print("exception is " + argThrow);

    }




    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDeoPackageNotGetterSetter()")

    public void beforeAddAccountAdvice(JoinPoint joinPoint )
    {
        MethodSignature methodSignature =(MethodSignature) joinPoint.getSignature();

        System.out.println("methhod " + methodSignature);

        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {

            System.out.println(arg);

            if(arg instanceof Account)
            {
                Account account = (Account) arg;

                System.out.println(account.getName());
                System.out.println(account.getLevel());

            }

        }


        System.out.println("AddAccountAdvice"); }





}
