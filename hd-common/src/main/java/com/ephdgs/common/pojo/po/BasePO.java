package com.ephdgs.common.pojo.po;

import lombok.Data;

/**
 * @Description:
 * @Date: 2024/2/28
 * @Author: Hill
 */
@Data
public class BasePO {
    private Integer flag;
    private String remark;
    private Integer createUser;
    private String createTime;
    private Integer updateUser;
    private String updateTime;
}
