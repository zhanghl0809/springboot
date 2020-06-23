package com.example.controller;

import com.example.config.MinioHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;




@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private MinioHelper minioHelper;

    @PostMapping("/upload")
    public Object upload (@RequestParam("file") MultipartFile multipartFile)throws Exception {
        return this.minioHelper.putObject(multipartFile);
    }

}

