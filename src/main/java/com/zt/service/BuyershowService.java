package com.zt.service;

import com.zt.entity.Buyershow;
import com.zt.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xyq
 * @create 2020-05-08 19:27
 */
public interface BuyershowService {
    public List<Buyershow> getAllShow();
    public Buyershow getOneShow(int showid);
    public List<Comment> getAllCommentByshow(int showid);
    public int addComment(Comment comment);

    public int getPageCount();
    public List<Buyershow> getPageIndex(@Param("first") int first, @Param("pageSize") int pageSize);
    /**
     * 买家秀的插入
     */
    public int insertBuyershow(Buyershow buyershow);
    /**
     * 用来判断是否秀了该车
     *
     */
    public Buyershow selectBuyershowCid(Buyershow buyershow);
}
