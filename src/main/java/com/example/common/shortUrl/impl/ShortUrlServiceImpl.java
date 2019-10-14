package com.example.common.shortUrl.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.common.shortUrl.ShortUrlService;
import com.example.common.shortUrl.utiles.HttpUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 短连接服务
 * @author zhl
 */
@Service
public class ShortUrlServiceImpl implements ShortUrlService {
	/**
	 * 日志工具
	 */
	private static final Logger logger = LoggerFactory.getLogger(ShortUrlServiceImpl.class);


	@Override
	public String aliShortUrlService(String longUrl) {
		logger.debug("阿里短连接服务---长连接：{}", longUrl);
		if (StringUtils.isEmpty(longUrl)) {
			return longUrl;
		}
		String shortUrl = null;
		final String successCode = "200";
		final String host = "https://short.market.alicloudapi.com";
		final String path = "/short";
		final String method = "POST";
		final String appcode = "2c1700809b3b432ba6fa67438975146a";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Authorization", "APPCODE " + appcode);
		headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		Map<String, String> querys = new HashMap<String, String>();
		Map<String, String> bodys = new HashMap<String, String>();
		bodys.put("src", longUrl);

		try {
			HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
			JSONObject jsonObject = JSONObject.parseObject(EntityUtils.toString(response.getEntity()));
			String status = jsonObject.get("status").toString();
			if(successCode.equals(status)){
				String msg = jsonObject.get("msg").toString();
				logger.debug("阿里短连接服务---短连接：{}", msg);
				shortUrl = msg;
			}else {
				logger.debug("阿里短连接服务---未正常响应：{}", status);
				return longUrl;
			}
		} catch (Exception e) {
			logger.error("阿里短连接服务---发送请求出现异常:{}", e.toString());
			return longUrl;
		}
		return shortUrl;
	}

	@Override
	public String mrwShortUrlService(String longUrl) {
		logger.debug("MRW短链接服务---长连接：{}", longUrl);
		if (StringUtils.isEmpty(longUrl)) {
			return longUrl;
		}
		String shortUrl = null;
		//MRW短链接source,类似key
		String source = "5d78b83dd3c3812b2ed2107c@93268121a4edae5853c8155965d306fa";
		//MRW短链接服务地址
		String api ="http://mrw.so/api.php?format=json&url=%s&key=%s";

		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		String method = "GET";
		String url = String.format(api,HttpUtils.getUrlEncode(longUrl),source);
		try {
			HttpResponse response = HttpUtils.doGet(url,null,method,headers,null);
			JSONObject jsonObject = JSONObject.parseObject(EntityUtils.toString(response.getEntity()));
			String err = jsonObject.get("err").toString();
			if("".equals(err)){
				String msg = jsonObject.get("url").toString();
				logger.debug("MRW短链接服务---短连接：{}", msg);
				shortUrl = msg;
			}else{
				logger.debug("MRW短链接服务---未正常响应：{}", err);
				return longUrl;
			}
		} catch (Exception e) {
			logger.error("MRW短链接服务---发送请求出现异常:{}", e.toString());
			return longUrl;
		}
		return shortUrl;
	}

	@Override
	public String sineShortUrlService(String longUrl) {
		//TODO
		return longUrl;
	}

	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {

		String longUrl = "https://tui.buyforyou.cn/aipc-be/merchandiseCoupon/merchandiseCoupon.html?{\"companyId\":\"c046a039d2d14a23bcd67e5951f87065\",\"distinguish\":\"WHYH01\",\"merchantId\":\"cf0f78a37f2644999ef1c90c7f7065e5\",\"productIds\":\"a7108a014f874e1ba25febc336049b3d,\",\"modelId\":\"dc0622aa94da40d6bc6c9c80a47fa97a\",\"appid\":\"wx3907e2ad6ece7793\",\"customerId\":\"620375410966003712\",\"type\":\"1\"}";
		String s = new ShortUrlServiceImpl().mrwShortUrlService(longUrl);
		System.out.println(s);

	}

}
