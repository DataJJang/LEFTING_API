package com.lefting.api.common.exceptions;

public class UnauthorizedException extends BaseException {

    private String parameterlog;

    public UnauthorizedException(String code) {
        setCode(code);
        getDescMsg();
    }

    public UnauthorizedException(String code, String parameterlog) {
        setCode(code);
        this.parameterlog = parameterlog;
    }

    public String getParameterlog() {
        return parameterlog;
    }
}
