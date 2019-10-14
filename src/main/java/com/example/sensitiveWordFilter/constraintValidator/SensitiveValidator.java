package com.example.sensitiveWordFilter.constraintValidator;


import cn.hutool.dfa.WordTree;
import com.example.sensitiveWordFilter.annotation.Sensitive;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

/**
 * @author zhl
 * 校验器
 */
@Component public class SensitiveValidator implements ConstraintValidator<Sensitive, Object> {
	private Logger logger = LoggerFactory.getLogger(getClass());
	private boolean require = false;
	private static WordTree tree = new WordTree();
//	@Autowired private SensitiveWordMapper sensitiveWordMapper;

	//初始化
	@Override public void initialize(Sensitive constraintAnnotation) {
		require = constraintAnnotation.required();
	}

	@Override public boolean isValid(Object value, ConstraintValidatorContext context) {
		if (value != null && !"".equals(value)) {
//			if (tree.size() == 0) {
//				List<String> list = sensitiveWordMapper.getList();
//				for (String word : list) {
//					tree.addWord(word);
//				}
//			}
//			List<String> matchAll = tree.matchAll(value.toString(), -1, false, false);
//			if (matchAll.size() > 0) {
//				logger.debug("存在的敏感词>>>>>>>>>>>>>>:{}", matchAll.toString());
//				return false;
//			}
			if(value.toString().contains("4")){
				logger.debug("存在的敏感词>>>>>>>>>>>>>>:{}", value.toString());
				return false;
			}
		}
		return true;
	}
}
