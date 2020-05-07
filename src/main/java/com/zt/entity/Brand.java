package com.zt.entity;

/**
 * @author guan
 * @create 2020-05-07 16:59
 * 品牌
 */
public class Brand {
    private int bid;
    //品牌名字
    private String bname;

    public Brand() {
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "bid=" + bid +
                ", bname='" + bname + '\'' +
                '}';
    }
}
