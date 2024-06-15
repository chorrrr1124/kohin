package com.ephdgs.kohin.warehouse.controller;

import com.ephdgs.common.pojo.dto.RestfulDTO;
import com.ephdgs.common.utils.HttpResponseUtil;
import com.ephdgs.kohin.warehouse.pojo.dto.KohinIoProductOrderDTO;
import com.ephdgs.kohin.warehouse.pojo.po.KohinIoProductPO;
import com.ephdgs.kohin.warehouse.pojo.po.KohinWarehouseOrderPO;
import com.ephdgs.kohin.warehouse.service.KohinIoProductService;
import com.ephdgs.kohin.warehouse.service.KohinWarehouseOrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/kohin/warehouse/warehouseiorder")
public class KohinIoProductController {
    private KohinIoProductService kohinIoProductService;
    private KohinWarehouseOrderService kohinWarehouseOrderService;

    @Autowired
    public void setKohinIoProductService(KohinIoProductService kohinIoProductService) {
        this.kohinIoProductService = kohinIoProductService;
    }
@Autowired
    public void setKohinWarehouseOrderService(KohinWarehouseOrderService kohinWarehouseOrderService) {
        this.kohinWarehouseOrderService = kohinWarehouseOrderService;
    }

    @PostMapping("create")
    public RestfulDTO<Object> creatIoProduct(@RequestBody KohinIoProductOrderDTO kohinIoProductOrderDTO) {
        kohinIoProductOrderDTO.getProductDTOList().forEach((k) -> {
            KohinIoProductPO kohinIoProductPO = new KohinIoProductPO();
            BeanUtils.copyProperties(k,kohinIoProductPO);
            kohinIoProductService.save(kohinIoProductPO);
        });
        KohinWarehouseOrderPO kohinWarehouseOrderPO = new KohinWarehouseOrderPO();
        BeanUtils.copyProperties(kohinIoProductOrderDTO,kohinWarehouseOrderPO);
        kohinWarehouseOrderService.save(kohinWarehouseOrderPO);
        return HttpResponseUtil.ok();
    }
}
