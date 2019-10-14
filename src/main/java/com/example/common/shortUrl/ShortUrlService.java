package com.example.common.shortUrl;

/**
 * 短连接服务接口
 * @author zhl
 * @date 2019-09-12
 */
public interface ShortUrlService {
	/**
	 * 阿里短连接服务
	 * @param longUrl
	 * @return
	 */
	String aliShortUrlService(String longUrl);
	/**
	 * wrm短连接服务
	 * @param longUrl
	 * @return
	 */
	String mrwShortUrlService(String longUrl);
	/**
	 * 新浪短连接服务
	 * @param longUrl
	 * @return
	 */
	String sineShortUrlService(String longUrl);
}
