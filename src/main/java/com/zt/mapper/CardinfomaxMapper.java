package com.zt.mapper;

import com.zt.entity.Cardinfomax;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author guan
 * @create 2020-05-08 17:04
 */
@Mapper
public interface CardinfomaxMapper {
    /**
     * 插入车的详细信息
     * @param cardinfomax
     * @return
     */
    public int insertCardinfomax(Cardinfomax cardinfomax);
}
