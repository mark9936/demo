package com.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 找不到資料時使用的例外。
 *
 * <p>{@link ResponseStatus} 會讓 Spring MVC 將這個例外轉成 HTTP 404，
 * 因此 Controller 不需要在每個方法中重複撰寫 try-catch。</p>
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
