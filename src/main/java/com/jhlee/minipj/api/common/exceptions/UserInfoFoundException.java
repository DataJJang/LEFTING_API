package com.jhlee.minipj.api.common.exceptions;

public class UserInfoFoundException extends BaseException{

    private String parameterlog;

    public UserInfoFoundException(String code) {
        setCode(code);
        getDescMsg();
    }
}
