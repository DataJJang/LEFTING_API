<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>쥬비스 다이어트 | 회원정보</title>
</head>
<body>
		<div id="wrap">
			<div class="member_box member_top">
				<form>
					<fieldset>
						<legend>회원정보1</legend>

							<!-- 입력필드 -->
							<!-- 성별 -->
							<div class="member_sex member_ipt">
								<span class="sub_txt2 v_bottom">성별${crudMode}</span>
								<div class="member_sex_box">
									<label for="F" class="radio_btn">
										<input type="radio" value="F" id="F" name="sex" class="inp_w4" <c:if test="${item.memSex eq 'F'}">checked='checked'</c:if> <c:if test="${crudMode eq 'R'}">disabled='disabled'</c:if> ><span class="fake_chk1">여성</span>
									</label>
								</div>
								<div class="member_sex_box">
									<label for="M" class="radio_btn">
										<input type="radio" value="M" id="M" name="sex" class="inp_w4" <c:if test="${item.memSex eq 'M'}">checked='checked'</c:if> <c:if test="${crudMode eq 'R'}">disabled='disabled'</c:if> ><span class="fake_chk1">남성</span>
									</label>
								</div>
							</div>
							 <span class="both"></span>

							<!-- 연령 -->
							<div class="member_age member_ipt">
								<span class="sub_txt2">연령</span>
								<div class="member_sub_box">
									<label for="mb_name" class="hidden">연령</label>
									<input type="number" pattern="\d*" value="${item.memCurrentAge}" id="mb_age" name="mb_age" class="inp_w2" maxlength="3" oninput="maxLengthCheck(this)" placeholder="37" <c:if test="${crudMode eq 'R'}">readonly='readonly'</c:if> ><span class="sub_txt3" >세</span>
								</div>
							</div>

							<!-- 신장 -->
							<div class="member_height member_ipt">
								<span class="sub_txt2">신장</span>
								<div class="member_sub_box">
									<label for="mb_height" class="hidden">신장</label>
									<input type="number" value="${item.memHeight}" id="mb_height" name="mb_height" class="inp_w2" maxlength="5" oninput="maxLengthCheck(this)" placeholder="" <c:if test="${crudMode eq 'R'}">readonly='readonly'</c:if>><span class="sub_txt3">cm</span>
								</div>
							</div>

							<!-- 체중 -->
							<div class="member_weight member_ipt">
								<span class="sub_txt2">체중</span>
								<div class="member_sub_box">
									<label for="mb_weight" class="hidden">체중</label>
									<input type="number" value="${item.chtWeightAfter}" id="mb_weight" name="mb_weight" class="inp_w2" maxlength="5" oninput="maxLengthCheck(this)" placeholder="" <c:if test="${crudMode eq 'R'}">readonly='readonly'</c:if>><span class="sub_txt3">kg</span>
								</div>
							</div>
					</fieldset>
				</form>
			</div>

			<div class="member_box member_middle">
				<form>
					<fieldset>
						<legend>회원정보2</legend>
							<!-- 입력필드 -->
							<!-- 목표체중 -->
							<div class="member_g_weight member_ipt">
								<span class="sub_txt2">목표체중</span>
								<div class="member_sub_box">
									<label for="mb_g_weight" class="hidden">목표체중</label>
									<input type="number" value="${item.memWishWeight}" id="mb_g_weight" name="mb_g_weight" class="inp_w2" maxlength="3" oninput="maxLengthCheck(this)" placeholder="" <c:if test="${crudMode eq 'R'}">readonly='readonly'</c:if>><span class="sub_txt3">kg</span>
								</div>
							</div>

							<!-- 목표기간 -->
							<!--
							<div class="member_g_week member_ipt">
								<span class="sub_txt2">목표기간</span>
								<div class="member_sub_box">
									<label for="mb_g_week" class="hidden">목표기간</label>
									<input type="number" value="${item.memWishWeight}" id="mb_g_week" name="mb_g_week" class="inp_w2" maxlength="4" oninput="maxLengthCheck(this)" placeholder="" <c:if test="${crudMode eq 'R'}">readonly='readonly'</c:if>><span class="sub_txt3">주</span>
								</div>
								<button type="reset" class="btn_reset" id="mb_g_week" style="">초기화</button>
							</div>
							-->
					</fieldset>
				</form>
			</div>

			<div class="member_box member_bottom">
				<form>
					<fieldset>
						<legend>회원정보3</legend>

							<!-- 혈액형 -->
							<div class="member_blood member_ipt">
								<span class="sub_txt2 v_bottom">혈액형</span>
								<div class="member_blood_box">
									<label for="A" class="radio_btn2">
										<input type="radio" value="A" id="A" name="blood" class="inp_w4" <c:if test="${item.memBloodType eq 'A'}">checked='checked'</c:if> <c:if test="${crudMode eq 'R'}">disabled='disabled'</c:if> ><span class="fake_chk1">A형</span>
									</label>
								</div>
								<div class="member_blood_box">
									<label for="B" class="radio_btn2">
										<input type="radio" value="B" id="B" name="blood" class="inp_w4" <c:if test="${item.memBloodType eq 'B'}">checked='checked'</c:if> <c:if test="${crudMode eq 'R'}">disabled='disabled'</c:if> ><span class="fake_chk1">B형</span>
									</label>
								</div>
								<div class="member_blood_box">
									<label for="O" class="radio_btn2">
										<input type="radio" value="O" id="O" name="blood" class="inp_w4" <c:if test="${item.memBloodType eq 'O'}">checked='checked'</c:if> <c:if test="${crudMode eq 'R'}">disabled='disabled'</c:if> ><span class="fake_chk1">O형</span>
									</label>
								</div>
								<div class="member_blood_box">
									<label for="AB" class="radio_btn2">
										<input type="radio" value="AB" id="AB" name="blood" class="inp_w4" <c:if test="${item.memBloodType eq 'AB'}">checked='checked'</c:if> <c:if test="${crudMode eq 'R'}">disabled='disabled'</c:if> ><span class="fake_chk1">AB형</span>
									</label>
								</div>
							</div>
							<span class="both"></span>

							<!-- 선호지점  -->
							<div class="member_store member_ipt">
								<span class="sub_txt2">선호지점</span>
								<div class="member_sub_box">
									<label for="like_store" class="like_store hidden" >선호지점</label>
									<select id="like_store" class="like_store_box" <c:if test="${crudMode eq 'R'}">disabled='disabled'</c:if> >
										<option class="sec2" value="#">선호지점을 선택하세요.</option>
										<c:forEach var="brcItem" items="${branchs}" varStatus="idx">
										    <option class="sec2" value="${brcItem.brcId}" <c:if test='${item.memBrcId eq brcItem.brcId}'>selected='selected'</c:if> >${brcItem.brcName}</option>
										</c:forEach>
										<!--
										<option class="sec2" value="">강남점</option>
										<option class="sec2" value="">강서점</option>
										<option class="sec2" value="">관악점</option>
										<option class="sec2" value="">노원점</option>
										<option class="sec2" value="">도곡대치점</option>
										<option class="sec2" value="">목동점</option>
										<option class="sec2" value="">삼성동점</option>
										<option class="sec2" value="">성신여대점</option>
										<option class="sec2" value="">송파점</option>
										<option class="sec2" value="">시청점</option>
										<option class="sec2" value="">여의도점</option>
										<option class="sec2" value="">왕십리점</option>
										<option class="sec2" value="">은평점</option>
										<option class="sec2" value="">부천점</option>
										<option class="sec2" value="">분당점</option>
										<option class="sec2" value="">수원점</option>
										<option class="sec2" value="">의정부점</option>
										<option class="sec2" value="">인천점</option>
										<option class="sec2" value="">일산점</option>
										<option class="sec2" value="">평촌점</option>
										<option class="sec2" value="">광주점</option>
										<option class="sec2" value="">대구점</option>
										<option class="sec2" value="">부산서면점</option>
										<option class="sec2" value="">부산센텀시티점</option>
										<option class="sec2" value="">울산점</option>
										<option class="sec2" value="">창원점</option>
										-->
									</select>
								</div>
							</div>

						<!-- 버튼 -->
						<div class="member_btn">
							<button type="button" class="btn_line btn_cancel" id="submit_cancel" style="">취소</button>
							<button type="button" class="btn_submit btn_submit_half" id="submit_member" style="">수정</button>
						</div>
					</fieldset>
				</form>
			</div>
			<script type="text/javascript">
				function maxLengthCheck(object){
					if (object.value.length > object.maxLength){
					object.value = object.value.slice(0, object.maxLength);
					}
				}

				$(function(){
				    $(document).on('click','#submit_cancel',function(){
				        NativeInterface.requestGoFinish();
				    });

				    $(document).on('click','#submit_member',function(){
                        //NativeInterface.requestGoFinish();
                        location.replace('<c:url value="/hybrid/profile/edit"/>');
                    });
				});
			</script>
		</div>
	</body>
</html>