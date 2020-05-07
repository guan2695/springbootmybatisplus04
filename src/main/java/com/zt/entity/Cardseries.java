package com.zt.entity;

/**
 * @author guan
 * @create 2020-05-07 17:10
 * 车系
 */
public class Cardseries {
    private int csid;
    //品牌id外键
    private int bid;
    //车系名称
    private String csname;

    public Cardseries() {
    }

    public int getCsid() {
        return csid;
    }

    public void setCsid(int csid) {
        this.csid = csid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getCsname() {
        return csname;
    }

    public void setCsname(String csname) {
        this.csname = csname;
    }

    @Override
    public String toString() {
        return "Cardseries{" +
                "csid=" + csid +
                ", bid=" + bid +
                ", csname='" + csname + '\'' +
                '}';
    }
}
