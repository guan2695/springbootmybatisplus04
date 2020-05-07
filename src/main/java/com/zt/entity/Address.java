package com.zt.entity;

/**
 * @author guan
 * @create 2020-05-07 16:44
 */
public class Address {
  private int addid;
  private String address;

    public Address() {
    }

    public int getAddid() {
        return addid;
    }

    public void setAddid(int addid) {
        this.addid = addid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addid=" + addid +
                ", address='" + address + '\'' +
                '}';
    }
}
