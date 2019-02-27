package org.studentSys.entity;
//这里为啥没法import,非要在test创建文件夹才可以不解

import org.studentSys.enums.SexEnums;
import org.studentSys.enums.SmajorEnums;
import org.studentSys.enums.SpeoEnums;

/**
 * Created by HuiJa on 2018/4/26.
 */
public class Student {
    private int sid;
    private String sname;
    private SexEnums ssex;
    private String spasswd;
    private SmajorEnums smajor;
    private int xid;
    private String sdorm;
    private String stele;
    private String spoo;
    private SpeoEnums speo;
    private String addr;
    private String telopm;
    private String sresult;

    public Student() {
    }

    public Student(int sid, String sname, SexEnums ssex, SmajorEnums smajor,
                   int xid, String sdorm, String stele,
                   String spoo, SpeoEnums speo, String addr, String telopm) {
        this.sid = sid;
        this.sname = sname;
        this.ssex = ssex;
        this.smajor = smajor;
        this.xid=xid;
        this.sdorm = sdorm;
        this.stele = stele;
        this.spoo = spoo;
        this.speo = speo;
        this.addr = addr;
        this.telopm = telopm;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public SexEnums getSsex() {
        return ssex;
    }

    public void setSsex(SexEnums ssex) {
        this.ssex = ssex;
    }

    public String getSpasswd() {
        return spasswd;
    }

    public void setSpasswd(String spasswd) {
        this.spasswd = spasswd;
    }

    public SmajorEnums getSmajor() {
        return smajor;
    }

    public void setSmajor(SmajorEnums smajor) {
        this.smajor = smajor;
    }

    public int getXid() {
        return xid;
    }

    public void setXid(int xid) {
        this.xid = xid;
    }

    public String getSdorm() {
        return sdorm;
    }

    public void setSdorm(String sdorm) {
        this.sdorm = sdorm;
    }

    public String getStele() {
        return stele;
    }

    public void setStele(String stele) {
        this.stele = stele;
    }

    public String getSpoo() {
        return spoo;
    }

    public void setSpoo(String spoo) {
        this.spoo = spoo;
    }

    public SpeoEnums getSpeo() {
        return speo;
    }

    public void setSpeo(SpeoEnums speo) {
        this.speo = speo;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getTelopm() {
        return telopm;
    }

    public void setTelopm(String telopm) {
        this.telopm = telopm;
    }

    public String getSresult() {
        return sresult;
    }

    public void setSresult(String sresult) {
        this.sresult = sresult;
    }

    public int getSid() {
        return sid;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", ssex=" + ssex +
                ", spasswd='" + spasswd + '\'' +
                ", smajor=" + smajor +
                ", xid=" + xid +
                ", sdorm='" + sdorm + '\'' +
                ", stele='" + stele + '\'' +
                ", spoo='" + spoo + '\'' +
                ", speo=" + speo +
                ", addr='" + addr + '\'' +
                ", telopm='" + telopm + '\'' +
                ", sresult='" + sresult + '\'' +
                '}';
    }
}
