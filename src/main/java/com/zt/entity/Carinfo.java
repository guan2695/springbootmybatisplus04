package com.zt.entity;

/**
 * @author guan
 * @create 2020-05-07 17:12
 * 车辆详细
 */
public class Carinfo {
    private  int cinfoid;
    //车id外键
    private int cid;
    private  int length;
    private  int width;
    private  int height;
    //质量 kg
    private  int mass;

    public Carinfo() {
    }

    public int getCinfoid() {
        return cinfoid;
    }

    public void setCinfoid(int cinfoid) {
        this.cinfoid = cinfoid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    @Override
    public String toString() {
        return "Carinfo{" +
                "cinfoid=" + cinfoid +
                ", cid=" + cid +
                ", length=" + length +
                ", width=" + width +
                ", height=" + height +
                ", mass=" + mass +
                '}';
    }
}
