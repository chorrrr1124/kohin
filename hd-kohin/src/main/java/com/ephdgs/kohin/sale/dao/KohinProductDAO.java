package com.ephdgs.kohin.sale.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ephdgs.kohin.sale.pojo.po.KohinProductPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface KohinProductDAO extends BaseMapper<KohinProductPO> {
}
