package com.lefting.api.member.service;

import com.lefting.api.common.constant.MessageConstants;
import com.lefting.api.member.mapper.MemberMapper;
import com.lefting.api.member.model.MemberVO;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

  Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  MemberMapper memberMapper;


  /**
   *
   * 회원 기본 정보 조회
   *
   * @param memberVO
   * @return
   * @throws Exception
   */
  public Map memberInfo(MemberVO memberVO) throws Exception {
    Map<String, Object> pMap = new HashMap<>();

    // Mapper 통해서 DB 데이터 수집

    MemberVO tVO = memberMapper.getMemberInfo(memberVO);

    if(tVO == null) {
      pMap.put("msg", MessageConstants.ResponseEnum.SURVIVAL_NOT_JOIN.getDesc());
      pMap.put("code", MessageConstants.ResponseEnum.SURVIVAL_NOT_JOIN.getCode());

      return pMap;
    }

    pMap.put("data", tVO);
    return pMap;
  }

  /**
   *
   * Todo. 회원 최종 접속 이력 조회
   *
   */

  /**
   * Todo. 회원 중복 체크 조회
   * Todo. 회원 가입 입력
   *
   */

  /**
   * Todo. 회원 ID/PW 찾기 조회
   */

  /**
   * Todo. 회원 로그인(ID/PW)
   */

  /**
   * Todo. 회원 로그인(Token)
   */

  /**
   * Todo. 회원 정보 수정
   */

  /**
   * Todo. 회원 비밀번호 재확인
   */


  /**
   * Todo. 회원 Token 유효 체크
   */
}
