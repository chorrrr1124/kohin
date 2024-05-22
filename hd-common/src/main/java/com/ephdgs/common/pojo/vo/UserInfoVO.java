package com.ephdgs.common.pojo.vo;

import lombok.Data;

/**
 * @Description:
 * @Date: 2024/5/8
 * @Author: Hill
 */
@Data
public class UserInfoVO {
    private String code;
    private String username;
    private String nickname;
    private String mobile;
    private Integer loginIn;
    private String roleName;
    private Integer flag;
    private String remark;
    private String createTime;
}
