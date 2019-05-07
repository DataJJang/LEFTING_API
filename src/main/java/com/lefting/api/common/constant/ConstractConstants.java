package com.lefting.api.common.constant;

/**
 * @author Openit corp.
 * @date 2019.01.08
 * @desc JUVIS HUB 상수 정의 정보
 * **/

public class ConstractConstants {


    /**
     * @desc 기본 생성자 생성
     * **/
    public ConstractConstants() {

    }


    /**
     * @desc JUVIS 관리고객 계약 현재 상태정보
     * @creDate 2019.01.08
     * @uptDate 2019.01.08
     * **/
    public static final class CTD_STATUS_CODE {

        public static final String CTD_FORM_DELAY = "CT01";
        public static final String CTD_FORM_SHIFT = "CT02";
        public static final String CTD_FORM_ASSIGN = "CT03";
        public static final String CTD_FORM_MGMT_NG = "CT04";
        public static final String CTD_FORM_MGMT_ED = "CT05";
        public static final String CTD_WAIT = "CT06";
        public static final String CTD_FORM_REFUND  = "CT07";
        public static final String CTD_FORM_MGMT_HOLD  = "CT08";
        public static final String CTD_FORM_CHANGE = "CT09";
        public static final String CTD_FORM_GG  = "CT10";
        public static final String CTD_FORM_CHANGE_CASH = "CT11";

    }



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

}


