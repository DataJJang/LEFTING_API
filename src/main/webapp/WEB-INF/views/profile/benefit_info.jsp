<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>쥬비스 다이어트 | 포인트 혜택</title>
</head>
<body>
		<div id="wrap">
			<div class="point_box1">
				<div class="point_tab">
					<ul>
						<li><a href="javascript:void(0)" data-ctgry="point" class="header_tab tab_select">포인트</a></li>
						<li><a href="javascript:void(0)" data-ctgry="cash"  class="header_tab">캐시</a></li>
						<li><a href="javascript:void(0)" data-ctgry="stemp" class="header_tab">스탬프</a></li>
						<span class="both"></span>
					</ul>
				</div>

				<!-- 포인트 -->
				<div id="point-wrap" class="view-wrap">
				  <div class="point_view">
					<ul>
						<li>
							<p class="f34 point_p w900"><span><fmt:formatNumber value="${totalVo.point.totalPoint}" type="number"/> </span>P</p>
							<p class="f18 w500">푸드 포인트 </p>
						</li>
						<li>
							<p class="f34 point_p w900"><span><fmt:formatNumber value="${totalVo.point.destroyExpectPoint}" type="number"/> </span>P</p>
							<p class="f18 w500">소멸 예정 포인트</p>
						</li>
						<span class="both"></span>
					</ul>
				  </div>

				  <table class="point_table" cellpadding="0" cellspacing="0" border="0" >
					<colgroup>
						<col style="width:43%">
						<col style="width:27%">
						<col style="width:30%">
					</colgroup>
					  <c:if test="${pointResult.pointList == null &&  fn:length(pointResult.pointList)  == 0  }">
						  <thead>
						  <tr>
							  <th colspan="3">적립된 포인트 내역이 없습니다.</th>
						  </tr>
						  </thead>
					  </c:if>
					<tbody class="point_body" data-nextyn="${pointResult.nextYn}">


					  <c:forEach var="item" items="${pointResult.pointList}"  varStatus="status">
							<tr class="point-tr pointNode" data-idx="${item.pnlId}">
								<td>
									<p class="f15 w500">${item.pnlEtc}</p>
								</td>
								<td>
									<c:if test="${item.pnlSave > 0 }">
										<p class="f15 point_plus w500"> <fmt:formatNumber value="${item.pnlSave}" type="number"/></p>
									</c:if>
									<c:if test="${item.pnlUse > 0 }">
										<p class="f15 point_minus w500"><fmt:formatNumber value="${item.pnlUse}" type="number"/></p>
									</c:if>

								</td>
								<td>
									<p class="f15 date gray w500">${item.pnlDate}</p>
								</td>
							</tr>
					  </c:forEach>
					</tbody>
				  </table>
				</div>
				<!-- 포인트 -->



				<!-- 캐시 -->
				<div id="cash-wrap" class="view-wrap hidden" >
					<div class="point_view">
						<ul>
							<li>
								<p class="f34 point_p w900"><span><fmt:formatNumber value="${totalVo.cash.useableExpectCash }" type="number"/></span></p>
								<p class="f18 w500">캐시</p>
							</li>
							<li>
								<p class="f34 point_p w900"><span><fmt:formatNumber value="${totalVo.cash.destroyExpectCash}" type="number"/></span></p>
								<p class="f18 w500">소멸 예정 캐시</p>
							</li>
							<span class="both"></span>
						</ul>
					</div>
					<table class="point_table" cellpadding="0" cellspacing="0" border="0" >
						<colgroup>
							<col style="width:43%">
							<col style="width:27%">
							<col style="width:30%">
						</colgroup>
						<c:if test="${cashResult.cashList == null &&  fn:length(cashResult.cashList)  == 0  }">
							<thead>
							<tr>
								<th colspan="3">적립된 캐시 내역이 없습니다.</th>
							</tr>
							</thead>
						</c:if>

						<tbody class="cash_body" data-nextyn="${cashResult.nextYn}">

						<c:forEach var="citem" items="${cashResult.cashList}"  varStatus="status">
						  <tr class="point-tr cashNode" data-idx="${citem.seq}">
							  <td>
								  <p class="f15 w500">${citem.cashGubun}</p>
							  </td>
							  <td>
								  <c:if test="${citem.gubun == 'save' }">
									  <p class="f15 cash_plus w500"> <fmt:formatNumber value="${citem.cashAmount}" type="number"/></p>
								  </c:if>
								  <c:if test="${citem.gubun == 'use' }">
									  <p class="f15 cash_minus  w500"><fmt:formatNumber value="${citem.cashAmount}" type="number"/></p>
								  </c:if>

							  </td>
							  <td>
								  <p class="f15 date gray w500">${citem.cashDate}</p>
							  </td>
						  </tr>

						</c:forEach>

						</tbody>
					</table>
                </div>
				<!-- 캐시 -->

				<div id="stemp-wrap" class="view-wrap hidden" >

					<div class="stemp_view">
						<ul>
							<li>
								<p class="f18 w500">푸드 스탬프</p>
							</li>
							<li>
								<p class="f34 point_p w900"><span>${stampResult.loyalcrown == null ? 0 : stampResult.loyalcrown}</span>/<span>${stampResult.crown == null ? 0 : stampResult.crown}</span>/<span>${stampResult.heart == null ? 0 : stampResult.heart}</span>/<span>${stampResult.stamp == null ? 0 : stampResult.stamp}</span></p>
							</li>
							<span class="both"></span>
						</ul>
						<div class="stemp_crown">
							<c:if test="${stampResult.crown >= 1}">
								<img src="/assets/images/step_crown_on.png" alt="큰왕관 스탬프 on" />
							</c:if>
							<c:if test="${(stampResult.crown == null ? 0 : stampResult.crown) < 1}">
								<img src="/assets/images/step_crown_off.png" alt="큰왕관 스탬프 off" />
							</c:if>
						</div>

						<div class="stemp_crown_small">
							<ul>
								<c:forEach begin="1" end="5"  varStatus="status">
									<c:choose>
									   <c:when test="${status.index <= stampResult.crown }">
										   <li><img src="/assets/images/step_crown_small_on.png" alt="왕관 스탬프 on" /></li>
									   </c:when>
									   <c:otherwise>
										   <li><img src="/assets/images/step_crown_small_off.png" alt="왕관 스탬프 off" /></li>
									   </c:otherwise>
								    </c:choose>
								</c:forEach>
								<span class="both"></span>
							</ul>
						</div>

						<div class="stemp_heart">
							<ul>
								<c:forEach begin="1" end="5"  varStatus="status">
									<c:choose>
										<c:when test="${status.index <= stampResult.heart }">
											<li><img src="/assets/images/step_heart_on.png" alt="하트 스탬프 on" /></li>
										</c:when>
										<c:otherwise>
											<li><img src="/assets/images/step_heart_off.png" alt="하트 스탬프 off" /></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
								<span class="both"></span>
							</ul>
						</div>

						<div class="stemp_normal">
							<ul>
								<c:forEach begin="1" end="5"  varStatus="status">
									<c:choose>
										<c:when test="${status.index <= stampResult.stamp }">
											<li><img src="/assets/images/step_0${status.index }_on.png" alt="숫자 스탬프 on" /></li>
										</c:when>
										<c:otherwise>
											<li><img src="/assets/images/step_0${status.index }_off.png" alt="숫자 스탬프 off" /></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
								<span class="both"></span>
							</ul>
						</div>

					</div>


					<table class="point_table" cellpadding="0" cellspacing="0" border="0" >
						<colgroup>
							<col style="width:43%">
							<col style="width:27%">
							<col style="width:30%">
						</colgroup>
						<c:if test="${stampResult.stampList == null &&  fn:length(stampResult.stampList)  == 0  }">
						<thead>
						<tr>
							<th colspan="3">적립된 스탬프 내역이 없습니다.</th>
						</tr>
						</thead>
						</c:if>
						<tbody class="stemp_body" data-nextyn="${stampResult.nextYn}">
						   <c:forEach var="sitem" items="${stampResult.stampList}"  varStatus="status">
						         <tr class="stempNode" data-idx="${sitem.stlId}">
									 <td>
										 <p class="f15 w500">${sitem.stlEtc}</p>
									 </td>
									 <td>
										 <c:choose>
											 <c:when test="${sitem.stlExchgeYN == '미사용'}">
												 <p class="f15 w500">${sitem.stlExchgeYN}</p>
											 </c:when>
											 <c:otherwise>
												 <p class="f15 point_use w500">${sitem.stlExchgeYN}</p>
											 </c:otherwise>
										 </c:choose>
									 </td>
									 <td>
										 <p class="f15 date gray w500">${sitem.stlRegDate}</p>
									 </td>
								 </tr>
						   </c:forEach>
						</tbody>
					</table>

					<div class="contents_foot">
						<p class="f20 w500 con_foot_tit">푸드 스탬프 적립 안내</p>
						<p class="f15 w500 con_foot_txt">
							적립기준
						</p>
						<p class="f12 w400 con_foot_txt2">
							<span class="point_p">스탬프 1개</span> - 매일 아침, 점심, 저녁, 기상시간, 수면시간, 오전, 오후 체중<br>
							<span class="point_p">하트 1개</span> - 스탬프가 5개 모이면 하트 1개로 교환됩니다.<br>
							<span class="point_p">왕관 1개</span> - 하트 5개가 모이면 왕관 1개로 교환됩니다.<br>
						</p>
						<p class="f15 w500 con_foot_txt">
							식단일기 입력 기준은 익일까지 작성한 식단까지만 발급됩니다.
						</p>
						<p class="f15 w500 con_foot_txt">
							쥬비스 관리기간내에 식단일기 작성시 적립됩니다.
						</p>
					</div>
				</div>
			</div>
		</div>

		<script src='<c:url value="/assets/juvis/profile/benefit_info.js"/>'></script>
	</body>
</html>