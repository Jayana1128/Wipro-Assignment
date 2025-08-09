package com.wipro.grow.quizappmonorepo.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.wipro.grow.quizappmonorepo.example.controller.*.*(..))")
    public void logBefore(JoinPoint joinPoint){
        System.out.println(LocalDateTime.now() + " - Called: " + joinPoint.getSignature());
    }
}
