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

    @Override
    public String toString() {
        return "Course{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", cyear=" + cyear +
                '}';
    }
}
