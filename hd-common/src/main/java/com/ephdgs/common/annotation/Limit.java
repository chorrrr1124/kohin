package com.ephdgs.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description:
 * @Date: 2024/2/29
 * @Author: Hill
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Limit {

    //资源名称
    String name() default "";

    // 限制每秒访问次数，默认最大即不限制
    double perSecond() default Double.MAX_VALUE;

}