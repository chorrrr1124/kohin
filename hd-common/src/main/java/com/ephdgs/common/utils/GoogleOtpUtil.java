package com.ephdgs.common.utils;

import com.ephdgs.common.config.GoogleOtpConfig;
import org.apache.commons.codec.binary.Base32;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @Description:
 * @Date: 2024/5/10
 * @Author: Hill
 */
@Component
public class GoogleOtpUtil {

    private GoogleOtpConfig googleOtpConfig;
    @Autowired
    public void setGoogleOtpConfig(GoogleOtpConfig googleOtpConfig) {
        this.googleOtpConfig = googleOtpConfig;
    }

    /**
     * 生成一个SecretKey，外部绑定到用户
     *
     * @return SecretKey
     */
    public String generateSecretKey() {
        SecureRandom sr;
        try {
            sr = SecureRandom.getInstance(googleOtpConfig.getAlgorithm());
            sr.setSeed(getSeed());
            byte[] buffer = sr.generateSeed(googleOtpConfig.getSecretSize());
            Base32 codec = new Base32();
            byte[] bEncodedKey = codec.encode(buffer);
            String ret = new String(bEncodedKey);
            return ret.replaceAll("=+$", "");// 移除末尾的等号
        } catch (NoSuchAlgorithmException e) {
            // should never occur... configuration error
            throw new RuntimeException(e);
        }
    }

    /**
     * 生成二维码所需的字符串，注：这个format不可修改，否则会导致身份验证器无法识别二维码
     *
     * @param user   绑定到的用户名
     * @param secret 对应的secretKey
     * @return 二维码字符串
     */
    public String getQRBarcode(String user, String secret) {
        user = googleOtpConfig.getIssuer() + ":" + user;
        String format = "otpauth://totp/%s?secret=%s";
        String ret = String.format(format, user, secret);
        ret += "&issuer=" + googleOtpConfig.getIssuer();
        return ret;
    }

    /**
     * 验证用户提交的code是否匹配
     *
     * @param secret 用户绑定的secretKey
     * @param code   用户输入的code
     * @return 匹配成功与否
     */
    public boolean checkCode(String secret, int code) {
        Base32 codec = new Base32();
        byte[] decodedKey = codec.decode(secret);
        // convert unix msec time into a 30 second "window"
        // this is per the TOTP spec (see the RFC for details)
        long timeMsec = System.currentTimeMillis();
        long t = (timeMsec / 1000L) / googleOtpConfig.getPer();
        // Window is used to check codes generated in the near past.
        // You can use this value to tune how far you're willing to go.
        for (int i = -googleOtpConfig.getWindowSize(); i <= googleOtpConfig.getWindowSize(); ++i) {
            int hash;
            try {
                hash = verifyCode(decodedKey, t + i);
            } catch (Exception e) {
                // Yes, this is bad form - but
                // the exceptions thrown would be rare and a static
                // configuration problem
                e.printStackTrace();
                throw new RuntimeException(e.getMessage());
                // return false;
            }
            System.out.println("input code=" + code + "; count hash=" + hash);
            if (code == hash) { // addZero(hash)
                return true;
            }
/*            if (code==hash ) {
                return true;
            }*/
        }
        // The validation code is invalid.
        return false;
    }

    private static int verifyCode(byte[] key, long t) throws NoSuchAlgorithmException, InvalidKeyException {
        byte[] data = new byte[8];
        long value = t;
        for (int i = 8; i-- > 0; value >>>= 8) {
            data[i] = (byte) value;
        }
        SecretKeySpec signKey = new SecretKeySpec(key, "HmacSHA1");
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(signKey);
        byte[] hash = mac.doFinal(data);
        int offset = hash[20 - 1] & 0xF;
        // We're using a long because Java hasn't got unsigned int.
        long truncatedHash = 0;
        for (int i = 0; i < 4; ++i) {
            truncatedHash <<= 8;
            // We are dealing with signed bytes:
            // we just keep the first byte.
            truncatedHash |= (hash[offset + i] & 0xFF);
        }
        truncatedHash &= 0x7FFFFFFF;
        truncatedHash %= 1000000;
        return (int) truncatedHash;
    }

    private byte[] getSeed() {
        String str = googleOtpConfig.getIssuer() + System.currentTimeMillis() + googleOtpConfig.getIssuer();
        return str.getBytes(StandardCharsets.UTF_8);
    }
}
