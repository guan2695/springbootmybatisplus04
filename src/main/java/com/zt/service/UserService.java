package com.zt.service;

import com.zt.entity.User;

import java.util.List;

/**
 * @author guan
 * @create 2020-05-08 14:17
 */
public interface UserService {
    public User selectlogin(User user);

    /**
     * 查询所有用户
     * @return
     */

    public List<User> selectall();
    /**
     * 用户注册
     */
    public int userregister(User user);
}
