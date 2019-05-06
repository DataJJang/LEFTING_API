package com.jhlee.minipj.api.common.constant;

/**
 * @author Openit corp.
 * @date 2019.02.15
 * @desc JUVIS HUB 공통 코드 정보
 * **/

public class PubCodeConstants {


    /**
     * @desc 기본 생성자 생성
     * **/
    public PubCodeConstants() {

    }

    /**
     * @desc 연기신청상태 정보
     * @creDate : 2019. 02. 15
     * @uptDate : 2019. 02. 15
     * **/

    public static enum DelayStatusCode {

        FORM_ING("DS01","신청중"),
        FORM_COMPLETE("DS02","처리완료"),
        FORM_CANCEL("DS03", "취소"),
        FORM_SIGN_COMPLETE("DS04", "서명완료");

        private final String code;
        private final String name;

        private DelayStatusCode(final String code, final String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() { return code;}
        public String getName() { return name;}

    }


    /**
     * @desc JUVIS 관리고객 계약 현재 상태정보
     * @creDate 2019.01.08
     * @uptDate 2019.01.08
     * **/
    public static enum ConstractStatusCode {
        FORM_DELAY("CT01", "연기")
        ,FORM_SHIFT("CT02", "연계")
        ,FORM_ASSIGN("CT03", "양도")
        ,FORM_MNG_PROGRESS("CT04","관리 중")
        ,FORM_MNG_COMPLETE("CT05","관리완료")
        ,WAIT("CT06", "대기 중")
        ,REFUND("CT07","환불")
        ,PENNDING("CT08","보류중")
        ,FORM_CHANGE("CT09","변경")
        ,ABNADON("CT10", "포기")
        ,CHANGE_CASH("CT11", "캐시전환");

        private final String code;
        private final String name;

        private ConstractStatusCode(final String code, final String name){
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }


    /**
     * @desc 계약서 진행타입 정보
     * @creDate : 2019. 02. 15
     * @uptDate : 2019. 02. 15
     * **/
    public static enum CtrTermStatusCode {

        TERM_WAIT("TS01","대기중"),
        TERM_MANAGE("TS02","관리중"),
        TERM_END("TS03", "관리종료");

        private final String code;
        private final String name;

        private CtrTermStatusCode(final String code, final String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() { return code;}
        public String getName() { return name;}

    }

    /**
     * @desc 계약 신청양식 종류 정보
     * @creDate : 2019. 02. 15
     * @uptDate : 2019. 02. 15
     * **/
    public static enum FormTypeCode {

        CUSTOMER("W","고객신청"),
        BRANCH("B","지점신청"),
        APP("A", "앱신청");

        private final String code;
        private final String name;

        private FormTypeCode(final String code, final String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() { return code;}
        public String getName() { return name;}

    }

    public static enum SurvivalStatusCode {

        SURVIVAL_FORM_ING("DS01","신청중"),
        SURVIVAL_FORM_COMPLETE("DS02","처리완료"),
        SURVIVAL_FORM_CANCEL("DS03", "취소");

        private final String code;
        private final String name;

        private SurvivalStatusCode(final String code, final String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() { return code;}
        public String getName() { return name;}

    }


    public static enum SurvivalResultCode {

        SURVIVAL_RESULT_COMPLETE("SR01","확정"),
        SURVIVAL_RESULT_FAIL("SR02","실패"),
        SURVIVAL_RESULT_ESTIMATION("SR03", "미평가");

        private final String code;
        private final String name;

        private SurvivalResultCode(final String code, final String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() { return code;}
        public String getName() { return name;}

    }

    public static enum DocumentTypeCode {


