package com.ephdgs.kohin.warehouse.pojo.dto;

import com.ephdgs.common.pojo.dto.PageDTO;
import lombok.Data;

@Data
public class KohinWarehouseLogDTO extends PageDTO {
    private Integer kohinWarehouseLogId;
    private Integer kohinWarehouseProductId;
    private String type;
    private Integer num;
}
