package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

public class MrwShortUrlUtil {


	public static void main(String[] args) {
		String longUrl = "https://tui.buyforyou.cn/aipc-be/merchandiseCoupon/merchandiseCoupon.html?{\"companyId\":\"c046a039d2d14a23bcd67e5951f87065\",\"distinguish\":\"WHYH01\",\"merchantId\":\"cf0f78a37f2644999ef1c90c7f7065e5\",\"productIds\":\"a7108a014f874e1ba25febc336049b3d,\",\"modelId\":\"dc0622aa94da40d6bc6c9c80a47fa97a\",\"appid\":\"wx3907e2ad6ece7793\",\"customerId\":\"620375410966003712\",\"type\":\"1\"}";

		String host = "https://short.market.alicloudapi.com";
		String path = "/short";
		String method = "POST";
		String appcode = "2c1700809b3b432ba6fa67438975146a";
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
			if("200".equals(status)){
				String msg = jsonObject.get("msg").toString();
				System.out.println("短连接："+msg);
			}else {
				System.out.println("未正常响应。。。。。。。。。。。。。");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
