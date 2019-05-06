<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<title>쥬비스 다이어트 | 서바이벌 오프라인</title>
	</head>
		
	<body>
		<div id="wrap">
			<div class="sur_offline_box">
				<div class="sur_view">
					<img src="/assets/images/offsurvival_banner.jpg">
				</div>
				<div class="sur_txt">
				<c:if test="${data.svvStatus == 'DS01' }">
				<p class="f14 w500">
          ${data.memId} 고객님은 현재 <span class="point_p">${data.svvYm} </span> 서바이벌에 참가 중입니다.<br>
          현재 기준으로 서바이벌 랭킹은 <span class="point_p">${data.svvRank} 위 </span>입니다.<br>
          식단일기 진척률은 현재기준으로 <span class="point_p">${data.svvDiaryRate} % </span>입니다.<br>
          진행 계획 횟수 ${data.svvDiaryPlan} 회 중 ${data.svvDiaryDo} 회를 진행 하셨습니다.<br>

          </p>
				</c:if>
				<c:if test="${data.svvStatus != 'DS01' }">
					<p class="f14 w500">
						<span class="point_p w900">쥬비스 다이어트 오프라인 서바이벌 이란?</span><br>
						매월 관리 완료(프로그램 종료기준)를 적정 체중까지 감량후,
						추가 감량을 한 고객님을 선정합니다.
					</p>
				</c:if>
					<p class="mg5">
						<img src="/assets/images/offsurvival_icon00.png" alt="cash" width="30%">
					</p>
					<p class="f14 w500">
						랭킹 1위로 선정된 고객님께는<br>
						신청 당시 등록회차 <span class="point_p">프로그램 비용을 100% 쥬비스 캐시</span>,<br>
						랭킹 2위로 선정된 고객님께는<br>
						신청 당시 등록회차 <span class="point_p">프로그램 비용을 50% 쥬비스 캐시</span>로<br>
						환급해드립니다!
					</p>

				</div>
				<div class="sur_submit">
					<button type="submit" class="btn_submit2" id="check_survival">신청하기</button>
				</div>
				<div class="contents_foot">
					<p class="f20 w500 con_foot_tit">오프라인 서바이벌 신청 안내</p>
					<ul class="sur_processBox">
						<li>
							<dl class="sur_process">
								<dt>
									<img src="/assets/images/offsurvival_icon01.png" alt="" border="0" width="95%">
								</dt>
								<dd>
									<p class="f16 sur_unline">신청조건</p>
									<p class="f14 w500">
										기존 고객님의 경우 집중관리를 추가 등록하시면 서바이벌에 참여하실 수 있습니다.
									</p>
								</dd>
							</dl>
						</li>
						<li>
							<dl class="sur_process">
								<dt>   
									<img src="/assets/images/offsurvival_icon02.png" alt="" border="0" width="95%">
								</dt>
								<dd>
									<p class="f16 sur_unline">신청방법</p>
									<p class="f14 w500">
										서바이벌은 <span class="point_p">집중관리 시작 전 신청</span>해주셔야 가능합니다.(관리 연기 시 제외)
									</p>
								</dd>
							</dl>
						</li>
						<li>
							<dl class="sur_process">
								<dt>   
									<img src="/assets/images/offsurvival_icon03.png" alt="" border="0" width="95%">
								</dt>
								<dd>
									<p class="f16 sur_unline">선정조건 및 방법</p>
									<p class="f14 w500">
										집중관리 기간 동안 <span class="point_p">식단일기 100% 적정체중 이후 가장 많은 체중을 감량</span>한 달성 고객님에 한해 선정됩니다.
									</p>
								</dd>
							</dl>
						</li>
						<li>
							<dl class="sur_process">
								<dt>   
									<img src="/assets/images/offsurvival_icon04.png" alt="" border="0" width="95%">
								</dt>
								<dd>
									<p class="f16 sur_unline">선정자 필수사항</p>
									<p class="f14 w500">
										<span class="point_p">체중감량에 대한 데이터 및 감량전 비포사진 공개, 성공 인터뷰 촬영을 의무</span>로 진행해주셔야합니다.
									</p>
								</dd>
							</dl>
						</li>
					</ul>
				</div>
			</div>
		</div>

				<script src='<c:url value="/assets/juvis/survival/survival_info.js"/>'></script>
</body></html>