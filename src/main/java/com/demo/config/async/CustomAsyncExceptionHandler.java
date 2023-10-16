package com.demo.config.async;

import java.lang.reflect.Method;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

@Slf4j
public class CustomAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

    @Override
    public void handleUncaughtException(Throwable ex, Method method, Object... params) {
        log.debug("Exception message - {}", ex.getMessage());
        log.debug("Method name - {}", method.getName());
        for (Object param : params) {
            log.debug("Parameter value - {}", param);
        }
    }

}
