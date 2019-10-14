package com.example.base;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;

public abstract class BaseAppletController extends BaseLogger implements InitializingBean {

	@Override
	public void afterPropertiesSet() throws Exception {

	}

	/**
	 * 获取基于应用程序的url绝对路径
	 *
	 * @param request
	 * @param url 以"/"打头的URL地址
	 * @return 基于应用程序的url绝对路径
	 */
	protected final String getAppbaseUrl(HttpServletRequest request, String url) {
		Assert.hasLength(url, "url不能为空");
		Assert.isTrue(url.startsWith("/"), "必须以/打头");
		return request.getContextPath() + url;
	}
}
