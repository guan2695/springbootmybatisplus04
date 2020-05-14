package com.zt.service.impl;

import com.zt.entity.History;
import com.zt.mapper.HistoryMapper;
import com.zt.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import java.util.List;

/**
 * @author guan
 * @create 2020-05-13 10:08
 */
@Service
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    private HistoryMapper historyMapper;
    @Override
    public int insertHistory(History history) {
        return historyMapper.insertHistory(history);
    }

    @Override
    public List<History> selectHistory(History history) {
        return historyMapper.selectHistory(history);
    }

    @Override
    public int deleteUidHistory(History history) {
        return historyMapper.deleteUidHistory(history);
    }
}
