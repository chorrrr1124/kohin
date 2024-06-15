package com.ephdgs.kohin.warehouse.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ephdgs.kohin.warehouse.dao.KohinWarehouseLogDAO;
import com.ephdgs.kohin.warehouse.pojo.po.KohinWarehouseLogPO;
import com.ephdgs.kohin.warehouse.pojo.vo.KohinWarehouseLogVO;
import com.ephdgs.kohin.warehouse.service.KohinWarehouseLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class KohinWarehouseLogServiceImpl extends ServiceImpl<KohinWarehouseLogDAO, KohinWarehouseLogPO>  implements KohinWarehouseLogService {
    private KohinWarehouseLogDAO kohinWarehouseLogDAO;
    @Autowired
    public void setKohinWarehouseLogDAO(KohinWarehouseLogDAO kohinWarehouseLogDAO) {
        this.kohinWarehouseLogDAO = kohinWarehouseLogDAO;
    }

    @Override
    public IPage<KohinWarehouseLogVO> selectWarehouseLogPOPage(Page<KohinWarehouseLogPO> page, Integer kohinWarehouseLogId) {
        return kohinWarehouseLogDAO.selectWarehouseLogPOPage(page,kohinWarehouseLogId);
    }

}
