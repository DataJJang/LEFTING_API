package com.lefting.api.common.dataService.model;

import java.util.List;
import java.util.Map;
import com.lefting.api.common.base.model.BaseVO;

public class CodeVO  extends BaseVO {

    private String grpCd;
    private List<Map<String,String>> cdList;

    public String getGrpCd() {
        return grpCd;
    }

    public void setGrpCd(String grpCd) {
        this.grpCd = grpCd;
    }

    public List<Map<String, String>> getCdList() {
        return cdList;
    }

    public void setCdList(List<Map<String, String>> cdList) {
        this.cdList = cdList;
    }
}
