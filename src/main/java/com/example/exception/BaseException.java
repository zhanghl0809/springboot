package com.example.exception;

/**
 *  异常基类 其它层异常需继承此基类
 */
public class BaseException extends Exception {

    private static final long serialVersionUID = -6077014216304140329L;

    public String messageCode;



    public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

    public BaseException() {
        super();
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(String messageCode, String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String messageCode, String message) {

        super(message);
        this.messageCode = messageCode;
    }

}
