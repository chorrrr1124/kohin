package com.ephdgs.kohin.sale.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ephdgs.kohin.sale.dao.KohinCustomerDAO;
import com.ephdgs.kohin.sale.pojo.po.KohinCustomerPO;
import com.ephdgs.kohin.sale.service.KohinCustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class KohinCustomerServiceImpl extends ServiceImpl<KohinCustomerDAO, KohinCustomerPO> implements KohinCustomerService {
}
