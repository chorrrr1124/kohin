package com.ephdgs.mes.base.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ephdgs.common.pojo.po.BasePO;
import com.ephdgs.mes.base.enums.UnitEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description: 商品表
 * @Date: 2024/5/12
 * @Author: Hill
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("base_commodity")
public class CommodityPO extends BasePO {
    @TableId(type = IdType.AUTO)
    private Integer commodityId;
    private String code;
    private String name;
    private String model;
    private UnitEnum unit;
}
