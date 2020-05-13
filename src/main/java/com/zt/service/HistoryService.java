package com.zt.service;

import com.zt.entity.History;

import java.util.List;

/**
 * @author guan
 * @create 2020-05-13 10:07
 */
public interface HistoryService {
    /**
     * 加入一条浏览记录
     * @return
     */
    public int insertHistory(History history);

    /**
     * 查询登录用户的浏览记录
     */
    public List<History> selectHistory(History history);
}
