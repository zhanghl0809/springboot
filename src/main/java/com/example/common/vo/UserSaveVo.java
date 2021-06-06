package com.example.common.vo;

import com.example.common.ReqCommon;

import lombok.Data;


@Data
public class UserSaveVo extends ReqCommon {

    private String userName;
    private String passWord;
    private String realName;
}
