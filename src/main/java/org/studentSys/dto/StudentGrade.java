package org.studentSys.dto;

/**
 * Created by HuiJa on 2018/5/28.
 */
public class StudentGrade {
    private int sid;
    private String cname;
    private int cyear;
    private int gresult;

    public StudentGrade() {
    }

    public StudentGrade(int sid, String cname, int cyear, int gresult) {
        this.sid = sid;
        this.cname = cname;
        this.cyear = cyear;
        this.gresult = gresult;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
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

    public int getGresult() {
        return gresult;
    }

    public void setGresult(int gresult) {
        this.gresult = gresult;
    }

    @Override
    public String toString() {
        return "StudentGrade{" +
                "sid=" + sid +
                ", cname='" + cname + '\'' +
                ", cyear=" + cyear +
                ", gresult=" + gresult +
                '}';
    }
}
