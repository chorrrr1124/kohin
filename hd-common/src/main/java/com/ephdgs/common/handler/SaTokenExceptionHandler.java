package com.ephdgs.common.handler;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import cn.dev33.satoken.exception.NotSafeException;
import com.ephdgs.common.enums.HttpStatusCodeEnum;
import com.ephdgs.common.pojo.dto.RestfulDTO;
import com.ephdgs.common.utils.HttpResponseUtil;
import com.ephdgs.common.utils.LoggerUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Description:
 * @Date: 2024/2/22
 * @Author: Hill
 */
@RestControllerAdvice
public class SaTokenExceptionHandler {

    @ExceptionHandler(NotLoginException.class)
    public RestfulDTO<Object> handlerNotLoginException(NotLoginException nle) {
        // 不同异常返回不同状态码
        String message = "";
        if (nle.getType().equals(NotLoginException.NOT_TOKEN)) {
            message = "未提供Token";
            LoggerUtil.error(message, nle);
            return HttpResponseUtil.error(HttpStatusCodeEnum.TOKEN_ERROR);
        } else if (nle.getType().equals(NotLoginException.INVALID_TOKEN)) {
            message = "未提供有效的Token";
            LoggerUtil.error(message, nle);
            return HttpResponseUtil.error(HttpStatusCodeEnum.TOKEN_ERROR);
        } else if (nle.getType().equals(NotLoginException.TOKEN_TIMEOUT)) {
            message = "登录信息已过期，请重新登录";
            LoggerUtil.error(message, nle);
            return HttpResponseUtil.error(HttpStatusCodeEnum.TOKEN_ERROR);
        } else if (nle.getType().equals(NotLoginException.BE_REPLACED)) {
            message = "您的账户已在另一台设备上登录，如非本人操作，请立即修改密码";
            LoggerUtil.error(message, nle);
            return HttpResponseUtil.error(HttpStatusCodeEnum.TOKEN_ERROR);
        } else if (nle.getType().equals(NotLoginException.KICK_OUT)) {
            message = "已被系统强制下线";
            LoggerUtil.error(message, nle);
            return HttpResponseUtil.error(HttpStatusCodeEnum.TOKEN_ERROR);
        } else {
            message = "当前会话未登录";
            LoggerUtil.error(message, nle);
            return HttpResponseUtil.error(HttpStatusCodeEnum.LOGIN_ERROR);
        }
    }

    @ExceptionHandler
    public RestfulDTO<Object> handlerNotRoleException(NotRoleException e) {
        LoggerUtil.error(e.getMessage(), e);
        return HttpResponseUtil.error(HttpStatusCodeEnum.ROLE_ERROR);
    }

    @ExceptionHandler
    public RestfulDTO<Object> handlerNotPermissionException(NotPermissionException e) {
        LoggerUtil.error(e.getMessage(), e);
        return HttpResponseUtil.error(HttpStatusCodeEnum.PERMISSION_ERROR);
    }

    @ExceptionHandler
    public RestfulDTO<Object> handlerNotSafeException(NotSafeException e) {
        LoggerUtil.error(e.getMessage(), e);
        return HttpResponseUtil.error(HttpStatusCodeEnum.PERMISSION_ERROR);
    }

}
