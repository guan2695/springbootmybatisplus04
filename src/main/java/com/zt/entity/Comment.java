package com.zt.entity;

/**
 * @author guan
 * @create 2020-05-07 17:15
 * 评价
 */
public class Comment {
    private int commid;
    //买家秀id外键
    private int showid;
    //评价用户id外键
    private int uid;
    //评价内容
    private String comment;
    //时间
    private String cdate;

    public Comment() {
    }

    public int getCommid() {
        return commid;
    }

    public void setCommid(int commid) {
        this.commid = commid;
    }

    public int getShowid() {
        return showid;
    }

    public void setShowid(int showid) {
        this.showid = showid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commid=" + commid +
                ", showid=" + showid +
                ", uid=" + uid +
                ", comment='" + comment + '\'' +
                ", cdate='" + cdate + '\'' +
                '}';
    }
}
