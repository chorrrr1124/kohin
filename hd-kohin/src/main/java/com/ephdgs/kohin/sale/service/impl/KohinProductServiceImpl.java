package com.ephdgs.kohin.sale.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ephdgs.kohin.sale.dao.KohinProductDAO;
import com.ephdgs.kohin.sale.pojo.po.KohinProductPO;
import com.ephdgs.kohin.sale.service.KohinProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class KohinProductServiceImpl extends ServiceImpl<KohinProductDAO, KohinProductPO> implements KohinProductService {

}
