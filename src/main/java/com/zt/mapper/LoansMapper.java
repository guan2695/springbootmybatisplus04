package com.zt.mapper;

import com.sun.org.apache.xalan.internal.xsltc.dom.CachedNodeListIterator;
import com.zt.entity.Banks;
import com.zt.entity.Loans;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

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
            @Result(column = "uid",property = "user",one = @One(select = "com.zt.mapper.UsersMapper.getOneUserById")),
            @Result(column = "bankid",property = "banks",one = @One(select = "com.zt.mapper.BanksMapper.getOneBankById"))
    })
    public List<Loans> getAllLoans();

    /**
     * 管理员更改审核状态
     * @param lid
     * @param lstate
     * @return
     */
    @Update("UPDATE loans SET lstate=#{lstate} WHERE lid=#{lid}")
    public int updLoansState(@Param("lid") int lid,@Param("lstate") int lstate);

    /**
     * 添加审核失败原因
     * @param lid
     * @param lmsgbecause
     * @return
     */
    @Insert("INSERT INTO loansasses VALUES(DEFAULT,#{lid},1,#{lmsgbecause})")
    public int addLoansOverBeca(@Param("lid") int lid,@Param("lmsgbecause") String lmsgbecause);

    /**
     * 插入贷款信息
     * @param loans
     * @return
     */
    @Insert("INSERT INTO loans (uid,idcard,lmoney,ishavehouse,bankid,lstate)\n" +
            "VALUES(#{uid},#{idcard},#{lmoney},#{ishavehouse},#{bankid},DEFAULT)")
    public int insertloans(Loans loans);
    @Select("SELECT * FROM loans WHERE uid=#{uid}")
    public List<Loans>getUserone(Loans loans);
}
