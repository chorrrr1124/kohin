package com.ephdgs.common.exception;

import com.ephdgs.common.enums.HttpStatusCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description:
 * @Date: 2024/5/8
 * @Author: Hill
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class HDException extends RuntimeException {
    private Integer code;
    private String message;
    public HDException() {
        super();
    }
    public HDException(HttpStatusCodeEnum httpStatusCodeEnum) {
        super(String.valueOf(httpStatusCodeEnum.getCode()));
        this.code = httpStatusCodeEnum.getCode();
        this.message = httpStatusCodeEnum.getMessage();
    }
}
