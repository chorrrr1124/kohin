package com.ephdgs.kohin.warehouse.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ephdgs.kohin.warehouse.pojo.po.KohinInventoryProductPO;
import com.ephdgs.kohin.warehouse.pojo.vo.KohinInventoryProductVO;

public interface KohinInventoryProductService extends IService<KohinInventoryProductPO> {

    IPage<KohinInventoryProductVO> pageKohinProductByKohinInventoryProductId(Page<KohinInventoryProductPO> page, Integer kohinInventoryProductId);
}
