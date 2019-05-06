<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>연기 정정 신청</title>
</head>
<body>
    <div id="wrap">
        <div class="sign_detail">
            <div class="sign_top">
                <p class="f19 w500"><span class="w900">쥬비스</span> 고객님</p>
                <p class="f15 w500">프로그램 연기는 최소 2주부터<br>최대 6개월까지 신청 가능합니다.</p>
            </div>
            <div class="sign_middle_1">
                <div class="contract_txt">
                    <p class="f15 w700 cont_txt1">이름</p>
                    <p class="f15 w400 cont_txt2">
                        ${formDelayInfo.memName}
                    </p>
                    <span class="both"></span>
                </div>
                <div class="contract_txt">
                    <p class="f15 w700 cont_txt1">지점</p>
                    <p class="f15 w400 cont_txt2">
                        ${formDelayInfo.brcName}
                    </p>
                    <span class="both"></span>
                </div>
                <div class="contract_txt">
                    <p class="f15 w700 cont_txt1">연락처</p>
                    <p class="f15 w400 cont_txt2">
                        ${formDelayInfo.memSms}
                    </p>
                    <span class="both"></span>
                </div>
                <div class="contract_txt">
                    <p class="f15 w700 cont_txt1">생년월일</p>
                    <p class="f15 w400 cont_txt2">
                        ${formDelayInfo.dlyBirthday}
                    </p>
                    <span class="both"></span>
                </div>
                <div class="contract_txt">
                    <p class="f15 w700 cont_txt1">연기기간</p>
                    <p class="f15 w400 cont_txt2">
                        ${formDelayInfo.dlyStartDate} ~ ${formDelayInfo.dlyEndDate}
                    </p>
                    <span class="both"></span>
                </div>
                <div class="contract_txt">
                    <p class="f15 w700 cont_txt1">연기중 관리여부</p>
                    <p class="f15 w400 cont_txt2">
                         ${formDelayInfo.dlyManageYN}
                    </p>
                    <span class="both"></span>
                </div>
                <div class="contract_txt">
                    <p class="f15 w700 cont_txt1">신청일</p>
                    <p class="f15 w400 cont_txt2">
                        ${formDelayInfo.dlyRegDate}
                    </p>
                    <span class="both"></span>
                </div>
                <div class="contract_txt">
                    <p class="f15 w700 cont_txt1">처리일</p>
                    <p class="f15 w400 cont_txt2">
                        ${formDelayInfo.dlyUdtDate}
                    </p>
                    <span class="both"></span>
                </div>
                <div class="contract_txt">
                    <p class="f15 w700 cont_txt1">사유</p>
                    <p class="f15 w400 cont_txt2">
                        ${formDelayInfo.dlyReasonDesc} - ${formDelayInfo.dlyContents}
                    </p>
                    <span class="both"></span>
                </div>
                <div class="contract_txt">
                    <p class="f15 w700 cont_txt1">구분</p>
                    <p class="f15 w400 cont_txt2">
                        <c:choose>
                            <c:when test="${formDelayInfo.dlyType eq 'W'}">고객신청</c:when>
                            <c:when test="${formDelayInfo.dlyType eq 'B'}">지점신청</c:when>
                            <c:when test="${formDelayInfo.dlyType eq 'A'}">앱신청</c:when>
                            <c:otherwise>기타</c:otherwise>
                        </c:choose>
                    </p>
                    <span class="both"></span>
                </div>
                <div class="contract_txt">
                    <p class="f15 w700 cont_txt1">처리상태</p>
                    <p class="f15 w400 cont_txt2">
                        ${formDelayInfo.dlyStatusDesc}
                    </p>
                    <span class="both"></span>
                </div>


                <div class="contract_tit">
                    <p class="f15 w700 cont_txt1">연기정정 신청 기간</p>
                </div>
                <div class="contract_input">
                    <%--<form>--%>
                        <fieldset>
                            <!-- 시작일 -->
                            <div class="sign_start sign_ipt">
                                <label for="dlcStartDate" class="hidden">연기 신청기간 시작일</label>
                                <div class="sign_sub_box">
                                    <input type="text" value="${formDelayInfo.dlyStartDate}" id="dlcStartDate" name="dlcStartDate" class="inp_w2" maxlength="50" placeholder="예) 20190105" readonly="readonly">
                                </div>
                            </div>
                            <span class="sign_ipt2">-</span>

                            <!-- 마감일 -->
                            <div class="sign_last sign_ipt">
                                <label for="dlcEndDate" class="hidden">연기 신청기간 마감일</label>
                                <div class="sign_sub_box">
                                    <input type="number" value="" id="dlcEndDate" name="dlcEndDate" class="inp_w2" maxlength="50" placeholder="예) 20190115" >
                                </div>
                            </div>
                            <span class="both"></span>


                            <!-- 기타 사유 -->
                            <div class="contract_tit">
                                <p class="f15 w700 cont_txt1">연기정정 사유</p>
                            </div>
                            <div class="contract_txt">

                                <div class="reason">
                                    <fieldset>
                                        <label for="dlcContents" class="hidden">기타 사유</label>
                                        <div class="reason_box">
                                            <input type="text" value="" id="dlcContents" name="dlcContents" class="inp_w2" maxlength="50" placeholder="">
                                        </div>
                                    </fieldset>
                                </div>
                                <span class="both"></span>
                            </div>

                            <!-- 휴대폰 -->
                            <div class="sign_tel sign_ipt3">
                                <label for="memSms" class="hidden">휴대폰</label>
                                <div class="bank_sub_box">
                                    <input type="tel" value="" id="memSms" name="memSms" class="inp_w1" maxlength="50" placeholder="‘-’ 없이 숫자만">
                                    <a href="#" class="btn_cert btn_cert1" id="btn_send_auth">인증번호 받기</a><br>
                                    <span class="both"></span>
                                </div>
                            </div>


                            <!-- 인증번호 -->
                            <div class="sign_agree sign_ipt3">
                                <label for="sign_num" class="hidden">인증번호</label>
                                <div class="bank_sub_box">
                                    <input type="number" pattern="\d*" value="" id="sign_num" name="sign_num" class="inp_w1" maxlength="50" placeholder="">
                                    <a href="#" class="btn_cert btn_cert2" id="btn_check_auth">인증번호 확인</a><br>
                                    <span class="both"></span>
                                </div>
                            </div>

                            <div class="sign_txt_box">
                                ${dcmContent}
                            </div>
                            <div class="sign_check sign_ipt3">
                                <label for="check_agree" class="check_agree">
                                    <input type="checkbox" value="" id="check_agree" class="check_agree" name="check_agree"><span class="fake_chk">SMS 인증 및 약관에 동의합니다. </span>
                                </label>
                                <p class="f12 w500">
                                    부득이한 사정으로 인해 연기신청 정정을 하셔야 할 경우 연기신청 정정 후 관리에 불편함이 없도록 연기신청 정정서의 특약조항을 꼼꼼히 체크해주세요.
                                </p>
                            </div>

                            <div class="refund_btn">
                                <button type="button" class="btn_line btn_cancel" id="3213" style="">취소</button>
                                <button type="submit" class="btn_submit btn_submit_half" id="btn_insert_delayCancel" style="">입력</button>
                            </div>
                        </fieldset>
                    <%--</form>--%>

                    <div clas="hidden">
                        <input type="hidden" id="msnId" name="msnId" value=""/>
                        <input type="hidden" id="dlyId" name="dlyId" value="${formDelayInfo.dlyId}"/>
                        <input type="hidden" id="brcId" name="brcId" value="${formDelayInfo.brcId}"/>
                        <input type="hidden" id="ctrId" name="ctrId" value="${formDelayInfo.ctrId}"/>
                        <input type="hidden" id="ctdId" name="ctdId" value="${formDelayInfo.ctdId}"/>
                        <input type="hidden" id="dlyRedo" name="dlyRedo" value="${formDelayInfo.dlyRedo}"/>
                        <input type="hidden" id="ctdStfId" name="ctdStfId" value="${formDelayInfo.ctdStfId}"/>
                        <input type="hidden" id="memId" name="memId" value="${formDelayInfo.memId}"/>
                        <%--<input type="hidden" id="memSms" name="memSms" value="${formDelayInfo.memSms}"/>--%>
                        <input type="hidden" id="dlyBirthday" name="dlyBirthday" value="${formDelayInfo.memBirthday}"/>
                        <input type="hidden" id="dlySex" name="dlySex" value="${formDelayInfo.memSex}"/>
                        <input type="hidden" id="dlyStartDate" name="dlyStartDate" value="${formDelayInfo.dlyStartDate}"/>
                        <input type="hidden" id="dlyEndDate" name="dlyEndDate" value="${formDelayInfo.dlyEndDate}"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src='<c:url value="/assets/juvis/delay/delay_cancel_form.js"/>'></script>
</body>
</html>