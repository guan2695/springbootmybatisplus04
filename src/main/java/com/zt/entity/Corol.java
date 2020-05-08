package com.zt.entity;

/**
 * @author guan
 * @create 2020-05-07 17:18
 */
public class Corol {
    private int corolid;
    private String corol;

    public Corol() {
    }

    public int getCorolid() {
        return corolid;
    }

    public void setCorolid(int corolid) {
        this.corolid = corolid;
    }

    public String getCorol() {
        return corol;
    }

    public void setCorol(String corol) {
        this.corol = corol;
    }

    @Override
    public String toString() {
        return "Corol{" +
                "corolid=" + corolid +
                ", corol='" + corol + '\'' +
                '}';
    }
}
