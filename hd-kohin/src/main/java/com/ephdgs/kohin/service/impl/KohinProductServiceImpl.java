package com.ephdgs.kohin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ephdgs.kohin.dao.KohinProductDAO;
import com.ephdgs.kohin.pojo.po.KohinProductPO;
import com.ephdgs.kohin.service.KohinProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class KohinProductServiceImpl extends ServiceImpl<KohinProductDAO, KohinProductPO> implements KohinProductService {

}
