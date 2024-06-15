package com.ephdgs.kohin.sale.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ephdgs.common.pojo.po.BasePO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("kohin_sale_product")
public class KohinSaleProductPO extends BasePO {
    @TableId(type = IdType.AUTO)
    private Integer kohinSaleProductId;
    private Integer kohinSaleId;
    private Integer kohinProductId;
    private Integer num;
    private double discount;
    private BigDecimal total;
}
