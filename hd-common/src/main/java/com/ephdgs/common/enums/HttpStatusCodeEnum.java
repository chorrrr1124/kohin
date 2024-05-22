package com.ephdgs.common.enums;

import lombok.Getter;

/**
 * @Description:
 * @Date: 2024/2/28
 * @Author: Hill
 */
@Getter
public enum HttpStatusCodeEnum {
    //系统
    ERROR(40000, "未知错误"),
    PARAMETER_ERROR(41000, "参数错误"),
    REQUEST_ERROR(41001, "请求非法"),
    NETWORK_ERROR(41002, "网络错误"),
    INSERT_ERROR(41003, "插入失败"),
    UPDATE_ERROR(41004, "更新失败"),
    SELECT_ERROR(41005, "查询失败"),
    DELETE_ERROR(41006, "删除失败"),
    LIMIT_ERROR(41007, "访问频率过高，请稍后再访问"),
    UPLOAD_ERROR(41008, "上传失败"),

    //登录业务
    LOGIN_ERROR(51001, "登录失败"),
    NO_LOGIN_ERROR(51002, "未登录"),
    ROLE_ERROR(51003, "没有此角色"),
    TOKEN_ERROR(51004, "TOKEN失效"),
    NO_TOKEN(51005, "未提供TOKEN"),
    CODE_ERROR(51006, "CODE过期"),
    PERMISSION_ERROR(51007, "权限不足"),
    OTP_CODE_ERROR(51008,"二次校验失败"),

    //预定业务
    HAS_ORDER_ERROR(61001, "预约失败，存在生效的预约"),
    CANCEL_ORDER_ERROR(61002, "取消失败")

    ;

    private Integer code;

    private String message;

    HttpStatusCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
