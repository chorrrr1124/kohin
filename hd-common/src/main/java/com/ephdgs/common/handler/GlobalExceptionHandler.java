package com.ephdgs.common.handler;

import com.ephdgs.common.enums.HttpStatusCodeEnum;
import com.ephdgs.common.exception.HDException;
import com.ephdgs.common.pojo.dto.RestfulDTO;
import com.ephdgs.common.utils.HttpResponseUtil;
import com.ephdgs.common.utils.LoggerUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Description:
 * @Date: 2024/5/8
 * @Author: Hill
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public RestfulDTO<Object> parameterBodyMissingExceptionHandler(HttpMessageNotReadableException e) {
        LoggerUtil.error(e.getMessage());
        return HttpResponseUtil.custom(HttpStatusCodeEnum.PARAMETER_ERROR.getCode(), null, HttpStatusCodeEnum.PARAMETER_ERROR.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public RestfulDTO<Object> exceptionHandler(HttpServletRequest request, Exception e) {
        LoggerUtil.error(e.getMessage());
        return HttpResponseUtil.custom(500, null, e.getMessage());
    }
}
