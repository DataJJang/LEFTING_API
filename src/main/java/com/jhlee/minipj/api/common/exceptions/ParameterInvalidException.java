package com.jhlee.minipj.api.common.exceptions;

import com.jhlee.minipj.api.common.base.model.ResultVO;

public class ParameterInvalidException  extends BaseException {

    private ResultVO resultVO;

    public ParameterInvalidException(String code) {
        setCode(code);
        getDescMsg();
    }
}
