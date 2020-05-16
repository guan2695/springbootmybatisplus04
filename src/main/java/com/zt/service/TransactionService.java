package com.zt.service;

import com.zt.entity.Transaction;
import org.springframework.stereotype.Service;

/**
 * @author guan
 * @create 2020-05-16 15:39
 */

public interface TransactionService {

    public int insertTransaction(Transaction transaction);

}
