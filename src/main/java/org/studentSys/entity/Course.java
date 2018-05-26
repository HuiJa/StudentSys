package org.studentSys.entity;

/**
 * Created by HuiJa on 2018/5/7.
 */
public class Course {
    private int cid;
    private String cname;
    private int cyear;

    public Course() {
    }

    public Course(int cid, String cname, int cyear) {
        this.cid = cid;
        this.cname = cname;
        this.cyear = cyear;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getCyear() {
        return cyear;
    }

    public void setCyear(int cyear) {
        this.cyear = cyear;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", cyear=" + cyear +
                '}';
    }
}
