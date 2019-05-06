<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>연기 신청</title>
</head>
<body>
    <div id="wrap">
        <form id='delayForm' name="delayForm" enctype="multipart/form-data">
        <div class="sign_detail">
            <div class="sign_top">
                <p class="f19 w500"><span class="w900">쥬비스</span> 고객님</p>
                <p class="f15 w500">프로그램 연기는 최소 2주부터<br>최대 6개월까지 신청 가능합니다.</p>
            </div>
            <div class="sign_middle_1">
                <div class="contract_txt">
                    <p class="f15 w700 cont_txt1">이름</p>
                    <p class="f15 w400 cont_txt2">
                        ${data.memberVO.memName}
                    </p>
                    <span class="both"></span>
                </div>
                <div class="contract_txt">
                    <p class="f15 w700 cont_txt1">지점</p>
                    <p class="f15 w400 cont_txt2">
                        ${data.brcName}
                    </p>
                    <span class="both"></span>
                </div>
                <div class="contract_txt">
                    <p class="f15 w700 cont_txt1">이메일</p>
                    <p class="f15 w400 cont_txt2">${data.memberVO.memEmail}</p>
                    <span class="both"></span>
                </div>
                <div class="contract_txt">
                    <p class="f15 w700 cont_txt1">연락처</p>
                    <p class="f15 w400 cont_txt2">${data.memberVO.memSms}</p>
                    <span class="both"></span>
                </div>
                <div class="contract_txt">
                    <p class="f15 w700 cont_txt1">생년월일</p>
                    <p class="f15 w400 cont_txt2">${data.memberVO.memBirthday}</p>
                    <span class="both"></span>
                </div>
                <div class="contract_txt">
                    <p class="f15 w700 cont_txt1">성별</p>
                    <p class="f15 w400 cont_txt2">
                        <c:choose>
                            <c:when test="${data.memberVO.memSex == 'F'}">여</c:when>
                            <c:otherwise>남</c:otherwise>
                        </c:choose>
                    </p>
                    <span class="both"></span>
                </div>
                <div class="contract_txt">
                    <p class="f15 w700 cont_txt1">프로그램 기간</p>
                    <p class="f15 w400 cont_txt2">${data.ctdStartDate} ~ ${data.ctdEndDate}</p>
                    <span class="both"></span>
                </div>
                <div class="contract_txt">
                    <p class="f15 w700 cont_txt1">연기신청 사유</p>
                    <!-- 연기신청 라디오 버튼 -->

                    <div class="delay_radio">
                            <fieldset>

                                <c:forEach var="item" items="${delayReasonList.cdList}"  varStatus="status">
                                    <div class="delay_radio_box">
                                        <label for="delay_${status.index}" class="delay_radio_btn">
                                            <input type="radio" value="${item.pubName}" id="delay_${status.index}" name="dlyReason" class="inp_w4"><span class="fake_chk1">${item.pubDesc}</span>
                                        </label>
                                    </div>
                                </c:forEach>

                                <%--
                                <div class="delay_radio_box">
                                    <label for="delay_1" class="delay_radio_btn">
                                        <input type="radio" value="delay_1" id="delay_1" name="delay" class="inp_w4"><span class="fake_chk1">임신(출산)</span>
                                    </label>
                                </div>
                                <div class="delay_radio_box">
                                    <label for="delay_2" class="delay_radio_btn">
                                        <input type="radio" value="delay_2" id="delay_2" name="delay" class="inp_w4"><span class="fake_chk1">해외출장</span>
                                    </label>
                                </div>
                                <div class="delay_radio_box">
                                    <label for="delay_3" class="delay_radio_btn">
                                        <input type="radio" value="delay_3" id="delay_3" name="delay" class="inp_w4"><span class="fake_chk1">병원입원</span>
                                    </label>
                                </div>
                                <div class="delay_radio_box">
                                    <label for="delay_4" class="delay_radio_btn">
                                        <input type="radio" value="delay_4" id="delay_4" name="delay" class="inp_w4"><span class="fake_chk1">메르스(MERS)</span>
                                    </label>
                                </div>
                                <div class="delay_radio_box">
                                    <label for="delay_5" class="delay_radio_btn">
                                        <input type="radio" value="delay_5" id="delay_5" name="delay" class="inp_w4"><span class="fake_chk1">기타 사유</span>
                                    </label>
                                </div>
                                --%>
                            </fieldset>
                    </div>
                    <span class="both"></span>
                    <!-- 연기신청 라디오 버튼 끝 -->
                </div>
                <div class="contract_txt">
                    <p class="f15 w700 cont_txt1">기타 사유</p>
                    <!-- 기타 사유 -->
                    <div class="reason">
                            <fieldset>
                                <label for="dlyContents" class="hidden">기타 사유</label>
                                <div class="reason_box">
                                    <input type="text" value="" id="dlyContents" name="dlyContents" class="inp_w2" maxlength="50" placeholder="">
                                </div>
                            </fieldset>
                    </div>
                    <span class="both"></span>
                </div>
                <div class="contract_txt">
                    <p class="f15 w700 cont_txt1">증빙서류 첨부</p>
                    <div class="add_report">
                        <input type="file" id="attrFile" name="attrFile"/>
                        <p class="f12 w500 cont_txt1">이미지 형태의 파일만 첨부 가능합니다. 증빙서류가 문서일 경우 지점 방문 시 전달해주세요.</p>
                    </div>
                    <span class="both"></span>
                </div>
                <div class="contract_tit">
                    <p class="f15 w700 cont_txt1">연기신청 기간</p>
                </div>
                <div class="contract_input">
                    <%--<form>--%>
                        <fieldset>
                            <!-- 시작일 -->
                            <div class="sign_start sign_ipt">
                                <label for="dlyStartDate" class="hidden">연기 신청기간 시작일</label>
                                <div class="sign_sub_box">
                                    <input type="number" value="" id="dlyStartDate" name="dlyStartDate" class="inp_w2" maxlength="50" placeholder="예) 20190105">
                                </div>
                            </div>
                            <span class="sign_ipt2">-</span>

                            <!-- 마감일 -->
                            <div class="sign_last sign_ipt">
                                <label for="dlyEndDate" class="hidden">연기 신청기간 마감일</label>
                                <div class="sign_sub_box">
                                    <input type="number" value="" id="dlyEndDate" name="dlyEndDate" class="inp_w2" maxlength="50" placeholder="예) 20190115" >
                                </div>
                            </div>
                            <span class="both"></span>

                            <div class="contract_tit">
                                <p class="f15 w700 cont_txt1">휴대폰 인증</p>
                            </div>

                            <!-- 휴대폰 -->

                            <div class="sign_tel sign_ipt3">
                                <label for="sign_tel" class="hidden">휴대폰</label>
                                <div class="bank_sub_box">
                                    <input type="number" value="" id="sign_tel" name="memSms" class="inp_w1" maxlength="50" placeholder="‘-’ 없이 숫자만">
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
                                <%--<span class="f12 w500">입력시간  <span>59:59</span></span>--%>
                            </div>


                            <div class="sign_txt_box">
                                <%--<p class="f13">
                                    본인은 쥬비스 프로그램을 서비스를 연기 신청하였으며 아래 특
                                    약 조항에 대하여 충분히 고지 받은 후 계약에 동의한다.<br>
                                    [특약조항]<br>
                                        연기는 집중관리시 1회, 유지관리시 1회씩만 가능하며, 고객님
                                        과 정한 첫 관리일은 연기가 불가합니다.<br>
                                        연기신청은 관리가 종료되지 않은 관리기간 중에만 신청할 수
                                        있습니다.<br>
                                        연기는 신청일로부터 최소 2주~`최대6개월까지이며 연기 후 관
                                        리 기간은 연기 기간 종료일 다음날로부터 약정된 남은 잔여일입
                                        니다. (단, 임신으로 인해 연기가 필요한 경우에는 최대 1년까지
                                        연기가 가능합니다)<br>
                                        연기 불가 사유 - 프로그램 등록 후 첫관리 일자 연기의 경우- 연기신청서를 작성하지 않은 경우- 관리기간이 이미 만료된 경우- 남은 프로그램 기간이 4주 미만이거나 4주 이하 프로그램을 등록한 경우.- 서비스 프로그램만 나은 경우- 연기 사유에 해당하는 서류를 제출하지 않은 경우
                                        기간 연기를 한 고객님의 경우 연기 기간을 제외하고 남아 있는 계약 기간에 대해 부분 환불이 가능합니다. 단, 기간 재설정 괙님이 연기를 한 경우에 대해서는 환불이 불가능합니다.<br>
                                        연기 신청에 대한 기준은 프로그램별로 다를 수 있음을 알려드립니다.<br>
                                        본 사항에 대한 자세한 설명을 듣고 이에 동의하며 본인 인증을 통해서 서명을 대체합니다.<br><br>

                                        또한 저작권에 관한 모든 권한은 (주)쥬비스그룹에 귀속됨을 동의합니다.
                                </p>--%>
                                <%--<p class="f13">--%>
                                    ${dcmContent}
                                    <%--
                                    <p>
                                        본 약관은 다이어트 전문기업 쥬비스(이하 '회사'라 함)가 제공하는 다이어트컨설팅서비스, 운동컨설팅서비스(이하 통칭 '서비스'라 함)의 관리기간을 연기하는데 있어 회사와 회원사이의 권리 및 의무사항 등을 규정함에 그 목적을 둔다.</p>
                                    <p>
                                        회원은 "연기신청 계약서"를 작성함에 있어 아래 특약조항에 대해서 충분히 고지 받은 후 본 계약에 동의한다.</p>
                                    <p>
                                        &nbsp;</p>
                                    <p>
                                        고객님께서 현재 진행하고 계시는 쥬비스 다이어트는 지방세포의 사이즈를 줄이는 다이어트로 적정 체중을 6개월 이상 유지했을 경우 요요없는 다이어트가 완성 됩니다.</p>
                                    <p>
                                        하지만 연기 신청으로 인해 다이어트가 중도에 중지될 경우 인체 구조상 지방세포는 다시 늘어날 확률이 높아지게 되기 때문에 그동안 진행한 다이어트의 효과가 감소될 수 있습니다.</p>
                                    <p>
                                        따라서 쥬비스는 되도록이면 고객님께서 연기 없이 지속적인 다이어트를 진행하길 권해 드립니다.&nbsp;</p>
                                    <p>
                                        &nbsp;</p>
                                    <p>
                                        &lt;특약조항&gt;</p>
                                    <p>
                                        &nbsp;</p>
                                    <p>
                                        1. 연기는 집중관리시 1회, 유지관리시 1회씩만 가능하며, 고객님과 정한 첫관리일은 연기가 불가합니다.</p>
                                    <p>
                                        &nbsp;</p>
                                    <p>

                                        2. 연기신청은 관리가 종료되지 않은 관리기간 중에만 신청하실 수 있습니다.</p>
                                    <p>
                                        &nbsp;</p>
                                    <p>
                                        3. 연기는 신청일로부터 최소2주~ 최대 6개월까지이며 연기 후 관리 기간은 연기기간 종료일 다음날로부터 약정된 남은 잔여일입니다. (단, 임신으로 인해 연기가 필요한 경우에는 최대 1년까지 연기가 가능합니다.)</p>
                                    <p>
                                        &nbsp;</p>
                                    <p>
                                        4. 아래와 같은 경우에는 연기신청이 불가합니다.</p>
                                    <p>
                                        ① 프로그램 등록 후 첫관리 일자 연기의 경우</p>
                                    <p>
                                        ② 연기신청서를 작성하지 않은 경우(연기 신청서가 작성되지 않을 경우 연기가 되지 않습니다.)</p>
                                    <p>
                                        ③ 관리기간이 이미 만료된 경우</p>
                                    <p>
                                        ④ 남은 프로그램 기간이 4주 미만이거나 4주 이하의 프로그램을 등록한 경우</p>
                                    <p>
                                        ⑤ 서비스 프로그램만 남았을 경우(요요방지 프로그램, 보너스 서비스 등)</p>
                                    <p>
                                        ⑥ 이미 연기 1회를 사용한 경우</p>
                                    <p>
                                        ⑦ 연기사유에 해당하는 서류를 제출하지 않은 경우</p>
                                    <p>
                                        &nbsp;</p>
                                    <p>
                                        5. 기간 연기를 한 고객님의 경우 연기 기간을 제외하고 남아 있는 계약 기간에 대해 부분 환불이 가능합니다.</p>
                                    <p>
                                        단, 기간 재설정 고객님이 연기를 한 경우에 대해서는 환불이 불가능합니다.</p>
                                    <p>
                                        &nbsp;</p>
                                    <p>
                                        6. 연기신청에 대한 기준은 프로그램별로 다를 수 있음을 알려드립니다.</p>
                                    <p>
                                        &nbsp;</p>
                                    <p>
                                        &nbsp;</p>
                                    <p>
                                        "본 약관은 법적효력을 지닌 약관입니다"</p>
                                    <p>
                                        &nbsp;</p>
                                    <p>
                                        본 약관에 명시된 연기신청에 대한 자세한 설명을 들었음에 자필 서명합니다.</p>
                                    <p>
                                        &nbsp;</p>
                                    <p>
                                        &nbsp;</p>
                                    --%>

                                    <%--</p>--%>
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
                                <button type="submit" class="btn_submit btn_submit_half" id="btn_insert_delay" style="">입력</button>
                            </div>
                        </fieldset>
                    <%--</form>--%>

                    </form>

                    <div clas="hidden">
                        <input type="hidden" id="msnId" name="msnId" value=""/>
                        <input type="hidden" id="brcId" name="brcId" value="${data.brcId}"/>
                        <input type="hidden" id="ctrId" name="ctrId" value="${data.ctrId}"/>
                        <input type="hidden" id="ctdId" name="ctdId" value="${data.ctdId}"/>
                        <input type="hidden" id="dlyRedo" name="dlyRedo" value="${data.dlyRedo}"/>
                        <input type="hidden" id="ctdStfId" name="ctdStfId" value="${data.ctdStfId}"/>
                        <input type="hidden" id="memId" name="memId" value="${data.memberVO.memId}"/>
                        <%--<input type="hidden" id="memSms" name="memSms" value="${data.memberVO.memSms}"/>--%>
                        <input type="hidden" id="dlyBirthday" name="dlyBirthday" value="${data.memberVO.memBirthday}"/>
                        <input type="hidden" id="dlySex" name="dlySex" value="${data.memberVO.memSex}"/>
                        <input type="hidden" id="ctdStartDate" name="ctdStartDate" value="${data.ctdStartDate}"/>
                    </div>
                </div>
            </div>

        </div>
        </form>
    </div>
    <script src='<c:url value="/assets/juvis/delay/delay_form.js"/>'></script>
</body>
</html>