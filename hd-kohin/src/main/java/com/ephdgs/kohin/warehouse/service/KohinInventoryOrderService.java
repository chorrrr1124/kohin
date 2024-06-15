package com.ephdgs.kohin.warehouse.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ephdgs.kohin.warehouse.pojo.dto.KohinInventoryOrederDTO;
import com.ephdgs.kohin.warehouse.pojo.po.KohinInventoryOrderPO;

public interface KohinInventoryOrderService extends IService<KohinInventoryOrderPO> {
    Boolean newOrder(KohinInventoryOrederDTO kohinInventoryOrederDTO);
}
