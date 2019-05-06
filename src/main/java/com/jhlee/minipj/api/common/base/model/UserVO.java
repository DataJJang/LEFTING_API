package com.jhlee.minipj.api.common.base.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.ibatis.type.Alias;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Alias("userInfo")
public class UserVO extends BaseVO{

    private String token;
    private String memId;
    private String memPwd;
    private Integer ctrId;
    private Integer ctdId;

    public UserVO() {

    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMemId() {
        return memId;
    }

    public void setMemId(String memId) {
        this.memId = memId;
    }

    public String getMemPwd() {
        return memPwd;
    }

    public void setMemPwd(String memPwd) {
        this.memPwd = memPwd;
    }

    public Integer getCtrId() {
        return ctrId;
    }

    public void setCtrId(Integer ctrId) {
        this.ctrId = ctrId;
    }

    public Integer getCtdId() {
        return ctdId;
    }

    public void setCtdId(Integer ctdId) {
        this.ctdId = ctdId;
    }
}
