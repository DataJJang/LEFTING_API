package com.lefting.api.common.dataService.mapper;

import java.util.List;
import java.util.Map;
import com.lefting.api.common.dataService.model.BranchVO;
import com.lefting.api.common.dataService.model.CodeVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DataCommonMapper {

     List<BranchVO> getBranchList(Map<String, Object> param);

     List<CodeVO> getCodeList(Map<String, Object> param);


}
