package com.jhlee.minipj.api.common.resolver;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
//import com.jhlee.minipj.api.auth.model.AuthVO;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class AuthVOHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    private static final Logger logger = LoggerFactory.getLogger(AuthVOHandlerMethodArgumentResolver.class);

    private static final String AUTH_TOKEN = "AUTH_TOKEN";
    private static final String JSONBODYATTRIBUTE = "JSON_REQUEST_BODY";

    private ObjectMapper om = new ObjectMapper();

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return true;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        String jsonBody = getRequestBody(webRequest);
        JsonNode rootNode = om.readTree(jsonBody);
        om.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, true);

        String token = webRequest.getHeader(AUTH_TOKEN);
//        AuthVO authVO = new AuthVO();
//        if ( token != null && !"".equalsIgnoreCase(token)) {
//            authVO = JwtUtil.getAuth(token);
//            ((ObjectNode)rootNode).put("memId", authVO.getMemId());
//        }else{
//            logger.debug(">>>>>>null");
//        }

        logger.debug("parameter.getParameterType():" + parameter.getParameterType());
        String test = om.writeValueAsString(rootNode);
        logger.debug(">>>>>>test:"+ test);
        return om.readValue(test, parameter.getParameterType());
    }

    private String getRequestBody(NativeWebRequest webRequest){
        HttpServletRequest servletRequest = webRequest.getNativeRequest(HttpServletRequest.class);
        /*
        String token = webRequest.getHeader(AUTH_TOKEN);
        if (token != null){
            servletRequest.setAttribute("memId", token);
        }
        */

        try {
            String body = IOUtils.toString(servletRequest.getInputStream(), "UTF-8");
            servletRequest.setAttribute(JSONBODYATTRIBUTE, body);
            return body;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
