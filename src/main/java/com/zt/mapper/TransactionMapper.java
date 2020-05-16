package com.zt.mapper;

import com.zt.entity.Transaction;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author guan
 * @create 2020-05-16 15:37
 */
@Mapper
public interface TransactionMapper  {
    public int insertTransaction(Transaction transaction);

}
