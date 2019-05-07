package com.lefting.api.common.interceptor;

import com.lefting.api.common.constant.MessageConstants;
import com.lefting.api.common.exceptions.UnauthorizedException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component("apiInterceptor")
public class AppApiInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(AppApiInterceptor.class);
    private static final String AUTH_TOKEN = "AUTH_TOKEN";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("=========================== Interceptor prehandler {}=============================", request.getRequestURI());
        String token = request.getHeader(AUTH_TOKEN);

        //AppApiInterceptorConfig check URL
        if (!"".equalsIgnoreCase(token) && token != null) {
            if ( request.getMethod().equalsIgnoreCase("GET") ){
                //TODO:GET인경우 Parameter에 추가.
            }else{
                //TODO:POST는 BODY수정을 위해 다른곳에서 수행.
            }
//            request.setAttribute("memId", JwtUtil.getAuth(token).getMemId());
            request.setAttribute("token",token);
            return true;
        }

        throw new UnauthorizedException(MessageConstants.ResponseEnum.UNAUTHORIZED.getCode(), MessageConstants.ResponseEnum.UNAUTHORIZED.getDesc());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        logger.info("=========================== Method Completed =============================");
    }


}
