package com.demo.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    /**
     * The code.
     */
    private Integer code = 0;

    /**
     * The message.
     */
    private String message;

    /**
     * The data.
     */
    private T data;

    /**
     * Constructors common result.
     *
     * @param code    the code
     * @param message the message
     */
    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }

    /**
     * Constructors common result.
     *
     * @param data the data
     */
    public CommonResult(T data) {
        this.data = data;
    }

}
