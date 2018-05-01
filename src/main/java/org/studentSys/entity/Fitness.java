package org.studentSys.entity;

/**
 * Created by HuiJa on 2018/5/1.
 */
public class Fitness {
    private int sid;
    private int fyear;
    private double fheig;
    private double fweig;
    private double frun;
    private int fjump;
    private double fwalk;
    private int fup;
    private double fahead;

    public Fitness() {
    }

    public Fitness(int sid, int fyear, double fheig, double fweig, double frun, int fjump, double fwalk, int fup, double fahead) {
        this.sid = sid;
        this.fyear = fyear;
        this.fheig = fheig;
        this.fweig = fweig;
        this.frun = frun;
        this.fjump = fjump;
        this.fwalk = fwalk;
        this.fup = fup;
        this.fahead = fahead;
    }

    @Override
    public String toString() {
        return "Fitness{" +
                "sid=" + sid +
                ", fyear=" + fyear +
                ", fheig=" + fheig +
                ", fweig=" + fweig +
                ", frun=" + frun +
                ", fjump=" + fjump +
                ", fwalk=" + fwalk +
                ", fup=" + fup +
                ", fahead=" + fahead +
                '}';
    }
}
