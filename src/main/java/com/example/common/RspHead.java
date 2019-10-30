/*
 * Copyright 2014-2018 buyforyou.cn. All rights reserved.
 */
package com.example.common;

import java.util.Date;

/**
 * 
 * @author LGD
 * @since 1.8
 */
public class RspHead {

	private String status = Const.NORMAL_CODE;

	private String message;
	private String token;

	private Date rspTime = new Date();

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RspHead [status=" + status + ", message=" + message + ", rspTime=" + rspTime + ",token="+token+"]";
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	public Date getRspTime() {
		return rspTime;
	}

	public void setRspTime(Date rspTime) {
		this.rspTime = rspTime;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
