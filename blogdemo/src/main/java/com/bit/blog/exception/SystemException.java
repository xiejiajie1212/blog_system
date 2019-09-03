package com.bit.blog.exception;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SystemException extends RuntimeException {
    private String code;
    public SystemException(String message) {
        super("系统异常:"+message);
        code="500";
    }

    public SystemException(String message, Throwable cause) {
        super("系统异常:"+message, cause);
        code="500";
    }
}
