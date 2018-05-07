package org.studentSys.entity;

import org.studentSys.util.DateFormatUtil;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by HuiJa on 2018/5/7.
 */
public class Grade {
    private int cid;
    private int sid;
    private int gresult;
    private Date gtime;
    private Boolean greply;

    public Grade() {
    }

    public Grade(int cid, int sid, int gresult, Date gtime) {
        this.cid = cid;
        this.sid = sid;
        this.gresult = gresult;
        this.gtime = gtime;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "cid=" + cid +
                ", sid=" + sid +
                ", gresult=" + gresult +
                ", gtime=" + DateFormatUtil.dateToString(gtime) +
                ", greply=" + greply +
                '}';
    }
}
