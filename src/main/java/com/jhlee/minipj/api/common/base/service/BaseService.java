package com.jhlee.minipj.api.common.base.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     *
     */
    public BaseService() {}

    protected void logDebug(Object message) {
        if(message == null) logger.debug("null");
        logger.debug(message.toString());
    }

    protected void logInfo(Object message) {
        if(message == null) logger.info("null");
        logger.info(message.toString());
    }
    /**
     * slf4j.Logger를 이용한 Error 로그 출력
     * @param message 메세지
     */
    protected void logError(Object message) {
        if(message == null) logger.error("null");
        logger.error(message.toString());
    }

    /**
     * slf4j.Logger를 이용한 Error 로그 출력, 인자값으로 익셉션 객체 받음
     * @param : meesage 메세지
     * @param : t 오류 Exception 객체
     */
    protected void logError(Object message, Throwable t) {
        if(message == null) logger.error("null", t);
        logger.error(message.toString(), t);
    }

}
