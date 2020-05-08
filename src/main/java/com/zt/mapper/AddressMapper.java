package com.zt.mapper;

import com.zt.entity.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author xyq
 * @create 2020-05-08 9:02
 */
@Mapper
public interface AddressMapper {

    /**
     * 查询所有地区
     * @return
     */
    @Select("SELECT * FROM address")
    public List<Address> getAllAddress();


}
