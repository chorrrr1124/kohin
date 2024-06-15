package com.ephdgs.kohin.warehouse.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ephdgs.kohin.warehouse.dao.KohinIoProductDAO;
import com.ephdgs.kohin.warehouse.pojo.po.KohinIoProductPO;
import com.ephdgs.kohin.warehouse.pojo.vo.KohinIoProductVO;
import com.ephdgs.kohin.warehouse.service.KohinIoProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KohinIoProductServiceImpl extends ServiceImpl<KohinIoProductDAO, KohinIoProductPO> implements KohinIoProductService {
    private KohinIoProductDAO kohinIoProductDAO;

   @Autowired
    public void setKohinIoProductDAO(KohinIoProductDAO kohinIoProductDAO) {
        this.kohinIoProductDAO = kohinIoProductDAO;
    }

    @Override
    public IPage<KohinIoProductVO> pageKohinProductByKohinIoProductId(Page<KohinIoProductPO> page, Integer kohinIoProductId) {
        return kohinIoProductDAO.selectIoProductPOPage(page,kohinIoProductId);
    }
}
