package com.ephdgs.kohin.pojo.dto;

import com.ephdgs.common.pojo.dto.PageDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class KohinSaleDTO extends PageDTO {
    private Integer kohinCustomerId;
    private String code;
    private Integer userId;
    private String province;
    private String city;
    private String district;
    private String detailAddress;
    private String consigneeName;
    private String consigneeMobile;
    private String paymentMethod;
    private Integer saleOrderId;
    private List<KohinSaleProductDTO> productDTOList;
}
