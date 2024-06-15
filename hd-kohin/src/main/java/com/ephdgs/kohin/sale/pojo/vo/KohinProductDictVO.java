package com.ephdgs.kohin.sale.pojo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class KohinProductDictVO {
    @JsonProperty("value")
    private String code;
    @JsonProperty("label")
    private String name;
}
