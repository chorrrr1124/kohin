package com.ephdgs.kohin.sale.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ephdgs.kohin.sale.dao.KohinProductCustomerDAO;
import com.ephdgs.kohin.sale.pojo.po.KohinProductCustomerPO;
import com.ephdgs.kohin.sale.service.KohinProductCustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class KohinProductCustomerServiceImpl extends ServiceImpl<KohinProductCustomerDAO, KohinProductCustomerPO> implements KohinProductCustomerService {
}
