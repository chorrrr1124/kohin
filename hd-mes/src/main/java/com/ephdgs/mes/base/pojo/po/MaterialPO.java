package com.ephdgs.mes.base.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ephdgs.common.pojo.po.BasePO;
import com.ephdgs.mes.base.enums.TypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description:
 * @Date: 2024/5/12
 * @Author: Hill
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("base_material")
public class MaterialPO extends BasePO {
    @TableId(type = IdType.AUTO)
    private Integer materialId;
    private String code;
    private String name;
    private TypeEnum type;
    private String model;
    private String parameter;
}
