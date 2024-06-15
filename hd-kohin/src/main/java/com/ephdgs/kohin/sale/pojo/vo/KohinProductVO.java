package com.ephdgs.kohin.sale.pojo.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class KohinProductVO {
    private String code;
    private String name;
    private String type;
    private String series;
    private BigDecimal price;
}
