package org.studentSys.entity;

import org.studentSys.enums.EvaluatorEnums;
import org.studentSys.util.DateFormatUtil;

import java.util.Date;

/**
 * Created by HuiJa on 2018/5/7.
 */
public class Review {
    private int rid;
    private int sid;
    private EvaluatorEnums rtype;
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

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public EvaluatorEnums getRtype() {
        return rtype;
    }

    public void setRtype(EvaluatorEnums rtype) {
        this.rtype = rtype;
    }

    public String getRcont() {
        return rcont;
    }

    public void setRcont(String rcont) {
        this.rcont = rcont;
    }

    public Date getRdate() {
        return rdate;
    }

    public void setRdate(Date rdate) {
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
