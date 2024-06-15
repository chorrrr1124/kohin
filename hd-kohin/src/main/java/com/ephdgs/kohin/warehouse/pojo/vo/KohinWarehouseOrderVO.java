package com.ephdgs.kohin.warehouse.pojo.vo;

import lombok.Data;

@Data
public class KohinWarehouseOrderVO {
    private String name;
    private String code;
    private String type;
    private String ioDate;
    private String series;
    private String width;
    private String length;
    private String warpage;
    private String unit;
    private Integer num;
}
