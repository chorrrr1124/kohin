package com.ephdgs.kohin.warehouse.pojo.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ephdgs.common.pojo.po.BasePO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("kohin_inventory_product")
public class KohinInventoryProductPO extends BasePO {
    private Integer kohinInventoryProductId;
    private Integer kohinInventoryOrderId;
    private Integer kohinWarehouseProductId;
    private Integer num;
    private Integer inventoryProfit;
    private Integer inventoryLoss;
}
