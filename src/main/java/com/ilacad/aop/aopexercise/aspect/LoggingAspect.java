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

    // Pointcut for setter methods
    @Pointcut("execution(* com.ilacad.aop.aopexercise.service.*.set*(..))")
    private void setter() {}

    // Pointcut for getter methods
    @Pointcut("execution(* com.ilacad.aop.aop.exercise.service.*.get*(..))")
    private void getter() {}

    @Pointcut("forServicePackage() && !(setter() || getter())")
    private void forServicePackageNoGetterSetter() {}

    @Before("forServicePackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {

        System.out.println("Message Before Adding User");
    }

    @Before("forServicePackageNoGetterSetter()")
    public void auditDateForAddingAccount() {

        Date date = new Date();
        Timestamp timeStamp = new Timestamp(date.getTime());

        System.out.println("=============" +timeStamp + "=============");
    }
}
