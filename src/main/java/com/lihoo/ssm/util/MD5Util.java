package com.lihoo.ssm.util;

import org.apache.log4j.Logger;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * #Title: MD5Util
 * #ProjectName task5_index1
 * #Description: TODO
 * #author lihoo
 * #date 2018/9/1-12:58
 */


public class MD5Util {

    private static Logger logger = Logger.getLogger(MD5Util.class);
    /**
     * 对字符串md5加密(小写+字母)
     *
     * @param str 传入要加密的字符串
     * @return  MD5加密后的字符串
     */
    public static String getMD5(String str) {
        try {
//        生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
//            计算MD5函数
            md.update(str.getBytes());
//            digest()最后确定返回MD5 hash值，返回值为8位字符串。因为MD5 hash值是16位的hex值，实际上就是8位的字符串
//            BigInter函数则将8位的字符数转换为16位的hex值，用字符串来表示，得到字符串形式的hash值。
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 对字符串md5加密(大写+数字)
     *
     * @param s 传入要加密的字符串
     * @return  MD5加密后的字符串
     */

    public static String MD5(String s) {
        char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

        try {
            byte[] btInput = s.getBytes();      //获取二进制
//        获得MD5摘要算法的MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
//            使用指定的字节更新摘要
            mdInst.update(btInput);     //执行加密
//            获得密文
            byte[] md = mdInst.digest();        //加密结果
//            把密文转换成十六位进制的字符串形式
            int j = md.length;      //结果长度
            char str[] = new char[j * 2];       //字符数组
            int k = 0;
            for (byte byte0 : md) {     //将二进制加密结果转化为字符
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);     //输出加密后的字符
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}