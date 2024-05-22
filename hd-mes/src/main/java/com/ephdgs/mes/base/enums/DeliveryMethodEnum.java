package com.ephdgs.mes.base.enums;

import com.alibaba.fastjson.annotation.JSONType;
import com.baomidou.mybatisplus.annotation.IEnum;

/**
 * @Description:
 * @Date: 2024/5/12
 * @Author: Hill
 */
@JSONType(serializeEnumAsJavaBean = true)
public enum DeliveryMethodEnum implements IEnum<Integer> {
    /**
     * 当面交易
     */
    F2F(1, "当面交易"),
    /**
     * 海运
     */
    ST(2, "海运"),
    /**
     * 空运
     */
    AT(3, "空运"),
    /**
     * 铁路
     */
    RT(4, "铁路"),
    /**
     * 当面物流
     */
    GL(5, "当面物流"),
    /**
     * 普通快递
     */
    OE(6, "普通快递");

    DeliveryMethodEnum(Integer code, String key) {
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
