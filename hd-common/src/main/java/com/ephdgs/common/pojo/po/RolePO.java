package com.ephdgs.common.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description:
 * @Date: 2024/2/28
 * @Author: Hill
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_role")
public class RolePO extends BasePO{
    @TableId(type = IdType.AUTO)
    private Integer roleId;
    private Integer parentRoleId;
    private String name;
}
