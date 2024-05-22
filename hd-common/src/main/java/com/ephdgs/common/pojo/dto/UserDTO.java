package com.ephdgs.common.pojo.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * @Description:
 * @Date: 2024/5/8
 * @Author: Hill
 */
@Data
public class UserDTO {
    private String code;
    private String username;
    private String password;
    private String salt;
    private String otpAuthSecret;
    private String nickname;
    private String avatar;
    private String mobile;
    private String mail;
    private Integer loginIn;
}
