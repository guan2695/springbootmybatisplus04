package com.zt.entity;

/**
 * @author guan
 * @create 2020-05-07 17:21
 */
public class Images {
    private  int iid;
    private  int cid;
    private  String src;

    public Images() {
    }

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    @Override
    public String toString() {
        return "Images{" +
                "iid=" + iid +
                ", cid=" + cid +
                ", src='" + src + '\'' +
                '}';
    }
}
