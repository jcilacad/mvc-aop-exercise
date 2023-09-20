package com.ilacad.aop.aopexercise.aspect;

import com.ilacad.aop.aopexercise.dto.UserDto;
import com.ilacad.aop.aopexercise.entity.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;


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

    @AfterReturning(
            pointcut = "execution(* com.ilacad.aop.aopexercise.service.UserServiceImpl.findAllUsers(..))",
            returning = "result"
    )
    public void afterReturningGetUsersAdvice(JoinPoint joinPoint,
                                             List<User> result) {

        // Getting the signature method of the method within the pointcut expression
        String method = joinPoint.getSignature().toShortString();

        // Printing the method name
        System.out.println("Executing After Returning Advice with a method of - " + method);

        // Printing all users everytime users interacting with the method
        System.out.println("Result\n");

        for (User user : result) {
            System.out.println(user);
        }
    }

}
