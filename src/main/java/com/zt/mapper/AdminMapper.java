package com.zt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zt.entity.Admin;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


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

    /**
     * 根据管理员id得到一个管理员
     * @param adminid
     * @return
     */
    @Select("SELECT * FROM admin WHERE adminid=#{adminid}")
    public Admin getOneAdminByid(int adminid);
}
