package com.ephdgs.kohin.warehouse.controller;

import com.ephdgs.common.pojo.dto.RestfulDTO;
import com.ephdgs.common.utils.HttpResponseUtil;
import com.ephdgs.common.utils.LoggerUtil;
import com.ephdgs.kohin.warehouse.pojo.dto.KohinInventoryOrederDTO;
import com.ephdgs.kohin.warehouse.service.KohinInventoryOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/kohin/warehouse/inventoryorder")
@CrossOrigin("*")
public class KohinInventoryOrderController {
    private KohinInventoryOrderService kohinInventoryOrderService;

    @Autowired
    public void setKohinInventoryOrderService(KohinInventoryOrderService kohinInventoryOrderService) {
        this.kohinInventoryOrderService = kohinInventoryOrderService;
    }

    @PostMapping("create")
    public RestfulDTO<Object> create(@RequestBody KohinInventoryOrederDTO kohinInventoryOrederDTO) {
        LoggerUtil.info(String.valueOf(kohinInventoryOrederDTO));
        kohinInventoryOrderService.newOrder(kohinInventoryOrederDTO);
        return HttpResponseUtil.ok();
    }
}
