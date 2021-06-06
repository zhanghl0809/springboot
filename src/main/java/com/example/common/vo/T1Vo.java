package com.example.common.vo;

import com.example.common.ReqCommon;

import lombok.Data;
import lombok.NonNull;


@Data
public class T1Vo extends ReqCommon {

    @NonNull
    private String id;
}
