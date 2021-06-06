package com.example.entity;

import com.example.common.ReqCommon;
import com.example.checker.sensitive.annotation.Sensitive;

public class Student extends ReqCommon {
    @Sensitive
    private int age;
    @Sensitive
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
