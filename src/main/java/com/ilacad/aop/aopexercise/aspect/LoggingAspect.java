package com.ilacad.aop.aopexercise.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {


    @Before("execution(* com.ilacad.aop.aopexercise.service.*.*(..))")
    public void beforeAddAccountAdvice() {

        System.out.println("Message Before Adding User");
    }
}
