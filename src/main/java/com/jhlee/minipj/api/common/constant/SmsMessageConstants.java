package com.jhlee.minipj.api.common.constant;

import java.util.Iterator;
import java.util.Map;

public class SmsMessageConstants {


    public SmsMessageConstants() {

    }

    public static final String DELAY_REQ_COMPLETE_MSG = "["+CommonConstants.TITLE_MAIN+"] 연기신청 접수가 되었습니다. SMS서명 인증절차를 완료하셔야 최종 반영됩니다.";
    public static final String DELAY_AUTH_NUM_MSG = "["+CommonConstants.TITLE_MAIN+"] 인증번호는 ${{otpNum}} 입니다. 관리기간 연기 관련한 특약 조항에 동의하시면 인증번호를 입력해주세요.";
    public static final String DELAY_AUTH_COMPLETE_MSG = "["+CommonConstants.TITLE_MAIN+"] ${{mem_name}}님의 연기서명이 최종 완료되었습니다.\n\n연기신청일 : ${{dly_regDate}} \n연기신청기간 : ${{dly_st_year}}년 ${{dly_st_month}}월 ${{dly_st_day}}일 ~ ${{dly_ed_year}}년 ${{dly_ed_month}}월 ${{dly_ed_day}}일";

    public static final String DELAY_CANCEL_REQ_COMPLETE_MSG = "["+ CommonConstants.TITLE_MAIN+"] 연기정정신청 접수가 되었습니다. SMS서명 인증절차를 완료하셔야 최종 반영됩니다.";
    public static final String DELAY_CANCEL_AUTH_NUM_MSG = "["+ CommonConstants.TITLE_MAIN+ "] 연기정정신청 인증번호는 ${{otpNum}} 입니다.";
    public static final String DELAY_CANCEL_AUTH_COMPLETE_MSG = "["+CommonConstants.TITLE_MAIN+"] ${{mem_name}}님의 연기정정 신청 서명이 최종 완료되었습니다.\n\n연기정정신청일 : ${{dlc_regDate}} \n연기정정신청기간 : ${{dlc_st_year}}년 ${{dlc_st_month}}월 ${{dlc_st_day}}일 ~ ${{dlc_ed_year}}년 ${{dlc_ed_month}}월 ${{dlc_ed_day}}일";

    public static final String MEMBER_AUTH_NUM_MSG = "["+CommonConstants.TITLE_MAIN+"] 인증번호는 ${{otpNum}} 입니다.";

    public static final String SURVIVAL_FORM_AGREE_MSG =  "["+CommonConstants.TITLE_MAIN+"] ${{mem_name}} 님께서는 쥬비스에서 진행하는 다이어트 서바이벌 이벤트 참여 신청서에 동의하셨습니다.\n\n쥬비스 다이어트 서바이벌은 매월 관리 완료(프로그램 종료기준)하는 고객님 중 적정체중 기준(적정체중에서 추가 감량한 기준)에서 가장 많은 체중을 감량한 달성 고객님을 선정하여\n1위로 선정될 경우 신청 당시 등록 회차 프로그램 비율을 100%,\n2위로 선정될 경우 50% 쥬비스 캐시로 제공됩니다.\n\n순위 결과는 매월 관리 완료(프로그램 종료기준)하시는 다음달 1~5일 사이에 확인되며 그 전까지 순위변동 폭이 클 수 있습니다.\n\n* 자세한 안내는 지점에 문의바랍니다. *\n\n건강의 가치를 전하는 기업, 쥬비스\n회신번호 1600-0441\n\n\n무료수신거부 080-850-3855";



