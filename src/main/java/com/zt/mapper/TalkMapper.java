package com.zt.mapper;

import com.zt.entity.Talk;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author xyq
 * @create 2020-05-17 19:03
 */
@Mapper
public interface TalkMapper {


    /**
     * 查看未读消息
     * @param meid
     * @return
     */
    @Select("SELECT *,COUNT(meid) unread FROM talk WHERE talkstate=0 AND otherid=#{meid} GROUP BY meid")
    @Results({
            @Result(column = "meid",property = "meuser",one = @One(select = "com.zt.mapper.UsersMapper.getOneUserById")),
            @Result(column = "otherid",property = "otheruser",one = @One(select = "com.zt.mapper.UsersMapper.getOneUserById"))
    })
    public List<Talk> getUnreadGroup(int meid);


    /**
     * 查询两个人的聊天记录
     * @param meid
     * @param otherid
     * @return
     */
    @Select("SELECT * FROM talk WHERE (meid=#{meid} AND otherid=#{otherid}) OR (meid=#{otherid} AND otherid=#{meid})")
    @Results({
            @Result(column = "meid",property = "meuser",one = @One(select = "com.zt.mapper.UsersMapper.getOneUserById")),
            @Result(column = "otherid",property = "otheruser",one = @One(select = "com.zt.mapper.UsersMapper.getOneUserById"))
    })
    public List<Talk> getTalkHistory(@Param("meid") int meid,@Param("otherid") int otherid);


    /**
     * 更改消息状态为已读
     * @param meid
     * @param otherid
     * @return
     */
    @Update("UPDATE talk SET talkstate=1 WHERE (meid=#{meid} AND otherid=#{otherid}) OR (meid=#{otherid} AND otherid=#{meid})")
    public int updTalkState(@Param("meid") int meid,@Param("otherid") int otherid);

    /**
     * 发送消息
     * @param talk
     * @return
     */
    @Insert("INSERT INTO talk(meid,otherid,talkmsg,talkdate) VALUES(#{meid},#{otherid},#{talkmsg},#{talkdate})")
    public int sendTalk(Talk talk);

    /**
     * 消息列表
     * @param meid
     * @return
     */
    @Select("SELECT * FROM talk WHERE otherid=#{meid} GROUP BY meid")
    @Results({
            @Result(column = "meid",property = "meuser",one = @One(select = "com.zt.mapper.UsersMapper.getOneUserById")),
            @Result(column = "otherid",property = "otheruser",one = @One(select = "com.zt.mapper.UsersMapper.getOneUserById"))
    })
    public List<Talk> getAllTalk(int meid);

}
