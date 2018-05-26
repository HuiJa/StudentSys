package org.studentSys.entity;

import org.studentSys.enums.ExtraDevEnums;
import org.studentSys.util.DateFormatUtil;

import java.util.Date;

/**
 * Created by HuiJa on 2018/5/7.
 */
public class Extra {
    private int sid;
    private ExtraDevEnums etype;
    private String ename;
    private Date estime;
    private Date eetime;

    public Extra() {
    }

    public Extra(int sid, ExtraDevEnums etype, String ename, Date estime, Date eetime) {
        this.sid = sid;
        this.etype = etype;
        this.ename = ename;
        this.estime = estime;
        this.eetime = eetime;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public ExtraDevEnums getEtype() {
        return etype;
    }

    public void setEtype(ExtraDevEnums etype) {
        this.etype = etype;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Date getEstime() {
        return estime;
    }

    public void setEstime(Date estime) {
        this.estime = estime;
    }

    public Date getEetime() {
        return eetime;
    }

    public void setEetime(Date eetime) {
        this.eetime = eetime;
    }

    @Override
    public String toString() {
        return "Extra{" +
                "sid=" + sid +
                ", etypr=" + etype +
                ", ename='" + ename + '\'' +
                ", estime=" + DateFormatUtil.dateToString(estime) +
                ", eetime=" + DateFormatUtil.dateToString(eetime) +
                '}';
    }
}
