package com.ephdgs.kohin.sale.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@Data
@TableName("kohin_product_customer")
public class KohinProductCustomerPO  {
    @TableId(type = IdType.AUTO)
    private Integer kohinProductCustomerId;
    private Integer kohinProductId;
    private Integer kohinCustomerId;
    private Integer num;
}