        DOCUMENT_FORM_MEMBER_JOIN("DT01","관리회원등록 약관"),
        DOCUMENT_FORM_REFUND_INFO("DT02","환불안내"),
        DOCUMENT_FORM_ASSIGN_GRANTER("DT03","양도자약관"),
        DOCUMENT_FORM_ASSIGN_TAKE_OVER("DT04","양수자약관"),
        DOCUMENT_FORM_CHANGE_DURATION("DT05"	,"관리기간재설정"),
        DOCUMENT_FORM_CHANGE_PROGRAM("DT06"	,"프로그램변경"),
        DOCUMENT_FORM_PROGRAM_DELAY("DT07"	,"프로그램연기"),
        DOCUMENT_FORM_PROGRAM_SHIFT("DT08"	,"프로그램연계"),
        DOCUMENT_FORM_PROGRAM_DELAY_CHANGE("DT09"	,"프로그램연기정정	"),
        DOCUMENT_FORM_MEMBER_PORTRAIT("DT10"	,"초상권사용고객동의서"),
        DOCUMENT_FORM_SELL_DEVICE("DT11"	,"기기 판매계약서"),
        DOCUMENT_FORM_CONTRACT_CHECK("DT12"	,"계약고지확인"),
        DOCUMENT_FORM_PRESTIGE_JOIN("DT13"	,"프레스티지가입"),
        DOCUMENT_FORM_AI_MEMBER_JOIN("DT14"	,"AI관리회원등록 약관"),
        DOCUMENT_FORM_AI_CONTRACT_CHECK("DT15"	,"AI계약고지확인"),
        DOCUMENT_FORM_PRODUCT_RECEIPT("DT21"	,"상품수령확인서"),
        DOCUMENT_FORM_EVENT_JOIN("DT22"	,"이벤트참여신청서"),
        DOCUMENT_FORM_CHANGE_GOAL_WEIGHT("DT23"	,"목표체중변경신청서"),
        DOCUMENT_FORM_CREDIT_KEEP_AGREE("DT24"	,"카드결제보관동의서"),
        DOCUMENT_FORM_NEW_FOOD_CLINIC_AGREE("DT25"	,"쥬비스 신규 푸드프로그램 임상체험 동의서"),
        DOCUMENT_FORM_PART_TIME_EMPLOYMENT_CONTRACT("DT26"	,"단시간근로계약서"),
        DOCUMENT_FORM_TODAY_MANAGE_CANCEL_AGREE("DT27"	,"당일관리취소동의서"),
        DOCUMENT_FORM_MANAGE_ABANDONMENT_AGREE("DT28"	,"관리포기동의서"),
        DOCUMENT_FORM_TICKET_CHECK("DT29"	,"티켓수령 확인서"),
        DOCUMENT_FORM_CONVERT_CONTRACT_CHANGE_INTENSE("DT30"	,"전환집중프로그램 변경 확인서"),
        DOCUMENT_FORM_CCTV_AGREE_CONTRACT("DT31"	,"CCTV 설치 및 운영 동의서 (관리계약)"),
        DOCUMENT_FORM_PROMOTION_COUPON_RECEIPT("DT33"	,"승급쿠폰수령"),
        DOCUMENT_FORM_CCTV_AGREE_COUNSEL("DT35"	,"CCTV 설치 및 운영 동의서 (상담실)"),
        DOCUMENT_FORM_CONVERT_CONTRACT_CHANGE_A("DT44"	,"요요방지전환계약서"),
        DOCUMENT_FORM_TEMPORARY_EMPLOYMENT_CONTRACT("DT50"	,"계약직근로계약서"),
        DOCUMENT_FORM_FOOD_REGISTRATION("DT51"	,"푸드등록약관"),
        DOCUMENT_FORM_MANAGE_RENEW_DURATION("DT54"	,"관리기간연장동의서"),
        DOCUMENT_FORM_MANAGE_CHECKLIST_LAST_TIME("DT98"	,"마지막 관리 체크리스트"),
        DOCUMENT_FORM_MANAGE_CHECKLIST_FIRST_TIME("DT99"	,"첫관리 체크리스트");

        private final String code;
        private final String name;

        private DocumentTypeCode(final String code, final String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() { return code;}
        public String getName() { return name;}

    }
}


