package com.jhlee.minipj.api.test.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jhlee.minipj.api.common.base.model.BaseVO;
import org.apache.ibatis.type.Alias;

@JsonInclude(JsonInclude.Include.NON_NULL)
//@Alias("test")
public class TestVO extends BaseVO {

  private String memId;
  private String memName;
  private String memEmail;
  private String memMdn;
  private String memNationCode;

  public String getMemId() {
    return memId;
  }

  public void setMemId(String memId) {
    this.memId = memId;
  }

  public String getMemName() {
    return memName;
  }

  public void setMemName(String memName) {
    this.memName = memName;
  }

  public String getMemEmail() {
    return memEmail;
  }

  public void setMemEmail(String memEmail) {
    this.memEmail = memEmail;
  }

  public String getMemMdn() {
    return memMdn;
  }

  public void setMemMdn(String memMdn) {
    this.memMdn = memMdn;
  }

  public String getMemNationCode() {
    return memNationCode;
  }

  public void setMemNationCode(String memNationCode) {
    this.memNationCode = memNationCode;
  }
}
