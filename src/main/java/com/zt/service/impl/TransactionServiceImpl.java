package com.zt.service.impl;

import com.zt.entity.Transaction;
import com.zt.mapper.TransactionMapper;
import com.zt.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author guan
 * @create 2020-05-16 15:40
 */
@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionMapper transactionMapper;
    @Override
    public int insertTransaction(Transaction transaction) {
        return transactionMapper.insertTransaction(transaction);
    }
}
