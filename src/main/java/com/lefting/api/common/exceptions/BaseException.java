package com.lefting.api.common.exceptions;

import com.lefting.api.common.constant.MessageConstants;

public class BaseException extends Exception {

    private String code;

    public BaseException() {

    }

    public BaseException(String msg) {
        super(msg);
    }

    public String getDescMsg() {
        return MessageConstants.ResponseEnum.findDescByCode(code);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
