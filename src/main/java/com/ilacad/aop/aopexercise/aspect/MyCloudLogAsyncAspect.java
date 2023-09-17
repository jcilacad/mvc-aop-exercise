package com.ilacad.aop.aopexercise.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyCloudLogAsyncAspect {

    @Before("forServicePackageNoGetterSetter()")
    public void logToCloudAsync() {
        System.out.println("Logging to Cloud Async");
    }
}
