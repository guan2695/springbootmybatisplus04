package com.zt.service;

import com.zt.entity.Buyershow;
import com.zt.entity.Comment;

import java.util.List;

/**
 * @author xyq
 * @create 2020-05-08 19:27
 */
public interface BuyershowService {
    public List<Buyershow> getAllShow();
    public Buyershow getOneShow(int showid);
    public List<Comment> getAllCommentByshow(int showid);
}
