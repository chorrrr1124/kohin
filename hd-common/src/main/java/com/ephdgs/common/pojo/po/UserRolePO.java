package com.ephdgs.common.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description:
 * @Date: 2024/2/28
 * @Author: Hill
 */
@Data
@TableName("sys_user_role")
public class UserRolePO {
    @TableId(type = IdType.AUTO)
    private Integer userRoleId;
    private Integer userId;
    private Integer roleId;
}
