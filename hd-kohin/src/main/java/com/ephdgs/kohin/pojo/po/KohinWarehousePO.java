package com.ephdgs.kohin.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ephdgs.common.pojo.po.BasePO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("kohin_warehouse")
public class KohinWarehousePO extends BasePO {
    @TableId(type = IdType.AUTO)
    private Integer KohinWarehouseId;
    private Integer code;
    private Integer kohinProductId;
    private Integer num;
}
