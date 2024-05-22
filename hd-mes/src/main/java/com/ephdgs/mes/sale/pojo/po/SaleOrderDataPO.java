package com.ephdgs.mes.sale.pojo.po;

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
@TableName("sale_order_data")
public class SaleOrderDataPO extends BasePO {
    @TableId(type = IdType.AUTO)
    private Integer saleOrderDataId;
    private Integer saleOrderId;
    private Integer commodityId;
    private String nickname;
    private Integer quantity;
    private String deliveryDate;
    private Integer seq;
}
