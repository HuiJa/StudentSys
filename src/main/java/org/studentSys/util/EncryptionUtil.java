package org.studentSys.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by HuiJa on 2018/5/5.
 */
public class EncryptionUtil {
    /**
     * 按照你喜欢的方式进行字符串加密
     * @param str
     * @param method 加密方式使用SHA-256
     *  MD5,SHA,SHA-1,SHA-224,SHA-256,SHA-384,SHA-512
     * @return
     */
    public static String StrEncoder(String str, String method) {
        String newStr = "";
        //生辰一个加密计算摘要
        try {
            MessageDigest md = MessageDigest.getInstance(method);
            md.update(str.getBytes());
            newStr = new BigInteger(1, md.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return newStr;
    }
}
