package com.zt.mapper;

import com.zt.entity.Banks;
import org.apache.ibatis.annotations.*;

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

    /**
     * 修改银行名
     * @param bankname
     * @param bankid
     * @return
     */
    @Update("UPDATE banks SET bankname=#{bankname} where bankid=#{bankid}")
    public int updatebanks(@Param("bankname") String bankname, @Param("bankid") int bankid);

    /**
     * 添加银行
     * @param bankname
     * @return
     */
    @Insert("INSERT INTO banks(bankname) VALUE (#{bankname})")
    public int insertbanks(@Param("bankname") String bankname);

    /**
     * 删除银行
     * @param bankid
     * @return
     */
    @Delete("DELETE FROM banks WHERE bankid = #{bankid}")
    public int deletebanks(@Param("bankid") int bankid);
}
