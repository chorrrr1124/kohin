package com.ephdgs.common.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description:
 * @Date: 2024/2/28
 * @Author: Hill
 */
@EqualsAndHashCode(callSuper = true)
@TableName("sys_user")
@Data
public class UserPO extends BasePO {
    @TableId(type = IdType.AUTO)
    private Integer userId;
    private String code;
    private String username;
    @TableField(select = false)
    private String password;
    private String salt;
    @TableField(value = "otpauth_secret")
    private String otpAuthSecret;
    private String nickname;
    private String avatar;
    private String mobile;
    private String mail;
    private Integer loginIn;
}
