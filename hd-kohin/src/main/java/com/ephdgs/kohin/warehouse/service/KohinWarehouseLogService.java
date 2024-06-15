package com.ephdgs.kohin.warehouse.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ephdgs.kohin.warehouse.pojo.po.KohinWarehouseLogPO;
import com.ephdgs.kohin.warehouse.pojo.vo.KohinWarehouseLogVO;


public interface KohinWarehouseLogService extends IService<KohinWarehouseLogPO> {
    IPage<KohinWarehouseLogVO> selectWarehouseLogPOPage(Page<KohinWarehouseLogPO> page, Integer kohinWarehouseLogId);
}
