package com.mgrru.test01.util;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class R<T> {
    private Integer code;
    private String msg;
    private T data;

    public static <T> R<T> success() {
        codeEnums c = codeEnums.SUCCESS;
        return new R<T>(c.code(), c.msg(), null);
    }

    public static <T> R<T> successMsg(String msg) {
        codeEnums c = codeEnums.SUCCESS;
        return new R<T>(c.code(), msg, null);
    }

    public static <T> R<T> success(T data) {
        codeEnums c = codeEnums.SUCCESS;
        return new R<T>(c.code(), c.msg(), data);
    }

    public static <T> R<T> error(Integer code, String msg) {
        return new R<>(code, msg, null);
    }

    public static <T> R<T> error(codeEnums c) {
        return new R<>(c.code(), c.msg(), null);
    }
}
