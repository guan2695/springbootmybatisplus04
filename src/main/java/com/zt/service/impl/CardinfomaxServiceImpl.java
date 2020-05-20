package com.zt.service.impl;

import com.zt.entity.Cardinfomax;
import com.zt.mapper.CardinfomaxMapper;
import com.zt.service.CardinfomaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author guan
 * @create 2020-05-08 17:05
 */
@Service
public class CardinfomaxServiceImpl implements CardinfomaxService {
    @Autowired
    private CardinfomaxMapper cardinfomaxMapper;
    @Override
    public int insertCardinfomax(Cardinfomax cardinfomax) {
        return cardinfomaxMapper.insertCardinfomax(cardinfomax);
    }

    public int infomax(int cid,Double pailiang,String youtype,int youname,String dangtype) {
        return cardinfomaxMapper.infomax(cid,pailiang,youtype,youname,dangtype);
    }
    public Cardinfomax focid(){
        return cardinfomaxMapper.focid();
    }

}
