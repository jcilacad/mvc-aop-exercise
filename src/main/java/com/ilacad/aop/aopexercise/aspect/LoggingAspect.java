package com.ilacad.aop.aopexercise.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.ilacad.aop.aopexercise.service.*.*(..))")
    private void forServicePackage() {}

    @Before("forServicePackage()")
    public void beforeAddAccountAdvice() {

        System.out.println("Message Before Adding User");
    }

    @Before("forServicePackage()")
    public void auditDateForAddingAccount() {

        Date date = new Date();
        Timestamp timeStamp = new Timestamp(date.getTime());

        System.out.println("=============" +timeStamp + "=============");
    }
}
