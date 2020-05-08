package com.zt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zt.entity.Admin;

import org.apache.ibatis.annotations.Mapper;


/**
 * @author guan
 * @create 2020-05-07 17:45
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
    /**
     * 管理员登录
     * @param admin
     * @return
     */
    public Admin adminlogin(Admin admin);
}
