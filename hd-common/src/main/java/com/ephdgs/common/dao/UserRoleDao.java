package com.ephdgs.common.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ephdgs.common.pojo.po.UserRolePO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description:
 * @Date: 2024/3/1 9:23
 * @Author: Hill
 */
@Mapper
public interface UserRoleDao extends BaseMapper<UserRolePO> {

    @Select("SELECT a.name FROM sys_role a LEFT JOIN sys_user_role b ON b.role_id = a.role_id WHERE b.user_id = #{userId}")
    List<String> selectRoleByUserId(Object userId);
}
