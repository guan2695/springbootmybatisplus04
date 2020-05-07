package com.zt.entity;

/**
 * @author guan
 * @create 2020-05-07 16:50
 * 评价失败表
 */
public class Assessover {
    private int overid;
    private int aid;
    private String because;

    public Assessover() {
    }

    public int getOverid() {
        return overid;
    }

    public void setOverid(int overid) {
        this.overid = overid;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getBecause() {
        return because;
    }

    public void setBecause(String because) {
        this.because = because;
    }

    @Override
    public String toString() {
        return "Assessover{" +
                "overid=" + overid +
                ", aid=" + aid +
                ", because='" + because + '\'' +
                '}';
    }
}
