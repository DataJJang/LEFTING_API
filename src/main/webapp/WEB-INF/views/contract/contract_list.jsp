<%--
  Created by IntelliJ IDEA.
  User: SSAN
  Date: 2019-04-29
  Time: 오전 10:41
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
    <title>쥬비스 다이어트 | 프로그램 이력</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta id="Viewport" name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="format-detection" content="telephone=no, address=no, email=no">
</head>

<body>
<div id="wrap">
    <div class="contract_list">
        <c:choose>
            <c:when test="${contractResult == null || contractResult.contractList == null || fn:length(contractResult.contractList) == 0}">
                <div class="contract_box_none">
                    <p class="f16 w500 cont_txt">프로그램 이력이 없습니다.</p>
                </div>
            </c:when>
            <c:otherwise>
                <c:forEach var="item" items="${contractResult.contractList}" varStatus="status">
                <div class="contract_box" data-ctrid="${item.ctrId}">
                    <div class="contract_cate">
                        <p class="f12 w500">${item.prgTypeDesc}</p>
                    </div>
                    <div class="contract_tit">
                        <p class="f16 w500">${item.prgName}</p>
                        <p class="f15 w500 gray2 mg_b0">${item.prgTypeDesc}(외 ${item.otherCnt}건)</p>
                    </div>
                    <div class="contract_txt">
                        <p class="f14 w500 cont_txt1">[${item.prgDuration}주] ${item.ctdStartDate} ~ ${item.ctdEndDate}</p>
                        <c:choose>
                            <c:when test="${item.ctdStatusName == '관리중'}">
                                <p class="f14 w500 cont_txt2 font_Blue">${item.ctdStatusName}</p>
                            </c:when>
                            <c:when test="${item.ctdStatusName == '관리완료'}">
                                <p class="f14 w500 cont_txt2 font_Red">${item.ctdStatusName}</p>
                            </c:when>
                            <c:when test="${item.ctdStatusName == '대기중'}">
                                <p class="f14 w500 cont_txt2 font_Gray">${item.ctdStatusName}</p>
                            </c:when>
                            <c:otherwise>
                                <p class="f14 w500 cont_txt2 font_Green">${item.ctdStatusName}</p>
                            </c:otherwise>
                        </c:choose>
                        <span class="both"></span>
                    </div>
                    <a href="javascript:void(0)" class="btn_more"></a>
                </div>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </div>
</div>
<script src='<c:url value="/assets/juvis/contract/contract_list.js"/>'></script>
</body>
</html>