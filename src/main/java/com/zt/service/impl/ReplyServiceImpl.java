package com.zt.service.impl;

import com.zt.entity.Reply;
import com.zt.mapper.ReplyMapper;
import com.zt.service.ReplyService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    private ReplyMapper replyMapper;
    @Override
    public List<Reply> getAllreply(@Param("commid") int commid) {
        return replyMapper.getAllreply(commid);
    }

    @Override
    public int addreply(Reply reply) {
        return replyMapper.addreply(reply);
    }
}
