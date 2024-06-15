package com.ephdgs.kohin.warehouse.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ephdgs.common.enums.SysFlagEnum;
import com.ephdgs.common.pojo.dto.RestfulDTO;
import com.ephdgs.common.utils.HttpResponseUtil;
import com.ephdgs.kohin.sale.pojo.dto.KohinSaleProductDTO;
import com.ephdgs.kohin.warehouse.pojo.dto.KohinWarehouseProductDTO;
import com.ephdgs.kohin.warehouse.pojo.po.KohinWarehouseProductPO;
import com.ephdgs.kohin.warehouse.service.KohinWarehouseProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/kohin/warehouse")
public class KohinWarehouseProductController {
    private KohinWarehouseProductService kohinWarehouseProductService;

    @Autowired
    public void setKohinWarehouseProductService(KohinWarehouseProductService kohinWarehouseProductService) {
        this.kohinWarehouseProductService = kohinWarehouseProductService;
    }

    @PostMapping("update")
    public RestfulDTO<Object> update(@RequestBody List<KohinSaleProductDTO> kohinSaleProductDTO) {
        kohinSaleProductDTO.forEach((k) -> {
            UpdateWrapper<KohinWarehouseProductPO> wrapper = new UpdateWrapper<>();
            wrapper.eq("kohin_product_id", k.getKohinProductId());
            wrapper.eq("kohin_warehouse_product_id", k.getKohinWarehouseProductId());
            wrapper.set("num", kohinWarehouseProductService.getOne(wrapper).getNum() - k.getNum());
            kohinWarehouseProductService.update(wrapper);
        });
        return HttpResponseUtil.ok();
    }
    @PostMapping("pageWarehouseProduct")
    public RestfulDTO<Object> pageSaleOrderByUserId(@RequestBody KohinWarehouseProductDTO kohinWarehouseProductDTO) {
        return HttpResponseUtil.data(kohinWarehouseProductService.pageKohinProductByKohinWarehouseId(new Page<>(kohinWarehouseProductDTO.getCurrentPage(), kohinWarehouseProductDTO.getPageSize()), kohinWarehouseProductDTO.getKohinWarehouseId()));
    }

@PostMapping("delete")
public RestfulDTO<Object> delete(@RequestBody List<KohinSaleProductDTO> kohinSaleProductDTO) {
    kohinSaleProductDTO.forEach((k) -> {
        UpdateWrapper<KohinWarehouseProductPO> wrapper = new UpdateWrapper<>();
        wrapper.eq("kohin_product_id", k.getKohinProductId());
        wrapper.eq("kohin_warehouse_product_id", k.getKohinWarehouseProductId());
        wrapper.set("flag", SysFlagEnum.USER_DISABLED);
        kohinWarehouseProductService.update(wrapper);
    });
    return HttpResponseUtil.ok();
}
}
