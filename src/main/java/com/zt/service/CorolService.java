package com.zt.service;

import com.zt.entity.Corol;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xyq
 * @create 2020-05-13 19:27
 */
public interface CorolService {
    public List<Corol> getAllcorol();
    public int insertcorol(String corol);
    public int deletecorol(int corolid);
}
