package com.zt.entity;

/**
 * @author guan
 * @create 2020-05-07 17:19
 * 浏览记录
 */
public class History {
    private  int hid;
    private  int  uid;
    private  int cid;
    //浏览时间
    private  String hdate;

    public History() {
    }

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getHdate() {
        return hdate;
    }

    public void setHdate(String hdate) {
        this.hdate = hdate;
    }

    @Override
    public String toString() {
        return "History{" +
                "hid=" + hid +
                ", uid=" + uid +
                ", cid=" + cid +
                ", hdate='" + hdate + '\'' +
                '}';
    }
}
