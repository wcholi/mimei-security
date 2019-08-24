package com.mimei.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author wuchongliang
 * @create 2019-08-22 14:08:23
 * @description:
 */
@Aspect
@Component
public class TimeAspect {

    @Around("execution(* com.mimei.controller.UserController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("time aspect start");
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println("arg is " + arg);
        }
        long startTime = new Date().getTime();
        Object object = joinPoint.proceed();
        System.out.println("time aspect 耗时：" + (new Date().getTime() - startTime));
        System.out.println("time aspect end");
        return object;
    }
}
