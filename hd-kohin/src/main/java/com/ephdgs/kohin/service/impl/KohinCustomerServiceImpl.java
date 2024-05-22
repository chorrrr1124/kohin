package com.ephdgs.kohin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ephdgs.kohin.dao.KohinCustomerDAO;
import com.ephdgs.kohin.pojo.po.KohinCustomerPO;
import com.ephdgs.kohin.service.KohinCustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class KohinCustomerServiceImpl extends ServiceImpl<KohinCustomerDAO, KohinCustomerPO> implements KohinCustomerService {
}
