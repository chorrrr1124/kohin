package com.ephdgs.kohin.warehouse.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ephdgs.kohin.warehouse.dao.KohinWarehouseDAO;
import com.ephdgs.kohin.warehouse.pojo.po.KohinWarehousePO;
import com.ephdgs.kohin.warehouse.service.KohinWarehouseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class KohinWarehouseServiceImpl extends ServiceImpl<KohinWarehouseDAO, KohinWarehousePO> implements KohinWarehouseService {
}
