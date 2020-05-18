package com.zt.service.impl;

import com.zt.entity.Loans;
import com.zt.mapper.LoansMapper;
import com.zt.service.LoansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xyq
 * @create 2020-05-15 10:47
 */
@Service
public class LoansServiceImpl implements LoansService {
    @Autowired
    private LoansMapper loansMapper;
    @Override
    public List<Loans> getAllLoans() {
        return loansMapper.getAllLoans();
    }

    @Override
    public int updLoansState(int lid, int lstate) {
        return loansMapper.updLoansState(lid,lstate);
    }

    @Override
    public int addLoansOverBeca(int lid, String lmsgbecause) {
        return loansMapper.addLoansOverBeca(lid,lmsgbecause);
    }

    @Override
    public int insertloans(Loans loans) {
        return loansMapper.insertloans(loans);
    }
    @Override
    public List<Loans>getUserone(Loans loans){
        return loansMapper.getUserone(loans);
    }

}
