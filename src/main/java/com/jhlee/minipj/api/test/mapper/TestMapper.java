package com.jhlee.minipj.api.test.mapper;

import com.jhlee.minipj.api.test.model.TestVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper {

  TestVO getDual(TestVO testVO);

}
