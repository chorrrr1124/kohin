package com.ephdgs.kohin.pojo.vo;

import lombok.Data;

@Data
public class KohinSaleProductVO {
    /**
     * 商品编码
     */
    private String kohinProductCode;
    /**
     * 规格
     */
    private String spec;
    /**
     * 单价
     */
    private String price;
    /**
     * 数量
     */
    private String num;
    /**
     * 金额
     */
    private String subtotal;

}
