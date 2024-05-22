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
@TableName("sys_role_menu")
public class RoleMenuPO {
    @TableId(type = IdType.AUTO)
    private Integer roleMenuId;
    private Integer roleId;
    private Integer menuId;
}
