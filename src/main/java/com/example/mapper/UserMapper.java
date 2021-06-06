package com.example.mapper;

import com.example.entity.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
public interface UserMapper {

    User Sel(int id);

    int insert(User user);

    int insertSelective(User user);

    List<User> findAllUser();
}
