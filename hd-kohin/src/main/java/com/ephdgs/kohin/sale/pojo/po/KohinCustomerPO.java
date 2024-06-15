package com.ephdgs.kohin.sale.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ephdgs.common.pojo.po.BasePO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("kohin_customer")
public class KohinCustomerPO extends BasePO {
    @TableId(type = IdType.AUTO)
    private Integer kohinCustomerId;
    private String code;
    private String nickname;
    private String type;
    private String mobile;
    private String wechatId;
    private String province;
    private String city;
    private String district;
    private String detailAddress;
}
