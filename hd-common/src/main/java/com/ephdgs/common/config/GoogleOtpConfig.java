package com.ephdgs.common.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Date: 2024/3/18
 * @Author: Hill
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "otp")
public class GoogleOtpConfig {

    @Value("${otp.issuer}")
    private String issuer;
    @Value("${otp.secret-size}")
    private Integer secretSize;
    @Value("${otp.algorithm}")
    private String algorithm;
    @Value("${otp.window-size}")
    private Integer windowSize;
    @Value("${otp.per}")
    private Long per;


}

