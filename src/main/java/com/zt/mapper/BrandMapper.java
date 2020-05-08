package com.zt.mapper;

import com.zt.entity.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author xyq
 * @create 2020-05-08 9:08
 */
@Mapper
public interface BrandMapper {

    /**
     * 得到全部车品牌
     * @return
     */
    @Select(value = "SELECT * FROM brand")
    public List<Brand> getAllBrand();

    /**
     * 得到一个车品牌，和他的所有车系
     * @param bid
     * @return
     */
    @Select(value = "SELECT * FROM brand WHERE bid=#{bid}")
    @Results({
            @Result(column = "bid",property = "cardseries",many = @Many(select = "com.zt.mapper.CardseriesMapper.getCardSeriesByBrand"))
    })
    public Brand getOneBrandById(int bid);
}
