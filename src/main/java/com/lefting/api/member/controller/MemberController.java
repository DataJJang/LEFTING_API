package com.lefting.api.member.controller;

import com.lefting.api.common.abstracts.AbstractController;
import com.lefting.api.common.base.model.ResultVO;
import com.lefting.api.member.model.MemberVO;
import com.lefting.api.member.service.MemberService;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/member")
public class MemberController extends AbstractController {

  private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
  @Autowired
  MemberService memberService;

  /**
   * 회원 기본 정보 제공
   *
   * @param memberVO
   * @return
   * @throws Exception
   */
  @PostMapping(value = "/info", consumes = "application/json")
  public @ResponseBody
  ResultVO memberInfo(@RequestBody MemberVO memberVO) throws Exception {

//    if (StringUtils.isEmpty(testVO.getMemId())) {
//      throw new ParameterInvalidException(MessageConstants.ResponseEnum.PARAM_REQUIRED.getCode());
//    }
    ResultVO resultVO = new ResultVO();
    Map<String, Object> pMap = memberService.memberInfo(memberVO);
    if (pMap.get("code") != null && pMap.get("msg") != null) {
      resultVO.setCode(String.valueOf(pMap.get("code")));
      resultVO.setMessage(String.valueOf(pMap.get("msg")));
    }

    resultVO.setData(pMap.get("data"));

    return resultVO;
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
