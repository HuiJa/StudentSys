package org.studentSys.entity;

import org.studentSys.util.EncryptionUtil;

/**
 * Created by HuiJa on 2018/5/7.
 */
public class Teacher {
    private int tid;
    private String tname;
    private int xid;
    private String ttele;
    private String tpasswd;

    public Teacher() {
    }

    public Teacher(int tid, String tname, int syear, String sclass, String ttele) {
        this.tid = tid;
        this.tname = tname;
        this.xid=xid;
        this.ttele = ttele;
    }

    public String getTname() {
        return tname;
    }

    public void setTpasswd(String tpasswd) {
        this.tpasswd = EncryptionUtil.StrEncoder(tpasswd, "SHA-256");
    }

    /**
     * ToString决定你打印对象返回的信息,这里我们选择不显示密码
     *
     * @return
     */
    @Override
    public String toString() {
        return "Teacher{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", xid=" + xid +
                ", ttele='" + ttele + '\'' +
                ", tpasswd='" + tpasswd + '\'' +
                '}';
    }
}
