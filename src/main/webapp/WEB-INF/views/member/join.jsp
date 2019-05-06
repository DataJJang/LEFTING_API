<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>쥬비스 다이어트 | 인증 및 약관동의</title>
</head>
<body>
        <div id="wrap">


            <div class="agree_box">
                <div class="agree_text">
                    <p>
                        회원가입은 가입인증을 하셔야 됩니다.<br>
                        핸드폰으로 인증번호를 전송받아 인증 후 가입하실 수 있습니다.<br>
                        가입확인을 위해 입력된 정보는 회원가입 외에 어떠한 용도로도 사용되지 않습니다.
                    </p>
                </div>

                <form>
                    <fieldset>
                        <legend>인증 및 약관동의</legend>
                            <!-- 입력필드 -->

                            <!-- 이름 -->
                            <div class="agree_name agree_ipt">
                            <label for="mb_name_step1">이름 *</label>
                                <div class="agree_sub_box">
                                    <input type="text" value="" id="mb_name_step1" name="mb_name" class="inp_w2" maxlength="10" placeholder="예) 김쥬비" data-type="text" data-mxlength="10">
                                </div>
                            </div>

                            <!-- 휴대폰 -->
                            <div class="agree_tel agree_ipt">
                            <label for="mb_tel">휴대폰 *</label>
                                <div class="agree_sub_box">
                                    <input type="number" value="" id="mb_tel" name="mb_tel" class="inp_w1" maxlength="11" placeholder="‘-’ 없이 숫자만"  data-type="number" data-mxlength="11">
                                    <a href="javascript:void(0)"  class="btn_cert btn_cert1" id="btn_same">인증번호 받기</a><br>
                                </div>
                            </div>
                            <span class="both"></span>

                            <!-- 인증번호 -->
                            <div class="agree_agree agree_ipt">
                            <label for="otpNum" class="hidden">인증번호</label>
                                <div class="agree_sub_box">
                                    <input type="number" pattern="\d*" value="" id="otpNum" name="mb_num" class="inp_w1 " maxlength="4" placeholder="" data-type="number" data-mxlength="4">
                                    <a href="#" class="btn_cert btn_cert2" id="btn_same2">인증번호 확인</a><br>
                                </div>
                            </div>
                            <span class="both"></span>

                            <div class="agree_count hidden">
                              <p class="f13 gray2">남은시간 <span class="point_p w700" id="timer">05:00</span></p>
                            </div>

                            <!-- 이용약관 동의 -->
                            <div class="agree_use agree_ipt">
                                <span class="sub_txt">이용약관 동의 *</span>
                                <label for="all_agree" class="agree_checkbox ">
                                    <input type="checkbox" value="all_agree" id="all_agree" class="all_agree termsCk" name="all_agree"><span class="fake_chk strong">전체동의</span>
                                </label>
                                <div class="agree_use2">
                                    <label for="agree1" class="agree_checkbox1">
                                        <input type="checkbox" value="agree1" id="agree1" class="agree1 termsCk term_necessary" name="agree1"><span class="fake_chk ">이용안내</span><span class="sub_txt2">(필수)</span>
                                    </label>
                                    <a href="javascript:void(0)" class="termDetail sub_txt3" data-termctgry="use">약관보기 ></a>
                                </div>
                                <div class="agree_use2">
                                    <label for="agree2" class="agree_checkbox1">
                                        <input type="checkbox" value="agree2" id="agree2" class="agree2 termsCk term_necessary" name="agree2"><span class="fake_chk ">개인정보 수집/이용 안내</span><span class="sub_txt2">(필수)</span>
                                    </label>
                                    <a href="javascript:void(0)" class="termDetail sub_txt3" data-termctgry="privacy">약관보기 ></a>
                                </div>
                                <div class="agree_use2">
                                    <label for="agree3" class="agree_checkbox1">
                                        <input type="checkbox" value="marketing_term" id="agree3" class="agree3 marketing_termsCk termsCk" name="agree3"><span class="fake_chk ">마케팅 정보 수신 동의</span><span class="sub_txt2">(선택)</span>
                                    </label>
                                    <a href="javascript:void(0)" class="termDetail sub_txt3" data-termctgry="marketing">약관보기 ></a>
                                    <div class="agree_use3">
                                        <label for="email_term" class="agree_checkbox2">
                                            <input type="checkbox" value="agree4" id="email_term" class="agree4 marketing_termsCk termsCk" name="agree4"><span class="fake_chk ">이메일</span>
                                        </label>
                                        <label for="sms_term" class="agree_checkbox2" style="margin-left:20px;">
                                            <input type="checkbox" value="agree5" id="sms_term" class="agree5 marketing_termsCk termsCk" name="agree5"><span class="fake_chk ">SMS</span>
                                        </label>
                                    </div>
                                </div>
                            </div>

                        <!-- 버튼 -->
                        <button  class="btn_submit" id="submit_agree" style="margin-top:20px;">확인</button>

                    </fieldset>
                </form>
            </div>




            <div class="join_box hidden">
            <%--<div class="join_box">--%>
                <form>
                    <fieldset>
                        <legend>회원가입</legend>
                        <!-- 입력필드 -->

                        <!-- 이름 -->
                        <div class="join_name join_ipt">
                            <label for="mb_name">이름 *</label>
                            <div class="join_sub_box">
                                <input type="text" value="" id="mb_name" name="mb_name" class="inp_w2" maxlength="50" placeholder="예) 김쥬비"  data-type="text" data-mxlength="10">
                            </div>
                        </div>

                        <!-- 생년월일 -->
                        <div class="join_birth join_ipt">
                            <span class="sub_txt2">생년월일 *</span>
                            <div class="join_birth_box join_sub_box">
                                <label for="mb_y" class="hidden">생년</label>
                                <div>
                                    <input type="number" pattern="\d*" value="" id="mb_y" name="mb_y" class="inp_w3 birth" maxlength="4" oninput="maxLengthCheck(this)" placeholder="YYYY" data-type="number" data-mxlength="4">
                                </div>
                                <span class="sub_txt3">/</span>
                                <label for="mb_m" class="hidden">월</label>
                                <div>
                                    <input type="number" pattern="\d*" value="" id="mb_m" name="mb_mmb_y" class="inp_w3 birth" maxlength="2" oninput="maxLengthCheck(this)" placeholder="MM" data-type="number" data-mxlength="2">
                                </div>
                                <span class="sub_txt3">/</span>
                                <label for="mb_d" class="hidden">일</label>
                                <div>
                                    <input type="number" pattern="\d*" value="" id="mb_d" name="mb_d" class="inp_w3 last birth" maxlength="2" oninput="maxLengthCheck(this)" placeholder="DD" data-type="number" data-mxlength="2">
                                </div>
                            </div>
                        </div>
                        <span class="both"></span>

                        <!-- 아이디 -->
                        <div class="join_id join_ipt">
                            <label for="mb_id">아이디 *</label>
                            <div class="join_sub_box">
                                <input type="text" value="" id="mb_id" name="mb_id" class="inp_w1" maxlength="10" placeholder="예) juvis1234 " data-type="text" data-mxlength="10">
                                <a  href="javascript:void(0)" class="btn_cert" id="btn_same_id">중복확인</a><br>
                                <span class="sub_txt">(영문/숫자포함 6자 이상 입력하여 주세요)</span>
                            </div>
                        </div>
                        <span class="both"></span>
                        <!-- 비밀번호 -->
                        <div class="join_pw join_ipt">
                            <label for="mb_pw">비밀번호 *</label>
                            <div class="join_sub_box">
                                <input type="password" value="" id="mb_pw" name="mb_pw" class="inp_w2" maxlength="20" placeholder="비밀번호를 입력해주세요." data-mxlength="20">
                                <span class="sub_txt">영문/숫자/특수문자 포함 8자 이상 입력해주세요. (# $ _ , . 제외)</span>
                            </div>
                        </div>

                        <!-- 비밀번호 확인 -->
                        <div class="join_pw join_ipt">
                            <label for="mb_pw2">비밀번호 확인 *</label>
                            <div class="join_sub_box">
                                <input type="password" value="" id="mb_pw2" name="mb_pw2" class="inp_w2" maxlength="20" placeholder="비밀번호를 한번 더 입력해주세요." data-mxlength="20">
                            </div>
                        </div>

                        <!-- 이메일 -->
                        <div class="join_email join_ipt">
                            <label for="mb_email">이메일 *</label>
                            <div class="join_sub_box">
                                <input type="email" value="" id="mb_email" name="mb_email" class="inp_w2" maxlength="50" placeholder="예) juvisdiet@juvis.co.kr" data-mxlength="50">
                            </div>
                        </div>

                        <!-- 성별 -->
                        <div class="join_sex join_ipt">
                            <span class="sub_txt2">성별 *</span>
                            <div class="join_sex_box">
                                <label for="F" class="radio_btn">
                                    <input type="radio" value="F" id="F" name="sex" class="inp_w4 memSex"><span class="fake_chk1">여성</span>
                                </label>
                            </div>
                            <div class="join_sex_box">
                                <label for="M" class="radio_btn">
                                    <input type="radio" value="M" id="M" name="sex" class="inp_w4 memSex"><span class="fake_chk1">남성</span>
                                </label>
                            </div>
                        </div>
                        <span class="both"></span>

                        <!-- 사이트 알게 된 경로  -->
                        <div class="join_root join_ipt">
                            <label for="site_root" class="site_root" >사이트 알게된 경로 *</label>
                            <select id="site_root" class="site_root_box">
                                <option class="sec1" value="">선택해주세요.</option>
                                <c:forEach var="item" items="${joinPathList}"  varStatus="status">
                                    <option class="sec1" value="${item.pubName}">${item.pubDesc}</option>
                                </c:forEach>

                            </select>
                        </div>


                        <!-- 버튼 -->
                        <button type="submit" class="btn_submit" id="submit_join" style="margin-top:0px;">가입하기</button>

                    </fieldset>
                    <script type="text/javascript">
                        function maxLengthCheck(object){
                            if (object.value.length > object.maxLength){
                                object.value = object.value.slice(0, object.maxLength);
                            }
                        }
                    </script>
                </form>


            </div>



        </div>

        <script src='<c:url value="/assets/juvis/member/join.js"/>'></script>
    </body>
</html>