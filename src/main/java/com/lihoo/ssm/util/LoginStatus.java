package com.lihoo.ssm.util;

import com.lihoo.ssm.model.StudentInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * #Title: LoginStatus
 * #ProjectName task5_index1
 * #Description: TODO
 * #author lihoo
 * #date 2018/9/8-11:20
 */


public class LoginStatus {
    private static Logger logger = LogManager.getLogger(LoginStatus.class);

    /**
     * 返回值说明：
     * status[0],status[1]代表状态信息；
     * status[2],status[3]代表状态链接；
     * status[4]为用户信息；
     * */
    public static String[] status(HttpServletRequest request) {
        String[] status = {"登录", "注册", "login", "join", "account"};

        Cookie[] cookies = request.getCookies();
        System.out.println(Arrays.toString(cookies));
        System.out.println(cookies != null);
        if (cookies != null) {
            System.out.println("准备循环cookie");
//            遍历cookie，查看用户信息
            for (int i = 0; i < cookies.length; i++) {
                System.out.println("开始循环cookie" + i);
                String tokenName = cookies[i].getName();
                System.out.println(tokenName);

//                System.out.println("开始判断cookie是否有一个叫token的");
                if ("token".equals(cookies[i].getName())) {

                    String tokenValue = cookies[i].getValue();
                    logger.info("获取到的token：" + tokenValue);
//                    解密token
                    String tokenValueDecrypt = DesUtil.decrypt(tokenValue);
                    logger.info("解码token得到用户id和登录时间拼接的字符串为：" + tokenValueDecrypt);
//                    因为之前是用","分隔的用户id和登录时间，所以需要拆解成两个部分
                    String[] arrToken = tokenValueDecrypt.split(",");
                    logger.info("状态得到一个数组：" + arrToken);
                    String uid = arrToken[0];
                    logger.info("状态数组索引为“0”的部分是用户id" + uid);
                    String loginTime = arrToken[1];
                    logger.info("状态数组索引为“1”的部分是登录时间" + loginTime);
                    String uname = arrToken[2];
                    logger.info("状态数组索引为“2”的部分是用户名" + uname);

                    status[0] = uname;
                    status[1] = "退出登录";
                    status[2] = "#";
                    status[3] = "logout";
                    status[4] = tokenValueDecrypt;
//                    break;
                }
            }
        }
        return status;
    }
}