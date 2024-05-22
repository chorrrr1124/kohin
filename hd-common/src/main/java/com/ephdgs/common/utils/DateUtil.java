package com.ephdgs.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @Date: 2024/3/18
 * @Author: Hill
 */
public class DateUtil {
    // 定义时间格式化对象和定义格式化样式
    static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    // 格式化时间对象
    public static String getNowDateTime() {
        return dateTimeFormat.format(new Date());
    }

    public static String getNowDate() {
        return dateFormat.format(new Date());
    }

    public static String getFormatDateNow(SimpleDateFormat dateFormat) {
        return dateFormat.format(new Date());
    }

    public static String getFormatDateCustom(SimpleDateFormat dateFormat, Date date) {
        return dateFormat.format(date);
    }

}
