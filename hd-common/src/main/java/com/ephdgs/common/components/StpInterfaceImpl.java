package com.ephdgs.common.components;

import cn.dev33.satoken.stp.StpInterface;
import com.ephdgs.common.dao.UserRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description:
 * @Date: 2024/2/23
 * @Author: Hill
 */
@Component
public class StpInterfaceImpl implements StpInterface {

    private UserRoleDao userRoleDao;

    @Autowired
    public void setUserRoleDao(UserRoleDao userRoleDao) {
        this.userRoleDao = userRoleDao;
    }

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        return null;
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        return userRoleDao.selectRoleByUserId(loginId);
    }
}
