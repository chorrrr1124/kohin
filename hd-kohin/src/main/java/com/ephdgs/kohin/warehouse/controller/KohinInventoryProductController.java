package com.ephdgs.kohin.warehouse.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ephdgs.common.pojo.dto.RestfulDTO;
import com.ephdgs.common.utils.HttpResponseUtil;
import com.ephdgs.kohin.warehouse.pojo.dto.KohinInventoryProductDTO;
import com.ephdgs.kohin.warehouse.service.KohinInventoryProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/kohin/warehouse/inventoryproduct")
public class KohinInventoryProductController {
private KohinInventoryProductService kohinInventoryProductService;
@Autowired
    public void setKohinInventoryProductService(KohinInventoryProductService kohinInventoryProductService) {
        this.kohinInventoryProductService = kohinInventoryProductService;
    }
    @PostMapping("pageinventoryproduct")
    public RestfulDTO<Object> pageKohinProductByKohinInventoryProductId(@RequestBody KohinInventoryProductDTO kohinInventoryProductDTO) {
        return HttpResponseUtil.data(kohinInventoryProductService.pageKohinProductByKohinInventoryProductId(new Page<>(kohinInventoryProductDTO.getCurrentPage(), kohinInventoryProductDTO.getPageSize()), kohinInventoryProductDTO.getKohinInventoryProductId()));
    }
}

