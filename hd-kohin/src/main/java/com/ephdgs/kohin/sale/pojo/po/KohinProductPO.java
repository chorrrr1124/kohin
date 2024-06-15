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
@TableName("kohin_product")
public class KohinProductPO extends BasePO {
    @TableId(type = IdType.AUTO)
    private Integer kohinProductId;
    private String code;
    private String name;
    private String type;
    private String series;
    private BigDecimal price;
    private String spec;
}
