package com.zt.entity;

import java.io.Serializable;

/**
 * @author guan
 * @create 2020-05-07 10:51
 */
public class User implements Serializable {
    private int uid;
    private String uname;
    private String upwd;

    private double money;
    private String phone;
    public User(){}

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }



    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                ", money=" + money +
                ", phone='" + phone + '\'' +
                '}';
    }
}
