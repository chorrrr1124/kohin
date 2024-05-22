package com.ephdgs.mes.base.enums;

import com.baomidou.mybatisplus.annotation.IEnum;

/**
 * @Description:
 * @Date: 2024/5/12
 * @Author: Hill
 */
public enum UnitEnum implements IEnum<Integer> {
    PIECE(1, "个");

    UnitEnum(Integer code, String key){
        this.code = code;
        this.key = key;
    }
    private final Integer code;
    private final String key;

    @Override
    public Integer getValue() {
        return this.code;
    }
}
