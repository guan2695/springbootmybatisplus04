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
    private String lmsgbecause;

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

    public String getLmsgbecause() {
        return lmsgbecause;
    }

    public void setLmsgbecause(String lmsgbecause) {
        this.lmsgbecause = lmsgbecause;
    }

    @Override
    public String toString() {
        return "Loansasses{" +
                "lmsgid=" + lmsgid +
                ", lid=" + lid +
                ", adminid=" + adminid +
                ", lmsgbecause='" + lmsgbecause + '\'' +
                '}';
    }
}
