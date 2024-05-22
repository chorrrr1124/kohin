package com.ephdgs.mes.sale.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ephdgs.common.annotation.ApiVersion;
import com.ephdgs.common.pojo.dto.RestfulDTO;
import com.ephdgs.common.utils.HttpResponseUtil;
import com.ephdgs.mes.sale.pojo.dto.SaleOrderDTO;
import com.ephdgs.mes.sale.pojo.dto.SaleOrderDataDTO;
import com.ephdgs.mes.sale.service.impl.SaleOrderDataServiceImpl;
import com.ephdgs.mes.sale.service.impl.SaleOrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Date: 2024/5/12
 * @Author: Hill
 */
@RestController
@RequestMapping("/api/{version}/sale")
@CrossOrigin("*")
@ApiVersion
public class SaleOrderController {

    private SaleOrderServiceImpl saleOrderService;

    private SaleOrderDataServiceImpl saleOrderDataService;

    @Autowired
    public void setSaleOrderService(SaleOrderServiceImpl saleOrderService) {
        this.saleOrderService = saleOrderService;
    }

    @Autowired
    public void setSaleOrderDataService(SaleOrderDataServiceImpl saleOrderDataService) {
        this.saleOrderDataService = saleOrderDataService;
    }

    @PostMapping("saleOrderPage")
    public RestfulDTO<Object> saleOrderPage(@RequestBody SaleOrderDTO saleOrderDTO) {
        return HttpResponseUtil.data(saleOrderService.getSaleOrderPage(new Page<>(saleOrderDTO.getCurrentPage(), saleOrderDTO.getPageSize()), saleOrderDTO.getIndex()));
    }

    @PostMapping("saleOrderDataByOrderId")
    public RestfulDTO<Object> saleOrderDataByOrderId(@RequestBody SaleOrderDataDTO saleOrderDataDTO) {
        return HttpResponseUtil.data(saleOrderDataService.getSaleOrderDataList(saleOrderDataDTO.getSaleOrderId()));
    }
}
