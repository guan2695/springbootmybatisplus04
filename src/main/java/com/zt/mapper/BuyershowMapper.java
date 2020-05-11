package com.zt.mapper;

import com.zt.entity.Buyershow;
import com.zt.entity.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 买家秀和评论
 * @author xyq
 * @create 2020-05-08 18:55
 */
public interface BuyershowMapper {

    /**
     * 得到所有的买家秀和对应的用户
     * @return
     */
    @Select("SELECT * FROM  buyershow")
    @Results({
            @Result(column = "uid",property = "user",one = @One(select = "com.zt.mapper.UsersMapper.getOneUserById"))
    })
    public List<Buyershow> getAllShow();

    /**
     *得到一个买家秀和对应的用户
     * @param showid
     * @return
     */
    @Select("SELECT * FROM buyershow WHERE showid=#{showid}")
    @Results({
            @Result(column = "uid",property = "user",one = @One(select = "com.zt.mapper.UsersMapper.getOneUserById"))
    })
    public Buyershow getOneShow(int showid);

    /**
     * 根据买家秀得到下面所有的评论和评论的用户
     * @param showid
     * @return
     */
    @Select("SELECT * FROM COMMENT WHERE showid=#{showid}")
    @Results({
            @Result(column = "uid",property = "user",one = @One(select = "com.zt.mapper.UsersMapper.getOneUserById"))
    })
    public List<Comment> getAllCommentByshow(int showid);

    /**
     * 对当前买家秀添加评论
     * @param comment
     * @return
     */
    @Insert("INSERT INTO COMMENT VALUES(DEFAULT,#{showid},#{uid},#{comment},DEFAULT)")
    public int addComment(Comment comment);
}
