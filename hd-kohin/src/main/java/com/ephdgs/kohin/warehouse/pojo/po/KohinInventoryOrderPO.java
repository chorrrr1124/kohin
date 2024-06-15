package com.ephdgs.kohin.warehouse.pojo.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ephdgs.common.pojo.po.BasePO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("kohin_inventory_order")
public class KohinInventoryOrderPO extends BasePO {
    private Integer kohinInventoryOrderId;
    private String type;
    private Integer inventoryOrderDate;
    private Integer kohinWarehouseId;
}
