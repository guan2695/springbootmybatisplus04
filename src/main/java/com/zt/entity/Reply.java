package com.zt.entity;

import java.io.Serializable;

public class Reply implements Serializable {
    private int commid;
    private int uid;
    private int replyid;
    private String comment;
    private String redate;

    //发布评论的用户
    private User user;

    public int getCommid() {
        return commid;
    }

    public void setCommid(int commid) {
        this.commid = commid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getReplyid() {
        return replyid;
    }

    public void setReplyid(int replyid) {
        this.replyid = replyid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getRedate() {
        return redate;
    }

    public void setRedate(String redate) {
        this.redate = redate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "commid=" + commid +
                ", uid=" + uid +
                ", replyid=" + replyid +
                ", comment='" + comment + '\'' +
                ", redate='" + redate + '\'' +
                ", user=" + user +
                '}';
    }
}
