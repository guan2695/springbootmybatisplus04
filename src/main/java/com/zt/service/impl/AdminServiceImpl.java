package com.zt.service.impl;

import com.zt.entity.Admin;
import com.zt.mapper.AdminMapper;
import com.zt.mapper.UsersMapper;
import com.zt.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author guan
 * @create 2020-05-08 14:11
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public Admin adminlogin(Admin admin) {
        return adminMapper.adminlogin(admin);
    }
}
