package com.jhlee.minipj.api.common.base.web;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/**
 * Class Name : BaseController.java<br>
 * Description : BaseController class
 * @see
 * <pre>
 *  Modification Information
 *  수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *
 * </pre>
 * @author Wan
 * @since 2015. 6. 8.
 * @version 1.0
 *
 */
public abstract class BaseController implements ApplicationContextAware {
	private Logger logger; 
	
	private ApplicationContext applicationContext;

	public BaseController() {
		logger = LoggerFactory.getLogger(this.getClass());
	}
	
	/*@PostConstruct
	private void init() {
		messageSource = applicationContext.getBean("egovMessageSource", EgovMessageSource.class);
	}*/

	/**
	 * slf4j.Logger를 이용한 Deubg 로그 출력
	 * @param message 메세지
	 */
	protected void logDebug(Object message) {
		if(message == null) logger.debug("null"); 
		logger.debug(message.toString());
	}

	/**
	 * slf4j.Logger를 이용한 Info 로그 출력
	 * @param message 메세지
	 */
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
	 * @param message 메세지
	 * @param t 오류 Exception 객체
	 */
	protected void logError(Object message, Throwable t) {
		if(message == null) logger.error("null", t);
		logger.error(message.toString(), t);
	}
	
	/*@ExceptionHandler(Exception.class)
    public @ResponseBody String handleUncaughtException(Exception ex, WebRequest request, HttpServletResponse response) throws IOException {
		String requestedWith = request.getHeader("X-Requested-With");
		boolean isAjaxRequest = requestedWith != null ? "XMLHttpRequest".equals(requestedWith) : false;
         if (isAjaxRequest) {
            response.setHeader("Content-Type", "application/json");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return "Unknown error occurred: " + ex.getMessage();
        } else {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, ex.getMessage());
            return null;
        }
    }*/


	/**
	 * 현재 접속한 클라이언트의 IP정보를 가져오는 메소드(HttpServletRequest의 getRemoteAddr() 호출)
	 * @return IP Address ex)0:0:0:0:0:0:0:1(IpV6) 127.0.0.1(IpV4)
	 */
	protected String getIp() {
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		if(servletRequestAttributes == null) return null;
		HttpServletRequest request = servletRequestAttributes.getRequest();
		String ip = request.getHeader("X-Forwarded-For");
		if(ip == null || ip.length() < 7 ) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}
}
