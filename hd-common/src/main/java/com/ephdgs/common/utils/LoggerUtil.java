package com.ephdgs.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description:
 * @Date: 2024/2/10
 * @Author: Hill
 */
public class LoggerUtil {

    public static String top = "";

    private static Logger logger = LoggerFactory.getLogger("MyLog4j");

    public static void debug(String message) {
        if (logger.isDebugEnabled()) {
            logger.debug(top + "-" + message);
        }
    }

    public static void debug(String message, Exception e) {
        if (logger.isDebugEnabled()) {
            getTop();
            logger.debug(top + "-" + message, e);
        }
    }

    public static void info(String message) {
        if (logger.isInfoEnabled()) {
            getTop();
            logger.info(top + "-" + message);
        }
    }

    public static void info(String message, Exception e) {
        if (logger.isInfoEnabled()) {
            getTop();
            logger.info(top + "-" + message, e);
        }
    }

    public static void warn(String message) {
        getTop();
        logger.warn(top + "-" + message);
    }

    public static void warn(String message, Exception e) {
        getTop();
        logger.warn(top + "-" + message, e);
    }

    public static void error(String message) {
        getTop();
        logger.error(top + "-" + message);
    }

    public static void error(String message, Exception e) {
        getTop();
        logger.error(top + "-" + message, e);
    }

    public static void getTop() {
        // 获取堆栈信息
        StackTraceElement[] callStack = Thread.currentThread().getStackTrace();
        if (null == callStack) {
            top = "";
        }
        else {
            // 最原始被调用的堆栈信息
            StackTraceElement caller = null;
            // 日志类名称
            String logClassName = LoggerUtil.class.getName();
            // 循环遍历到日志类标识
            boolean isEachLogClass = false;

            // 遍历堆栈信息，获取出最原始被调用的方法信息
            for (StackTraceElement s : callStack) {
                // 遍历到日志类
                if (logClassName.equals(s.getClassName())) {
                    isEachLogClass = true;
                }
                // 下一个非日志类的堆栈，就是最原始被调用的方法
                if (isEachLogClass) {
                    if (!logClassName.equals(s.getClassName())) {
                        isEachLogClass = false;
                        caller = s;
                        break;
                    }
                }
            }
            top = caller.toString();
        }
    }
}
