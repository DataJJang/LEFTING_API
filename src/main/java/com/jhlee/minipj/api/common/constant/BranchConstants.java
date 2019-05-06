package com.jhlee.minipj.api.common.constant;

public class BranchConstants  {

    public static enum BranchTypeCode  {
        BRANCH_TYPE_JIJUM("B","지점"),
        BRANCH_TYPE_BONSA("C","본사");

        private BranchTypeCode(String code, String name){
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
