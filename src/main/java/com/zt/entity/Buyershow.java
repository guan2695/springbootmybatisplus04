package com.zt.entity;

/**
 * @author guan
 * @create 2020-05-07 17:00
 * 买家秀
 */
public class Buyershow {
    private int showid;
    private int uid;
    private int cid;
    private String title;
    //秀的内容
    private String showmsg;
    //图片
    private String img;
    //秀的时间
    private String showtime;

    //一对一，发布买家秀的用户
    private User user;

    public Buyershow() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getShowid() {
        return showid;
    }

    public void setShowid(int showid) {
        this.showid = showid;
    }

    public String getShowtime() {
        return showtime;
    }

    public void setShowtime(String showtime) {
        this.showtime = showtime;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShowmsg() {
        return showmsg;
    }

    public void setShowmsg(String showmsg) {
        this.showmsg = showmsg;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Buyershow{" +
                "showid=" + showid +
                ", uid=" + uid +
                ", cid=" + cid +
                ", title='" + title + '\'' +
                ", showmsg='" + showmsg + '\'' +
                ", img='" + img + '\'' +
                ", showtime='" + showtime + '\'' +
                ", user=" + user +
                '}';
    }
}
