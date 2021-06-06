package com.example.checker.sensitive.constraint;

import cn.hutool.dfa.WordTree;
import com.alibaba.fastjson.JSON;
import com.example.utiles.JsonUtil;
import com.example.common.Const;
import com.example.common.RspCommon;
import com.example.exception.SensitiveBindException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * SensitiveWordsFilterAspect class
 *
 * @author zhl
 * @date
 */
@Component
@Aspect
public class SensitiveWordsFilterAspect {
	private Logger logger = LoggerFactory.getLogger(getClass());
	private static WordTree tree = new WordTree();
//	@Autowired private SensitiveWordMapper sensitiveWordMapper;

	@Pointcut("@annotation(com.example.checker.sensitive.annotation.SensitiveWordsFilter)")
	private void sensitiveWordsFilter() {

	}

	/**
	 * 定制一个环绕通知
	 *
	 * @param joinPoint
	 */
	@Around("sensitiveWordsFilter()")
	public Object advice(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("AROUND~~~~~~~~~~~~~~~~~~~~");
		logger.debug("敏感词环绕通知开始-Around Begin");
		//查询敏感词
//		if (tree.size() == 0) {
//			List<String> list = sensitiveWordMapper.getList();
//			for (String word : list) {
//				tree.addWord(word);
//			}
//		}

		//logger.debug("敏感词环绕通知结束-Around End");
		System.out.println("敏感词---AOP配置");
		Object result = null;
		Signature signature = joinPoint.getSignature();
		// 方法名
		String methodName = signature.getName();
		// 类名
		String serviceName = signature.getDeclaringTypeName();
		// 参数名数组
		String[] parameterNames = ((MethodSignature) signature).getParameterNames();
		// 构造参数组集合
		List<Object> argList = new ArrayList<>();
		for (Object arg : joinPoint.getArgs()) {
			if (arg instanceof HttpServletRequest) {
				argList.add("request");
			} else if (arg instanceof HttpServletResponse) {
				argList.add("response");
			} else {
				argList.add(JSON.toJSON(arg));
			}
		}
		logger.debug("{} -> 方法({}) -> 参数:{} - {}", serviceName, methodName, JSON.toJSON(parameterNames),
				JSON.toJSON(argList));
		//net.sf.json.JSONObject 依赖的json处理
		JSONArray array = JSONArray.fromObject(JSON.toJSON(argList));
		for (int i = 0; i < array.size(); i++) {
			JSONObject job = array.getJSONObject(i);
			Iterator iterator = job.keys();
			while (iterator.hasNext()) {
				String key = (String) iterator.next();
				if (!"deviceType".equals(key) && !"tradeTime".equals(key) && !"distinguish".equals(key)
						&& !"identity".equals(key) && !"appid".equals(key)) {
					String value = job.getString(key);
					//						List<String> matchAll = tree.matchAll(value, -1, false, false);
					if(value.toString().contains("4")){
						logger.debug("存在的敏感词>>>>>>>>>>>>>>:{}", value.toString());
						throw new SensitiveBindException(Const.ERR_CODE, Const.SENSITIVE_EXCEPTION_PROMPTING_LANGUAGE);
					}
				}
			}
		}
		//执行到这里开始走进来的方法体（必须声明）
		Object rspBody = joinPoint.proceed();
		RspCommon rsp = new RspCommon();
		logger.debug("{}.{} 业务响应报文RspBody value:{}", new Object[] { serviceName, methodName, JsonUtil.formatJson(rsp) });
		return rspBody;
	}

	/**
	 * 当想获得注解里面的属性，可以直接注入改注解
	 * 方法可以带参数，可以同时设置多个方法用
	 *
	 * @param joinPoint
	 */
	@Before("sensitiveWordsFilter()")
	public void record(JoinPoint joinPoint) throws Exception {
		System.out.println("BEFORE~~~~~~~~~~~~");
	}

	@After("sensitiveWordsFilter()")
	public void after() {
		System.out.println("AFTER~~~~~~~~~~~~~~");
		logger.debug("敏感词切面-After");
	}
}
