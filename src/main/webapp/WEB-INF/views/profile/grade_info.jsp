<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>쥬비스 다이어트 | 등급정도 및 혜택</title>
</head>
<body>
${data}
    <div id="wrap">
        <div class="mem_grade_box">
            <div class="grade_top">
                <img src="<c:url value="/assets/images/grade_r.png"/>" alt="등급이미지"/>
                <div>
                    <p class="f20"><span class="w900">${item.memName}</span> 고객님은</p>
                    <p class="f20"><span class="w900 point_p">${item.memClass}</span> 등급입니다.</p>
                    <p class="f14 gray subtxt1"><span>플래티넘</span> 등급까지 <span class="w900"><fmt:formatNumber value="${item.upgradeRemainPrice}" type="number"/>원</span> 남았습니다.</p>
                </div>
                <div class="gauge">
                    <div class="gauge_line" style="width:${item.totCtpPrice * 100 / 25000000}%">
                    </div>
                    <div class="bar_box gray w400 bar1">
                        <span class="gauge_bar"></span>
                        베이직
                    </div>
                    <div class="bar_box gray w400 bar2">
                        <span class="gauge_bar"></span>
                        스페셜
                    </div>
                    <div class="bar_box gray w400 bar3">
                        <span class="gauge_bar"></span>
                        프리미엄
                    </div>
                    <div class="bar_box gray w400 bar4">
                        <span class="gauge_bar"></span>
                        플래티넘
                    </div>
                    <div class="bar_box gray w400 bar5">
                        <span class="gauge_bar"></span>
                        다이아
                    </div>
                </div>
            </div>
            <div class="contents">
                <div class="con_grade_box">
                    <p class="f16 grade_b w500">베이직 등급</p>
                    <p class="f16 money point_p w500">0 ~ 999만원</p>
                </div>

                <div class="con_grade_box">
                    <p class="f16 grade_s w500">스페셜 등급</p>
                    <p class="f16 money point_p w500">1,000 ~ 1,499만원</p>
                </div>

                <div class="con_grade_txt">
                    <p class="f14 w400">- 요요방지 프로그램 3회 추가 <span class="gray">(771,000원 상당)</span></p>
                    <p class="f14 w400">- 엑티베이션 3회 추가 <span class="gray">(180,000원 상당)</span></p>
                </div>

                <div class="con_grade_box">
                    <p class="f16 grade_r w500">프리미엄 등급</p>
                    <p class="f16 money point_p w500">1,500 ~ 1,999만원</p>
                </div>

                <div class="con_grade_txt">
                    <p class="f14 w400">- 요요방지 프로그램 3회 추가 <span class="gray">(771,000원 상당)</span></p>
                    <p class="f14 w400">- 울트라소닉 3회 추가 <span class="gray">(240,000원 상당)</span></p>
                    <p class="f14 w400">- 샐러드를 그대로 28포 <span class="gray">(92,000원 상당)</span></p>
                </div>

                <div class="con_grade_box">
                    <p class="f16 grade_p w500">플래티넘 등급</p>
                    <p class="f16 money point_p w500">2,000 ~ 2,499만원</p>
                </div>

                <div class="con_grade_txt">
                    <p class="f14 w400">- 요요방지 프로그램 3회 추가 <span class="gray">(771,000원 상당)</span></p>
                    <p class="f14 w400">- 울트라소닉 3회 추가 <span class="gray">(240,000원 상당)</span></p>
                    <p class="f14 w400">- 엑티베이션 3회 추가 <span class="gray">(180,000원 상당)</span></p>
                    <p class="f14 w400">- 샐러드를 그대로 28포 <span class="gray">(92,000원 상당)</span></p>
                    <p class="f14 w400">- 쥬비스 명절선물 증정 <span class="gray">(160,000원 상당)</span></p>
                </div>

                <div class="con_grade_box">
                    <p class="f16 grade_d w500">다이아 등급</p>
                    <p class="f16 money point_p w500">2,500만원 ~</p>
                </div>

                <div class="con_grade_txt">
                    <p class="f14 w400">- 요요방지 프로그램 3회 추가 <span class="gray">(771,000원 상당)</span></p>
                    <p class="f14 w400">- 울트라소닉 3회 추가 <span class="gray">(240,000원 상당)</span></p>
                    <p class="f14 w400">- 엑티베이션 3회 추가 <span class="gray">(180,000원 상당)</span></p>
                    <p class="f14 w400">- 샐러드를 그대로 28포 <span class="gray">(92,000원 상당)</span></p>
                    <p class="f14 w400">- 비타민 B를 그대로 30포 <span class="gray">(92,000원 상당)</span></p>
                    <p class="f14 w400">- 100% 현미로 만든 현미빵 <span class="gray">(50,000원 상당)</span></p>
                    <p class="f14 w400">- 쥬비스 명절선물 증정 <span class="gray">(160,000원 상당)</span></p>
                </div>
            </div>
            <div class="contents_foot">
                <p class="f20 w500 con_foot_tit">베이직 등급</p>
                <p class="f14 w400 con_foot_txt">
                        전년도 누적 결제금액에 따라 해당 연도 승급이 결정되며, 결정된 등급은
                        1년간 유효합니다. (2019년 승급 유효기간은 2019년 1월~12월까지)
                    </p>
                    <p class="f14 w400 con_foot_txt">
                        해당 연도의 누적 재등록 금액에 따라 다음 등급으로 승급이 가능하며,
                        승급하실 경우 승급한 등급의 혜택이 제공됩니다.
                    </p>
                    <p class="f14 w400 con_foot_txt">
                        프로그램을 환불 또는 양도하실 경우, 승급 혜택은 취소됩니다.
                    </p>
                    <p class="f14 w400 con_foot_txt">
                        프로그램 변경 시에는 변경 전 프로그램의 등록금액에 따른
                        승급 혜택은 취소됩니다.
                    </p>
                    <p class="f14 w400 con_foot_txt">
                        2019년 신규로 등록하시는 고객님의 경우는 기본 등급인 베이직에 해당되며,
                        2019년 총 등록금액에 따라 2020년도에 등급이 결정되어
                        승급 혜택을 받으실 수 있습니다.
                    </p>
                    <p class="f14 w400 con_foot_txt">
                        해당 등급의 자격이 유지되는 경우 혜택을 받으실 수 있으며,
                        승급 혜택은  정해진 유효기간 내 사용하셔야 합니다.
                        (유효기간 이후에는 혜택이 제공되지 않습니다)
                    </p>
                    <p class="f14 w400 con_foot_txt">
                        등록 금액 기준은 관리 중 프로그램이 남아있을 경우에 한해 누적되며,
                        모든 프로그램이 관리 완료 될 경우에는 누적금액 혜택 또한 종료됩니다.
                    </p>
                    <p class="f14 w400 con_foot_txt">
                        울트라소닉 및 액티베이션 기기 추가 혜택은 지점에서 관리받으실 때
                        추가로 이용 가능합니다.  (해당 기기 혜택만 별도로 이용하실 수 없습니다.)
                    </p>
                    <p class="f14 w400 con_foot_txt">
                        2018년 관리 중이신 고객님들의 경우, 2018년 등급이 2019년에도
                        그대로 유지될 예정이며,    변경된 혜택은 2019년 승급하실 경우 제공됩니다.
                    </p>
                </div>
            </div>

        </div>
    </body>
</html>