package com.example.checker.sensitive.annotation;

import java.lang.annotation.*;

/**
 * @author zhl
 * 用于 请求Controller 除请求头参数外的参数 性敏感词过滤注解
 * @date 2019-10-12
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface SensitiveWordsFilter {
}
