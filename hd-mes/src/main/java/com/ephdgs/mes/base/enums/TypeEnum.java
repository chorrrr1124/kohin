package com.ephdgs.mes.base.enums;

import com.baomidou.mybatisplus.annotation.IEnum;

/**
 * @Description:
 * @Date: 2024/5/12
 * @Author: Hill
 */
public enum TypeEnum implements IEnum<Integer> {
    RES(1, "电阻"),
    CAP(2, "电容"),
    MCU(3, "MCU"),

    ;

    TypeEnum(Integer code, String key){
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
