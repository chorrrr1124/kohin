package com.ephdgs.mes.sale.pojo.vo;

import com.ephdgs.mes.base.enums.UnitEnum;
import lombok.Data;

/**
 * @Description:
 * @Date: 2024/5/12
 * @Author: Hill
 */
@Data
public class SaleOrderDataVO {
    private String code;
    private String name;
    private String model;
    private UnitEnum unit;
    private String nickname;
    private Integer quantity;
    private String deliveryDate;
    private Integer seq;
}
