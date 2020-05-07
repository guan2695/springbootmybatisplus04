package com.zt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zt.entity.Admin;

import org.apache.ibatis.annotations.Mapper;


/**
 * @author guan
 * @create 2020-05-07 17:45
 */
@Mapper
public interface Adminmapper  extends BaseMapper<Admin> {
    public Admin adminlogin(Admin admin);
}
