package com.example.checker.sensitive.annotation;



import com.example.common.Const;
import com.example.checker.sensitive.constraint.SensitiveValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author zhl
 * 用于 请求VO 单一属性敏感词过滤注解。
 * 1.在vo实体类每个属性上添加。
 * 2.在controller的方法参数中添加 @Valid。
 * 例：
 * @RequestMapping("/CL***")
 * 	public Object supportDrop(@Valid SupportDropVo vo) throws Exception {
 * 		return addressService.supportDrop(vo);
 * 	}
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SensitiveValidator.class)
public @interface Sensitive {
	//强制校验
	boolean required() default true;
	//自定义错误消息的内容
	String message() default Const.SENSITIVE_EXCEPTION_PROMPTING_LANGUAGE;
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
