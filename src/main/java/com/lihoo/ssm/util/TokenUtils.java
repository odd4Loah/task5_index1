package com.lihoo.ssm.util;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * #Title: TokenUtils
 * #ProjectName task5_index1
 * #Description: TODO
 * #author lihoo
 * #date 2018/9/5-11:04
 */


public class TokenUtils {
    private static Logger logger = LogManager.getLogger(TokenUtils.class);

    /**
     * 获取Token
     * @param token TOKEN
     * @return
     */
    public static String getToken(String token) {
        logger.info("生成token字符串：data = " + token);
        try {
            token = DesUtil.encrypt(token);
        } catch (Exception e) {
            logger.info("生成TOKEN DES加密错误！");
            e.printStackTrace();
        }
        return token;
    }
    private TokenUtils() {
        super();
    }

    public static void main(String[] args) {

        Long uid = 59L;
        Long loginTime = 111L;
        String a = String.valueOf(uid + loginTime);
        logger.info(getToken(a));
    }



}
