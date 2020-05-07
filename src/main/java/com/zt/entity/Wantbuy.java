package com.zt.entity;

/**
 * @author guan
 * @create 2020-05-07 17:34
 * 求购表
 */
public class Wantbuy {
    private  int wbbid;
    private  int uid;
    //品牌
    private  int bid;
    //车系
    private  int csid;
    //车龄
    private  int carage;
     //地区
    private  int address;

    public Wantbuy() {
    }

    public int getWbbid() {
        return wbbid;
    }

    public void setWbbid(int wbbid) {
        this.wbbid = wbbid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getCsid() {
        return csid;
    }

    public void setCsid(int csid) {
        this.csid = csid;
    }

    public int getCarage() {
        return carage;
    }

    public void setCarage(int carage) {
        this.carage = carage;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Wantbuy{" +
                "wbbid=" + wbbid +
                ", uid=" + uid +
                ", bid=" + bid +
                ", csid=" + csid +
                ", carage=" + carage +
                ", address=" + address +
                '}';
    }
}
