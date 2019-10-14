/*
 * Copyright 2014-2018 buyforyou.cn. All rights reserved.
 */
package com.example.exception;

import java.time.format.DateTimeFormatter;

/**
 * 业务异常控制
 * 
 * @author LGD
 * @since 1.8
 */
public class BizException extends BaseException {
    
    private static final long serialVersionUID = 7946304343713696205L;

    public BizException() {
        super();
    }

    public BizException(String message) {
        super(String.format(message));
        this.messageCode = "PR0000";

    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    public BizException(String messageCode, String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(String messageCode, String message, Object... args) {
        super(String.format(message, args));
        this.messageCode = messageCode;
    }

    public static void main(String[] args) {
        System.out.println(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));

    }
}
