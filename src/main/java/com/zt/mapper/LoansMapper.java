package com.zt.mapper;

import com.sun.org.apache.xalan.internal.xsltc.dom.CachedNodeListIterator;
import com.zt.entity.Loans;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author xyq
 * @create 2020-05-08 20:22
 */
@Mapper
public interface LoansMapper {

    /**
     * 得到所有贷款
     * @return
     */
    @Select("SELECT * FROM loans")
    @Results({
            @Result(column = "uid",property = "user",one = @One(select = "")),
            @Result(column = "bankid",property = "banks",one = @One(select = ""))
    })
    public List<Loans> getAllLoans();
}
