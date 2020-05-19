package com.zt.mapper;

import com.zt.entity.Carinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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

    /**
     * 得到一辆车的基本信息
     * @param cid
     * @return
     */
    @Select("SELECT * FROM carinfo WHERE cid=#{cid}")
    public Carinfo getOneCarinfo(int cid);

    public String addinfo(int cid,int length,int width,int height,int mass);
}
