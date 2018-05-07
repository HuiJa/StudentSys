package org.studentSys.entity;

import org.studentSys.enums.EvaluatorEnums;
import org.studentSys.util.DateFormatUtil;

import java.util.Date;

/**
 * Created by HuiJa on 2018/5/7.
 */
public class Review {
    private int sid;
    private EvaluatorEnums rtype;
    ;
    private String rcont;
    private Date rdate;

    public Review() {
    }

    public Review(int sid, EvaluatorEnums rtype, String rcont, Date rdate) {
        this.sid = sid;
        this.rtype = rtype;
        this.rcont = rcont;
        this.rdate = rdate;
    }

    @Override
    public String toString() {
        return "Review{" +
                "sid=" + sid +
                ", rtype=" + rtype +
                ", rcont='" + rcont + '\'' +
                ", rdate=" + DateFormatUtil.dateToString(rdate) +
                '}';
    }
}
