package com.lefting.api.member.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.lefting.api.common.base.model.BaseVO;
import org.apache.ibatis.type.Alias;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Alias("member")
public class MemberVO extends BaseVO {

  /** Todo
   *  IDX, LastConnectDT,
   *  Token, LastServiceMenuID,
   *  Password, 로그인 접속 횟수
   *
   *
   *
   *
   */

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
