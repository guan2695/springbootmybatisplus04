package com.zt.entity;

/**
 * @author xyq
 * @create 2020-05-17 19:00
 */
public class Talk {
    private int talkid;
    private int meid;
    private int otherid;
    private String talkmsg;
    private String talkdate;
    private int talkstate;

    private int unread;//未读消息数

    private User meuser;//发消息的人
    private User otheruser;//收消息的人

    @Override
    public String toString() {
        return "Talk{" +
                "talkid=" + talkid +
                ", meid=" + meid +
                ", otherid=" + otherid +
                ", talkmsg='" + talkmsg + '\'' +
                ", talkdate='" + talkdate + '\'' +
                ", talkstate=" + talkstate +
                ", unread=" + unread +
                ", meuser=" + meuser +
                ", otheruser=" + otheruser +
                '}';
    }

    public int getTalkstate() {
        return talkstate;
    }

    public void setTalkstate(int talkstate) {
        this.talkstate = talkstate;
    }

    public int getUnread() {
        return unread;
    }

    public void setUnread(int unread) {
        this.unread = unread;
    }

    public int getTalkid() {
        return talkid;
    }

    public void setTalkid(int talkid) {
        this.talkid = talkid;
    }

    public int getMeid() {
        return meid;
    }

    public void setMeid(int meid) {
        this.meid = meid;
    }

    public int getOtherid() {
        return otherid;
    }

    public void setOtherid(int otherid) {
        this.otherid = otherid;
    }

    public String getTalkmsg() {
        return talkmsg;
    }

    public void setTalkmsg(String talkmsg) {
        this.talkmsg = talkmsg;
    }

    public String getTalkdate() {
        return talkdate;
    }

    public void setTalkdate(String talkdate) {
        this.talkdate = talkdate;
    }

    public User getMeuser() {
        return meuser;
    }

    public void setMeuser(User meuser) {
        this.meuser = meuser;
    }

    public User getOtheruser() {
        return otheruser;
    }

    public void setOtheruser(User otheruser) {
        this.otheruser = otheruser;
    }


}
