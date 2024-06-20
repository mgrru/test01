package com.mgrru.test01.util;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum codeEnums {
    SUCCESS(0,"成功!"),
    ERROR(1,"操作失败!"),
    NOT_FOUND(2,"未找到资源!"),
    UN_ERROR(3,"未知错误!"),
    RUN_ERROR(4,"未知运行错误!"),
    ;

    private final Integer code;
    private final String msg;

    public Integer code(){
        return code;
    }

    public String msg(){
        return msg;
    }
}
