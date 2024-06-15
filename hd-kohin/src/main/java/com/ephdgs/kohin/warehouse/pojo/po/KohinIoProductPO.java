package com.ephdgs.kohin.warehouse.pojo.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ephdgs.common.pojo.po.BasePO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("kohin_io_product")
public class KohinIoProductPO extends BasePO {
    private Integer kohinIoProductId;
    private Integer kohinWarehouseProductId;
    private Integer kohinWarehouseOrderId;
    private Integer num;
    private Integer price;
}
