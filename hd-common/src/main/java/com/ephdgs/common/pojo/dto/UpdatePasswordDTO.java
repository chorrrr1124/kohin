package com.ephdgs.common.pojo.dto;

import lombok.Data;

/**
 * @Description:
 * @Date: 2024/5/11
 * @Author: Hill
 */
@Data
public class UpdatePasswordDTO {
    private String username;
    private String originPassword;
    private String newPassword;
}
