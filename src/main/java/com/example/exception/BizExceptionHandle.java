/*
 * Copyright 2014-2018 buyforyou.cn. All rights reserved.
 */
package com.example.exception;


import com.example.base.BaseLogger;
import com.example.common.Const;
import com.example.common.RspCommon;
import org.apache.commons.lang.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 统一异常处理
 * 
 * @author zhl
 * @since 1.8
 * 修改原因：配合敏感词过滤，取消打印异常的堆栈信息 e.printStackTrace(),
 * 			其他异常需要手动增加堆栈信息的打印；
 * 			新增两种异常捕获（BindException，SensitiveBindException）。
 * 修改时间：2019-10-10
 * 修改人：zhl
 * 修改版本：8.4
 */
@ControllerAdvice
public class BizExceptionHandle extends BaseLogger {

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public RspCommon defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception {
//		e.printStackTrace();
		RspCommon rsp = new RspCommon();
		if (e instanceof BizException) {
			logger.error("业务异常 :{} ", e.getMessage());
			rsp.getRspHead().setMessage(e.getMessage());
			String messageCode = ((BizException) e).getMessageCode();
			e.printStackTrace();
			if (StringUtils.isNotEmpty(messageCode)) {
				rsp.getRspHead().setStatus(((BizException) e).getMessageCode());
			}
			// 单一参数敏感词过滤，自定义注解起作用时的异常，BindException
		} else if (e instanceof BindException) {
			BindException ex = (BindException)e;
			List<ObjectError> errors = ex.getAllErrors();
			ObjectError error = errors.get(0);
			String msg = error.getDefaultMessage();
			logger.error("请求参数存在敏感词");
			rsp.getRspHead().setStatus(Const.ERR_CODE);
			rsp.getRspHead().setMessage(msg);
			// 自定义敏感词异常SensitiveBindException
		} else if (e instanceof SensitiveBindException) {
			logger.error("请求参数存在敏感词");
			rsp.getRspHead().setMessage(e.getMessage());
		}else {
			e.printStackTrace();
			logger.error("系统异常：", e);
			rsp.getRspHead().setMessage("系统异常");
		}
		if (Const.NORMAL_CODE.equals(rsp.getRspHead().getStatus())) {
			rsp.getRspHead().setStatus(Const.ERR_CODE);
		}
		return rsp;
	}

}
