package com.ephdgs.common.pojo.dto;

import lombok.Data;

/**
 * @Description:
 * @Date: 2024/5/9
 * @Author: Hill
 */
@Data
public class LoginDTO {
    private String username;
    private String password;
    private String salt;
}
