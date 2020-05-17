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
    @Select("SELECT *,COUNT(otherid) unread FROM talk WHERE lookstate=0 AND meid=#{meid} GROUP BY otherid")
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

}
