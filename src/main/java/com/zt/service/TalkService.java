package com.zt.service;

import com.zt.entity.Talk;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xyq
 * @create 2020-05-17 19:33
 */
public interface TalkService {
    public List<Talk> getUnreadGroup(int meid);
    public List<Talk> getTalkHistory(int meid,int otherid);
}
