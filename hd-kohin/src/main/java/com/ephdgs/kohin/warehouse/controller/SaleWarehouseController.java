package com.ephdgs.kohin.warehouse.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.ephdgs.common.pojo.dto.RestfulDTO;
import com.ephdgs.common.utils.HttpResponseUtil;
import com.ephdgs.kohin.sale.pojo.dto.KohinSaleCustomerDTO;
import com.ephdgs.kohin.warehouse.pojo.po.KohinWarehousePO;
import com.ephdgs.kohin.warehouse.service.KohinWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/kohin/sale/warehouse")
@CrossOrigin("*")
public class SaleWarehouseController {

    private KohinWarehouseService kohinWarehouseService;

    @Autowired
    public void setKohinWarehouseService(KohinWarehouseService kohinWarehouseService) {
        this.kohinWarehouseService = kohinWarehouseService;
    }

    @PostMapping("update")
    public RestfulDTO<Object> update(@RequestBody List<KohinSaleCustomerDTO> kohinSaleCustomerDTO) {
        kohinSaleCustomerDTO.forEach((k) -> {
            UpdateWrapper<KohinWarehousePO> wrapper = new UpdateWrapper<>();
            wrapper.eq("kohin_product_id", k.getKohinProductId());

            kohinWarehouseService.update(wrapper);
        });
        return HttpResponseUtil.ok();
    }
}
