package com.jhlee.minipj.api.common.exceptions;

public class NoContentException extends BaseException {

    public NoContentException(String code) {
        setCode(code);
        getDescMsg();
    }
}

