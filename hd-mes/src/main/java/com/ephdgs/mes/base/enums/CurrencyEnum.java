package com.ephdgs.mes.base.enums;

import com.alibaba.fastjson.annotation.JSONType;
import com.baomidou.mybatisplus.annotation.IEnum;

/**
 * @Description:
 * @Date: 2024/5/12
 * @Author: Hill
 */
@JSONType(serializeEnumAsJavaBean = true)
public enum CurrencyEnum implements IEnum<Integer> {
    RMB(1, "人民币");

    CurrencyEnum(Integer code, String key) {
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
