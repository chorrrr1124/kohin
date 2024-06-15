package com.ephdgs.kohin.warehogetOcontroller;

import com.ephdgs.common.pojo.dto.RestfulDTO;
import com.ephdgs.common.utils.HttpResponseUtil;
import com.ephdgs.kohin.warehouse.pojo.dto.KohinWarehouseOrderDTO;
import com.ephdgs.kohin.warehouse.service.KohinWarehouseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/kohin/warehouse/warehouseorder")
public class KohinWarehouseOrderController {
    private KohinWarehouseOrderService kohinWarehouseOrderService;
@Autowired
    public void setKohinWarehouseOrderService(KohinWarehouseOrderService kohinWarehouseOrderService) {
        this.kohinWarehouseOrderService = kohinWarehouseOrderService;
    }
    @PostMapping("create")
    public RestfulDTO<Object> create(@RequestBody KohinWarehouseOrderDTO kohinWarehouseOrderDTO ){
        kohinWarehouseOrderService.newOrder(kohinWarehouseOrderDTO);
        return HttpResponseUtil.ok();
    }
}
