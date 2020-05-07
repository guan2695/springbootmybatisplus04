package com.zt.entity;

/**
 * @author guan
 * @create 2020-05-07 17:30
 * 订车表
 */
public class Lookcar {
    private int lookid;
    private int uid;
    private int cid;
    //预定时间
    private String lookdate;
    //0 未支付 1 已支付
    private int lookstate;

    public Lookcar() {
    }

    public int getLookid() {
        return lookid;
    }

    public void setLookid(int lookid) {
        this.lookid = lookid;
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

    public String getLookdate() {
        return lookdate;
    }

    public void setLookdate(String lookdate) {
        this.lookdate = lookdate;
    }

    public int getLookstate() {
        return lookstate;
    }

    public void setLookstate(int lookstate) {
        this.lookstate = lookstate;
    }

    @Override
    public String toString() {
        return "Lookcar{" +
                "lookid=" + lookid +
                ", uid=" + uid +
                ", cid=" + cid +
                ", lookdate='" + lookdate + '\'' +
                ", lookstate=" + lookstate +
                '}';
    }
}
