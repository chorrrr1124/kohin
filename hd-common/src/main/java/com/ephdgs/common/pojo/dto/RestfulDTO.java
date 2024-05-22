package com.ephdgs.common.pojo.dto;

import lombok.Data;

/**
 * @Description:
 * @Date: 2024/2/28
 * @Author: Hill
 */
@Data
public class RestfulDTO<T> {
    private Integer code;
    private String message;
    private T data;
}
