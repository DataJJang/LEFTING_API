<%--
  Created by IntelliJ IDEA.
  User: SSAN
  Date: 2019-04-24
  Time: 오후 2:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>쥬비스 다이어트 | 리서치 결과</title>
</head>

<body>
<div id="wrap">
    <div class="research_result">
        <div class="research_top">
            <p class="f19 w900">${toxicResult.adtTitle}</p>
            <p class="f14 w500 gray2">체크일  |  <span class="date">${fn:substring(toxicResult.adlRegDate, 0, 10)}</span>  <span class="time">${fn:substring(toxicResult.adlRegDate, 11, 16)}</span></p>
        </div>
        <div class="research_middle">
            <c:choose>
                <c:when test="${fn:length(toxicResult.toxicLogs) == 1}">
                    <c:forEach var="item" items="${toxicResult.toxicLogs}" varStatus="status">
                    <div class="research_viewBox floatL">
                        <div class="rsc_left_top">${item.adrTitle}</div>
                        <div class="rsc_left_txt">
                            <p class="rsc_left_score">${item.adlPoint}점으로 ${item.adrNo}단계</p>
                            <c:if test="${item.adrNo > 0}">
                            <p class="rsch_left_ment">컨설턴트와의 상담이<br />필요합니다.</p>
                            </c:if>
                        </div>
                    </div>
                    <div class="research_viewBox floatR">
                        <div class="rsc_right_top">${item.adrTitle}</div>
                        <div class="rsc_right_txt">
                            <p class="rsc_right_score">${item.adlPoint}점으로 ${item.adrNo}단계</p>
                            <c:if test="${item.adrNo > 0}">
                            <p class="rsch_right_ment">컨설턴트와의 상담이<br />필요합니다.</p>
                            </c:if>
                        </div>
                    </div>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <c:forEach var="item" items="${toxicResult.toxicLogs}" varStatus="status">
                        <c:if test="${status.first}">
                        <div class="research_viewBox floatL">
                            <div class="rsc_left_top">${item.adrTitle}</div>
                            <div class="rsc_left_txt">
                                <p class="rsc_left_score">${item.adlPoint}점으로 ${item.adrNo}단계</p>
                                <c:if test="${item.adrNo > 0}">
                                <p class="rsch_left_ment">컨설턴트와의 상담이<br />필요합니다.</p>
                                </c:if>
                            </div>
                        </div>
                        </c:if>
                        <c:if test="${status.last}">
                        <div class="research_viewBox floatR">
                            <div class="rsc_right_top">${item.adrTitle}</div>
                            <div class="rsc_right_txt">
                                <p class="rsc_right_score">${item.adlPoint}점으로 ${item.adrNo}단계</p>
                                <c:if test="${item.adrNo > 0}">
                                <p class="rsch_right_ment">컨설턴트와의 상담이<br />필요합니다.</p>
                                </c:if>
                            </div>
                        </div>
                        </c:if>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </div>
        <div class="research_tit">
            <p class="f17 w500">컨설턴트 코멘트</p>
        </div>
        <div class="research_txt gray2">
            <p class="f14 w500 ">
                ${toxicResult.solutionsText}
            </p>
        </div>
        <div class="research_submit toxicList">
            <button type="submit" class="btn_submit2" id="">목록</button>
        </div>
    </div>
</div>
<script src='<c:url value="/assets/juvis/research/toxic_result.js"/>'></script>
</body>
</html>