package com.example.exception;

/**
 *  异常基类 其它层异常需继承此基类
 */
public class BaseException extends Exception {

    private static final long serialVersionUID = -6077014216304140329L;

    private String messageCode;



    private String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

    private BaseException() {
        super();
    }

    private BaseException(String message) {
        super(message);
    }

    private BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(String messageCode, String message, Throwable cause) {
        super(message, cause);
    }

    private BaseException(Throwable cause) {
        super(cause);
    }

    private BaseException(String messageCode, String message) {

        super(message);
        this.messageCode = messageCode;
    }

}
