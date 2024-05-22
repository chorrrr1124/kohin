package com.ephdgs.mes.sale.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ephdgs.mes.sale.pojo.po.SaleOrderPO;
import com.ephdgs.mes.sale.pojo.vo.SaleOrderDataVO;
import com.ephdgs.mes.sale.pojo.vo.SaleOrderVO;

import java.util.List;

/**
 * @Description:
 * @Date: 2024/5/12 12:40
 * @Author: Hill
 */
public interface SaleOrderService extends IService<SaleOrderPO> {

    IPage<SaleOrderVO> getSaleOrderPage(Page<SaleOrderPO> page, Integer index);

}
