package com.zt.mapper;

import com.zt.entity.Assessover;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author guan
 * @create 2020-05-18 16:46
 */
@Mapper
public interface AssessoverMapper {
    @Select("SELECT *  FROM assessover WHERE aid=#{aid}")
    public Assessover selectOver(Assessover assessover);
}
