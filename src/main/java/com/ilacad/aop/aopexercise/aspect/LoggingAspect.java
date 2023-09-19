package com.ilacad.aop.aopexercise.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Order(2)
public class LoggingAspect {

    @Before("com.ilacad.aop.aopexercise.aspect.LogAopExpressions.forServicePackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {

        System.out.println("Message Before Adding User");

        // Getting the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        // Displaying the method signature
        System.out.println("Method Signature: " + methodSignature);

    }


}
