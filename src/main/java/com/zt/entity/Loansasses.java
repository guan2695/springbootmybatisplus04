package com.zt.entity;

/**
 * @author guan
 * @create 2020-05-07 17:25
 * 贷款评估表
 */
public class Loansasses {
    private int lmsgid;
    private int lid;
    //评估员id外键
    private int adminid;
    //0 未 1 评估成功
    private int lmsgstate;

    public Loansasses() {
    }

    public int getLmsgid() {
        return lmsgid;
    }

    public void setLmsgid(int lmsgid) {
        this.lmsgid = lmsgid;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public int getAdminid() {
        return adminid;
    }

    public void setAdminid(int adminid) {
        this.adminid = adminid;
    }

    public int getLmsgstate() {
        return lmsgstate;
    }

    public void setLmsgstate(int lmsgstate) {
        this.lmsgstate = lmsgstate;
    }

    @Override
    public String toString() {
        return "Loansasses{" +
                "lmsgid=" + lmsgid +
                ", lid=" + lid +
                ", adminid=" + adminid +
                ", lmsgstate=" + lmsgstate +
                '}';
    }
}
