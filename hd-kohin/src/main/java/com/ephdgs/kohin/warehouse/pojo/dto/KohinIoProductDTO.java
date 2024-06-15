package com.ephdgs.kohin.warehouse.pojo.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class KohinIoProductDTO {
    private Integer kohinWarehouseProductId;
    private Integer kohinWarehouseOrderId;
    private String kohinProductId;
    private BigDecimal price;
    private Integer num;
}
