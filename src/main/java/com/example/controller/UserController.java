package com.example.controller;

import com.example.base.BaseAppletController;
import com.example.Utiles.shortUrl.ShortUrlService;
import com.example.common.vo.T1Vo;
import com.example.entity.User;
import com.example.service.UserService;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import lombok.extern.slf4j.Slf4j;


/**
 *
 * 测试
 *
 */
@Slf4j
@RestController
@RequestMapping("/V1.0.0")
public class UserController extends BaseAppletController {


	@Autowired private UserService userService;


	@PostMapping(value = "/t1")
	public Object test1(T1Vo vo) throws Exception {
		User sel = userService.Sel(1);
		logger.debug("测试>>>>>>>>>>>>>>:{}",vo.getStr());
		return sel;
	}

	@PostMapping("/t2")
	public Object test2 (T1Vo vo)throws Exception {
		ArrayList<Object> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add("f");
		return list;
	}


	@PostMapping("/t3")
	public Object test3(T1Vo vo) throws Exception{
		List<HashMap<String, String>> list = new ArrayList<>();
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < 5; i++) {
			map.put("name","AAAAA");
			map.put("age","19");
			list.add(map);
		}
		return list;
	}

	/**
	 * 重定向 跳转
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/t4")
	public ModelAndView test4(T1Vo vo) throws Exception{
		return  new ModelAndView(new RedirectView("http://www.baidu.com"));
	}
}
