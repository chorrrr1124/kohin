package com.ephdgs.common.service;

import java.io.IOException;

/**
 * @Description:
 * @Date: 2024/5/9 11:54
 * @Author: Hill
 */
public interface LoginService {

    String getSalt(String username);
    Boolean doLogin(String username, String password);
    String getOtpCode(String username) throws IOException;
    Boolean authOtpCode(String username, Integer code);
}
