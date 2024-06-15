package com.ephdgs.kohin.sale.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ephdgs.kohin.sale.pojo.dto.KohinSaleDTO;
import com.ephdgs.kohin.sale.pojo.po.KohinSalePO;
import com.ephdgs.kohin.sale.pojo.po.KohinSaleProductPO;
import com.ephdgs.kohin.sale.pojo.vo.KohinSaleProductVO;
import com.ephdgs.kohin.sale.pojo.vo.KohinSaleVO;

public interface KohinSaleService extends IService<KohinSalePO> {
    IPage<KohinSaleVO> getSaleOrderByUserId(Page<KohinSalePO> page, Integer userId);
    IPage<KohinSaleProductVO> getSaleOrderProductBySaleOrderId(Page<KohinSaleProductPO> page, Integer saleOrderId);
    void createSaleOrder(KohinSaleDTO saleDTO);
}
