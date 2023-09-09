package com.ilacad.aop.aopexercise.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.ilacad.aop.aopexercise.service.*.*(..))")
    private void forServicePackage() {}

    @Before("forServicePackage()")
    public void beforeAddAccountAdvice() {

        System.out.println("Message Before Adding User");
    }
}
