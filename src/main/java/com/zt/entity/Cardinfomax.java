package com.zt.entity;

/**
 * @author guan
 * @create 2020-05-07 17:07
 * 车的详细信息表
 */
public class Cardinfomax {
    private  int infomaxid;
    private  int cid;
    //排量
    private Double pailiang;
    //燃油类型
    private String youtype;
    //燃油标号
    private  int youname;
    //手动或者自动档
    private String dangtype;

    public Cardinfomax() {
    }

    public int getInfomaxid() {
        return infomaxid;
    }

    public void setInfomaxid(int infomaxid) {
        this.infomaxid = infomaxid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public Double getPailiang() {
        return pailiang;
    }

    public void setPailiang(Double pailiang) {
        this.pailiang = pailiang;
    }

    public String getYoutype() {
        return youtype;
    }

    public void setYoutype(String youtype) {
        this.youtype = youtype;
    }

    public int getYouname() {
        return youname;
    }

    public void setYouname(int youname) {
        this.youname = youname;
    }

    public String getDangtype() {
        return dangtype;
    }

    public void setDangtype(String dangtype) {
        this.dangtype = dangtype;
    }

    @Override
    public String toString() {
        return "Cardinfomax{" +
                "infomaxid=" + infomaxid +
                ", cid=" + cid +
                ", pailiang=" + pailiang +
                ", youtype='" + youtype + '\'' +
                ", youname=" + youname +
                ", dangtype='" + dangtype + '\'' +
                '}';
    }
}
