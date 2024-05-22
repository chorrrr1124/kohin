package com.ephdgs.common.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.ephdgs.common.pojo.po.UserPO;
import com.ephdgs.common.pojo.vo.UserInfoVO;

import java.util.List;

/**
 * @Description:
 * @Date: 2024/5/8 11:39
 * @Author: Hill
 */
@Mapper
public interface UserDao extends BaseMapper<UserPO> {

    /**
     * @Description: 查询用户信息
     * @param userName 用户名
     * @return List<UserInfoVO>
     */
    @Select("SELECT u.`code`, u.nickname, u.username, u.mobile, u.login_in, r.`name` AS role_name, u.flag, u.remark, u.create_time FROM sys_user u LEFT JOIN sys_user_role ru ON ru.user_id = u.user_id LEFT JOIN sys_role r ON r.role_id = ru.role_id WHERE u.flag != -1 AND u.username = #{username}")
    UserInfoVO SelectUserInfoByUsername(String userName);


}