    public static String getMsgAddParam(String msg, Map<String, String> pMap) {

        if (pMap.size() > 0) {
            Iterator<String> iterator = pMap.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                String value = pMap.get(key);
                msg = msg.replace("${{"+key+"}}", value);
            }
        }
        return msg;
    }

    public static enum SmsTypeCode {
        SMS_TYPE_FORM_DELAY("ST01","연기신청"),
        SMS_TYPE_FORM_SHIFT("ST02","연계신청"),
        SMS_TYPE_FORM_ASSIGN("ST03","양도신청"),
        SMS_TYPE_COUNSEL_RESERVE("ST04","상담예약신청"),
        SMS_TYPE_COUNSEL_RESERVE_CHANGE("ST05","상담예약변경"),
        SMS_TYPE_COUNSEL_RESERVE_CANCEL("ST06","상담예약취소"),
        SMS_TYPE_DIRECT_SEND("ST07","직접보내기"),
        SMS_TYPE_AUTHENTICATION_CODE_SEND("ST08","인증코드발송"),
        SMS_TYPE_COUNSEL_RESERVE_NOTIFICATION("ST09","상담예약알림"),
        SMS_TYPE_RESERVE_AUTHENTICATION_CODE("ST10","예약인증번호"),
        SMS_TYPE_PRODUCT_REQUEST("ST11","제품신청"),
        SMS_TYPE_MANAGE_RESERVE("ST12","관리예약신청"),
        SMS_TYPE_MANAGE_RESERVE_CHANGE("ST13","관리예약변경"),
        SMS_TYPE_MANAGE_RESERVE_CANCEL("ST14","관리예약취소"),
        SMS_TYPE_MANAGE_RESERVE_NOTIFICATION("ST15","관리예약알림"),
        SMS_TYPE_ONLINE_COUNSEL_NOTIFICATION("ST16","온라인상담 알림"),
        SMS_TYPE_MANAGE_MEMBER_JOIN("ST17","관리회원등록"),
        SMS_TYPE_MANAGE_TIMES_MESSAGE("ST18","회차별 메세지"),
        SMS_TYPE_COUNSEL_RESERVE_NOTICE("ST19","상담예약알림"),
        SMS_TYPE_FORM_DELAY_EXPIRED("ST20","연기만료알림"),
        SMS_TYPE_CALL_COUNSEL_RESERVE("ST21","전화상담예약"),
        SMS_TYPE_FIND_PASSWORD("ST22","패스워드찾기"),
        SMS_TYPE_AUTHENTICATION_JOIN_MEMBER("ST23","회원가입인증번호"),
        SMS_TYPE_FOOD_ORDER_COMPLETE("ST24","푸드주문완료"),
        SMS_TYPE_SEND_COUPON("ST25","쿠폰발송"),
        SMS_TYPE_WEEKEND_MANAGE_MESSAGE("ST26","주말관리문자"),
//        SMS_TYPE_OYULL_RESERVE("ST27","오율예약"),                   // 오율은 폐점 되었음.
        SMS_TYPE_FOOD_DIARY_ESTIMATE("ST28","식단일기분석"),
        SMS_TYPE_MANAGE_AUTHENTICATION_NUMBER("ST29","관리등록인증번호"),
        SMS_TYPE_SEND_CONTRACT("ST30","계약서발송"),
        SMS_TYPE_MANAGE_DURATION_RESET("ST31","관리기간재설정"),
        SMS_TYPE_FOOD_ORDER_INFO("ST32","푸드주문내역:상담시스템"),
        SMS_TYPE_REFUND_INFO("ST33","환불고객 자동문자"),
        SMS_TYPE_CALL_COUNSEL_COMPLETE("ST34","전화상담완료"),
//        SMS_TYPE_OYULL_SURVEY_COMPLETE_COUPON("ST35","오율설문완료쿠폰발송"), // 오율은 폐점 되었음.
//        SMS_TYPE_OYULL_RESERVE_INFO("ST36","오율예약안내"),            // 오율은 폐점 되었음.
        SMS_TYPE_WEEKEND_MANAGE_COUPON("ST37","주말관리서비스쿠폰"),
        SMS_TYPE_SEND_REPORT("ST38","리포트전송"),
        SMS_TYPE_MANAGE_DURATION_CHANGE("ST39","관리기간재설정"),
        SMS_TYPE_FORM_DELAY_DURATION_CHANGE("ST40","연기기간정정"),
//        SMS_TYPE_DININGRY_RESERVE("ST41","이로울리예약"),             // 이로울리는 폐점 되었음.
        SMS_TYPE_MEMBER_PORTRAIT_AGREE("ST42","초상권사용고객동의서"),
        SMS_TYPE_DININGRY_SURVEY_COMPLETE_SEND_COUPON("ST43","이로울리설문완료쿠폰발송"),
        SMS_TYPE_DEVICE_SELL_RECEIPT("ST44","기기 판매계약서"),
        SMS_TYPE_PROMOTION_DINING_VOUCHER("ST45","관리회원승급시 외식상품권"),
        SMS_TYPE_WEEK_TIMES_GOODS_DINING_VOUCHER("ST46","주차별 상품 - 쥬비스그룹 5만원 외식상품권"),
        SMS_TYPE_STAFF_AUTHENTICATION_NUMBER("ST47","직원인증번호"),
        SMS_TYPE_PURCHASE_ORDER("ST48","발주서"),
//        SMS_TYPE_OYULL_RESERVE_CHANGE("ST49","오율예약변경"),         // 오율은 폐점 되었음.
        SMS_TYPE_SEND_FAMILY_EVENT("ST50","경조사문자"),
        SMS_TYPE_RESTAURANT_BIZ_DEPT_MEMBER_AUTHENTICATION("ST51","외식사업부 회원인증발송"),
        SMS_TYPE_MMS_COUPON("ST52","MMS쿠폰"),
        SMS_TYPE_REMOVE_CONTRACT("ST53","계약서삭제안내"),
        SMS_TYPE_INTERVIEW_INFO("ST54","인터뷰 안내"),
        SMS_TYPE_PROMOTION_MANAGE_MEMBER("ST55","관리회원승급"),
//        SMS_TYPE_OYULL_SERVICE_MONITORING_SEND("ST56","오율서비스모니터링문자발송"), // 오율은 폐점 되었음.
//        SMS_TYPE_DININGRY_SERVICE_MONITORING_SEND("ST57","이로울리서비스모니터링문자발송"), // 오율은 폐점 되었음.
//        SMS_TYPE_OYULL_REVISITATION("ST58","오율재방문문자"),     // 이로울리는 폐점 되었음.
        SMS_TYPE_SURVIVAL("ST59","다이어트서바이벌");

        private final String code;
        private final String name;

        private SmsTypeCode(final String code, final String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() { return code;}
        public String getName() { return name;}

    }

}


