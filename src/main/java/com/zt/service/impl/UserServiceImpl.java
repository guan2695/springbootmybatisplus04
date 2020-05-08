package com.zt.service.impl;

import com.zt.entity.User;
import com.zt.mapper.UsersMapper;
import com.zt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guan
 * @create 2020-05-08 14:17
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersMapper usersMapper;
    @Override
    public User selectlogin(User user) {
        return usersMapper.selectlogin(user);
    }

    @Override
    public List<User> selectall() {
        return usersMapper.selectall();
    }

    @Override
    public int userregister(User user) {
        return usersMapper.userregister(user);
    }
}
