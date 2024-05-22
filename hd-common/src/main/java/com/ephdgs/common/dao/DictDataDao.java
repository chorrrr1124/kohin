package com.ephdgs.common.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ephdgs.common.pojo.po.DictDataPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description:
 * @Date: 2024/2/28 18:06
 * @Author: Hill
 */
@Mapper
public interface DictDataDao  extends BaseMapper<DictDataPO> {

    @Select("SELECT a.`name`, a.`val` FROM `sys_dict_data` a LEFT JOIN `sys_dict` b ON b.`dict_id` = a.`dict_id` WHERE b.`code` = #{code}")
    List<DictDataPO> selectDictDataListByCode(String code);

}
