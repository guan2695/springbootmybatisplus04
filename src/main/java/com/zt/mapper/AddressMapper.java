package com.zt.mapper;

import com.zt.entity.Address;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author xyq
 * @create 2020-05-08 9:02
 */
public interface AddressMapper {

    /**
     * 查询所有地区
     * @return
     */
    @Select("SELECT * FROM address")
    public List<Address> getAllAddress();

    /**
     * 修改地区名
     * @param address
     * @param addid
     * @return
     */
    @Update("UPDATE address SET address=#{address} where addid=#{addid}")
    public int updateaddress(@Param("address") String address,@Param("addid") int addid);

    /**
     * 添加地区
     * @param address
     * @return
     */
    @Insert("INSERT INTO address(address) VALUE (#{address})")
    public int insertaddress(@Param("address") String address);

    /**
     * 根据id删除地区
     * @param addid
     * @return
     */
    @Delete("DELETE FROM address WHERE addid = #{addid}")
    public int deleteaddress(@Param("addid") int addid);

    /**
     * 根据id得到一个地区
     * @param addid
     * @return
     */
    @Select("SELECT * FROM address WHERE addid=#{addid}")
    public Address getAddressByid(int addid);
}
