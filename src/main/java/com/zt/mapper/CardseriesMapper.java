package com.zt.mapper;

import com.zt.entity.Cardseries;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author xyq
 * @create 2020-05-08 9:10
 */
public interface CardseriesMapper {

    /**
     * 根据品牌得到车系
     * @param bid
     * @return
     */
    @Select("SELECT * FROM cardseries WHERE bid=#{bid}")
    public List<Cardseries> getCardSeriesByBrand(int bid);
}
