package com.ephdgs.mes.sale.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ephdgs.common.pojo.po.BasePO;
import com.ephdgs.mes.base.enums.CurrencyEnum;
import com.ephdgs.mes.base.enums.DeliveryMethodEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description:
 * @Date: 2024/5/12
 * @Author: Hill
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sale_order")
public class SaleOrderPO extends BasePO {
    @TableId(type = IdType.AUTO)
    private Integer saleOrderId;
    private String code;
    private CurrencyEnum currency;
    private DeliveryMethodEnum deliveryMethod;
    private String deliveryPoint;
    private Integer businessUserId;
    private Integer checkUserId;
    private String checkDate;
}
