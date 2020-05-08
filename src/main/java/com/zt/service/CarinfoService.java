package com.zt.service;

import com.zt.entity.Carinfo;

/**
 * @author guan
 * @create 2020-05-08 15:00
 */
public interface CarinfoService {
    /**
     * 插入卖车的详细
     * @param carinfo
     * @return
     */
    public int insertCarinfo(Carinfo carinfo);
}
