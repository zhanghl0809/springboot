package com.example.Utiles.shortUrl;

/**
 * 短连接服务接口
 * @author zhl
 */
public interface ShortUrlService {
	/**
	 * 阿里短连接服务
	 */
	String aliShortUrlService(String longUrl);
	/**
	 * wrm短连接服务
	 */
	String mrwShortUrlService(String longUrl);
	/**
	 * 新浪短连接服务
	 */
	String sineShortUrlService(String longUrl);
}
