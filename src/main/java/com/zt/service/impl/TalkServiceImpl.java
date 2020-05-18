package com.zt.service.impl;

import com.zt.entity.Talk;
import com.zt.mapper.TalkMapper;
import com.zt.service.TalkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xyq
 * @create 2020-05-17 19:33
 */
@Service
public class TalkServiceImpl implements TalkService {

    @Autowired
    private TalkMapper talkMapper;

    @Override
    public List<Talk> getUnreadGroup(int meid) {
        return talkMapper.getUnreadGroup(meid);
    }

    @Override
    public List<Talk> getTalkHistory(int meid, int otherid) {
        return talkMapper.getTalkHistory(meid,otherid);
    }

    @Override
    public int updTalkState(int meid, int otherid) {
        return talkMapper.updTalkState(meid,otherid);
    }

    @Override
    public int sendTalk(Talk talk) {
        return talkMapper.sendTalk(talk);
    }

    @Override
    public List<Talk> getAllTalk(int meid) {
        return talkMapper.getAllTalk(meid);
    }
}
