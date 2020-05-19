package com.zt.service;

import com.zt.entity.History;
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
    public List<User> selectUserByPage(int pageIndex,int pageSize);
    /**
     * 用户注册
     */
    public int userregister(User user);


    public User getOneUserById(int uid);
    public List<History> getAllHistoryByUser(int uid);

    public int updateUserpwd(User user);
    public int delUserByid(int uid);
    /**
     * 修改
     */
    public int updateuser(User user);

    /**
     * 买好车修改用户金额
     *
     */
    public int updateMoney(User user);

    public User selllogin(User user);
}
