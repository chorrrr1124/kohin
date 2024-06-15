package com.ephdgs.kohin.warehouse.pojo.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ephdgs.common.pojo.po.BasePO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("kohin_warehouse_order")
public class KohinWarehouseOrderPO extends BasePO {
private Integer kohinWarehouseOrderId;
    private Integer kohinWarehouseId;
    private String type;
    private String ioDate;
}
