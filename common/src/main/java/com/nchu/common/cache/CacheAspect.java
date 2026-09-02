package com.nchu.common.cache;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

@Aspect
@Component
public class CacheAspect {
    @Pointcut("@annotation(com.nchu.common.cache.NchuCache)")
    public void cachePointcut() {}

    @Around("cachePointcut()")
    public Object cacheAround(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取方法
        MethodSignature methodSignature=(MethodSignature)joinPoint.getSignature();
        Method method=methodSignature.getMethod();
        NchuCache cache=method.getAnnotation(NchuCache.class);
        System.out.println(cache.prefix());

        //获取参数
        Parameter[] parameters = method.getParameters();
        System.out.println(parameters.length);
        return joinPoint.proceed();
    }
}
