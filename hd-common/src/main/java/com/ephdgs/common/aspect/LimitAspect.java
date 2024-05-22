package com.ephdgs.common.aspect;

import com.ephdgs.common.annotation.Limit;
import com.google.common.util.concurrent.RateLimiter;
import com.ephdgs.common.enums.HttpStatusCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import com.ephdgs.common.utils.HttpResponseUtil;
import com.ephdgs.common.utils.LoggerUtil;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Date: 2024/2/29
 * @Author: Hill
 */
@Slf4j
@Aspect
@Component
public class LimitAspect {

    RateLimiter rateLimiter = RateLimiter.create(Double.MAX_VALUE);

    @Pointcut("@annotation(com.ephdgs.common.annotation.Limit)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        //获取目标方法
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        Limit limit = method.getAnnotation(Limit.class);
        rateLimiter.setRate(limit.perSecond());

        // 获取令牌桶中的一个令牌，最多等待1秒
        if (rateLimiter.tryAcquire(1, 1, TimeUnit.SECONDS)) {
            return point.proceed();
        } else {
            LoggerUtil.error(limit.name() + " 接口并发量过大执行限流");
            return HttpResponseUtil.error(HttpStatusCodeEnum.LIMIT_ERROR);
//            throw new LimitAccessException("网络异常，请稍后重试！");
        }
    }

}