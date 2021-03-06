package org.studentSys.entity;

/**
 * Created by HuiJa on 2018/5/21.
 */
public class Classes {
    //这边避开使用Class作为类名，尴尬,很尴尬啊，数据库设计不该叫class的,真的睿智
    private int xid;
    private String xyear;
    private int xnum;

    public Classes() {
    }

    public Classes(int xid, String xyear, int xnum) {
        this.xid = xid;
        this.xyear = xyear;
        this.xnum = xnum;
    }

    public int getXid() {
        return xid;
    }

    public void setXid(int xid) {
        this.xid = xid;
    }

    public String getXyear() {
        return xyear;
    }

    public void setXyear(String xyear) {
        this.xyear = xyear;
    }

    public int getXnum() {
        return xnum;
    }

    public void setXnum(int xnum) {
        this.xnum = xnum;
    }

    @Override
    public String toString() {
        return "Class{" +
                "xid=" + xid +
                ", xyear='" + xyear + '\'' +
                ", xnum=" + xnum +
                '}';
    }
}
