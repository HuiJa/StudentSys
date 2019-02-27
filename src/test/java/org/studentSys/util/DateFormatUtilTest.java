package org.studentSys.util;

import org.junit.Test;

import java.util.Date;

/**
 * Created by HuiJa on 2018/5/7.
 */
public class DateFormatUtilTest {
    @Test
    public void dateToString() throws Exception {
        System.out.println(DateFormatUtil.dateToString(new Date()));
    }

    @Test
    public void dateFormat() throws Exception {
        System.out.println(DateFormatUtil.dateFormat("2017-1-2"));
    }

}