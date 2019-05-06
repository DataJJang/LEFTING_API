package com.jhlee.minipj.api.test.controller;

import com.jhlee.minipj.api.common.abstracts.AbstractController;
import com.jhlee.minipj.api.common.base.model.ResultVO;
import com.jhlee.minipj.api.common.constant.MessageConstants;
import com.jhlee.minipj.api.common.exceptions.ParameterInvalidException;
import com.jhlee.minipj.api.test.model.TestVO;
import com.jhlee.minipj.api.test.service.TestService;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestController  extends AbstractController {

  private static final Logger logger = LoggerFactory.getLogger(TestController.class);
  @Autowired
  TestService testService;

  @PostMapping(value = "/test", consumes = "application/json")
  public @ResponseBody ResultVO test1(@RequestBody TestVO testVO) throws Exception {

//    if (StringUtils.isEmpty(testVO.getMemId())) {
//      throw new ParameterInvalidException(MessageConstants.ResponseEnum.PARAM_REQUIRED.getCode());
//    }
    ResultVO resultVO = new ResultVO();
    Map<String, Object> pMap = testService.testInfo(testVO);
    if (pMap.get("code") != null && pMap.get("msg") != null) {
      resultVO.setCode(String.valueOf(pMap.get("code")));
      resultVO.setMessage(String.valueOf(pMap.get("msg")));
    }

    resultVO.setData(pMap.get("data"));

    return resultVO;
  }

}
