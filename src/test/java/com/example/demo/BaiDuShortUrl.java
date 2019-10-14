package com.example.demo;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;



public class  BaiDuShortUrl{
	final static String CREATE_API = "https://dwz.cn/admin/v2/create";
	final static String TOKEN = "f37aba735ba55a6951d883b863717cbc"; // TODO:设置Token

	class UrlResponse {
		@SerializedName("Code")
		private int code;

		@SerializedName("ErrMsg")
		private String errMsg;

		@SerializedName("LongUrl")
		private String longUrl;

		@SerializedName("ShortUrl")
		private String shortUrl;

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getErrMsg() {
			return errMsg;
		}

		public void setErrMsg(String errMsg) {
			this.errMsg = errMsg;
		}

		public String getLongUrl() {
			return longUrl;
		}

		public void setLongUrl(String longUrl) {
			this.longUrl = longUrl;
		}

		public String getShortUrl() {
			return shortUrl;
		}

		public void setShortUrl(String shortUrl) {
			this.shortUrl = shortUrl;
		}
	}

	/**
	 * 创建短网址
	 *
	 * @param longUrl
	 *            长网址：即原网址
	 *        termOfValidity
	 *            有效期：默认值为long-term
	 * @return  成功：短网址
	 *          失败：返回空字符串
	 */
	public static String createShortUrl(String longUrl, String termOfValidity) {
		String params = "{\"Url\":\""+ longUrl + "\",\"TermOfValidity\":\""+ termOfValidity + "\"}";

		BufferedReader reader = null;
		try {
			// 创建连接
			URL url = new URL(CREATE_API);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			connection.setRequestMethod("POST"); // 设置请求方式
			connection.setRequestProperty("Content-Type", "application/json"); // 设置发送数据的格式
			connection.setRequestProperty("Token", TOKEN); // 设置发送数据的格式");

			// 发起请求
			connection.connect();
			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8"); // utf-8编码
			out.append(params);
			out.flush();
			out.close();

			// 读取响应
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			String line;
			String res = "";
			while ((line = reader.readLine()) != null) {
				res += line;
			}
			reader.close();

			// 抽取生成短网址
			UrlResponse urlResponse = new Gson().fromJson(res, UrlResponse.class);
			System.out.println("~~~~~~~~~~~~"+urlResponse.getCode());
			if (urlResponse.getCode() == 0) {
				return urlResponse.getShortUrl();
			} else {
				System.out.println(urlResponse.getErrMsg());
			}

			return "自定义错误信息"+urlResponse.getErrMsg(); // 自定义错误信息
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "自定义错误信息2"; // 自定义错误信息
	}

	public static void main(String[] args) {
//String url="https://tui.buyforyou.cn/aipc-be/merchandiseCoupon/merchandiseCoupon.html?{\"companyId\":\"c046a039d2d14a23bcd67e5951f87065\",\"distinguish\":\"WHYH01\",\"merchantId\":\"cf0f78a37f2644999ef1c90c7f7065e5\",\"productIds\":\"a7108a014f874e1ba25febc336049b3d,\",\"modelId\":\"dc0622aa94da40d6bc6c9c80a47fa97a\",\"appid\":\"wx3907e2ad6ece7793\",\"customerId\":\"615933213491331072\",\"type\":\"1\"}";
//String url="https://tui.buyforyou.cn/aipc-be/merchandiseCoupon/merchandiseCoupon.html?a={\"companyId\":\"c046a039d2d14a23bcd67e5951f87065\",\"distinguish\":\"WHYH01\",\"merchantId\":\"cf0f78a37f2644999ef1c90c7f7065e5\",\"productIds\":\"a7108a014f874e1ba25febc336049b3d,\",\"modelId\":\"dc0622aa94da40d6bc6c9c80a47fa97a\",\"appid\":\"wx3907e2ad6ece7793\",\"customerId\":\"615933213491331072\",\"type\":\"1\"}";
		String url="https://tui.buyforyou.cn/aipc-be/merchandiseCoupon/merchandiseCoupon.html?a=321&b=456";
		String res = createShortUrl(url,"1-year");
		System.out.println(res);

	}

}
