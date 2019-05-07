package com.lefting.api.common.constant;

import java.util.Arrays;

public class MessageConstants {

    public static final String CODE = "code";
    public static final String MESSAGE = "message";

    // COMMON MESSAGE
    public static final String SUCCESS = "OK";
    public static final String FAIL = "FAIL";

    public enum ResponseEnum {
        SUCCESS("1", "SUCCESS"),
        EXIST_NEW_APP_VERSION("9100", "최신버전이 존재합니다. 최신버전을 설치해주세요. 확인을 누르시면 스토어로 이동합니다."),
        ALREADY_NEW_APP_VERSION("9101", "최신버전 입니다."),

        MEMBER_ID_AVAILABLE("9200", "사용 가능한 아이디 입니다."),
        MEMBER_ID_DUPLICATED("9201", "해당 아이디는 이미 가입되어 있습니다."),
        MEMBER_ID_NOT_FOUND("9202", "아이디를 찾을 수 없습니다."),
        NO_CONTENT("9204", "콘텐츠를 찾을 수 없습니다."),
        OTPNUM_EMPTY("9205", "인증번호를 입력해주세요."),
        OTPNUM_NOT_MATCH("9205", "인증번호가 일치하지 않습니다."),

        BAD_REQUEST("9400", "BAD_REQUEST"),
        UNAUTHORIZED("9401", "회원 토큰값을 찾을 수 없습니다."),
        USER_INFO_NOT_FOUND("9402", "회원 정보를 찾을 수 없습니다."),
        PARAM_REQUIRED("9403", "필수 파라미터가 없습니다."),
        PAGE_NOT_FOUND("9404", "PAGE_NOT_FOUND"),
        METHOD_NOT_ALLOWED("9405", "METHOD_NOT_ALLOWED"),
        MEMBER_ID_EMPTY("9406", "회원 아이디가 입력되지 않았습니다."),
        MEMBER_PASSWORD_EMPTY("9407", "회원 비밀번호가 입력되지 않았습니다."),
        MEMBER_BIRTHDAY_EMPTY("9408", "회원 생년월일이 입력되지 않았습니다."),
        MEMBER_GENDER_EMPTY("9409", "회원 생별 입력되지 않았습니다."),
        MEMBER_ADDRESS_EMPTY("9410", "회원 주소가 입력되지 않았습니다."),
        MEMBER_EMAIL_EMPTY("9411", "회원 이메일이 입력되지 않았습니다."),
        MEMBER_PHONE_NUMBER_EMPTY("9412", "회원 핸드폰번호가 입력되지 않았습니다."),

        FOOD_DIARY_FAIL("9414", "식단일기 입력 실패"),
        FOOD_DIARY_LIST_EMPTY("9415", "식단일기 리스트가 존재하지 않습니다."),
        FOOD_DIARY_HISTORY_FAIL("9416", "식단일기 히스토리 입력 실패"),
        FOOD_DIARY_HISTORY_DELETE_FAIL("9417", "식단일기 삭제실패"),
        FOOD_DIARY_HISTORY_FAVORITE_INSERT_FAIL("9418", "식단일기 즐겨찾기 등록 실패"),
        FOOD_DIARY_HISTORY_FAVORITE_DELETE_FAIL("9419", "식단일기 즐겨찾기 삭제 실패"),

        FILE_SIZE_TOO_BIG("9420", "파일사이즈 2MB를 넘을 수 없습니다."),

