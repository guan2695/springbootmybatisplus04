package com.zt.mapper;

import com.zt.entity.Loansasses;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author guan
 * @create 2020-05-18 11:02
 */
@Mapper
public interface LoansassesMapper {
    /**
     * 查询失败原因
     */
    @Select("SELECT * FROM loansasses WHERE lid=#{lid}")
    public Loansasses selecterrorLoansasses(Loansasses loansasses);
}
