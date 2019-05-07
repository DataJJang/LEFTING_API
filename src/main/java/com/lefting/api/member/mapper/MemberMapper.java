package com.lefting.api.member.mapper;

import com.lefting.api.member.model.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

  /* 회원 기초 정보 조회 */
  MemberVO getMemberInfo(MemberVO memberVO);

  /**
   * Todo 회원 최종 접속 이력 조회
   */
  MemberVO getLastConnectInfo(MemberVO memberVO);

  /**
   * Todo 회원 중복 체크 조회
   */
  MemberVO checkMultiLogin(MemberVO memberVO);

  /**
   * Todo 회원 가입 입력
   */
  MemberVO joinMember(MemberVO memberVO);

  /**
   * Todo 회원 ID/PW 찾기 조회
   */
  MemberVO findLoginInfo(MemberVO memberVO);

  /**
   * Todo 회원 로그인(ID/PW)
   */
  MemberVO memberLogin(MemberVO memberVO);

  /**
   * Todo 회원 로그인(Token)
   */
  MemberVO tokenLogin(MemberVO memberVO);

  /**
   * Todo 회원 정보 수정
   */
  MemberVO modifyMemberInfo(MemberVO memberVO);

  /**
   * Todo 회원 비밀번호 재확인
   */
  MemberVO checkPassword(MemberVO memberVO);

  /**
   * Todo 회원 Token 유효 체크
   */
  MemberVO checkToken(MemberVO memberVO);

  /**
   * Todo 회원 접속 횟수 증가 
   */
  MemberVO modifyMemberConnectCnt(MemberVO memberVO);

}
