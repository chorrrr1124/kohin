package com.ephdgs.kohin.warehouse.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ephdgs.kohin.warehouse.dao.KohinWarehouseProductDAO;
import com.ephdgs.kohin.warehouse.pojo.po.KohinWarehouseProductPO;
import com.ephdgs.kohin.warehouse.pojo.vo.KohinWarehouseProductVO;
import com.ephdgs.kohin.warehouse.service.KohinWarehouseProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KohinWarehouseProductImpl extends ServiceImpl<KohinWarehouseProductDAO, KohinWarehouseProductPO> implements KohinWarehouseProductService {
    private KohinWarehouseProductDAO kohinWarehouseProductDAO;
@Autowired
    public void setKohinWarehouseProductDAO(KohinWarehouseProductDAO kohinWarehouseProductDAO) {
        this.kohinWarehouseProductDAO = kohinWarehouseProductDAO;
    }

    @Override
    public IPage<KohinWarehouseProductVO> pageKohinProductByKohinWarehouseId(Page<KohinWarehouseProductPO> page, Integer kohinWarehouseId) {
        return kohinWarehouseProductDAO.selectWarehouseProductPOPage(page,kohinWarehouseId);
    }
}
