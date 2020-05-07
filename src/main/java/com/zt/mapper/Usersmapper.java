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
public interface Usersmapper extends BaseMapper<User> {

    public User selectlogin(User user);

    public List<User> selectall();
}
