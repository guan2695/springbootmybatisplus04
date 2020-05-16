package com.zt.service.impl;

import com.zt.entity.Transaction;
import com.zt.mapper.TransactionMapper;
import com.zt.service.TransationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xyq
 * @create 2020-05-16 18:32
 */
@Service
public class TransationServiceImpl implements TransationService {
    @Autowired
    private TransactionMapper transactionMapper;
    @Override
    public List<Transaction> getAllTransation() {
        return transactionMapper.getAllTransation();
    }
}
