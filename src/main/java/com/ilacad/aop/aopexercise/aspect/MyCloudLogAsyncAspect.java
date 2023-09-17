package com.ilacad.aop.aopexercise.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyCloudLogAsyncAspect {

    @Before("com.ilacad.aop.aopexercise.aspect.LogAopExpressions.forServicePackageNoGetterSetter()")
    public void logToCloudAsync() {
        System.out.println("Logging to Cloud Async");
    }
}
