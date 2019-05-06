package com.jhlee.minipj.api.test.service;

import com.jhlee.minipj.api.common.constant.MessageConstants;
import com.jhlee.minipj.api.test.mapper.TestMapper;
import com.jhlee.minipj.api.test.model.TestVO;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class TestService {

  Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  TestMapper testMapper;

  public Map testInfo(TestVO testVO) throws Exception {
    Map<String, Object> pMap = new HashMap<>();

    // Mapper 통해서 DB 데이터 수집

    TestVO tVO = testMapper.getDual(testVO);

    if(tVO == null) {
      pMap.put("msg", MessageConstants.ResponseEnum.SURVIVAL_NOT_JOIN.getDesc());
      pMap.put("code", MessageConstants.ResponseEnum.SURVIVAL_NOT_JOIN.getCode());

      return pMap;
    }

    pMap.put("data", tVO);
    return pMap;
  }
}
