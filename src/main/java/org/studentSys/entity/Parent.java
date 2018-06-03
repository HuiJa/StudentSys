package org.studentSys.entity;

/**
 * Created by HuiJa on 2018/5/31.
 */
public class Parent {
    private int pid;
    private int sid;
    private String ppasswd;
    private String pname;

    public Parent() {
    }

    public Parent(int pid, int sid, String ppasswd, String pname) {
        this.pid = pid;
        this.sid = sid;
        this.ppasswd = ppasswd;
        this.pname = pname;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getPpasswd() {
        return ppasswd;
    }

    public void setPpasswd(String ppasswd) {
        this.ppasswd = ppasswd;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "pid=" + pid +
                ", sid=" + sid +
                ", pname='" + pname + '\'' +
                '}';
    }
}
