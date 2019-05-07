package com.lefting.api.common.exceptions;

import com.lefting.api.common.base.model.ResultVO;

public class ParameterInvalidException  extends BaseException {

    private ResultVO resultVO;

    public ParameterInvalidException(String code) {
        setCode(code);
        getDescMsg();
    }
}
