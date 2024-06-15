package com.ephdgs.kohin.warehouse.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ephdgs.kohin.warehouse.pojo.po.KohinIoProductPO;
import com.ephdgs.kohin.warehouse.pojo.vo.KohinIoProductVO;

public interface KohinIoProductService extends IService<KohinIoProductPO> {
    IPage<KohinIoProductVO> pageKohinProductByKohinIoProductId(Page<KohinIoProductPO> page, Integer kohinIoProductId);

}
