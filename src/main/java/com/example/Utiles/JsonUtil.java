/*
 * Copyright 2014-2018 buyforyou.cn. All rights reserved.
 */
package com.example.Utiles;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * 
 * @author zhl
 * @since 1.8
 */
public class JsonUtil {

	private static final ObjectMapper mapper = new ObjectMapper();

	/**
	 * 格式化json  object to  json
	 * 
	 * @param obj
	 * @return
	 */
	public static String formatJson(Object obj) {

		try {
			return mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * json to object
	 * 
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static <T> T parseJson(String json, Class<T> clazz) {
		try {
			return mapper.readValue(json, clazz);
		} catch (IOException e) {

			throw new RuntimeException(e);
		}
	}
}
