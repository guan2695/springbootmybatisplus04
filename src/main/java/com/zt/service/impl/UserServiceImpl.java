package com.zt.service.impl;

import com.zt.entity.History;
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
    public List<User> selectUserByPage(int pageIndex, int pageSize) {
        pageIndex=(pageIndex-1)*pageSize;
        return usersMapper.selectUserByPage(pageIndex,pageSize);
    }

    @Override
    public int userregister(User user) {
        return usersMapper.userregister(user);
    }

    @Override
    public User getOneUserById(int uid) {
        return usersMapper.getOneUserById(uid);
    }

    @Override
    public List<History> getAllHistoryByUser(int uid) {
        return usersMapper.getAllHistoryByUser(uid);
    }

    @Override
    public int updateUserpwd(User user) {
        return usersMapper.updateUserpwd(user);
    }

    @Override
    public int delUserByid(int uid) {
        return usersMapper.delUserByid(uid);
    }

    @Override
    public int updateuser(User user) {
        return usersMapper.updateuser(user);
    }

    @Override
    public int updateMoney(User user) {
        return usersMapper.updateMoney(user);
    }
}
