package com.demo.config.aop;

import java.util.Arrays;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Slf4j
@Aspect
@Component
public class AopConfiguration {

    @Before("execution(* com.demo.controller..*(..))")
    public void logRequestURI() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();
        log.info("Request URI: " + request.getRequestURI());
    }

    @Around("execution(* com.demo.controller..*(..)) || "
            + "execution(* com.demo.service..*(..)) || "
            + "execution(* com.demo.repository..*(..)) || "
            + "execution(* com.demo.dao..*(..))")
    public Object logMethodExecution(ProceedingJoinPoint pjp) throws Throwable {
        return logAround(pjp);
    }

    private Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        String targetClassName = getTargetClassName(joinPoint);
        String methodName = getMethodName(joinPoint);

        log.info("== START " + targetClassName + "." + methodName);
        log.info(methodName + " input: " + Arrays.toString(joinPoint.getArgs()));

        Object result = joinPoint.proceed();

        log.info("== END " + targetClassName + "." + methodName + "("
                + ((System.currentTimeMillis() - startTime) * 1d / 1000) + ")");

        return result;
    }

    private String getTargetClassName(ProceedingJoinPoint joinPoint) {
        Object target = joinPoint.getTarget();
        return target.getClass().getName();
    }

    private String getMethodName(ProceedingJoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        return signature.getMethod().getName() + "()";
    }

}
