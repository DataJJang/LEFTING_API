package com.jhlee.minipj.api.common.exceptions;

import com.jhlee.minipj.api.common.base.model.ResultVO;

public class HubServerException extends BaseException {
    private ResultVO resultVO;

    public HubServerException(String code, ResultVO resultVO) {
        setCode(code);
        getDescMsg();
        this.resultVO = resultVO;
    }

    public ResultVO getResultVO() {
        return resultVO;
    }
}
