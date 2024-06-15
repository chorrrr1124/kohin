package com.ephdgs.kohin.warehouse.pojo.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class KohinIoProductVO {
    private String name;
    private String series;
    private String code;
    private String width;
    private String length;
    private String warpage;
    private BigDecimal price;
    private Integer num;
    private String unit;
}
