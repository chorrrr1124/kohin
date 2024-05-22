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
@TableName("sys_menu")
public class MenuPO extends BasePO{
    @TableId(type = IdType.AUTO)
    private Integer menuId;
    private Integer parentMenuId;
    private String name;
    private Integer level;
}
