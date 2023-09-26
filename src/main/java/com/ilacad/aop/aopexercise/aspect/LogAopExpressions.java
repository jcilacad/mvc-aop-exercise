package com.ilacad.aop.aopexercise.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAopExpressions {

    @Pointcut("execution(* com.ilacad.aop.aopexercise.service.*.*(..))")
    public void forServicePackage() {}

    // Pointcut for setter methods
    @Pointcut("execution(* com.ilacad.aop.aopexercise.service.*.set*(..))")
    public void setter() {}

    // Pointcut for getter methods
    @Pointcut("execution(* com.ilacad.aop.aopexercise.service.*.get*(..))")
    public void getter() {}

    @Pointcut("forServicePackage() && !(setter() || getter())")
    public void forServicePackageNoGetterSetter() {}

    // Pointcut for finding user by email in the UserServiceImpl
    @Pointcut("execution(* com.ilacad.aop.aopexercise.service.UserServiceImpl.findUserByEmail(..))")
    public void findUserByEmail() {}

}
