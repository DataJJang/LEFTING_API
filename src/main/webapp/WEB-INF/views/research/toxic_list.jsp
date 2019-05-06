<%--
  Created by IntelliJ IDEA.
  User: SSAN
  Date: 2019-04-17
  Time: 오후 9:01
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
    <title>쥬비스 다이어트 | 리서치 목록</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta id="Viewport" name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="format-detection" content="telephone=no, address=no, email=no">
</head>

<body>
<div id="wrap">
    <div class="research_list">
        <div class="research_top">
            <p class="f19 w500"><span class=" w900">${toxicList.memName}</span> 고객님</p>
            <p class="f19 w500 research_txt">총 <span class="point_p w900">${toxicList.total}</span> 건 중 <span class="point_p w900">${toxicList.unchecked}</span> 건의<br>중독증체크를 하지 않았습니다.</p>
        </div>
        <c:forEach var="item" items="${toxicList.addList}" varStatus="status">
        <div class="research_box">
            <div class="re_left_box">
                <div class="re_left_after">
                    <p class="af_p1 f16 w500">${item.adtTitle}</p>
                    <p class="af_p2 f13 w500 gray2">${fn:substring(item.toxicLog.adlRegDate, 0, 10)}</p>
                </div>
            </div>
            <c:if test="${item.toxicLog == null}">
            <div class="re_right_box">
                <div class="re_right_before toxicView" data-memsex="${item.adrGender}" data-adtid="${item.adtId}">
                    <a href="javascript:void(0)" class="f14 w500 ">체크하기</a>
                </div>
            </div>
            <span class="both"></span>
            </c:if>
            <c:if test="${item.toxicLog != null}">
            <div class="re_right_box">
                <div class="re_right_after toxicResult" data-adlid="${item.toxicLog.adlId}" data-adtid="${item.toxicLog.adtId}" data-adlregdate="${item.toxicLog.adlRegDate}">
                    <a href="javascript:void(0)" class=" f14 w500">결과보기</a>
                </div>
            </div>
            <span class="both"></span>
            </c:if>
        </div>
        </c:forEach>
    </div>
</div>
<script src='<c:url value="/assets/juvis/research/toxic_info.js"/>'></script>
</body>
</html>

