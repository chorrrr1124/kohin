package com.ephdgs.common.controller;

import com.ephdgs.common.annotation.ApiVersion;
import com.ephdgs.common.annotation.Limit;
import com.ephdgs.common.enums.HttpStatusCodeEnum;
import com.ephdgs.common.pojo.dto.RestfulDTO;
import com.ephdgs.common.pojo.dto.UserDTO;
import com.ephdgs.common.pojo.dto.UserOtpDTO;
import com.ephdgs.common.service.impl.LoginServiceImpl;
import com.ephdgs.common.service.impl.UserServiceImpl;
import com.ephdgs.common.utils.HttpResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @Description:
 * @Date: 2024/5/9
 * @Author: Hill
 */
@RestController
@CrossOrigin("*")
@ApiVersion
@RequestMapping("api/{version}/login")
public class LoginController {

    private LoginServiceImpl loginService;

    private UserServiceImpl userService;

    @Autowired
    public void setLoginService(LoginServiceImpl loginService) {
        this.loginService = loginService;
    }

    @Autowired
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    /**
     * 获取盐值
     *
     * @param userDTO
     * @return
     */
    @PostMapping("getSalt")
    @Limit(perSecond = 2)
    public RestfulDTO<Object> getSalt(@RequestBody UserDTO userDTO) {
        return HttpResponseUtil.data(loginService.getSalt(userDTO.getUsername()));
    }

    /**
     * 账号密码登录
     *
     * @param userDTO
     * @return
     */
    @PostMapping("doLogin")
    @Limit(perSecond = 2)
    public RestfulDTO<Object> login(@RequestBody UserDTO userDTO) {
        return loginService.doLogin(userDTO.getUsername(), userDTO.getPassword()) ?
                HttpResponseUtil.ok() : HttpResponseUtil.error(HttpStatusCodeEnum.LOGIN_ERROR);
    }

    /**
     * 获取二次校验二维码
     *
     * @param userDTO
     * @return
     * @throws IOException
     */
    @PostMapping("getAuthCode")
    public RestfulDTO<Object> getAuthCode(@RequestBody UserDTO userDTO) throws IOException {
        String qrcode = loginService.getOtpCode(userDTO.getUsername());
        return HttpResponseUtil.data(qrcode);
    }

    /**
     * 核验二次验证码
     *
     * @param userOtpDTO
     * @return
     */
    @PostMapping("checkAuthCode")
    public RestfulDTO<Object> checkAuthCode(@RequestBody UserOtpDTO userOtpDTO) {
        return loginService.authOtpCode(userOtpDTO.getUsername(), userOtpDTO.getCode()) ?
                HttpResponseUtil.data(userService.getUserInfo(userOtpDTO.getUsername())) : HttpResponseUtil.error(HttpStatusCodeEnum.OTP_CODE_ERROR);
    }

}
