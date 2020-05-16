package com.zt.entity;

/**
 * @author guan
 * @create 2020-05-07 17:22
 * 贷款
 */
public class Loans {
    private  int lid;
    private  int uid;
    private String idcard;
    //贷款金额万
    private Double lmoney;
    //0无 1有房产
    private  int ishavehouse;
    //银行id外键
    private  int bankid;
    //0未审核，1贷款失败，2贷款成功
    private  int lstate;

    //贷款的用户
    private User user;

    //贷款的银行
    private Banks banks;

    public Loans() {
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public Banks getBanks() {
        return banks;
    }

    public void setBanks(Banks banks) {
        this.banks = banks;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Double getLmoney() {
        return lmoney;
    }

    public void setLmoney(Double lmoney) {
        this.lmoney = lmoney;
    }

    public int getIshavehouse() {
        return ishavehouse;
    }

    public void setIshavehouse(int ishavehouse) {
        this.ishavehouse = ishavehouse;
    }

    public int getBankid() {
        return bankid;
    }

    public void setBankid(int bankid) {
        this.bankid = bankid;
    }

    public int getLstate() {
        return lstate;
    }

    public void setLstate(int lstate) {
        this.lstate = lstate;
    }

    @Override
    public String toString() {
        return "Loans{" +
                "lid=" + lid +
                ", uid=" + uid +
                ", idcard='" + idcard + '\'' +
                ", lmoney=" + lmoney +
                ", ishavehouse=" + ishavehouse +
                ", bankid=" + bankid +
                ", lstate=" + lstate +
                ", user=" + user +
                ", banks=" + banks +
                '}';
    }
}
