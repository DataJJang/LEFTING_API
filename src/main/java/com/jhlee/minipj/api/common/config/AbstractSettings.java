package com.jhlee.minipj.api.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public abstract class AbstractSettings {

    private static ObjectMapper mapper = new ObjectMapper();

    public String toString() {
        try{
            return mapper.writeValueAsString(this);
        }catch(Exception e){
            return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE.SHORT_PREFIX_STYLE);
        }
    }
}
