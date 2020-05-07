package com.zt.entity;

/**
 * @author guan
 * @create 2020-05-07 16:57
 * 银行
 */
public class Banks {
    private int bankid;
    //银行名称
    private String bankname;

    public Banks() {
    }

    public int getBankid() {
        return bankid;
    }

    public void setBankid(int bankid) {
        this.bankid = bankid;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    @Override
    public String toString() {
        return "Banks{" +
                "bankid=" + bankid +
                ", bankname='" + bankname + '\'' +
                '}';
    }
}
