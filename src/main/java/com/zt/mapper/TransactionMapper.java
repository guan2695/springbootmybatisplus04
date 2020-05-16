package com.zt.mapper;

import com.zt.entity.Transaction;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author xyq
 * @create 2020-05-16 18:27
 */
@Mapper
public interface TransactionMapper {

    /**
     * 得到所有交易记录
     * @return
     */
    @Select("SELECT * FROM transaction")
    @Results({
            @Result(column = "cid",property = "car",one = @One(select = "com.zt.mapper.CarMapper.GetOneCarAllInfo")),
            @Result(column = "buyer",property = "buyuser",one = @One(select = "com.zt.mapper.UsersMapper.getOneUserById")),
            @Result(column = "seller",property = "selluser",one = @One(select = "com.zt.mapper.UsersMapper.getOneUserById"))
    })
    public List<Transaction> getAllTransation();

    public int insertTransaction(Transaction transaction);

}
