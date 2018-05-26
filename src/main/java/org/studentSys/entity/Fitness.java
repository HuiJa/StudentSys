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

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getFyear() {
        return fyear;
    }

    public void setFyear(int fyear) {
        this.fyear = fyear;
    }

    public double getFheig() {
        return fheig;
    }

    public void setFheig(double fheig) {
        this.fheig = fheig;
    }

    public double getFweig() {
        return fweig;
    }

    public void setFweig(double fweig) {
        this.fweig = fweig;
    }

    public double getFrun() {
        return frun;
    }

    public void setFrun(double frun) {
        this.frun = frun;
    }

    public int getFjump() {
        return fjump;
    }

    public void setFjump(int fjump) {
        this.fjump = fjump;
    }

    public double getFwalk() {
        return fwalk;
    }

    public void setFwalk(double fwalk) {
        this.fwalk = fwalk;
    }

    public int getFup() {
        return fup;
    }

    public void setFup(int fup) {
        this.fup = fup;
    }

    public double getFahead() {
        return fahead;
    }

    public void setFahead(double fahead) {
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
