package com.jhlee.minipj.api.test.controller;

import com.jhlee.minipj.api.common.abstracts.AbstractController;
import com.jhlee.minipj.api.common.base.model.ResultVO;
import com.jhlee.minipj.api.test.model.TestVO;
import com.jhlee.minipj.api.test.service.TestService;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
  public @ResponseBody
  ResultVO test1(TestVO testVO) throws Exception {

    ResultVO resultVO = new ResultVO();
    Map<String, Object> pMap = testService.testInfo(testVO);

    //service 연계

    return resultVO;
  }

}
