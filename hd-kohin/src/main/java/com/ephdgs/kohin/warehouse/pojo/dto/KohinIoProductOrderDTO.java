package com.ephdgs.kohin.warehouse.pojo.dto;

import lombok.Data;

import java.util.List;

@Data
public class KohinIoProductOrderDTO {
    private String type;
    private String code;
    private String ioDate;
    private List<KohinIoProductDTO> productDTOList;
}
