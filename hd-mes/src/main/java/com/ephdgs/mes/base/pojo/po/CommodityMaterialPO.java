package com.ephdgs.mes.base.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description:
 * @Date: 2024/5/12
 * @Author: Hill
 */
@Data
@TableName("base_commodity_material")
public class CommodityMaterialPO {
    @TableId(type = IdType.AUTO)
    private Integer commodityMaterialId;
    private Integer commodityId;
    private Integer materialId;
}
