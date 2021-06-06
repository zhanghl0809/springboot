package com.example.mapper;


import com.example.entity.Mythread;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MythreadMapper {

    void insert(Mythread mythread);
}
