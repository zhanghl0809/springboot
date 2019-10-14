package com.example.exception;

/**
 * @Date 2019/1/14-15:46
 * @Author Amarone
 * @Description
 **/
public class EasemobException extends BaseException {

    public EasemobException(String messageCode, String message, Throwable cause) {
        super(message, cause);
    }

    public EasemobException(String messageCode, String message, Object... args) {
        super(String.format(message, args));
        this.messageCode = messageCode;
    }

    public EasemobException(String messageCode, String message) {
        super(message);
        this.messageCode = messageCode;
    }
}
