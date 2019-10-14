package com.example.exception;

import java.time.format.DateTimeFormatter;

/**
 * 方法注解，敏感词校验，异常处理类
 * @author zhl
 */
public class SensitiveBindException extends BaseException{

	private static final long serialVersionUID = 1L;

	public SensitiveBindException() {
		super();
	}

	public SensitiveBindException(String message) {
		super(String.format(message));
		this.messageCode = "PR0000";

	}

	public SensitiveBindException(String message, Throwable cause) {
		super(message, cause);
	}

	public SensitiveBindException(Throwable cause) {
		super(cause);
	}

	public SensitiveBindException(String messageCode, String message, Throwable cause) {
		super(message, cause);
	}

	public SensitiveBindException(String messageCode, String message, Object... args) {
		super(String.format(message, args));
		this.messageCode = messageCode;
	}

	public static void main(String[] args) {
		System.out.println(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));

	}
}
