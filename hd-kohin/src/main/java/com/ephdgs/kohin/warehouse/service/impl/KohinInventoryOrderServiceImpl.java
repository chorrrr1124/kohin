package com.ephdgs.kohin.warehouse.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ephdgs.common.utils.LoggerUtil;
import com.ephdgs.kohin.warehouse.dao.KohinInventoryOrderDAO;
import com.ephdgs.kohin.warehouse.pojo.dto.KohinInventoryOrederDTO;
import com.ephdgs.kohin.warehouse.pojo.po.KohinInventoryOrderPO;
import com.ephdgs.kohin.warehouse.service.KohinInventoryOrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KohinInventoryOrderServiceImpl extends ServiceImpl<KohinInventoryOrderDAO, KohinInventoryOrderPO> implements KohinInventoryOrderService {

private KohinInventoryOrderDAO kohinInventoryOrderDAO;
@Autowired
    public void setKohinInventoryOrderDAO(KohinInventoryOrderDAO kohinInventoryOrderDAO) {
        this.kohinInventoryOrderDAO = kohinInventoryOrderDAO;
    }

    @Override
    public Boolean newOrder(KohinInventoryOrederDTO kohinInventoryOrederDTO) {
        KohinInventoryOrderPO kohinInventoryOrderPO = new KohinInventoryOrderPO();
        BeanUtils.copyProperties(kohinInventoryOrederDTO, kohinInventoryOrderPO);
        LoggerUtil.info(String.valueOf(kohinInventoryOrederDTO));
        kohinInventoryOrderDAO.insert(kohinInventoryOrderPO);
        return true;
    }
}
