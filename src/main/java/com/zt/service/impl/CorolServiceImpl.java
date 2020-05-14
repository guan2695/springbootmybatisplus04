package com.zt.service.impl;

import com.zt.entity.Corol;
import com.zt.mapper.CorolMapper;
import com.zt.service.CorolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xyq
 * @create 2020-05-13 19:28
 */
@Service
public class CorolServiceImpl implements CorolService {
    @Autowired
    private CorolMapper corolMapper;
    @Override
    public List<Corol> getAllcorol() {
        return corolMapper.getAllcorol();
    }

    @Override
    public int insertcorol(String corol) {
        return corolMapper.insertcorol(corol);
    }

    @Override
    public int deletecorol(int corolid) {
        return corolMapper.deletecorol(corolid);
    }

}
