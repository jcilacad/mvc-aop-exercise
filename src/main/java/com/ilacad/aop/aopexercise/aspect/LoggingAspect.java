package com.ilacad.aop.aopexercise.aspect;

import com.ilacad.aop.aopexercise.dto.UserDto;
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

        // Get the arguments within the pointcut expression
        Object[] args = joinPoint.getArgs();

        // Iterate the array of args, get the instance of UserDto to print its values

        for (Object arg : args) {

            System.out.println(arg);

            if (arg instanceof UserDto) {
                UserDto userDto = (UserDto) arg;

                System.out.println("First Name: " + userDto.getFirstName());
                System.out.println("Last Name: " + userDto.getLastName());
                System.out.println("Email: " + userDto.getEmail());
            }


        }



    }


}
