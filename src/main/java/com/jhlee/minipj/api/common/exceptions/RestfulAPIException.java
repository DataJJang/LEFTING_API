package com.jhlee.minipj.api.common.exceptions;


public class RestfulAPIException extends BaseException{

    private String parameterlog;

    public RestfulAPIException(String code) {
        setCode(code);
    }

    public RestfulAPIException(String code, String parameterlog) {
        setCode(code);
        this.parameterlog = parameterlog;
    }

    public String getParameterlog() {
        return parameterlog;
    }
}
