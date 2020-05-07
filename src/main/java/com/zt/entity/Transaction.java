package com.zt.entity;

/**
 * @author guan
 * @create 2020-05-07 17:32
 * 交易表
 */
public class Transaction {
    private int tid;
    private int cid;
    //买家id
    private int buyer;
    //卖家id
    private int seller;
    //成交金额
    private Double tmoney;
    //交易时间
    private String tdate;

    public Transaction() {
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getBuyer() {
        return buyer;
    }

    public void setBuyer(int buyer) {
        this.buyer = buyer;
    }

    public int getSeller() {
        return seller;
    }

    public void setSeller(int seller) {
        this.seller = seller;
    }

    public Double getTmoney() {
        return tmoney;
    }

    public void setTmoney(Double tmoney) {
        this.tmoney = tmoney;
    }

    public String getTdate() {
        return tdate;
    }

    public void setTdate(String tdate) {
        this.tdate = tdate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "tid=" + tid +
                ", cid=" + cid +
                ", buyer=" + buyer +
                ", seller=" + seller +
                ", tmoney=" + tmoney +
                ", tdate='" + tdate + '\'' +
                '}';
    }
}
