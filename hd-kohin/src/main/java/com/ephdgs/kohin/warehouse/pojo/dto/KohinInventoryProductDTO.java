package com.ephdgs.kohin.warehouse.pojo.dto;

import com.ephdgs.common.pojo.dto.PageDTO;
import lombok.Data;

@Data
public class KohinInventoryProductDTO extends PageDTO {
    private Integer kohinInventoryProductId;
    private Integer kohinProductId;
    private String name;
    private String series;
    private String width;
    private String length;
    private String warpage;
    private String unit;
}
