package com.ilacad.aop.aopexercise.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAopExpressions {

    @Pointcut("execution(* com.ilacad.aop.aopexercise.service.*.*(..))")
    private void forServicePackage() {}

    // Pointcut for setter methods
    @Pointcut("execution(* com.ilacad.aop.aopexercise.service.*.set*(..))")
    private void setter() {}

    // Pointcut for getter methods
    @Pointcut("execution(* com.ilacad.aop.aopexercise.service.*.get*(..))")
    private void getter() {}

    @Pointcut("forServicePackage() && !(setter() || getter())")
    private void forServicePackageNoGetterSetter() {}

}
