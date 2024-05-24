package com.ephdgs.common.enums;

import com.baomidou.mybatisplus.annotation.IEnum;

/**
 * @Description:
 * @Date: 2024/5/8
 * @Author: Hill
 */
public enum SysFlagEnum implements IEnum<Integer> {
    USER_ENABLE(1),
    USER_DISABLED(-1);

    SysFlagEnum(Integer code) {
        this.code = code;
    }

    private final Integer code;

    @Override
    public Integer getValue() {
        return this.code;
    }
}
