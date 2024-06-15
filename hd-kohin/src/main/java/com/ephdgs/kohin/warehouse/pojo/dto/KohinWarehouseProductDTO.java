package com.ephdgs.kohin.warehouse.pojo.dto;

import com.ephdgs.common.pojo.dto.PageDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class KohinWarehouseProductDTO extends PageDTO {
    private Integer kohinWarehouseId;
}
