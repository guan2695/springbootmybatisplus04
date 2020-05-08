package com.zt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zt.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author guan
 * @create 2020-04-26 11:35
 */
@Mapper
public interface UsersMapper extends BaseMapper<User> {
    /**
     * 用户登录
     * @param user
     * @return
     */
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
