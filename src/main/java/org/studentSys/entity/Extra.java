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
