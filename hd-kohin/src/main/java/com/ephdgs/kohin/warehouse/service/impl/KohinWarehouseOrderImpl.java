package com.ephdgs.kohin.warehouse.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ephdgs.kohin.warehouse.dao.KohinIoProductDAO;
import com.ephdgs.kohin.warehouse.dao.KohinWarehouseLogDAO;
import com.ephdgs.kohin.warehouse.dao.KohinWarehouseOrderDAO;
import com.ephdgs.kohin.warehouse.pojo.dto.KohinWarehouseOrderDTO;
import com.ephdgs.kohin.warehouse.pojo.po.KohinIoProductPO;
import com.ephdgs.kohin.warehouse.pojo.po.KohinWarehouseLogPO;
import com.ephdgs.kohin.warehouse.pojo.po.KohinWarehouseOrderPO;
import com.ephdgs.kohin.warehouse.pojo.vo.KohinWarehouseOrderVO;
import com.ephdgs.kohin.warehouse.service.KohinWarehouseOrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KohinWarehouseOrderImpl extends ServiceImpl<KohinWarehouseOrderDAO, KohinWarehouseOrderPO> implements KohinWarehouseOrderService {
    private KohinWarehouseLogDAO kohinWarehouseLogDAO;
    private KohinIoProductDAO kohinIoProductDAO;
    private KohinWarehouseOrderDAO kohinWarehouseOrderDAO;

    @Autowired
    public void setKohinWarehouseLogDAO(KohinWarehouseLogDAO kohinWarehouseLogDAO) {
        this.kohinWarehouseLogDAO = kohinWarehouseLogDAO;
    }

    @Autowired
    public void setKohinIoProductDAO(KohinIoProductDAO kohinIoProductDAO) {
        this.kohinIoProductDAO = kohinIoProductDAO;
    }

    @Autowired
    public void setKohinWarehouseOrderDAO(KohinWarehouseOrderDAO kohinWarehouseOrderDAO) {
        this.kohinWarehouseOrderDAO = kohinWarehouseOrderDAO;
    }

    @Override
    public Boolean newOrder(KohinWarehouseOrderDTO kohinWarehouseOrderDTO) {
        KohinWarehouseOrderPO kohinWarehouseOrderPO = new KohinWarehouseOrderPO();
        BeanUtils.copyProperties(kohinWarehouseOrderDTO, kohinWarehouseOrderPO);
        kohinWarehouseOrderDAO.insert(kohinWarehouseOrderPO);
        kohinWarehouseOrderDTO.getProductDTOList().forEach(item -> {
            KohinIoProductPO kohinIoProductPO = new KohinIoProductPO();
            BeanUtils.copyProperties(item, kohinIoProductPO);
            kohinIoProductPO.setKohinWarehouseOrderId(kohinWarehouseOrderPO.getKohinWarehouseOrderId());
            if (item.getNum()>9999){
                item.setNum(9999);
            }
            kohinIoProductDAO.insert(kohinIoProductPO);
            KohinWarehouseLogPO kohinWarehouseLogPO =new KohinWarehouseLogPO();
            BeanUtils.copyProperties(item,kohinWarehouseLogPO);
            kohinWarehouseLogPO.setKohinWarehouseProductId(1);
            kohinWarehouseLogDAO.insert(kohinWarehouseLogPO);
        });
        return true;
    }

    @Override
    public IPage<KohinWarehouseOrderVO> selectWarehouseOrderPOPage(Page<KohinWarehouseOrderPO> page, Integer kohinWarehouseId) {
        return kohinWarehouseOrderDAO.selectWarehouseOrderPOPage(page,kohinWarehouseId);
    }
}
