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
    <title>쥬비스 다이어트 | 회원가입</title>
</head>
<body>
    <body>
        <div id="wrap">
            <div class="join_box">
                <form>
                    <fieldset>
                        <legend>회원가입</legend>
                            <!-- 입력필드 -->

                            <!-- 이름 -->
                            <div class="join_name join_ipt">
                            <label for="mb_name">이름 *</label>
                                <div class="join_sub_box">
                                    <input type="text" value="" id="mb_name" name="mb_name" class="inp_w2" maxlength="50" placeholder="예) 김쥬비">
                                </div>
                            </div>

                            <!-- 생년월일 -->
                            <div class="join_birth join_ipt">
                                <span class="sub_txt2">생년월일 *</span>
                                <div class="join_birth_box join_sub_box">
                                    <label for="mb_y" class="hidden">생년</label>
                                        <div>
                                            <input type="number" pattern="\d*" value="" id="mb_y" name="mb_y" class="inp_w3" maxlength="4" oninput="maxLengthCheck(this)" placeholder="YYYY">
                                        </div>
                                        <span class="sub_txt3">/</span>
                                    <label for="mb_m" class="hidden">월</label>
                                        <div>
                                            <input type="number" pattern="\d*" value="" id="mb_m" name="mb_mmb_y" class="inp_w3" maxlength="2" oninput="maxLengthCheck(this)" placeholder="MM">
                                        </div>
                                        <span class="sub_txt3">/</span>
                                    <label for="mb_d" class="hidden">일</label>
                                        <div>
                                            <input type="number" pattern="\d*" value="" id="mb_d" name="mb_d" class="inp_w3 last" maxlength="2" oninput="maxLengthCheck(this)" placeholder="DD">
                                        </div>
                                </div>
                            </div>
                            <span class="both"></span>

                            <!-- 아이디 -->
                            <div class="join_id join_ipt">
                            <label for="mb_id">아이디 *</label>
                                <div class="join_sub_box">
                                    <input type="text" value="" id="mb_id" name="mb_id" class="inp_w1" maxlength="50" placeholder="예) juvis1234 ">
                                    <a href="#" class="btn_cert" id="btn_same">중복확인</a><br>
                                    <span class="sub_txt">(영문/숫자포함 6자 이상 입력하여 주세요)</span>
                                </div>
                            </div>
                            <span class="both"></span>
                            <!-- 비밀번호 -->
                            <div class="join_pw join_ipt">
                            <label for="mb_pw">비밀번호 *</label>
                                <div class="join_sub_box">
                                    <input type="password" value="" id="mb_pw" name="mb_pw" class="inp_w2" maxlength="50" placeholder="비밀번호를 입력해주세요.">
                                    <span class="sub_txt">영문/숫자/특수문자 포함 8자 이상 입력해주세요. (# $ _ , . 제외)</span>
                                </div>
                            </div>

                            <!-- 비밀번호 확인 -->
                            <div class="join_pw join_ipt">
                            <label for="mb_pw2">비밀번호 확인 *</label>
                                <div class="join_sub_box">
                                    <input type="password" value="" id="mb_pw2" name="mb_pw2" class="inp_w2" maxlength="50" placeholder="비밀번호를 한번 더 입력해주세요.">
                                </div>
                            </div>

                            <!-- 이메일 -->
                            <div class="join_email join_ipt">
                            <label for="mb_email">이메일 *</label>
                                <div class="join_sub_box">
                                    <input type="email" value="" id="mb_email" name="mb_email" class="inp_w2" maxlength="50" placeholder="예) juvisdiet@juvis.co.kr">
                                </div>
                            </div>

                            <!-- 성별 -->
                            <div class="join_sex join_ipt">
                                <span class="sub_txt2">성별 *</span>
                                <div class="join_sex_box">
                                    <label for="F" class="radio_btn">
                                        <input type="radio" value="F" id="F" name="sex" class="inp_w4"><span class="fake_chk1">여성</span>
                                    </label>
                                </div>
                                <div class="join_sex_box">
                                    <label for="M" class="radio_btn">
                                        <input type="radio" value="M" id="M" name="sex" class="inp_w4"><span class="fake_chk1">남성</span>
                                    </label>
                                </div>
                            </div>
                             <span class="both"></span>

                            <!-- 사이트 알게 된 경로  -->
                            <div class="join_root join_ipt">
                                <label for="site_root" class="site_root" >사이트 알게된 경로</label>
                                <select id="site_root" class="site_root_box">
                                    <option class="sec1" value="#">선택해주세요.</option>
                                    <option class="sec1" value="">인터넷</option>
                                    <option class="sec1" value="">보도기사</option>
                                    <option class="sec1" value="">배너광고</option>
                                    <option class="sec1" value="">현수막</option>
                                    <option class="sec1" value="">극장광고</option>
                                    <option class="sec1" value="">지하철광고</option>
                                    <option class="sec1" value="">드라마방송</option>
                                    <option class="sec1" value="">신문</option>
                                    <option class="sec1" value="">잡지</option>
                                    <option class="sec1" value="">포스터</option>
                                    <option class="sec1" value="">지인소개</option>
                                    <option class="sec1" value="">무료강의노트</option>
                                    <option class="sec1" value="">기타</option>
                                </select>
                            </div>


                        <!-- 버튼 -->
                        <button type="submit" class="btn_submit" id="submit_join" style="margin-top:0px;">가입하기</button>

                    </fieldset>
                    <script type="text/javascript">
                        function maxLengthCheck(object){
                            if (object.value.length > object.maxLength){
                            object.value = object.value.slice(0, object.maxLength);
                            }
                        }
                     </script>
                </form>


            </div>
        </div>
    </body>
</html>