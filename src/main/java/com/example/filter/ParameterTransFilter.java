package com.example.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

//@WebFilter(filterName="intefaceFilter",urlPatterns = {"/V1.0.0/*","/V3.0.0/*"})
@Component
@WebFilter(filterName="intefaceFilter",urlPatterns = {"/V1"})
public class ParameterTransFilter implements Filter {

	private Logger logger = LoggerFactory.getLogger(ParameterTransFilter.class);

	ObjectMapper mapper = new ObjectMapper();

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("拦截器进入========拦截器进入========");
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("-------------------------------");
		HttpServletRequest request = (HttpServletRequest) req;
		String requestURI = request.getRequestURI();
		HashMap m = new HashMap();
		Map<String, Object> reqMap = null;
		try {
			reqMap = mapper.readValue(request.getInputStream(), HashMap.class);
			m.putAll((Map) reqMap.get("reqHead"));
			m.putAll((Map) reqMap.get("reqBody"));
		} catch (Exception e) {
			logger.error("{}传输报文格式异常..", new Object[] { requestURI }, e);
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("传输报文格式异常");
			out.flush();
			out.close();
			return;
		}

		ParameterRequestWrapper wrapRequest = new ParameterRequestWrapper(request, m);
		chain.doFilter(wrapRequest, response);
	}

	@Override
	public void destroy() {
		System.out.println("拦截器销毁========拦截器销毁========");
	}

}
