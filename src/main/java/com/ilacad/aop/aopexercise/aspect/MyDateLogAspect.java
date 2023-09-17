package com.ilacad.aop.aopexercise.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

@Aspect
@Component
public class MyDateLogAspect {

    @Before("com.ilacad.aop.aopexercise.aspect.LogAopExpressions.forServicePackageNoGetterSetter()")
    public void auditDateForAddingAccount() {

        Date date = new Date();
        Timestamp timeStamp = new Timestamp(date.getTime());

        System.out.println("=============" +timeStamp + "=============");
    }
}
