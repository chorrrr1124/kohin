package com.ephdgs.mes.sale.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ephdgs.mes.sale.dao.SaleOrderDataDao;
import com.ephdgs.mes.sale.pojo.po.SaleOrderDataPO;
import com.ephdgs.mes.sale.pojo.vo.SaleOrderDataVO;
import com.ephdgs.mes.sale.service.SaleOrderDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description:
 * @Date: 2024/5/12
 * @Author: Hill
 */
@Service
@Transactional
public class SaleOrderDataServiceImpl extends ServiceImpl<SaleOrderDataDao, SaleOrderDataPO> implements SaleOrderDataService {

    private SaleOrderDataDao saleOrderDataDao;

    @Autowired
    public void setSaleOrderDataDao(SaleOrderDataDao saleOrderDataDao) {
        this.saleOrderDataDao = saleOrderDataDao;
    }

    @Override
    public List<SaleOrderDataVO> getSaleOrderDataList(Integer saleOrderId) {
        return saleOrderDataDao.listBySaleOrderId(saleOrderId);
    }
}
