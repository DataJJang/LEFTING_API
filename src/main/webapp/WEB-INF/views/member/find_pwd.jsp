<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<!-- saved from url=(0142)http://new.dietconsulting.co.kr/checklist/toxic_list_r.php?mem_id=%EB%AC%B8%EC%88%98%EB%A6%B00204&gubun=J&mem_name=%EB%AC%B8%EC%88%98%EB%A6%B0 -->
<html lang="ko">
<head>
    <title>쥬비스 다이어트 | 비밀번호재설정</title>
</head>
<body>
    <div id="wrap">
        <div class="logo">
            <img src="<c:url value="/assets/images/logo.png"/>" alt="쥬비스로고" width="100%"/>
        </div>
        <div class="search_tab">
            <ul>
                <li><a href="">아아디 찾기</a></li>
                <li><a href="" class="tab_select">비밀번호 찾기</a></li>
            </ul>
        </div>

        <div class="input_newbox">
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
                            <label for="inp_search_pw">전화번호</label>
                            <input type="number" value="" id="inp_search_pw" class="inp_w1" placeholder="'-'없이 숫자만">
                            <a href="#" class="btn_cert btn_cert1" id="btn_same">인증번호 받기</a>
                        </div>
                        <div class="search_cert">
                            <label for="inp_search_pw" class="label_hidden">인증번호입력</label>
                            <input type="number" value="" id="inp_search_pw" class="" placeholder="인증번호 입력">
                        <div class="search_cert">
                        <!-- 버튼 -->
                    <button type="submit" class="btn_submit" id="submit_search_id">확인</button>
                </fieldset>
            </form>
            <script type="text/javascript">
                $('.input_box .input_txt').on('click',function(){
                    $(this).addClass('on').siblings().removeClass('on');
                });
            </script>
        </div>
    </div>
</body>
</html>