package com.zt.service;

import com.zt.entity.Loans;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xyq
 * @create 2020-05-15 10:47
 */
public interface LoansService {
    public List<Loans> getAllLoans();
    public int updLoansState(int lid,int lstate);
    public int addLoansOverBeca(int lid,String lmsgbecause);
    public int insertloans(Loans loans);
    public List<Loans>getUserone(Loans loans);

}
