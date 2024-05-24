package com.ephdgs.kohin.pojo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class KohinProductDictVO {
    @JsonProperty("value")
    private String code;
    @JsonProperty("label")
    private String name;
}
