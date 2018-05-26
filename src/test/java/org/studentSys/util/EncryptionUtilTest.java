package org.studentSys.util;

import org.junit.Test;

/**
 * Created by HuiJa on 2018/5/5.
 */
public class EncryptionUtilTest {
    @Test
    public void strEncoder() throws Exception {
        System.out.println(EncryptionUtil.StrEncoder("now888","MD5"));
        System.out.println(EncryptionUtil.StrEncoder("now888","SHA-256"));
        System.out.println(EncryptionUtil.StrEncoder("123456","SHA-256"));
    }

}