package com.zt.mapper;

import com.zt.entity.Cardseries;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author xyq
 * @create 2020-05-08 9:10
 */
@Mapper
public interface CardseriesMapper {

    /**
     * 根据品牌得到车系
     * @param bid
     * @return
     */
    @Select("SELECT * FROM cardseries WHERE bid=#{bid}")
    public List<Cardseries> getCardSeriesByBrand(int bid);

    /**
     * 根据车系id得到一个车系
     * @param csid
     * @return
     */
    @Select("SELECT * FROM cardseries WHERE csid=#{csid}")
    public Cardseries getCarseriesByid(int csid);
}
