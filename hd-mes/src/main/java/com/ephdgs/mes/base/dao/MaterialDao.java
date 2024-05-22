package com.ephdgs.mes.base.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ephdgs.mes.base.pojo.po.MaterialPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description:
 * @Date: 2024/5/12 21:51
 * @Author: Hill
 */
@Mapper
public interface MaterialDao extends BaseMapper<MaterialPO> {
}
