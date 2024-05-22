package com.ephdgs.mes.sale.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ephdgs.mes.sale.dao.SaleOrderDao;
import com.ephdgs.mes.sale.pojo.po.SaleOrderPO;
import com.ephdgs.mes.sale.pojo.vo.SaleOrderDataVO;
import com.ephdgs.mes.sale.pojo.vo.SaleOrderVO;
import com.ephdgs.mes.sale.service.SaleOrderService;
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
public class SaleOrderServiceImpl extends ServiceImpl<SaleOrderDao, SaleOrderPO> implements SaleOrderService {

    private SaleOrderDao saleOrderDao;

    @Autowired
    public void setSaleOrderDao(SaleOrderDao saleOrderDao) {
        this.saleOrderDao = saleOrderDao;
    }

    @Override
    public IPage<SaleOrderVO> getSaleOrderPage(Page<SaleOrderPO> page, Integer index) {
        return saleOrderDao.queryPage(page, index);
    }

}
