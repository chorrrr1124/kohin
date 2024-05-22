package com.ephdgs.mes.base.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ephdgs.common.pojo.po.BasePO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description:
 * @Date: 2024/5/12
 * @Author: Hill
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("base_bom")
public class BomPO extends BasePO {
    @TableId(type = IdType.AUTO)
    private Integer bomId;
    private String code;
    private String name;
}
