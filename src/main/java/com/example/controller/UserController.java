package com.example.controller;

import com.example.base.BaseAppletController;
import com.example.common.vo.RedisVo;
import com.example.common.vo.T1Vo;
import com.example.common.vo.UserSaveVo;
import com.example.entity.User;
import com.example.service.MythreadService;
import com.example.service.UserService;
import com.example.utiles.RedisUtil;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

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

	private static int ExpireTime = 60;   // redis中存储的过期时间60s

	@Autowired
	private UserService userService;

	@Autowired
	private MythreadService mythreadService;

	@Autowired
	private RedisUtil redisUtil;


	@PostMapping(value = "/save")
	public Object save(UserSaveVo vo) throws Exception {
		User user = new User();
		BeanUtils.copyProperties(vo,user);
		userService.saveUser(user);

		return "保存成功";
	}


	@PostMapping(value = "/incr")
	public Object incr() throws Exception {

		userService.incr();

		return "操作成功";
	}

	@PostMapping(value = "/incrIp")
	public Object incrIp() throws Exception {

		userService.incrIp();

		return "操作成功";
	}

	@PostMapping(value = "/redisList")
	public Object redisList() throws Exception {

		userService.redisList();

		return "操作成功";
	}

	@PostMapping(value = "/removeListOneValue")
	public Object removeListOneValue() throws Exception {

		userService.removeListOneValue();

		return "操作成功";
	}


	@PostMapping(value = "/hash")
	public Object hash() throws Exception {

		userService.hash();

		return "操作成功";
	}


































	@PostMapping(value = "/queryAll")
	public Object queryAll() throws Exception {
		List<User> users = userService.queryAllUser();
		logger.debug("---用户查询成功---");
		return users;
	}

	@PostMapping(value = "/queryById")
	public Object queryById(T1Vo vo) throws Exception {
		logger.debug("测试>>>>>>>>>>>>>>:{}",vo.getId());
		User sel = userService.Sel(Integer.parseInt(vo.getId()));
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
		return new ModelAndView(new RedirectView("http://www.baidu.com"));
	}

	/**
	 * redis测试
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/set")
	public Object test5(RedisVo vo) throws Exception{

		mythreadService.add();
		// String key = vo.getKey();
		// String value = String.format("%s我是redis的value", key);
		// return redisUtil.set(key,value);

		return null;
	}


	/**
	 * redis测试
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/get")
	public Object test6(RedisVo vo) throws Exception{
		String key = vo.getKey();
		String o = redisUtil.get(key).toString();
		logger.debug("----key:{}:的值是：{}",key,o);
		return o;
	}


	/**
	 * redis 过期存储
	 * @param vo
	 * @return
	 */
	@PostMapping("/expire")
	public Object expire(RedisVo vo)throws Exception{
		String key = vo.getKey();
		logger.debug("redis 设置过期的时间的key：{}",key);
		return redisUtil.expire(key,ExpireTime);
	}
}
