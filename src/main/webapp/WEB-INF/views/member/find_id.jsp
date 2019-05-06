<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>쥬비스 다이어트 | 아이디 찾기</title>
</head>
<body>
    <div id="wrap">
        <div class="logo">
            <img src="<c:url value="/assets/images/logo.png"/>" alt="쥬비스로고" width="100%"/>
        </div>
        <div class="search_tab">
            <ul>
                <li><a href="javascript:void(0)" data-ctgry="findid" class="header_tab">아아디 찾기</a></li>
                <li><a href="javascript:void(0)" data-ctgry="findpwd"  class="header_tab">비밀번호 찾기</a></li>
            </ul>
        </div>

        <div id="findid-wrap" class="input_newbox hidden">
            <form>
                <fieldset>
                    <legend>아이디 찾기</legend>
                        <!-- 입력필드 -->
                        <div class="search_neme">
                            <label for="inp_name">이름</label>
                            <input type="text" value="" id="inp_name" name="inp_name" class="" maxlength="50" placeholder="예) 김쥬비">
                        </div>
                        <div class="search_phone">
                            <label for="inp_tel">전화번호</label>
                            <input type="number" value="" id="inp_tel" class="inp_w1" placeholder="'-'없이 숫자만">
                            <a href="#" class="btn_cert btn_cert1" id="btnGetOtp" data-ftype="id" >인증번호 받기</a>
                        </div>
                        <div class="search_cert">
                            <label for="inp_otp_num" class="label_hidden">인증번호입력</label>
                            <input type="number" value="" id="inp_otp_num" class="" placeholder="인증번호 입력">
                        <div class="search_cert">
                        <!-- 버튼 -->
                    <button type="button" class="btn_submit" id="btnConfirm" data-ftype="id" >확인</button>
                </fieldset>
            </form>
        </div>
        <div id="findpwd-wrap" class="input_newbox hidden">
            <form>
                <fieldset>
                    <legend>비밀번호 찾기</legend>
                        <!-- 입력필드 -->
                        <div class="search_neme">
                            <label for="inp_id">아이디</label>
                            <input type="text" value="" id="inp_id" name="inp_id" class="" maxlength="50" placeholder="예) juvis0441">
                        </div>
                        <div class="search_neme">
                            <label for="inp_name">이름</label>
                            <input type="text" value="" id="inp_name" name="inp_name" class="" maxlength="50" placeholder="예) 김쥬비">
                        </div>
                        <div class="search_phone">
                            <label for="inp_tel">전화번호</label>
                            <input type="number" value="" id="inp_tel" class="inp_w1" placeholder="'-'없이 숫자만">
                            <a href="#" class="btn_cert btn_cert1" id="btnGetOtp" data-ftype="pwd" >인증번호 받기</a>
                        </div>
                        <div class="search_cert">
                            <label for="inp_otp_num" class="label_hidden">인증번호입력</label>
                            <input type="number" value="" id="inp_otp_num" class="" placeholder="인증번호 입력">
                        <div class="search_cert">
                        <!-- 버튼 -->
                    <button type="button" class="btn_submit" id="btnConfirm" data-ftype="pwd">확인</button>
                </fieldset>
            </form>
        </div>
    </div>
    <script src='<c:url value="/assets/juvis/member/member_info.js"/>'></script>
    <script type="text/javascript">
        $('.input_box .input_txt').on('click',function(){
            $(this).addClass('on').siblings().removeClass('on');
        });
    </script>
</body>
</html>