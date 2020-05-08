package com.zt.service.impl;

import com.zt.entity.Banks;
import com.zt.mapper.BanksMapper;
import com.zt.service.BanksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xyq
 * @create 2020-05-08 9:41
 */
@Service
public class BanksServiceImpl implements BanksService {

    @Autowired
    private BanksMapper banksMapper;

    @Override
    public List<Banks> getAllBanks() {
        return banksMapper.getAllBanks();
    }
}
