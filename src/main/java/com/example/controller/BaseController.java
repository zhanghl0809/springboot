package com.example.controller;

import com.example.base.BaseAppletController;
import com.example.entity.Student;
import com.example.entity.User;
import com.example.sensitiveWordFilter.annotation.SensitiveWordsFilter;
import com.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

/**
 * @Author:0xOO
 * @Date: 2018/9/26 0026
 * @Time: 14:42
 */

@RestController
@RequestMapping("/V1")
public class BaseController extends BaseAppletController {
    public Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/{shortUrl}", method = RequestMethod.GET)
    public ModelAndView GetUser1(@PathVariable String shortUrl) throws Exception {
        logger.debug("短连接>>>>：{}", shortUrl);
        return new ModelAndView(new RedirectView("http://www.baidu.com"));
    }

    @RequestMapping(value = "/sensitiveWordsFilter")
    public void SensitiveWordsFilter() throws Exception {
        logger.debug("敏感词过滤。。。。。。。。。。。。。。。。。。");

    }

    /**
     *
     * @param student
     * @return
     * @throws Exception
     */
    @PostMapping("/student")
    @SensitiveWordsFilter
    public Object addStudent(@Valid Student student) throws Exception{
//        if (validateResult.hasErrors()) {
//            System.out.println(validateResult.getModel());
//            System.out.println(validateResult.getAllErrors().get(0).getCode());
//            return validateResult.getAllErrors().get(0).getDefaultMessage();
//        }

        User user = userService.Sel(1);
//        System.out.println("student1----->方法体");
        return "Student Created";
    }

    /**
     *
     * @param student
     * @return
     * @throws Exception
     */
    @PostMapping("/student1")
    public Object addStudent1(@Valid Student student) throws Exception{
        //        if (validateResult.hasErrors()) {
        //            System.out.println(validateResult.getModel());
        //            System.out.println(validateResult.getAllErrors().get(0).getCode());
        //            return validateResult.getAllErrors().get(0).getDefaultMessage();
        //        }
        System.out.println("student1----->方法体");
        return "Student Created";
    }
}
