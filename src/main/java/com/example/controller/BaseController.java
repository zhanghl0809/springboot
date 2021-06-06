package com.example.controller;

import com.example.base.BaseAppletController;
import com.example.entity.Student;
import com.example.entity.User;
import com.example.checker.sensitive.annotation.SensitiveWordsFilter;
import com.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;


@RestController
@RequestMapping("/V1")
public class BaseController extends BaseAppletController {
    public Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping(value = "/{shortUrl}", method = RequestMethod.GET)
    public ModelAndView GetUser1(@PathVariable String shortUrl) throws Exception {
        logger.debug("短连接>>>>：{}", shortUrl);
        return new ModelAndView(new RedirectView("http://www.baidu.com"));
    }


    // /**
    //  *
    //  * @param student
    //  * @return
    //  * @throws Exception
    //  */
    // @PostMapping("/student")
    // @SensitiveWordsFilter
    // public Object addStudent(Student student) throws Exception{
    //     User user = userService.Sel(1);
    //     return "Student Created";
    // }

    /**
     *
     * @param student
     * @return
     * @throws Exception
     */
    @PostMapping("/student")
    @SensitiveWordsFilter
    public Object redisLockTest(Student student) throws Exception{
        stringRedisTemplate.opsForValue().set("111", "1", 30, TimeUnit.SECONDS);
        User user = userService.Sel(1);
        return "Student Created";
    }

}
