package com.ephdgs.kohin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ephdgs.common.pojo.dto.RestfulDTO;
import com.ephdgs.common.utils.HttpResponseUtil;
import com.ephdgs.kohin.pojo.dto.KohinSaleDTO;
import com.ephdgs.kohin.service.impl.KohinSaleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/kohin/sale")
@CrossOrigin("*")
public class SaleController {

    private KohinSaleServiceImpl kohinSaleService;

    @Autowired
    public void setKohinSaleService(KohinSaleServiceImpl kohinSaleService) {
        this.kohinSaleService = kohinSaleService;
    }

    @PostMapping("createSaleOrderHeader")
    public RestfulDTO<Object> createSaleOrderHeader(@RequestBody KohinSaleDTO kohinSaleDTO) {
        kohinSaleService.createSaleOrder(kohinSaleDTO);
        return HttpResponseUtil.ok();
    }

    @PostMapping("pageSaleOrderByUserId")
    public RestfulDTO<Object> pageSaleOrderByUserId(@RequestBody KohinSaleDTO kohinSaleDTO) {
        return HttpResponseUtil.data(kohinSaleService.getSaleOrderByUserId(new Page<>(kohinSaleDTO.getCurrentPage(), kohinSaleDTO.getPageSize()), kohinSaleDTO.getUserId()));
    }

    @PostMapping("pageSaleOrderProductBySaleOrderId")
    public RestfulDTO<Object> pageSaleOrderProductBySaleOrderId(@RequestBody KohinSaleDTO kohinSaleDTO) {
        return HttpResponseUtil.data(kohinSaleService.getSaleOrderProductBySaleOrderId(new Page<>(kohinSaleDTO.getCurrentPage(), kohinSaleDTO.getPageSize()), kohinSaleDTO.getSaleOrderId()));
    }
}
