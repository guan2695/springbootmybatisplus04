package com.zt.entity;

/**
 * @author guan
 * @create 2020-05-07 16:48'
 * 评估表
 */
public class Assessment {
    private int aid;
    private int uid;
    private int adminid;
    private int cid;
    //评估状态
    private int assstate;
    //一对一用户
    private User user;
    private Admin admin;
    private Car car;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Assessment() {
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getAdminid() {
        return adminid;
    }

    public void setAdminid(int adminid) {
        this.adminid = adminid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getAssstate() {
        return assstate;
    }

    public void setAssstate(int assstate) {
        this.assstate = assstate;
    }

    @Override
    public String toString() {
        return "Assessment{" +
                "aid=" + aid +
                ", uid=" + uid +
                ", adminid=" + adminid +
                ", cid=" + cid +
                ", assstate=" + assstate +
                ", user=" + user +
                ", admin=" + admin +
                ", car=" + car +
                '}';
    }
}
