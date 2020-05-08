package com.zt.entity;

import java.util.List;

/**
 * @author guan
 * @create 2020-05-07 16:59
 * 品牌
 */
public class Brand {
    private int bid;
    //品牌名字
    private String bname;
    //每个品牌下的车系
    private List<Cardseries> cardseries;

    public Brand() {
    }

    public List<Cardseries> getCardseries() {
        return cardseries;
    }

    public void setCardseries(List<Cardseries> cardseries) {
        this.cardseries = cardseries;
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
                ", cardseries=" + cardseries +
                '}';
    }
}
