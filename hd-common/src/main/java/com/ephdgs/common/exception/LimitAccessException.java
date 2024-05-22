package com.ephdgs.common.exception;

/**
 * @Description:
 * @Date: 2024/2/29
 * @Author: Hill
 */
public class LimitAccessException extends RuntimeException  {

    private static final long serialVersionUID = -3608667856397125671L;

    public LimitAccessException(String message) {
        super(message);
    }
}
