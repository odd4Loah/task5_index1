package com.lihoo.ssm.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

import com.lihoo.ssm.dao.StudentInfoMapper;
import com.lihoo.ssm.model.StudentInfo;
import com.lihoo.ssm.service.StudentInfoService;
import org.apache.commons.codec.binary.Hex;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.Random;

import static org.apache.commons.codec.digest.DigestUtils.md5Hex;

/**
 * #Title: MD5Encryption
 * #ProjectName task5_index1
 * #Description: TODO
 * #author lihoo
 * #date 2018/9/1-15:12
 */

@Component
@SuppressWarnings("unused")
public class MD5Encryption {
    private static Logger logger = LogManager.getLogger(MD5Encryption.class);
    private MD5Encryption() {

    }
//    字符串转MD5
    public static String getEncryption(String originString) throws UnsupportedEncodingException {
        String result = "";
        if (originString != null) {
            try {
//            指定加密方式为MD5
                MessageDigest md = MessageDigest.getInstance("MD5");
//                进行加密运算
                byte bytes[] = md.digest(originString.getBytes("ISO8859-1"));
                for (byte aByte : bytes) {
//                    将整数转换成十六进制形式的字符串，这里与0xff进行与运算的原因是保证转换结果为32位
                    String str = Integer.toHexString(aByte & 0xff);
                    if (str.length() == 1) {
                        str += "F";
                    }
                    result += str;
                }
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
//    加随机盐
    public static String saltInDB() {
        Random r = new Random();
        StringBuilder sb = new StringBuilder(16);
        sb.append(r.nextInt(99999999)).append(r.nextInt(99999999));
        int len = sb.length();
        if (len < 16) {
            for (int i = 0; i < 16 - len; i++) {
                sb.append("0");
            }
        }
        return sb.toString();
    }
//    加盐MD5(加了16位随机盐)
    public static String md5_salt(String pwd) {
//        Random r = new Random();
//        StringBuilder sb = new StringBuilder(16);
//        sb.append(r.nextInt(99999999)).append(r.nextInt(99999999));
//        int len = sb.length();
//        if (len < 16) {
//            for (int i = 0; i < 16 - len; i++) {
//                sb.append("0");
//            }
//        }
//
//        String salt = sb.toString();
//        盐加在前面
        pwd = md5Hex( saltInDB() + pwd);
        char[] cs = new char[48];
        for (int i = 0; i < 48; i += 3) {
            cs[i] =pwd.charAt(i / 3 * 2);
            char c = saltInDB().charAt(i / 3);
            cs[i + 1] = c;
            cs[i + 2] = pwd.charAt(i / 3 * 2 + 1);
        }
        return new String(cs);
    }


//    public void findDB_Salt(StudentInfoService studentInfoService) {
//        String salt0 = AddSalt.getSalt();
////        String pwdHash = getEncryption(studentInfoService.  )
//
//    }
//
//    //    加盐MD5(加了16位随机盐)
//    public static String DB_md5_salt(String pwd, String salt) {
////        Random r = new Random();
////        StringBuilder sb = new StringBuilder(16);
////        sb.append(r.nextInt(99999999)).append(r.nextInt(99999999));
////        int len = sb.length();
////        if (len < 16) {
////            for (int i = 0; i < 16 - len; i++) {
////                sb.append("0");
////            }
////        }
////
////        String salt = sb.toString();
////        盐加在前面
//        pwd = md5Hex( findDB_Salt(salt) + pwd);
//        char[] cs = new char[48];
//        for (int i = 0; i < 48; i += 3) {
//            cs[i] =pwd.charAt(i / 3 * 2);
//            char c = saltInDB().charAt(i / 3);
//            cs[i + 1] = c;
//            cs[i + 2] = pwd.charAt(i / 3 * 2 + 1);
//        }
//        return new String(cs);
//    }

//    //    给MD5加数据库中固定的盐(测试)
//    public static String FixedSaltMD5(String pwd) {
////        Random r = new Random();
////        StringBuilder sb = new StringBuilder(16);
////        sb.append(r.nextInt(99999999)).append(r.nextInt(99999999));
////        int len = sb.length();
////        if (len < 16) {
////            for (int i = 0; i < 16 - len; i++) {
////                sb.append("0");
////            }
////        }
////
////        String salt = sb.toString();
////        盐加在前面
//        inputPwdMD5ful = md5Hex( dbSalt + inputPwdMD5ful);
//        char[] cs = new char[48];
//        for (int i = 0; i < 48; i += 3) {
//            cs[i] =inputPwdMD5ful.charAt(i / 3 * 2);
//            char c = dbSalt.charAt(i / 3);
//            cs[i + 1] = c;
//            cs[i + 2] = inputPwdMD5ful.charAt(i / 3 * 2 + 1);
//        }
//        return new String(cs);
//    }

//    校验加盐后是否和原文一致
    public static boolean verify(String pwd, String md5) {
        char[] cs1 = new char[32];
        char[] cs2 = new char[16];
        for (int i = 0; i < 48; i += 3) {
            cs1[i / 3 * 2] = md5.charAt(i);
            cs1[i / 3 * 2 + 1] = md5.charAt(i + 2);
            cs2[i / 3] = md5.charAt(i + 1);
        }
        String salt = new String(cs2);
        return md5Hex(pwd + salt).equals(new String(cs1));
//        return Objects.requireNonNull(md5Hex(pwd + salt)).equals(new String(cs1));
//        return Objects.equals(md5Hex(pwd + salt), new String(cs1));

    }

//    获取十六进制字符串形式的MD5摘要(私
    public static String md5Hex(String src) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bs = md5.digest(src.getBytes());
            return new String(new  Hex().encode(bs));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
