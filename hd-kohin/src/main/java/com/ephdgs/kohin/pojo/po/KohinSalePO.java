package com.ephdgs.kohin.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ephdgs.common.pojo.po.BasePO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("kohin_sale")
public class KohinSalePO extends BasePO {
    @TableId(type = IdType.AUTO)
    private Integer kohinSaleId;
    private String code;
    private Integer kohinCustomerId;
    private Integer userId;
    private String province;
    private String city;
    private String district;
    private String detailAddress;
    private String consigneeName;
    private String consigneeMobile;
    private String paymentMethod;
}
