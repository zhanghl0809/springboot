/*
 * Copyright 2014-2018 buyforyou.cn. All rights reserved.
 */
package com.example.common;

import lombok.Data;

/**
 * 公共请求报文头
 * @author LGD
 * @since 1.8
 */
@Data
public class ReqCommon {

	private String deviceType;// 设备类型 android/ios

	private String tradeTime;// 请求交易日期时间 请求日期时间 yyyyMMddHHmmss
	private String distinguish;// 商户或者员工所属总公司标识

	private String appid; // 开发者设置中的appId

	private String identity;// 小程序所属总公司的标识

	private String token; // 令牌 如需校验Token必须上送
}
