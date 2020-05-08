package com.zt.mapper;

import com.zt.entity.Banks;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author xyq
 * @create 2020-05-08 9:05
 */
public interface BanksMapper {

    /**
     * 查询所有银行
     * @return
     */
    @Select("SELECT * FROM banks")
    public List<Banks> getAllBanks();
}
