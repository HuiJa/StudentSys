package org.studentSys.entity;
//这里为啥没法import,非要在test创建文件夹才可以不解

import org.studentSys.enums.SexEnums;
import org.studentSys.enums.SmajorEnums;
import org.studentSys.enums.SpeoEnums;
import org.studentSys.util.EncryptionUtil;

/**
 * Created by HuiJa on 2018/4/26.
 */
public class Student {
    private int sid;
    private String sname;
    private SexEnums ssex;
    private String spasswd;
    private SmajorEnums smajor;
    private int syear;
    private String sclass;
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
                   int syear, String sclass, String sdorm, String stele,
                   String spoo, SpeoEnums speo, String addr, String telopm) {
        this.sid = sid;
        this.sname = sname;
        this.ssex = ssex;
        this.smajor = smajor;
        this.syear = syear;
        this.sclass = sclass;
        this.sdorm = sdorm;
        this.stele = stele;
        this.spoo = spoo;
        this.speo = speo;
        this.addr = addr;
        this.telopm = telopm;
    }


    public void setSpasswd(String spasswd) {
        this.spasswd = EncryptionUtil.StrEncoder(spasswd,"SHA-256");
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", ssex=" + ssex +
                ", smajor=" + smajor +
                ", syear=" + syear +
                ", sclass='" + sclass + '\'' +
                ", sdorm='" + sdorm + '\'' +
                ", stele='" + stele + '\'' +
                ", spoo='" + spoo + '\'' +
                ", speo=" + speo +
                ", addr='" + addr + '\'' +
                ", telopm='" + telopm + '\'' +
                '}';
    }
}
