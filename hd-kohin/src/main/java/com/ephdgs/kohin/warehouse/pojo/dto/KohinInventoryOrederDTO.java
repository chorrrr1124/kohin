package com.ephdgs.kohin.warehouse.pojo.dto;

import lombok.Data;

@Data
public class KohinInventoryOrederDTO {
    private Integer kohinInventoryOrderId;
    private String type;
    private String inventoryOrderDate;
    private Integer kohinWarehouseId;
}