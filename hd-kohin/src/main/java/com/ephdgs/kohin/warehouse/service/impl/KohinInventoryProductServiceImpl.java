package com.ephdgs.kohin.warehouse.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ephdgs.kohin.warehouse.dao.KohinInventoryProductDAO;
import com.ephdgs.kohin.warehouse.pojo.dto.KohinInventoryProductDTO;
import com.ephdgs.kohin.warehouse.pojo.po.KohinInventoryProductPO;
import com.ephdgs.kohin.warehouse.pojo.vo.KohinInventoryProductVO;
import com.ephdgs.kohin.warehouse.service.KohinInventoryProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class KohinInventoryProductServiceImpl extends ServiceImpl<KohinInventoryProductDAO, KohinInventoryProductPO> implements KohinInventoryProductService {
    private KohinInventoryProductDAO kohinInventoryProductDAO;

    @Autowired
    public void setKohinInventoryProductDAO(KohinInventoryProductDAO kohinInventoryProductDAO) {
        this.kohinInventoryProductDAO = kohinInventoryProductDAO;
    }

    @Override
    public IPage<KohinInventoryProductVO> pageKohinProductByKohinInventoryProductId(Page<KohinInventoryProductDTO> page, Integer kohinInventoryProductId) {
        return kohinInventoryProductDAO.selectInventoryProductPOPage(page, kohinInventoryProductId);
    }
}

