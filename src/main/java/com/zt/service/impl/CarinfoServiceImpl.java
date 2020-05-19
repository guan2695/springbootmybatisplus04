package com.zt.service.impl;

import com.zt.entity.Carinfo;
import com.zt.mapper.CarinfoMapper;
import com.zt.service.CarService;
import com.zt.service.CarinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author guan
 * @create 2020-05-08 15:01
 */
@Service
public class CarinfoServiceImpl implements CarinfoService {
    @Autowired
    private CarinfoMapper carinfoMapper;
    @Override
    public int insertCarinfo(Carinfo carinfo) {
        return carinfoMapper.insertCarinfo(carinfo);
    }

    public String addinfo(int cid, int length,int width,int height,int mass){
        return carinfoMapper.addinfo(cid,length,width,height,mass);
    }
}
