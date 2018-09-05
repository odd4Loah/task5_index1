package com.lihoo.ssm.util;

import java.security.Key;
import java.security.SecureRandom;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

/**
 * #Title: TripleDESUtil
 * #ProjectName task5_index1
 * #Description: TODO
 * #author lihoo
 * #date 2018/9/5-10:15
 */


public class TripleDESUtil {
    private static final String ALGORITHM = "DESede";
    private static final String TRANSFORMATION = "DESede/ECB/PKCS5Padding";

    /**
     * 生成随机密钥
     *
     * @return
     * @throws Exception
     */
    public static Key generateKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
        keyGenerator.init(new SecureRandom());
        Key key = keyGenerator.generateKey();
        return key;
    }

    /**
     * 生成固定密钥
     *
     * @param seed
     * @return
     * @throws Exception
     */
    public static Key generateKey(byte[] seed) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
        keyGenerator.init(new SecureRandom(seed));
        Key key = keyGenerator.generateKey();
        return key;
    }

    /**
     * 生成固定密钥
     *
     * @param password
     * @return
     * @throws Exception
     */
    public static Key generateKey(String password) throws Exception {
        return generateKey(password.getBytes());
    }

    /**
     * 执行加密
     *
     * @param content
     * @param key       长度必须为8位，即64bit
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(byte[] content, byte[] key) throws Exception {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, ALGORITHM));
        byte[] output = cipher.doFinal(content);
        return output;
    }

    /**
     * 执行加密
     *
     * @param content
     * @param password
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(byte[] content, String password) throws Exception {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, generateKey(password));
        byte[] output = cipher.doFinal(content);
        return output;
    }

    /**
     * 执行解密
     *
     * @param content
     * @param key       长度必须为8位，即64bit
     * @return
     * @throws Exception
     */
    public static byte[] decrypt(byte[] content, byte[] key) throws Exception {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, ALGORITHM));
        byte[] output = cipher.doFinal(content);
        return output;
    }

    /**
     * 执行解密
     *
     * @param content
     * @param password
     * @return
     * @throws Exception
     */
    public static byte[] decrypt(byte[] content, String password) throws Exception {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, generateKey(password));
        byte[] output = cipher.doFinal(content);
        return output;
    }

    public static void main(String[] args) throws Exception {

        System.out.println(Arrays.toString(encrypt("使用3条56位的密钥对 数据进行三次加密。".getBytes(), "我是你爸")));
        System.out.println(new String(decrypt(encrypt("使用3条56位的密钥对 数据进行三次加密。".getBytes(), "我是你"), "我是你")));

        System.out.println(Arrays.toString(encrypt("使用3条56位的密钥对 数据进行三次加密。".getBytes(), "012345670123456701234567".getBytes())));
        System.out.println(new String(decrypt(encrypt("使用3条56位的密钥对 数据进行三次加密。".getBytes(), "012345670123456701234567".getBytes()), "012345670123456701234567".getBytes())));

        /*
         * 控制台输出：
         *
         * [-46, 78, 30, 115, 9, -79, -59, 46, 8, 46, -1, -92, -53, -42, -86, 15, -8, -25, -18, 92, 100, -109, 68, -9, -42, 80, 42, 60, -62, -43, 41, 84, -114, 52, 92, -115, -92, 16, -15, 3, 36, -105, 69, 118, -126, 61, 81, 121, -99, -89, -67, 91, 70, 19, 85, 9]
         * 使用3条56位的密钥对 数据进行三次加密。
         * [38, 108, 104, -124, 124, -73, -66, -121, -43, -41, -102, 74, -71, -98, 71, 4, 7, -50, 78, -28, 39, -103, 115, -93, -88, -107, -113, 89, -41, 55, -93, 111, -43, -120, -47, -50, -2, -104, 107, 105, 114, 45, 120, 40, 103, 64, 19, 60, 37, 18, 100, 71, 106, -66, 123, -66]
         * 使用3条56位的密钥对 数据进行三次加密。
         */
    }
}
