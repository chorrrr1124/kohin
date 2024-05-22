package com.ephdgs.kohin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ephdgs.kohin.pojo.po.KohinCustomerPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface KohinCustomerDAO extends BaseMapper<KohinCustomerPO> {
}
