package org.huija.jpa.entity;

import org.huija.jpa.util.DateFormatUtil;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by HuiJa on 2018/5/7.
 */
@Entity//Jpa注解
@Table(name = "grade")//对应表名
public class Grade {
    @Id
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

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getGresult() {
        return gresult;
    }

    public void setGresult(int gresult) {
        this.gresult = gresult;
    }

    public Date getGtime() {
        return gtime;
    }

    public void setGtime(Date gtime) {
        this.gtime = gtime;
    }

    public Boolean getGreply() {
        return greply;
    }

    public void setGreply(Boolean greply) {
        this.greply = greply;
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
