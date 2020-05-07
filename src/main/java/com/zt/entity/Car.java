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
    private int corol;
    //车主
    private int uid;
    private Double oprice;
    private Double price;
    //评估状态 0 未 1完成
    private int putstate;
   // 地区外键
    private int assesstate;

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

   private User user;
   //地区一对多
   private List<Address> addresslist;


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

    public List<Address> getAddresslist() {
        return addresslist;
    }

    public void setAddresslist(List<Address> addresslist) {
        this.addresslist = addresslist;
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

    public int getCorol() {
        return corol;
    }

    public void setCorol(int corol) {
        this.corol = corol;
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
                ", corol=" + corol +
                ", uid=" + uid +
                ", oprice=" + oprice +
                ", price=" + price +
                ", putstate=" + putstate +
                ", assesstate=" + assesstate +
                ", carage=" + carage +
                ", img='" + img + '\'' +
                ", brand=" + brand +
                ", cardseries=" + cardseries +
                ", imagesList=" + imagesList +
                ", user=" + user +
                ", addresslist=" + addresslist +
                '}';
    }
}
