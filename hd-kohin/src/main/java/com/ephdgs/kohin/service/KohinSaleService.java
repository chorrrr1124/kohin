package com.ephdgs.kohin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ephdgs.kohin.pojo.dto.KohinSaleDTO;
import com.ephdgs.kohin.pojo.po.KohinSalePO;
import com.ephdgs.kohin.pojo.po.KohinSaleProductPO;
import com.ephdgs.kohin.pojo.vo.KohinSaleProductVO;
import com.ephdgs.kohin.pojo.vo.KohinSaleVO;

public interface KohinSaleService extends IService<KohinSalePO> {
    IPage<KohinSaleVO> getSaleOrderByUserId(Page<KohinSalePO> page, Integer userId);
    IPage<KohinSaleProductVO> getSaleOrderProductBySaleOrderId(Page<KohinSaleProductPO> page, Integer saleOrderId);
    void createSaleOrder(KohinSaleDTO saleDTO);
}
