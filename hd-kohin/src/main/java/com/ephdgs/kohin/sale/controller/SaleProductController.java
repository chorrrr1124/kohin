package com.ephdgs.kohin.sale.controller;

import com.ephdgs.common.pojo.dto.RestfulDTO;
import com.ephdgs.common.utils.HttpResponseUtil;
import com.ephdgs.kohin.sale.pojo.dto.KohinSaleProductDTO;
import com.ephdgs.kohin.sale.pojo.po.KohinSaleProductPO;
import com.ephdgs.kohin.sale.service.impl.KohinSaleProductServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/kohin/saleProduct")
@CrossOrigin("*")
public class SaleProductController {

    private KohinSaleProductServiceImpl kohinSaleProductService;

    @Autowired
    public void setKohinSaleProductService(KohinSaleProductServiceImpl kohinSaleProductService) {
        this.kohinSaleProductService = kohinSaleProductService;
    }

    @PostMapping("create")
    public RestfulDTO<Object> create(@RequestBody KohinSaleProductDTO kohinSaleProductDTO) {
        KohinSaleProductPO kohinSaleProductPO = new KohinSaleProductPO();
        BeanUtils.copyProperties(kohinSaleProductDTO, kohinSaleProductPO);
        kohinSaleProductService.save(kohinSaleProductPO);
        return HttpResponseUtil.ok();
    }
}
