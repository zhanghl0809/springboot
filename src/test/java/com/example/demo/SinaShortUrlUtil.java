///*
// * Copyright 2014-2019 buyforyou.cn.
// * All rights reserved.
// */
//package com.example.demo;
//
//import com.alibaba.fastjson.JSONObject;
//import org.apache.commons.lang.StringUtils;
//import org.apache.http.HttpStatus;
//import org.apache.http.client.HttpClient;
//import org.hibernate.validator.internal.util.privilegedactions.GetMethod;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//
///**
// * 短链接服务MRW
// *
// * @author zhl
// * @since 8.2.0
// * 修改日志：
// * 1.因新浪不可用，改为 mrw 短连接。保留原接口 定义。
// * 2019-09-11
// */
//public class SinaShortUrlUtil {
//
//	public static void main(String[] args) throws Exception {
//
//		String url = "https://m.buyforyou.cn/web/index.html?c=V_LPpTqPxK";
//		String shorturl = convertShortUrl(url);
//		System.out.println("http转码："+shorturl);
//	}
//
//	/**
//	 * 日志工具
//	 */
//	private static final Logger logger = LoggerFactory.getLogger(SinaShortUrlUtil.class);
//
//	/**
//	 * sina appkey
//	 */
//	private static final String MRW_SOURCE = "5d78b83dd3c3812b2ed2107c@93268121a4edae5853c8155965d306fa";
//	//private static final String SINA_SOURCE = Global.getConfig("sina.api.source");
//	/**
//	 * MRW短链接服务地址
//	 */
//	private static final String MRW_API ="http://mrw.so/api.php?format=json&url=%s&key=%s";
//	/**
//	 * 长链接转换短链接
//	 *
//	 * @param long_url
//	 * @return
//	 * @throws Exception
//	 */
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	public static String convertShortUrl(String long_url) {
//
//		if (StringUtils.isEmpty(long_url)) {
//			return long_url;
//		}
//		//需要转长连接编码 urlencode
//		String uri = HttpUtils.getUrlEncode(long_url);
//		String url = String.format(MRW_API, uri,MRW_SOURCE);
//
//		Rsp rsp = get(url);
//
//		if (rsp.getCode() == 200) {
//			JSONObject jsonObject = JSONObject.parseObject(rsp.msg);
//			String mrwUrl = jsonObject.get("url").toString();
//			return mrwUrl;
//		} else {
//			return long_url;
//		}
//
//	}
//
//	/**
//	 * 发送get请求to sina
//	 *
//	 * @param url
//	 * @return
//	 */
//	private static Rsp get(String url) {
//
//		HttpClient client = new HttpClient();
//
//		// 设置在http头的Content-Type的字符编码
//		client.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
//		client.getHttpConnectionManager().getParams().setConnectionTimeout(60000);// 设置连接超时时间一分钟
//		client.getHttpConnectionManager().getParams().setSoTimeout(60000);// 设置读取响应时间一分钟
//
//		GetMethod method = new GetMethod(url);
//
//		String str = "";
//		int rspCode;
//		InputStream inputStream = null;
//		BufferedReader br = null;
//		StringBuffer stringBuffer = new StringBuffer();
//		try {
//			logger.debug("请求MRW短链接服务，GET: [" + url + "]");
//			// 获取响应码 HttpStatus.SC_OK=200
//			rspCode = client.executeMethod(method);
//			// 获取响应信息
//			// response = method.getResponseBodyAsString();
//			inputStream = method.getResponseBodyAsStream();
//			br = new BufferedReader(new InputStreamReader(inputStream));
//
//			while ((str = br.readLine()) != null) {
//				stringBuffer.append(str);
//			}
//
//			if (HttpStatus.SC_OK != rspCode) {// 200响应成功
//				logger.debug("请求MRW短链接服务，响应码：" + rspCode);
//			}
//			logger.debug("请求MRW短链接服务，RESPONSE: " + stringBuffer.toString());
//			return new SinaShortUrlUtil().new Rsp(rspCode, stringBuffer.toString());
//		} catch (Exception e) {
//			logger.debug("发送get请求出现异常", e);
//			return new SinaShortUrlUtil().new Rsp(500, "发送get请求出现异常");
//		} finally {
//			method.releaseConnection();// 关闭连接
//			try {
//				if (br != null)
//					br.close();
//			} catch (IOException e) {
//				logger.debug("发送get请求出现异常", e);
//			}
//		}
//	}
//
//	/**
//	 * 响应信息
//	 *
//	 * @author Fan.W
//	 * @since 1.8
//	 */
//	class Rsp {
//		/**
//		 * @param code
//		 * @param msg
//		 */
//		public Rsp(int code, String msg) {
//			super();
//			this.code = code;
//			this.msg = msg;
//		}
//
//		private int code;
//		private String msg;
//
//		/**
//		 * @return the code
//		 */
//		public int getCode() {
//			return code;
//		}
//
//		/**
//		 * @param code the code to set
//		 */
//		public void setCode(int code) {
//			this.code = code;
//		}
//
//		/**
//		 * @return the msg
//		 */
//		public String getMsg() {
//			return msg;
//		}
//
//		/**
//		 * @param msg the msg to set
//		 */
//		public void setMsg(String msg) {
//			this.msg = msg;
//		}
//	}
//}
