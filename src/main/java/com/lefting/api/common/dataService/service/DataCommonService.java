package com.lefting.api.common.dataService.service;

import com.lefting.api.common.dataService.mapper.DataCommonMapper;
import com.lefting.api.common.dataService.model.CodeVO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.lefting.api.common.constant.BranchConstants;
import com.lefting.api.common.constant.Constants;
import com.lefting.api.common.dataService.model.BranchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataCommonService {

    @Autowired
    private DataCommonMapper dataCommonMapper;

    public List<BranchVO> getBranchList(Map<String, Object> param){
        return dataCommonMapper.getBranchList(param);
    }

    public List<BranchVO> getBranchList(String brcId, String brcType, boolean useYn, boolean closeYn){
        Map<String, Object> param = new HashMap<String, Object>();
        param.put(Constants.PARAM_KEY.BRANCH_ID, brcId);
        param.put(Constants.PARAM_KEY.BRANCH_CLOSE_YN, closeYn?Constants.VALUE_KEY.USE_Y:Constants.VALUE_KEY.USE_N);
        param.put(Constants.PARAM_KEY.USE_YN, useYn?Constants.VALUE_KEY.USE_Y:Constants.VALUE_KEY.USE_N);
        param.put(Constants.PARAM_KEY.BRANCH_TYPE, brcType);

        return getBranchList(param);
    }

    public List<BranchVO> getBranchList(){
        Map<String, Object> param = new HashMap<String, Object>();
        param.put(Constants.PARAM_KEY.BRANCH_ID, null);
        param.put(Constants.PARAM_KEY.BRANCH_CLOSE_YN, Constants.VALUE_KEY.USE_N);
        param.put(Constants.PARAM_KEY.USE_YN, Constants.VALUE_KEY.USE_Y);
        param.put(Constants.PARAM_KEY.BRANCH_TYPE, BranchConstants.BranchTypeCode.BRANCH_TYPE_JIJUM.getCode());

        return getBranchList(param);
    }

    public List<CodeVO> getCodeList(Map<String, Object> param){
        return dataCommonMapper.getCodeList(param);
    }

    public List<CodeVO> getCodeList(String ctgry, String... cdList){
        Map<String, Object> param = new HashMap<String, Object>();
        if (Constants.PARAM_KEY.CODE_GROUP_LIST.equals(ctgry)) {
            param.put(Constants.PARAM_KEY.CODE_GROUP_LIST, cdList);
        } else if (Constants.PARAM_KEY.CODE_INCLUDE_LIST.equals(ctgry)) {
            param.put(Constants.PARAM_KEY.CODE_INCLUDE_LIST, cdList);
        }

        return getCodeList(param);
    }

    public List<CodeVO> getCodeList(String[] pubGrpList, String[] pubInCdList, String[] pubExCdList){


        Map<String, Object> param = new HashMap<String, Object>();

        param.put(Constants.PARAM_KEY.CODE_GROUP_LIST, pubGrpList);
        param.put(Constants.PARAM_KEY.CODE_INCLUDE_LIST, pubInCdList);
        param.put(Constants.PARAM_KEY.CODE_EXCLUDE_LIST, pubExCdList);

        return getCodeList(param);
    }
}
