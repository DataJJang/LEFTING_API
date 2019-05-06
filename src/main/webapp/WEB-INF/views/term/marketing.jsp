<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>마케팅 정보 수신 동의</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta id="Viewport" name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="format-detection" content="telephone=no, address=no, email=no">
</head>

<body>
<div id="wrap">
    <div class="privacy_box">

        <div class="privacy">

        <p>회사는 광고성 정보 제공 및 이벤트 알림, 이벤트 참여기회 제공 등의 목적으로 휴대폰번호, 이메일주소, 출생년도를 동의 철회 시까지 수집/이용합니다.</p>
        <p>마케팅 정보 수신에 동의하시면 쥬비스 통합회원으로 쥬비스 다이어트 및 다양한 쥬비스 브랜드(조인바이, 쥬비스푸드, 쥬비스아카데미, 제이에이스컴퍼니)의 이벤트 및 마케팅, 광고 정보를 제공받을 수 있습니다.</p>
        <p>고객님께서는 언제든지 활용 중단을 요청할 수 있습니다.</p>
        <p>본 동의는 거부할 수 있으며 다만 이에 동의하지 않을 시 이벤트 및 마케팅 등의 서비스를 제공받을 수 없습니다.</p>



        <div class="contract_submit">
            <button  class="btn_submit" id="close">확인</button>
        </div>
        </div>
   </div>
</div>
<script src='<c:url value="/assets/juvis/term/term.js"/>'></script>
</body>
</html>
