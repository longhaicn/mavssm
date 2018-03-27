package com.ssm.utils;

public class StatusObject {
    private String code;                            //响应状态码
    private String msg;                             //响应状态描述

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
