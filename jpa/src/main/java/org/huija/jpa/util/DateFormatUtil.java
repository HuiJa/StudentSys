package org.huija.jpa.util;

import org.hibernate.annotations.Table;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by HuiJa on 2018/5/7.
 */
public class DateFormatUtil {
    /**
     * 指定格式
     */
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 根据字符串日期返回Date类型日期
     *
     * @param str "yyyy-MM-dd"格式的日期
     * @return
     * @throws ParseException
     */
    public static Date dateFormat(String str) throws ParseException {
        return sdf.parse(str);
    }

    /**
     * 根据Date对象按格式输出字符串
     *
     * @param date
     * @return
     */
    public static String dateToString(Date date) {
        return sdf.format(date);
    }
}
