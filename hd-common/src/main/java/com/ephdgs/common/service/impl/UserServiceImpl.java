package com.ephdgs.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ephdgs.common.dao.UserDao;
import com.ephdgs.common.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ephdgs.common.pojo.po.UserPO;
import com.ephdgs.common.pojo.vo.UserInfoVO;

import java.util.List;

/**
 * @Description: 用户服务
 * @Date: 2024/5/8
 * @Author: Hill
 */
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserDao, UserPO> implements UserService {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserInfoVO getUserInfo(String username) {
        return userDao.SelectUserInfoByUsername(username);
    }
}