        DELAY_NOT_ABLE("9430", "연기 신청을 할 수 없습니다."),
        DELAY_EMPTY_MANAGE_PROGRAM("9431", "관리 중인 프로그램이 없습니다."),
        DELAY_NOT_ABLE_SERVICE("9432", "서비스 프로그램은 연기 신청을 할 수 없습니다."),
        DELAY_NOT_ABLE_EVENT("9432", "이벤트 프로그램은 연기 신청을 할 수 없습니다."),
        DELAY_COUNT_OVER("9433", "연기 신청 가능 횟수가 초과 되었습니다."),
        DELAY_TERM_NOT_ALLOWED("9434", "관리 기간이 남은 프로그램이 없습니다. 잔여 관리기간을 확인하여 주세요."),
        DELAY_MEM_NOT_ALLOWED("9435", "연기 신청은 지점에서 연기 신청 허용이 되어야만 가능합니다. 관리리점과 상의하세요."),
        DELAY_FORM_REQ_DUPLICATE("9436", "연기 신청 중인 문서가 있습니다. 신청중인 내용을 처리완료/취소 처리하신 후 신청하세요."),
        DELAY_FORM_MODIFY_FAIL("9437", "연기신청 수정에 실패하였습니다."),
        DELAY_FORM_DATE_IS_HOLIDAY("9438", "선택한 날짜가 휴일입니다. "),
        DELAY_FORM_STARTDT_AFTER_NOW("9439", "연기신청 시작일은 오늘 이후여야 합니다."),
        DELAY_FORM_PERIOD_TOO_LONG("9440", "연기신청기간은 최대 6개월까지 가능합니다."),
        DELAY_FORM_ENDDT_NOT_ALLOWED("9441", "연기 종료일이 잘못 설정 되었습니다."),
        DELAY_AUTH_NOT_PERMIT("9442", "인증번호를 확인해주세요."),
        DELAY_FORM_ENDDT_MIN_2WEEK("9443", "연기신청 종료일은 최소 2주 이후여야 합니다."),
        DELAY_FORM_DATE_IS_DELAY("9444", "연기기간내 재연기는 불가능합니다."),


        DELAY_CANCEL_NOT_EXIST("9450", "연기정정 가능한 신청서가 없습니다."),
        DELAY_CANCEL_NOT_ALLOWED("9451", "승인된 연기신청서가 있어야 연기정정신청이 가능합니다."),
        DELAY_CANCEL_DLYCTR_N("9452","연기정정 가능한 신청서가 아닙니다."),
        DELAY_CANCEL_TERM_NOT_ALLOWED("9453", "관리 기간이 남은 프로그램이 없습니다. 잔여 관리기간을 확인해 주세요."),
        DELAY_CANCEL_ENDDT_BEFORE_PGR_ENDDT("9454","연기정정 종료일은 기존 연기 종료일보다 빨라야 합니다."),
        DELAY_CANCEL_ENDDT_NOT_HOLIDAY("9455","연기정정 종료일은 법정휴무일이 아니어야 합니다."),
        DELAY_CANCEL_FORM_REQ_DUPLICATE("9456", "연기정정 신청중인 문서가 있습니다. 신청중인 내용을 처리완료/취소 처리하신 후 신청하세요."),
        DELAY_CANCEL_FORM_INSERT_FAIL("9457","연기정정신청 등록에 실패하였습니다. 연기정정 신청을 다시 진행해 주세요."),
        DELAY_CANCEL_MEMBER_SIGNATURE_FAIL("9458","연기정정신청 후 서명등록에 실패하였습니다. 연기정정 신청을 다시 진행해 주세요."),
        DELAY_CANCEL_STARTDT_AFTER_TODAY("9459","연기정정 시작일은 오늘 이후여야 합니다."),

        CONTRACT_NOT_EXIST("9460", "고객님은 현재 계약 확인이 되지 않아 예약을 하실 수 없습니다."),
        RESEARCH_NOT_EXIST("9461", "슬림바이디자인 상담직후 리서치를 하셔야 예약이 가능합니다."),
        DATE_IS_HOLIDAY("9462", "휴일/주말에는 예약 하실 수 없습니다."),
        EMPTY_MANAGE_PRODUCT("9463", "관리받을 수 있는 상품이 없습니다 관리예약 프로그램을 확인해주세요."),
        EMPTY_MANAGE_PROGRAM("9464", "관리받을 수 있는 프로그램이 없습니다 관리예약 프로그램을 확인해주세요."),

