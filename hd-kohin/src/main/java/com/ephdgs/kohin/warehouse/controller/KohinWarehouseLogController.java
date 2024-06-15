package com.ephdgs.kohin.warehouse.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ephdgs.common.enums.SysFlagEnum;
import com.ephdgs.common.pojo.dto.RestfulDTO;
import com.ephdgs.common.utils.HttpResponseUtil;
import com.ephdgs.kohin.warehouse.pojo.dto.KohinWarehouseLogDTO;
import com.ephdgs.kohin.warehouse.pojo.po.KohinWarehouseLogPO;
import com.ephdgs.kohin.warehouse.service.KohinWarehouseLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/kohin/warehouse/warehouseLog")
public class KohinWarehouseLogController {
    private KohinWarehouseLogService kohinWarehouseLogService;

@Autowired
    public void setKohinWarehouseLogService(KohinWarehouseLogService kohinWarehouseLogService) {
        this.kohinWarehouseLogService = kohinWarehouseLogService;
    }


@PostMapping("delete")
    public RestfulDTO<Object> deleteWarehouseLog(@RequestBody KohinWarehouseLogDTO kohinWarehouseLogDTO){
    UpdateWrapper<KohinWarehouseLogPO> wrapper = new UpdateWrapper<>();
    wrapper.eq("kohin_warehouse_log_id", kohinWarehouseLogDTO.getKohinWarehouseLogId());
    wrapper.eq("kohin_warehouse_product_id", kohinWarehouseLogDTO.getKohinWarehouseProductId());
    wrapper.set("flag", SysFlagEnum.USER_DISABLED);
    kohinWarehouseLogService.update(wrapper);
    return HttpResponseUtil.ok();
}
@PostMapping("pageWarehouseLog")
    public RestfulDTO<Object> pageWarehouseLog(@RequestBody KohinWarehouseLogDTO kohinWarehouseLogDTO){
    return HttpResponseUtil.data(kohinWarehouseLogService.selectWarehouseLogPOPage(new Page<>(kohinWarehouseLogDTO.getCurrentPage(), kohinWarehouseLogDTO.getPageSize()), kohinWarehouseLogDTO.getKohinWarehouseLogId()));
}
}
