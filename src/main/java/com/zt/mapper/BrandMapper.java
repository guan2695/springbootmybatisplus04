package com.zt.mapper;

import com.zt.entity.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author xyq
 * @create 2020-05-08 9:08
 */
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

    /**
     * 修改车品牌
     * @param bname
     * @param bid
     * @return
     */
    @Update("UPDATE brand SET bname=#{bname} where bid=#{bid}")
    public int updatebrand(@Param("bname") String bname,@Param("bid") int bid);

    /**
     * 添加品牌
     * @param bname
     * @return
     */
    @Insert("INSERT INTO brand(bname) VALUE (#{bname})")
    public int insertbrand(@Param("bname") String bname);

    /**
     * 删除品牌
     * @param bid
     * @return
     */
    @Delete("DELETE FROM brand WHERE bid = #{bid}")
    public int deletebrand(@Param("bid") int bid);
}
