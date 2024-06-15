package com.ephdgs.kohin.sale.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ephdgs.common.utils.LoggerUtil;
import com.ephdgs.kohin.sale.dao.KohinSaleDAO;
import com.ephdgs.kohin.sale.dao.KohinSaleProductDAO;
import com.ephdgs.kohin.sale.pojo.dto.KohinSaleDTO;
import com.ephdgs.kohin.sale.pojo.po.KohinSalePO;
import com.ephdgs.kohin.sale.pojo.po.KohinSaleProductPO;
import com.ephdgs.kohin.sale.pojo.vo.KohinSaleProductVO;
import com.ephdgs.kohin.sale.pojo.vo.KohinSaleVO;
import com.ephdgs.kohin.sale.service.KohinSaleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class KohinSaleServiceImpl extends ServiceImpl<KohinSaleDAO, KohinSalePO> implements KohinSaleService {
    private KohinSaleDAO kohinSaleDAO;

    private KohinSaleProductDAO kohinSaleProductDAO;

    @Autowired
    public void setKohinSaleDAO(KohinSaleDAO kohinSaleDAO) {
        this.kohinSaleDAO = kohinSaleDAO;
    }

    @Autowired
    public void setKohinSaleProductDAO(KohinSaleProductDAO kohinSaleProductDAO) {
        this.kohinSaleProductDAO = kohinSaleProductDAO;
    }

    @Override
    public IPage<KohinSaleVO> getSaleOrderByUserId(Page<KohinSalePO> page, Integer userId) {
        return kohinSaleDAO.selectSaleOrderPage(page, userId);
    }

    @Override
    public IPage<KohinSaleProductVO> getSaleOrderProductBySaleOrderId(Page<KohinSaleProductPO> page, Integer saleOrderId) {
        return kohinSaleDAO.selectSaleOrderProductPage(page, saleOrderId);
    }

    @Override
    public void createSaleOrder(KohinSaleDTO saleDTO) {
        KohinSalePO kohinSalePO = new KohinSalePO();
        BeanUtils.copyProperties(saleDTO, kohinSalePO);
        kohinSaleDAO.insert(kohinSalePO);
        saleDTO.getProductDTOList().forEach(item -> {
                    KohinSaleProductPO kohinSaleProductPO = new KohinSaleProductPO();
                    BeanUtils.copyProperties(item, kohinSaleProductPO);
                    LoggerUtil.info(item.toString());
                    kohinSaleProductPO.setKohinSaleId(kohinSalePO.getKohinSaleId());
                    kohinSaleProductDAO.insert(kohinSaleProductPO);
                }
        );
    }
}
