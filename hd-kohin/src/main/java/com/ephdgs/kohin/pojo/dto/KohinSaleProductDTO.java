package com.ephdgs.kohin.pojo.dto;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class KohinSaleProductDTO {
    private Integer kohinSaleId;
    private Integer kohinProductId;
    private Integer num;
    private double discount;
    private BigDecimal total;


}
