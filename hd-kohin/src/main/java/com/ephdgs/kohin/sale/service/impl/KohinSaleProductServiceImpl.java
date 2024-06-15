package com.ephdgs.kohin.sale.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ephdgs.kohin.sale.dao.KohinSaleProductDAO;
import com.ephdgs.kohin.sale.pojo.po.KohinSaleProductPO;
import com.ephdgs.kohin.sale.service.KohinSaleProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class KohinSaleProductServiceImpl extends ServiceImpl<KohinSaleProductDAO, KohinSaleProductPO> implements KohinSaleProductService {
}
