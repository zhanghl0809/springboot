package com.example.Utiles;

import com.example.common.shortUrl.impl.ShortUrlServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class ShortUrlUtils {
	@Autowired
	private static ShortUrlServiceImpl shortUrlService;

	/**
	 *
	 * @param long_url
	 * @return
	 */
	public static String convertShortUrl(String long_url) {
		String shortUrl = shortUrlService.mrwShortUrlService(long_url);
		return shortUrl;
	}

	public static void main(String[] args) {
		String longUrl = "https://tui.buyforyou.cn/aipc-be/merchandiseCoupon/merchandiseCoupon.html?{\"companyId\":\"c046a039d2d14a23bcd67e5951f87065\",\"distinguish\":\"WHYH01\",\"merchantId\":\"cf0f78a37f2644999ef1c90c7f7065e5\",\"productIds\":\"a7108a014f874e1ba25febc336049b3d,\",\"modelId\":\"dc0622aa94da40d6bc6c9c80a47fa97a\",\"appid\":\"wx3907e2ad6ece7793\",\"customerId\":\"620375410966003712\",\"type\":\"1\"}";
		System.out.println(	convertShortUrl(longUrl));
	}
}
