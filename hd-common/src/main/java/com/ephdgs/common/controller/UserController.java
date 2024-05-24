package com.ephdgs.common.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.ephdgs.common.annotation.ApiVersion;
import com.ephdgs.common.enums.SysFlagEnum;
import com.ephdgs.common.pojo.dto.RestfulDTO;
import com.ephdgs.common.pojo.dto.UpdatePasswordDTO;
import com.ephdgs.common.pojo.dto.UserDTO;
import com.ephdgs.common.pojo.dto.UserInfoDTO;
import com.ephdgs.common.pojo.po.UserPO;
import com.ephdgs.common.service.impl.UserServiceImpl;
import com.ephdgs.common.utils.HttpResponseUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Date: 2024/5/8
 * @Author: Hill
 */
@RestController
@RequestMapping("api/{version}/user")
@ApiVersion
@CrossOrigin(origins = "*")
public class UserController extends BaseController {

    private UserServiceImpl userService;

    @Autowired
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }


    @PostMapping("getUserInfo")
    @SaCheckLogin
    public RestfulDTO<Object> getUserInfo(@RequestBody UserInfoDTO userInfoDTO) {
        return HttpResponseUtil.data(userService.getUserInfo(userInfoDTO.getUsername()));
    }

    @PostMapping("addUser")
    public RestfulDTO<Object> addUser(@RequestBody UserDTO userDTO) {
        UserPO userPO = new UserPO();
        BeanUtils.copyProperties(userDTO, userPO);
        userService.save(userPO);
        return HttpResponseUtil.ok();
    }

    @PostMapping("safeDeleteUser")
    public RestfulDTO<Object> safeDeleteUser(@RequestBody UserDTO userDTO) {
        UserPO userPO = new UserPO();
        BeanUtils.copyProperties(userDTO, userPO);
        UpdateWrapper<UserPO> wrapper = new UpdateWrapper<>();
        wrapper.eq("code", userDTO.getCode());
        wrapper.set("flag", SysFlagEnum.USER_DISABLED);
        userService.update(wrapper);
        return HttpResponseUtil.ok();
    }

    @PostMapping("updateUser")
    public RestfulDTO<Object> updateUser(@RequestBody UserDTO userDTO) {
        UserPO userPO = new UserPO();
        BeanUtils.copyProperties(userDTO, userPO);
        UpdateWrapper<UserPO> wrapper = new UpdateWrapper<>();
        wrapper.eq("code", userDTO.getCode());
        userService.update(userPO, wrapper);
        return HttpResponseUtil.ok();
    }

    @PostMapping("updatePassword")
    public RestfulDTO<Object> updatePassword(@RequestBody UpdatePasswordDTO updatePasswordDTO) {
        UpdateWrapper<UserPO> wrapper = new UpdateWrapper<>();
        wrapper.eq("username", updatePasswordDTO.getUsername());
        wrapper.eq("password", updatePasswordDTO.getOriginPassword());
        wrapper.set("password", updatePasswordDTO.getNewPassword());
        userService.update(wrapper);
        return HttpResponseUtil.ok();
    }


}
