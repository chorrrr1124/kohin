package com.ephdgs.kohin.pojo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class KohinCustomerDictVO {
    @JsonProperty("value")
    private Integer kohinCustomerId;
    @JsonProperty("label")
    private String nickname;
}
