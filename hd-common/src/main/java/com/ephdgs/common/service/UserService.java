package com.ephdgs.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ephdgs.common.pojo.po.UserPO;
import com.ephdgs.common.pojo.vo.UserInfoVO;

import java.util.List;

/**
 * @Description:
 * @Date: 2024/5/8 11:39
 * @Author: Hill
 */
public interface UserService extends IService<UserPO> {

    UserInfoVO getUserInfo(String username);

}
