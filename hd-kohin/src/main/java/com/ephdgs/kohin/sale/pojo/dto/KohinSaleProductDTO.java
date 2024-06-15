package com.ephdgs.kohin.sale.pojo.dto;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class KohinSaleProductDTO {
    private Integer kohinSaleId;
    private Integer kohinWarehouseProductId;
    private Integer kohinProductId;
    private Integer num;
    private double discount;
    private BigDecimal total;


}
