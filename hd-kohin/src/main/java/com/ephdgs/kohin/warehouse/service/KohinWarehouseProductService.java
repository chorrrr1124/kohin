package com.ephdgs.kohin.warehouse.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ephdgs.kohin.warehouse.pojo.po.KohinWarehouseProductPO;
import com.ephdgs.kohin.warehouse.pojo.vo.KohinWarehouseProductVO;

public interface KohinWarehouseProductService extends IService<KohinWarehouseProductPO> {
    IPage<KohinWarehouseProductVO> pageKohinProductByKohinWarehouseId(Page<KohinWarehouseProductPO> page, Integer kohinWarehouseId);
}
