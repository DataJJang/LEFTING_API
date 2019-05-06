<%--
  Created by IntelliJ IDEA.
  User: SSAN
  Date: 2019-04-24
  Time: 오후 7:12
  To change this template use File | Settings | File Templates.
--%>
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
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>쥬비스 다이어트 | 리서치 상세</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta id="Viewport" name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="format-detection" content="telephone=no, address=no, email=no">
</head>

<body>
<div id="wrap">
    <div class="research_detail" data-memid="${toxicView.memId}" data-adtid="${toxicView.adtId}" data-brcid="${toxicView.brcId}">
        <div class="research_top">
            <p class="f19 w900" >${toxicView.adtTitle}</p>
        </div>
        <form>
            <fieldset>
                <div class="research_box">
                    <c:forEach var="item" items="${toxicView.questions}" varStatus="status">
                    <div class="q_box">
                        <p class="f16 w500">${status.count}. ${item}</p>
                    </div>
                    <div class="a_box">
                        <c:forEach var="answer" items="${toxicView.answer}" varStatus="sts">
                        <label class="radio_btn3">
                            <input type="radio" value="${sts.count}" name="answer[${status.count}]" class="inp_w4"/><span class="fake_chk1 f16 w700">${answer}</span>
                        </label>
                        </c:forEach>
                    </div>
                    </c:forEach>
                </div>
                <div class="research_submit">
                    <button type="submit" class="btn_submit" id="submit_toxic">확인</button>
                </div>
            </fieldset>
        </form>
    </div>
</div>
<script src='<c:url value="/assets/juvis/research/toxic_info.js"/>'></script>
</body>
</html>
