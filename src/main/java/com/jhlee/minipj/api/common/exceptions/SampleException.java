package com.jhlee.minipj.api.common.exceptions;

public class SampleException extends BaseException{

    private String parameterlog;

    public SampleException(String code) {
        setCode(code);
    }

    public SampleException(String code, String parameterlog) {
        setCode(code);
        this.parameterlog = parameterlog;
    }

    public String getParameterlog() {
        return parameterlog;
    }
}
