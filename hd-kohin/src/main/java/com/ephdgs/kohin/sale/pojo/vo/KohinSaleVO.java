package com.ephdgs.kohin.sale.pojo.vo;

import lombok.Data;

@Data
public class KohinSaleVO {
    /**
     * 订单编码
     */
    private String code;
    /**
     * 客户id
     */
    private Integer kohinCustomerId;
    /**
     * 客户名
     */
    private String kohinCustomerNickName;
    /**
     * 收货人名称
     */
    private String consigneeName;
    /**
     * 销售id
     */
    private Integer userId;
    /**
     * 收货人电话
     */
    private String consigneeMobile;
    private String province;
    private String city;
    private String district;
    private String detailAddress;
    /**
     * 收款方式
     */
    private String paymentMethod;
    /**
     * 收款金额
     */
    private Integer total;

}