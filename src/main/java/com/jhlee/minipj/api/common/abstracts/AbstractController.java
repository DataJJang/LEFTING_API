package com.jhlee.minipj.api.common.abstracts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jhlee.minipj.api.common.base.model.ResultVO;
import com.jhlee.minipj.api.common.constant.MessageConstants;
import com.jhlee.minipj.api.common.exceptions.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public abstract class AbstractController {

    private static final Logger logger = LoggerFactory.getLogger(AbstractController.class);

    /**
     * < Custom Exception >
     * Parameter Invalid Exception
     *
     * @param request
     * @param response
     * @param exception
     * @return
     */
    @ExceptionHandler({NoContentException.class})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public ResultVO NoContentExceptionHandler(final HttpServletRequest request, final HttpServletResponse response, final NoContentException exception) {
        final String errorType = "NE";
        final String code = exception.getCode();
        final String codeDesc = exception.getDescMsg();

        return getResultVO(request, exception, code, codeDesc, errorType);
    }

    @ExceptionHandler({RestfulAPIException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResultVO restfulApiExceptionHandler(final HttpServletRequest request, final HttpServletResponse response, final RestfulAPIException exception) {
        final String errorType = "RE";
        final String code = exception.getCode();
        final String codeDesc = exception.getDescMsg();
        return getResultVO(request, exception, code, codeDesc, errorType);
    }
    @ExceptionHandler({UnauthorizedException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ResultVO unauthrizedExceptionHandler(final HttpServletRequest request, final HttpServletResponse response, final UnauthorizedException exception) {
        final String errorType = "AE";
        final String code = exception.getCode();
        final String codeDesc = exception.getDescMsg();

        return getResultVO(request, exception, code, codeDesc, errorType);
    }

    @ExceptionHandler({UserInfoFoundException.class})
    @ResponseStatus(HttpStatus.PAYMENT_REQUIRED)
    @ResponseBody
    public ResultVO userInfoFoundExceptionHandler(final HttpServletRequest request, final HttpServletResponse response, final UserInfoFoundException exception) {
        final String errorType = "UE";
        final String code = exception.getCode();
        final String codeDesc = exception.getDescMsg();

        return getResultVO(request, exception, code, codeDesc, errorType);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class, ParameterInvalidException.class})
    @ResponseStatus(HttpStatus.PAYMENT_REQUIRED)
    @ResponseBody
    public ResultVO parameterInvalidExceptionHandler(final HttpServletRequest request, final HttpServletResponse response, final Exception exception) {
        final String errorType = "PI";
        final String code = MessageConstants.ResponseEnum.PARAM_REQUIRED.getCode();
        final String codeDesc = MessageConstants.ResponseEnum.PARAM_REQUIRED.getDesc();
        return getResultVO(request, exception, code, codeDesc, errorType);
    }


    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResultVO defaultExceptionHandler(final HttpServletRequest request, final HttpServletResponse response, final Exception exception) {

        final String errorType = "SE";
        final String code = "9400";
        final String codeDesc = exception.getMessage();
        final String data = exception.getMessage();

        return getResultVO(request, exception, code, codeDesc, errorType);
    }

    @ExceptionHandler({HubServerException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResultVO hubServerExceptionHandler(final HttpServletRequest request, final HttpServletResponse response, final HubServerException exception) {

        final String errorType = "SE";
        final String code = exception.getCode();
        final String codeDesc = exception.getDescMsg();

        return getResultVO(request, exception, code, codeDesc, errorType);
    }

    /**
     * 동일 코드 리팩토리
     * 작업자 - jblee
     * */
    private ResultVO getResultVO(final HttpServletRequest request, final Exception exception, final String code, final String codeDesc, final String errorType) {
        StringBuffer sblog = new StringBuffer();

        sblog.append("\n==================================================================================================");
        sblog.append("\n>>>>>>>>> Error Occurred >>>>>>>>>>");
        sblog.append(String.format("\n[url] : %s", request.getRequestURL()));
        //sblog.append(String.format("\n[Parameter] : %s", request.getRequestURL()));
        sblog.append(String.format("\n[error] : %s", exception.getClass().getSimpleName()));
        sblog.append(String.format("\n[message] : %s", codeDesc));
        sblog.append("\n[stack trace] : \n");

        final ResultVO error = new ResultVO();
        error.setCode(code);
        error.setMessage(codeDesc);

        if ("PI".equals(errorType)) { //errorType 이 'parameterInvalid' 즉 'PI' 인 경우
            // 스프링 어노테이션 invalid error인 경우
            if (exception instanceof MethodArgumentNotValidException) {
                error.setMessage(((MethodArgumentNotValidException) exception).getBindingResult().getFieldError().getField());
            } else { // 사용자 정의 invalid error인 경우
                error.setMessage(codeDesc);
            }
        }

        final StackTraceElement elements[] = exception.getStackTrace();
        for (final StackTraceElement element : elements) {
            sblog.append(element.toString());
        }

        sblog.append("\n>>>>>>>>> Error End >>>>>>>>>>");
        sblog.append("\n==================================================================================================");
        logger.error(sblog.toString());
        return error;
    }
}
