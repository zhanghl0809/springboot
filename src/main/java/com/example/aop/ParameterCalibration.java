/*
 * Copyright 2014-2018 buyforyou.cn. All rights reserved.
 */
package com.example.aop;

import com.example.utiles.JsonUtil;
import com.example.utiles.ReflectionUtils;
import com.example.base.BaseLogger;
import com.example.checker.EnumType;
import com.example.checker.NumberType;
import com.example.checker.TextType;
import com.example.common.RspCommon;
import com.example.exception.BizException;

import org.apache.logging.log4j.core.util.Assert;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import cn.hutool.core.util.IdUtil;

/**
 * 参数校验AOP
 *
 */
@Aspect
@Component
@Order(1)
public class ParameterCalibration extends BaseLogger {

    private static final String ENCODING = "UTF-8";
    private static Logger logger = LoggerFactory.getLogger(ParameterCalibration.class);


    /**
     * AOP 拦截所有controller
     */

    @Pointcut("execution(public * com.example.controller..*.*(..)) ")
    public void pointCut() {
    }

    @SuppressWarnings("unchecked")
    @Around("pointCut()")
    public Object parameterCalibration(ProceedingJoinPoint pjp) throws Throwable {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String hostAddress = InetAddress.getLocalHost().getHostAddress();

        StopWatch stopwatch = new StopWatch("pjp");
        stopwatch.start();

        Class<?> classTarget = pjp.getTarget().getClass();
        Class<?>[] par = ((MethodSignature) pjp.getSignature()).getParameterTypes();
        Method method = classTarget.getMethod(pjp.getSignature().getName(), par);//拦截方法
        String methodName = method.getName();
        String className = classTarget.getName(); // 拦截类完整名称

        //准备方法注解
        String interfaceName = interfaceName(method);

        Object[] args = pjp.getArgs();// Returns the arguments at this join point.
        StringBuffer params = new StringBuffer();
        Map<String, String> resultMap = new HashMap<String, String>();
        for (Object object : args) {
            Object obj = object;
            params.append(JsonUtil.formatJson(obj));
            resultMap = checking(obj);
        }
        String logId = IdUtil.fastSimpleUUID();

        //参数非空执行
        if (!Assert.isEmpty(params)) {
            Map<String, String> reqMap = JsonUtil.parseJson(params.toString(), Map.class);

            if (reqMap.containsKey("password") || reqMap.containsKey("pwd")) {
                Map<String, String> map = new HashMap<>();
                map.putAll(reqMap);
                map.put("password", "******");
                logger.info("{}||{}||Request ||-{}-||{}", hostAddress, logId, interfaceName,JsonUtil.formatJson(map));
            } else {
                logger.info("{}||{}||Request ||-{}-||{}", hostAddress, logId, interfaceName,JsonUtil.formatJson(reqMap));
            }

            if ("true".equals(resultMap.get("paramError"))) {
                throw new BizException(String.format("{%s},参数格式错误！", resultMap.get("errorField")));
            }
        }else{
            logger.info("{}||{}||Request ||-{}-||{}", hostAddress, logId, interfaceName,"无请求body");
        }

        // businessCheck(reqMap);

        Object rspBody = pjp.proceed();
        RspCommon rsp = new RspCommon();
        if (!Assert.isEmpty(rspBody)) {
            rsp.setRspBody(rspBody);
        }
        stopwatch.stop();
        logger.info("{}||{}||Response||{}||-{}-||{}ms", hostAddress, logId, interfaceName,JsonUtil.formatJson(rsp),stopwatch.getTotalTimeMillis());
        return rsp;
    }


    /**
     * Parameter business check
     */
    private void businessCheck(Map<String, String> reqMap) throws Exception {

    }

    /**
     * 参数校验
     *
     * @param obj
     * @return
     * @description 校验参数是否符合该参数所属注解
     */
    private Map<String, String> checking(Object obj) throws Exception {

        Map<String, String> resultMap = new HashMap<String, String>();

        Field[] fields = ReflectionUtils.getDeclaredField(obj);

        annotationCalibration(resultMap, fields, obj);

        return resultMap;
    }

