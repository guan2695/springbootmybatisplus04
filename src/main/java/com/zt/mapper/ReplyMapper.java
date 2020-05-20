package com.zt.mapper;

import com.zt.entity.Reply;
import org.apache.ibatis.annotations.*;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@Mapper
public interface ReplyMapper {

    /**
     * 查询买家评论的所有回复
     * @param commid
     * @return
     */
    @Select("SELECT * FROM reply WHERE commid=#{commid} ORDER BY redate")
    @Results({
            @Result(column = "uid",property = "user",one = @One(select = "com.zt.mapper.UsersMapper.getOneUserById"))
    })
    public List<Reply> getAllreply(@Param("commid") int commid);

    /**
     * 添加回复
     * @param reply
     * @return
     */
    @Insert("INSERT INTO reply(commid,uid,replyid,comment,redate) VALUES (#{commid},#{uid},#{replyid},#{comment},#{redate})")
    public int addreply(Reply reply);
}
