package com.ephdgs.kohin.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.ephdgs.common.pojo.dto.RestfulDTO;
import com.ephdgs.common.utils.HttpResponseUtil;
import com.ephdgs.kohin.pojo.dto.KohinSaleCustomerDTO;
import com.ephdgs.kohin.pojo.po.KohinProductCustomerPO;
import com.ephdgs.kohin.service.KohinProductCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/kohin/sale/productCustomer")
@CrossOrigin("*")
public class SaleCustomerController {

    private KohinProductCustomerService kohinProductCustomerService;

    @Autowired
    public void setKohinProductCustomerService(KohinProductCustomerService kohinProductCustomerService) {
        this.kohinProductCustomerService = kohinProductCustomerService;
    }

    @PostMapping("update")
    public RestfulDTO<Object> update(@RequestBody List<KohinSaleCustomerDTO> kohinSaleCustomerDTO) {
        kohinSaleCustomerDTO.forEach((k) -> {
            UpdateWrapper<KohinProductCustomerPO> wrapper = new UpdateWrapper<>();
            wrapper.eq("kohin_customer_id", k.getKohinCustomerId());
            wrapper.eq("kohin_product_id", k.getKohinProductId());
            wrapper.set("num", kohinProductCustomerService.getOne(wrapper).getNum() - k.getNum());
            kohinProductCustomerService.update(wrapper);
        });
        return HttpResponseUtil.ok();
    }
}
