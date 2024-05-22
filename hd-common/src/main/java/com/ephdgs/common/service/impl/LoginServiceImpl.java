package com.ephdgs.common.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.ephdgs.common.dao.UserDao;
import com.ephdgs.common.enums.UserEnum;
import com.ephdgs.common.pojo.po.UserPO;
import com.ephdgs.common.service.LoginService;
import com.ephdgs.common.utils.GoogleOtpUtil;
import com.ephdgs.common.utils.QRCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * @Description:
 * @Date: 2024/5/9
 * @Author: Hill
 */
@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    private GoogleOtpUtil googleOtpUtil;

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setGoogleOtpUtil(GoogleOtpUtil googleOtpUtil) {
        this.googleOtpUtil = googleOtpUtil;
    }


    @Override
    public String getSalt(String username) {
        QueryWrapper<UserPO> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        wrapper.eq("flag", UserEnum.USER_ENABLE);
        UserPO userPO = userDao.selectOne(wrapper);
        return userPO == null ? null : userPO.getSalt();
    }

    @Override
    public Boolean doLogin(String username, String password) {
        QueryWrapper<UserPO> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        wrapper.eq("flag", UserEnum.USER_ENABLE);
        if (!userDao.exists(wrapper)) {
            return false;
        } else {
            wrapper.eq("password", password);
            if (!userDao.exists(wrapper)) {
                return false;
            } else {
                return true;
            }
        }
    }

    @Override
    public String getOtpCode(String username) throws IOException {
        QueryWrapper<UserPO> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        wrapper.eq("flag", UserEnum.USER_ENABLE);
        UserPO userPO = userDao.selectOne(wrapper);
        String key;
        String secret;
        if (userPO.getOtpAuthSecret() == null || userPO.getOtpAuthSecret().isEmpty()) {
            //创建二次验证码并绑定对应用户
            key = googleOtpUtil.generateSecretKey();
            UpdateWrapper<UserPO> updateWrapper = new UpdateWrapper<>();
            if (key != null) {
                updateWrapper.set("otpauth_secret", key);
                updateWrapper.eq("username", username);
                int updateRes = userDao.update(updateWrapper);
                if (updateRes == 1) {
                    secret = googleOtpUtil.getQRBarcode(username, key);
                    return QRCodeUtil.createQRCode(secret, 200, 200);
                }
            }
        } else {
            return null;
//            secret = googleOtpUtil.getQRBarcode(username, userPO.getOtpAuthSecret());
//            return QRCodeUtil.createQRCode(secret, 200, 200);
        }
        return null;
    }

    @Override
    public Boolean authOtpCode(String username, Integer code) {
        QueryWrapper<UserPO> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        wrapper.eq("flag", UserEnum.USER_ENABLE);
        UserPO userPO = userDao.selectOne(wrapper);
        if (userPO != null) {
            if (googleOtpUtil.checkCode(userPO.getOtpAuthSecret(), code)) {
                StpUtil.login(userDao.selectOne(wrapper).getUserId());
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
