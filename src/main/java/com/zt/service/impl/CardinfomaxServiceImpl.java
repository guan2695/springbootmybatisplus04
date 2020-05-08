package com.zt.service.impl;

import com.zt.entity.Cardinfomax;
import com.zt.mapper.CardinfomaxMapper;
import com.zt.service.CardinfomaxService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author guan
 * @create 2020-05-08 17:05
 */
public class CardinfomaxServiceImpl implements CardinfomaxService {
    @Autowired
    private CardinfomaxMapper cardinfomaxMapper;
    @Override
    public int insertCardinfomax(Cardinfomax cardinfomax) {
        return cardinfomaxMapper.insertCardinfomax(cardinfomax);
    }
}