        DELAY_ING_PROGRAM("9465", "현재 연기중인 프로그램이 있으므로, 관리예약을 할 수 없습니다."),
        NOTICE_SIGNATURE_PROGRAM("9466", "계약서 자필서명이 진행되어야 관리예약이 가능합니다. 지점 방문하셔서 계약서 자필 서명을 완료해주시기 바랍니다."),
        BEFORE_DATE_NOT_RESERVATION("9467", "예약신청일은 현재일 이전 관리예약으로 등록할 수 없습니다."),
        RESERVATION_LIST_EMPTY("9468", "예약데이터가 존재하지 않습니다."),
        IS_NOT_MANAGE_MEMBER("9469", "관리회원만 접근하실수 있습니다."),
        DO_NOT_RESERVE("9470", "더이상 예약을 할 수 없습니다. 전체 관리횟수를 확인해주세요"),
        WEEK_MANAGE_LIMIT("9473", "1주일에 관리받을 수 있는 횟수 1회] 를 초과하였습니다. 관리예약을 확인해주세요"),
        RESERVE_INSERT_FAIL("9476", "관리예약 등록 실패 하였습니다."),
        RESERVE_DELETE_FAIL("9477", "관리예약 취소 실패 하였습니다."),
        RESERVE_TIME_OVER("9478", "관리예약 가능 시간을 초과했습니다."),


        MAGIC_LOG_EMPTY("9480", "생리주기 등록이 필요합니다."),
        DUPLICATED_MAGIC_LOG("9481", "해당일에 입력된 데이터가 있어 중복 입력이 안됩니다."),
        MAGIC_LOG_DELETE_FAIL("9482", "바디밸런스 삭제 할 데이터가 존재하지 않습니다."),
        MAGIC_LOG_UPDATE_FAIL("9483", "바디밸런스 업데이트 데이터가 존재하지 않습니다."),
        MAGIC_LOG_INSERT_FAIL("9484", "바디밸런스 등록에 실패했습니다."),

        OBESITYTYPE_EMPTY("9490", "체형 유형이 결정되어 있지 않습니다."),
        STRESS_DATA_EMPTY("9491", "스트레스측정 결과가 없습니다."),

        SURVIVAL_NOT_JOIN("9493","참여중인 서바이벌이 없습니다."),
        SURVIVAL_MEM_NOT_ALLOWED("9494","서바이벌 참여 대상이 아닙니다. 지점으로 문의하시기 바랍니다."),
        SURVIVAL_NOT_ABLE("9495","서바이벌 신청이 불가능 합니다. 지점으로 문의하시기 바랍니다."),
        SURVIVAL_DOCUMENT_NOT_EXIST("9496","서바이벌 신청서 정보가 없습니다. 지점으로 문의하시기 바랍니다."),
        SURVIVAL_SIGNATURE_FAIL("9497","계약서 서명 등록 실패입니다. 지점으로 문의하시기 바랍니다."),
        SURVIVAL_ALLOW_FAIL("9498","서바이벌 신청 승인 적용 오류. 지점으로 문의하시기 바랍니다."),

        EXTENTION_AGREEMENT_CHECK_FAIL("9495", "해당 프로그램은 연장 신청 혹은 연장 된 프로그램입니다."),




        SERVER_ERROR("9500", "SERVER_ERROR"),

        HUB_SERVER_EROOR("9520", "HUB_SERVER_ERROR"),

        NOT_EXIST_RESPONSE("9999", "NOT_FOUNT");

        private String code;
        private String desc;

        ResponseEnum(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public String getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }

        public static String findDescByCode(String code) {
            return Arrays.stream(values()).
                    filter(responseEnum -> responseEnum.getCode().equals(code)).findAny().
                    orElse(NOT_EXIST_RESPONSE).getDesc();
        }
    }
    
}
