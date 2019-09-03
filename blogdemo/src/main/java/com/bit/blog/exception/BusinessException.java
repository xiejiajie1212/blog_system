package com.bit.blog.exception;

public class BusinessException extends RuntimeException{
    private String code;

    public BusinessException(String message) {
        super("业务异常"+message);
        code="401";
    }

    public BusinessException(String message, Throwable cause) {
        super("业务异常"+message, cause);
        code="401";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
