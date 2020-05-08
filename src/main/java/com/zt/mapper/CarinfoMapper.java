package com.zt.mapper;

import com.zt.entity.Carinfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author guan
 * @create 2020-05-08 14:58
 */
@Mapper
public interface CarinfoMapper {
    /**
     * 插入卖车的详细
     * @param carinfo
     * @return
     */
    public int insertCarinfo(Carinfo carinfo);
}
