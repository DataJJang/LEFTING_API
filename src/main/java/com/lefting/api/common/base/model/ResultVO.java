package com.lefting.api.common.base.model;

import com.lefting.api.common.constant.MessageConstants;

public class ResultVO extends BaseVO {

    /**
     * Default Construct
     */
    public ResultVO() {

    }

    public ResultVO(Object data) {
        this.data = data;
    }


    public ResultVO(String code){
        this.code = code;
        this.message = MessageConstants.ResponseEnum.findDescByCode(code);
    }

    /**
     * Initialize Type2 Contract
     *
     * @param code
     * @param message
     */
    public ResultVO(String code, String message){
        this.code = code;
        this.message = message;
    }

    private String code = "1";
    private String message = MessageConstants.SUCCESS;
    private Object data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
        this.message = MessageConstants.ResponseEnum.findDescByCode(code);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
