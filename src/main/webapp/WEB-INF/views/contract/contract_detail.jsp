
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
    <title>쥬비스 다이어트 | 프로그램 상세</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta id="Viewport" name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="format-detection" content="telephone=no, address=no, email=no">
</head>

<body>
<div id="wrap">
    <div class="contract_detail">
        <c:forEach var="item" items="${contractResult.contractList}" varStatus="status">
        <div class="contract_program">
            <div class="contract_tit">
                <a href="javascript:void(0)"><p class="f19 w900">${item.prgName} <span style="float:right;"><img src="/assets/images/app_arr.png" alt="" width="80%" /></span></p></a>
            </div>
            <table class="contract_table">
                <caption>프로그램 상세</caption>
                <colgroup>
                    <col width="20%"><col width="*">
                </colgroup>
                <thead>
                <tr>
                    <th>프로그램 상세</th>
                    <td class="point_p">${item.ctdStatusName}</td>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th>프로그램 금액</th>
                    <td><fmt:formatNumber value="${item.ctdPrice}" type="number"/>원</td>
                </tr>
                <tr>
                    <th>미 결제 금액</th>
                    <td><fmt:formatNumber value="${item.outstandingPrice}" type="number"/>원</td>
                </tr>
                <tr>
                    <th>프로그램 기간</th>
                    <td>${item.ctdStartDate} ~ ${item.ctdEndDate}(${item.prgDuration}주)</td>
                </tr>
                <tr>
                    <th>전체 횟수</th>
                    <td>${item.ctdTotalServiceCnt}</td>
                </tr>
                <tr>
                    <th>잔여 횟수</th>
                    <td>${item.remainCnt}</td>
                </tr>
                <tr>
                    <th>관리 횟수</th>
                    <td>${item.ctdManageCnt}</td>
                </tr>
                </tbody>
            </table>
            <div class="contract_submit02">
                <button type="submit" class="f16  btn_submit mg0" id="">결제하기</button>
                <button class="f16 btn_line2" id="delayBtn">연기 신청</button>
                <button type="submit" class="f16 btn_line2" id="">연계 신청</button>
                <button type="submit" class="f16 btn_line2" id="">양도 신청</button>
                <button type="submit" class="f16 btn_line2" id="">취소 신청</button>
            </div>
        </div>
        </c:forEach>

        <div class="contract_payment">
            <div class="contract_tit">
                <a href="javascript:void(0)"><p class="f19 w900">결제 이력 <span style="float:right;"><img src="/assets/images/app_arr.png" alt="" width="80%" /></span></p></a>
            </div>
            <c:choose>
                <c:when test="${contractResult.paymentList == null || fn:length(contractResult.paymentList) == 0}">
                    <div class="contract_box_none">
                        <p>결제 내역이 없습니다.</p>
                    </div>
                </c:when>
                <c:otherwise>
                    <c:forEach var="item" items="${contractResult.paymentList}" varStatus="status">
                        <c:choose>
                            <c:when test="${item.ctpAfterType eq '서비스제공'}">
                                <div class="contract_box_list">
                                    <div class="contract_box">
                                        <div class="cont_sub_box2">
                                            <p class="f12 w400 cont_txt2">${item.ctpAfterType}</p>
                                            <span class="both"></span>
                                        </div>
                                    </div>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="contract_box_list">
                                    <div class="contract_box">
                                        <div class="cont_sub_box1">
                                            <p class="f15 w700 point_p cont_txt1"><fmt:formatNumber value="${item.ctpPrice}" type="number"/>원</p>
                                            <p class="f15 w400 cont_txt2">${item.ctpType}(${item.cdcName})</p>
                                            <span class="both"></span>
                                        </div>
                                        <div class="cont_sub_box2">
                                            <p class="f12 w700 cont_txt1">${item.ctpRegDate}</p>
                                            <p class="f12 w400 cont_txt2">${item.ctpAfterType}</p>
                                            <span class="both"></span>
                                        </div>
                                    </div>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </div>
        <div class="contract_btn contractList">
            <button type="submit" class="f16  btn_submit mg0" id="">목록 보기</button>
        </div>
    </div>
</div>
<script src='<c:url value="/assets/juvis/contract/contract_list.js"/>'></script>
</body>
</html>