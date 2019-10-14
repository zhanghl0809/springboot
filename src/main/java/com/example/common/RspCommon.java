/*
 * Copyright 2014-2018 buyforyou.cn. All rights reserved.
 */
package com.example.common;

/**
 * 公共响应报文头
 * 
 * @author LGD
 * @since 1.8
 */
public class RspCommon {

	private RspHead rspHead = new RspHead();

	private Object rspBody;

	/**
	 * @return the rspHead
	 */
	public RspHead getRspHead() {
		return rspHead;
	}

	/**
	 * @param rspHead the rspHead to set
	 */
	public void setRspHead(RspHead rspHead) {
		this.rspHead = rspHead;
	}

	/**
	 * @return the rspBody
	 */
	public Object getRspBody() {
		return rspBody;
	}

	/**
	 * @param rspBody the rspBody to set
	 */
	public void setRspBody(Object rspBody) {
		this.rspBody = rspBody;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RspCommon [rspHead=" + rspHead + ", rspBody=" + rspBody + "]";
	}

}
