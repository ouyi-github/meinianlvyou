package com.atguigu.aspectJ;


import com.atguigu.log.MyLogger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class ControllerAspectForLog {

    @Autowired
    private MyLogger myLogger;

    @Around("execution(* com.atguigu.controller.*Controller.*(..))")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        // 获取方法名
        String methodName = proceedingJoinPoint.getSignature().getName();
        // 获取类名
        String className = proceedingJoinPoint.getTarget().getClass().getName();
        //获取参数
        Object[] args = proceedingJoinPoint.getArgs();
        Object result = null;
        try {
            //前置通知
            myLogger.info(">>>>>>>>>>>>>>Start>>>>>>>>>>>>>>>>");
            myLogger.info("Start execution method: " + className + "." + methodName);
            for (int i = 0; i < args.length; i++) {
                myLogger.info("Method parameter: " + args[i].getClass().getTypeName() + " " + args[i]);
            }
            //执行目标方法
            result = proceedingJoinPoint.proceed();
            //返回通知
            myLogger.info("Method result: " + result);
        } catch (Throwable throwable) {
            //异常通知
            myLogger.severe("Method execution exception: " + throwable.getMessage());
            throwable.printStackTrace();
        } finally {
            //后置通知
            myLogger.info(">>>>>>>>>>>>>End>>>>>>>>>>>>>>>>>");
        }
        return result;
    }
}
