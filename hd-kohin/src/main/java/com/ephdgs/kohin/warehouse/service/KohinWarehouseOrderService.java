package com.ephdgs.kohin.warehouse.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ephdgs.kohin.warehouse.pojo.dto.KohinWarehouseOrderDTO;
import com.ephdgs.kohin.warehouse.pojo.po.KohinWarehouseOrderPO;
import com.ephdgs.kohin.warehouse.pojo.vo.KohinWarehouseOrderVO;

public interface KohinWarehouseOrderService extends IService<KohinWarehouseOrderPO> {
    Boolean newOrder(KohinWarehouseOrderDTO kohinWarehouseOrderDTO);
    IPage<KohinWarehouseOrderVO> selectWarehouseOrderPOPage(Page<KohinWarehouseOrderPO> page, Integer kohinWarehouseId);
}
