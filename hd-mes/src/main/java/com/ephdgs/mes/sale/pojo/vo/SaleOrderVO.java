package com.ephdgs.mes.sale.pojo.vo;

import lombok.Data;

/**
 * @Description:
 * @Date: 2024/5/12
 * @Author: Hill
 */
@Data
public class SaleOrderVO {
    private String code;
    private String currency;
    private String deliveryMethod;
    private String deliveryPoint;
    private String businessUserName;
    private String checkUserName;
    private String checkDate;
    private Integer flag;
    private String remark;
    private String createTime;
}
