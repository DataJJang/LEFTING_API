package com.lefting.api.common.exceptions;

public class NoContentException extends BaseException {

    public NoContentException(String code) {
        setCode(code);
        getDescMsg();
    }
}

