package com.ephdgs.kohin.sale.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ephdgs.common.enums.SysFlagEnum;
import com.ephdgs.common.pojo.dto.RestfulDTO;
import com.ephdgs.common.utils.HttpResponseUtil;
import com.ephdgs.kohin.sale.pojo.po.KohinCustomerPO;
import com.ephdgs.kohin.sale.pojo.vo.KohinCustomerDictVO;
import com.ephdgs.kohin.sale.service.impl.KohinCustomerServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/kohin/customer")
@CrossOrigin("*")
public class CustomerController {

    private KohinCustomerServiceImpl kohinCustomerService;

    @Autowired
    public void setKohinCustomerService(KohinCustomerServiceImpl kohinCustomerService) {
        this.kohinCustomerService = kohinCustomerService;
    }

    @PostMapping("getCustomer")
    public RestfulDTO<Object> getCustomer() {
        QueryWrapper<KohinCustomerPO> wrapper = new QueryWrapper<>();
        wrapper.eq("flag", SysFlagEnum.USER_ENABLE);
        List<KohinCustomerPO> customerPO = kohinCustomerService.list(wrapper);
        List<KohinCustomerDictVO> kohinCustomerDictVOList  = new ArrayList<>();
        customerPO.forEach(KohinCustomerPO ->{
            KohinCustomerDictVO kohinCustomerDictVO = new KohinCustomerDictVO();
            BeanUtils.copyProperties(KohinCustomerPO, kohinCustomerDictVO);
            kohinCustomerDictVOList.add(kohinCustomerDictVO);
        });
        return HttpResponseUtil.data(kohinCustomerDictVOList);
    }


}
