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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

        // 獲取類名和方法名
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Class<?> declaringType = signature.getDeclaringType();
        String targetClassName = declaringType.getSimpleName();
        String methodName = signature.getMethod().getName() + "()";

        // 使用LoggerFactory來確保logger的類型正確
        Logger logger = LoggerFactory.getLogger(declaringType);
        logger.info("== START " + targetClassName + "." + methodName);
        logger.info(methodName + " input: " + Arrays.toString(joinPoint.getArgs()));

        Object result = joinPoint.proceed();

        logger.info("== END " + targetClassName + "." + methodName + "("
                + ((System.currentTimeMillis() - startTime) * 1d / 1000) + ")");

        return result;
    }

}
