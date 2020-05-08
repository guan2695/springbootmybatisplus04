package com.zt.mapper;

import com.zt.entity.Corol;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CorolMapper {

    /**
     * 得到所有颜色
     * @return
     */
    @Select("SELECT * FROM corol")
    public List<Corol> getAllcorol();

    /**
     * 修改颜色
     * @param corol
     * @param corolid
     * @return
     */
    @Update("UPDATE corol SET corol=#{corol} where corolid=#{corolid}")
    public int updatecorol(@Param("corol") String corol, @Param("corolid") int corolid);

    /**
     * 添加颜色
     * @param corol
     * @return
     */
    @Insert("INSERT INTO corol(corol) VALUE (#{corol})")
    public int insertcorol(@Param("corol") String corol);

    /**
     * 删除颜色信息
     * @param corolid
     * @return
     */
    @Delete("DELETE FROM corol WHERE corolid = #{corolid}")
    public int deletecorol(@Param("corolid") int corolid);
}
