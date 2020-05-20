package com.zt.service;

import com.zt.entity.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * @author guan
 * @create 2020-05-08 14:09
 */
public interface AdminService {
    public Admin adminlogin(Admin admin);
    public int adminAddMoneyToUser(int uid,double money);
}
