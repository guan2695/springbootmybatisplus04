package com.zt.service;

import com.zt.entity.Reply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReplyService {

    public List<Reply> getAllreply(@Param("commid") int commid);
    public int addreply(Reply reply);
}
