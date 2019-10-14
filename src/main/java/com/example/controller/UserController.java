package com.example.controller;

import com.example.base.BaseAppletController;
import com.example.common.shortUrl.ShortUrlService;
import com.example.entity.User;
import com.example.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @Author:0xOO
 * @Date: 2018/9/26 0026
 * @Time: 14:42
 */

@RestController
@RequestMapping("/V1.0.0")
public class UserController extends BaseAppletController {
	public Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired private UserService userService;
	@Autowired private ShortUrlService shortUrlService;
	@Autowired private com.example.service.ShortUrlBaseService shortUrlBaseService;
	@RequestMapping(value = "/001",method = RequestMethod.GET)
	public String GetUser(@Param("longUrl") String longUrl) throws Exception{
		logger.debug("长连接>>>>：{}",longUrl);
		String shortUrl = shortUrlService.mrwShortUrlService(longUrl);
		User user = userService.Sel(1);
		logger.debug("短连接>>>>：{}",shortUrl);
		return shortUrl;
	}


	@RequestMapping(value = "/002",method = RequestMethod.GET)
	public ModelAndView GetUser1(@Param("shortUrl") String shortUrl) throws Exception{
		logger.debug("短连接>>>>：{}",shortUrl);
		return  new ModelAndView(new RedirectView("http://www.baidu.com"));
	}
}
