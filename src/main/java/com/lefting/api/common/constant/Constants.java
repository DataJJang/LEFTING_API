package com.lefting.api.common.constant;

public class Constants {

    public Constants() {

    }

    public static final class APP_INFO {
        public static final String APP_DOWNLOAD_URL = "http://juvisapp.co.kr";
        public static final String APP_AUTH_FILE_PATH_DEV = "/home/juvis/keyfile/rss_key.txt";
        public static final String APP_AUTH_FILE_PATH_LOCAL = "d:/api_vo/rss_key.txt";
    }

    public static final class HEADER_KEY {
        public static final String AUTH_TOKEN = "AUTH_TOKEN";
        public static final String DEVICE_ID = "d";
        public static final String APP_VERSION = "a";
        public static final String OS_TYPE = "o";
        public static final String PLATFORM = "p";
        public static final String DEVICE_MODEL = "m";
        public static final String CARRIER = "c";
    }

    public static final class ARRAY_INFO {
        public static final String[] PRG_TYPE = {"A","P","F"};
        public static final String[] PRG_GRADE = {"E"};
    }

    public static final class RTN_KEY{
        public static final String DATA = "data";
        public static final String ITEM = "item";
        public static final String BRANCH_LIST = "branchs";
        public static final String CRUD_MODE = "crudMode";


        public static final String BENEFIT_TOTAL = "totalVo";
        public static final String BENEFIT_POINT = "pointResult";
        public static final String BENEFIT_CASH = "cashResult";
        public static final String BENEFIT_STAMP = "stampResult";

        public static final String MEMBER_JOIN_PATH = "joinPathList";
        public static final String TOXIC_LIST = "toxicList";
        public static final String TOXIC_RESULT = "toxicResult";
        public static final String TOXIC_VIEW = "toxicView";

        public static final String CONTRACT_RESULT = "contractResult";

    }

    public static final class PARAM_KEY{
        public static final String MEMBER_ID = "memId";

        public static final String USE_YN = "useYn";

        public static final String BRANCH_ID = "brcId";
        public static final String BRANCH_CLOSE_YN = "brcCloseYn";
        public static final String BRANCH_TYPE = "brcType";

        public static final String CODE_GROUP_LIST = "pubGrpList";
        public static final String CODE_INCLUDE_LIST = "pubInCdList";
        public static final String CODE_EXCLUDE_LIST = "pubExCdList";
    }

    public static final class SIZE_INFO{
        public static final int RANGE = 20;
    }

    public static final class VALUE_KEY{
        public static final String USE_Y = "Y";
        public static final String USE_N = "N";
    }

    public static enum CRUDMode{
        CREATE("C", "등록"),
        RETRIEVE("R", "조회"),
        UPDATE("U", "수정"),
        DELETE("D", "삭제");

        private CRUDMode(String code, String name){
            this.code = code;
            this.name = name;
        }

        private String code;

        private String name;

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }

}
