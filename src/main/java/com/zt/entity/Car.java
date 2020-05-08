package com.zt.entity;

import java.util.List;

/**
 * @author guan
 * @create 2020-05-07 17:03
 */
public class Car {
     private int cid;
    private int bid;
    private int csid;
    private int corolid;
    //车主
    private int uid;
    private Double oprice;
    private Double price;
    //上架 0 未 1完成
    private int putstate;
    //评估状态 0 未 1完成
    private int assesstate;
    // 地区外键
    private int addressid;
    //车龄
    private int carage;
    //车图片
    private String img;

    //一对一品牌
    private Brand brand;
    //一辆车有一个系列
   private Cardseries cardseries;
   //一辆车六张图片
   private List<Images> imagesList;
   //一个车对应一个用户
   private User user;
   //地区一对多
   private Address address;
   private Corol corol;

    public Corol getCorolz() {
        return corol;
    }

    public void setCorolz(Corol corolz) {
        this.corol = corolz;
    }

    public int getAddressid() {
        return addressid;
    }

    public void setAddressid(int addressid) {
        this.addressid = addressid;
    }

    public Corol getCorol() {
        return corol;
    }

    public void setCorol(Corol corol) {
        this.corol = corol;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Cardseries getCardseries() {
        return cardseries;
    }

    public void setCardseries(Cardseries cardseries) {
        this.cardseries = cardseries;
    }

    public List<Images> getImagesList() {
        return imagesList;
    }

    public void setImagesList(List<Images> imagesList) {
        this.imagesList = imagesList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Car() {
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getCsid() {
        return csid;
    }

    public void setCsid(int csid) {
        this.csid = csid;
    }

    public int getCorolid() {
        return corolid;
    }

    public void setCorolid(int corolid) {
        this.corolid = corolid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Double getOprice() {
        return oprice;
    }

    public void setOprice(Double oprice) {
        this.oprice = oprice;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getPutstate() {
        return putstate;
    }

    public void setPutstate(int putstate) {
        this.putstate = putstate;
    }

    public int getAssesstate() {
        return assesstate;
    }

    public void setAssesstate(int assesstate) {
        this.assesstate = assesstate;
    }

    public int getCarage() {
        return carage;
    }

    public void setCarage(int carage) {
        this.carage = carage;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Car{" +
                "cid=" + cid +
                ", bid=" + bid +
                ", csid=" + csid +
                ", corolid=" + corolid +
                ", uid=" + uid +
                ", oprice=" + oprice +
                ", price=" + price +
                ", putstate=" + putstate +
                ", assesstate=" + assesstate +
                ", addressid=" + addressid +
                ", carage=" + carage +
                ", img='" + img + '\'' +
                ", brand=" + brand +
                ", cardseries=" + cardseries +
                ", imagesList=" + imagesList +
                ", user=" + user +
                ", address=" + address +
                ", corol=" + corol +
                '}';
    }
}
