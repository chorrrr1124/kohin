package com.ephdgs.kohin.sale.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ephdgs.common.enums.SysFlagEnum;
import com.ephdgs.common.pojo.dto.RestfulDTO;
import com.ephdgs.common.utils.HttpResponseUtil;
import com.ephdgs.kohin.sale.pojo.dto.KohinProductDTO;
import com.ephdgs.kohin.sale.pojo.po.KohinProductPO;
import com.ephdgs.kohin.sale.pojo.vo.KohinProductDictVO;
import com.ephdgs.kohin.sale.pojo.vo.KohinProductSpecVO;
import com.ephdgs.kohin.sale.pojo.vo.KohinProductVO;
import com.ephdgs.kohin.sale.service.impl.KohinProductServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/kohin/product")
@CrossOrigin("*")
public class ProductController {

    private KohinProductServiceImpl kohinProductService;

    @Autowired
    public void setKohinProductService(KohinProductServiceImpl kohinProductService) {
        this.kohinProductService = kohinProductService;
    }

    @PostMapping("getProduct")
    public RestfulDTO<Object> getProduct() {
        QueryWrapper<KohinProductPO> wrapper = new QueryWrapper<>();
        wrapper.eq("flag", SysFlagEnum.USER_ENABLE);
        List<KohinProductPO> productPO = kohinProductService.list(wrapper);
        List<KohinProductDictVO> kohinProductDictVOList = new ArrayList<>();
        productPO.forEach(item -> {
            ObjectMapper objectMapper = new ObjectMapper();
            KohinProductSpecVO kohinProductSpecVO = new KohinProductSpecVO();
            try {
                kohinProductSpecVO = objectMapper.readValue(item.getSpec(), KohinProductSpecVO.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            item.setName(item.getName() + "-" + kohinProductSpecVO.getWidth() + kohinProductSpecVO.getWarpage() + "-" + kohinProductSpecVO.getLength());
            KohinProductDictVO kohinProductDictVO = new KohinProductDictVO();
            BeanUtils.copyProperties(item, kohinProductDictVO);
            kohinProductDictVOList.add(kohinProductDictVO);
        });
        return HttpResponseUtil.data(kohinProductDictVOList);
    }

    @PostMapping("getProductByCode")
    public RestfulDTO<Object> getProductByCode(@RequestBody KohinProductDTO kohinProductDTO) {
        QueryWrapper<KohinProductPO> wrapper = new QueryWrapper<>();
        wrapper.eq("flag", SysFlagEnum.USER_ENABLE);
        wrapper.eq("code", kohinProductDTO.getCode());
        KohinProductPO productPO = kohinProductService.getOne(wrapper);
        KohinProductVO kohinProductVO = new KohinProductVO();
        BeanUtils.copyProperties(productPO, kohinProductVO);
        return HttpResponseUtil.data(kohinProductVO);
    }

}