    /**
     *
     * 方法名称获取
     *
     * @param method
     * @return
     */
    private String interfaceName(Method method){
        String interfaceName = "";
        if (method.isAnnotationPresent(RequestMapping.class)) {
            RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
            String values[] = requestMapping.value();
            interfaceName = values[0];
        }
        if(method.isAnnotationPresent(PostMapping.class)){
            PostMapping PostMapping = method.getAnnotation(PostMapping.class);
            String values[] = PostMapping.value();
            interfaceName = values[0];
        }
        if(method.isAnnotationPresent(GetMapping.class)){
            GetMapping GetMapping = method.getAnnotation(GetMapping.class);
            String values[] = GetMapping.value();
            interfaceName = values[0];
        }
        return interfaceName;
    }
    /**
     * 字段校验
     *
     * @param resultMap
     * @param fields
     * @param obj
     * @throws Exception
     */
    private void annotationCalibration(Map<String, String> resultMap, Field[] fields, Object obj) throws Exception {
        for (Field field : fields) {
            String filedName = field.getName();// 获得参数名称
            Object singleParam = ReflectionUtils.getInvoke(obj, filedName, false);

            // notNull校验
            if (field.isAnnotationPresent(NotNull.class)) {
                if (singleParam == null || "".equals(singleParam)) {
                    logger.debug(filedName + " cannot be null");
                    resultMap.put("paramError", "true");
                    resultMap.put("errorField", filedName);
                    break;
                }
            }

            if (field.isAnnotationPresent(TextType.class)) {

                TextType textType = field.getAnnotation(TextType.class);
                boolean notNull = textType.notNull();

                if (notNull) {
                    if (singleParam == null || "".equals(singleParam)) {
                        logger.debug(filedName + " cannot be empty");
                        resultMap.put("paramError", "true");
                        resultMap.put("errorField", filedName);
                        break;
                    }
                }

                if (singleParam != null && !"".equals(singleParam)) {
                    int max = textType.maxLength();
                    int min = textType.minLength();
                    if (singleParam.toString().getBytes(ENCODING).length < min) {
                        logger.debug(filedName + " minLength is [" + min + "], but input [" + singleParam.toString().length() + "]");
                        resultMap.put("paramError", "true");
                        resultMap.put("errorField", filedName);
                        break;
                    } else if (singleParam.toString().getBytes(ENCODING).length > max) {
                        logger.debug(filedName + " maxLength is [" + max + "], but input [" + singleParam.toString().length() + "]");
                        resultMap.put("paramError", "true");
                        resultMap.put("errorField", filedName);
                        break;
                    }
                }
            }

            if (field.isAnnotationPresent(EnumType.class)) {
                EnumType enumType = field.getAnnotation(EnumType.class);
                boolean notNull = enumType.notNull();
                if (notNull) {
                    if (singleParam == null || "".equals(singleParam)) {
                        logger.debug(filedName + " cannot be empty");
                        resultMap.put("paramError", "true");
                        resultMap.put("errorField", filedName);
                        break;
                    }
                }
                if (singleParam != null && !"".equals(singleParam)) {
                    String[] allows = enumType.allows();
                    Arrays.sort(allows);
                    int index = Arrays.binarySearch(allows, singleParam.toString());
                    if (index < 0) {
                        logger.debug(filedName + " must in [" + Arrays.toString(allows) + "], but input [" + singleParam.toString() + "] is not in");
                        resultMap.put("paramError", "true");
                        resultMap.put("errorField", filedName);
                        break;
                    }
                }
            }

            if (field.isAnnotationPresent(NumberType.class)) {
                NumberType numberType = field.getAnnotation(NumberType.class);
                boolean notNull = numberType.notNull();
                if (notNull) {
                    if (singleParam == null || "".equals(singleParam)) {
                        logger.debug(filedName + " cannot be empty");
                        resultMap.put("paramError", "true");
                        resultMap.put("errorField", filedName);
                        break;
                    }
                }
                if (singleParam != null && !"".equals(singleParam)) {
                    int length = numberType.length();
                    Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
                    // Pattern pattern =
                    // Pattern.compile("^[-\\+]?(([1-9][0-9]*)|(([0]\\.\\d{1,2}|[1-9][0-9]*\\.\\d{1,2})))$");
                    if (!pattern.matcher(singleParam.toString()).matches() || singleParam.toString().length() > length) {
                        resultMap.put("paramError", "true");
                        resultMap.put("errorField", filedName);
                        break;
                    }
                }
            }

        }
    }

}
